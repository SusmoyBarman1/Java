package com.example.hello;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;

public class RegisterActivity extends AppCompatActivity
{
    private Button CreateAccountButton;
    private EditText UserEmail,UserPassword;
    private TextView AlreadyHaveAccountLink;

    private FirebaseAuth mAuth;
    private DatabaseReference RootRef;

    private ProgressDialog loadingBar;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();
        RootRef = FirebaseDatabase.getInstance().getReference();

        Initializefields();

        AlreadyHaveAccountLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                sendUserToLoginActivity();
            }
        });

        CreateAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateNewAccount();
            }
        });

    }

    private void CreateNewAccount()
    {
        String email = UserEmail.getText().toString();
        String password = UserPassword.getText().toString();

        if(TextUtils.isEmpty(email))
        {
            Toast.makeText(this, "Please insert email!", Toast.LENGTH_SHORT).show();
        }
        if(TextUtils.isEmpty(password))
        {
            Toast.makeText(this, "Please insert password!", Toast.LENGTH_SHORT).show();
        }
        else
        {
            loadingBar.setTitle("Creating new account!");
            loadingBar.setMessage("Please wait!");
            loadingBar.setCanceledOnTouchOutside(true);
            loadingBar.show();

            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task)
                {
                    if(task.isSuccessful())
                    {
                        String deviceToken = FirebaseInstanceId.getInstance().getToken();

                        String currentUserId = mAuth.getCurrentUser().getUid();
                        RootRef.child("Users").child(currentUserId).setValue("");

                        RootRef.child("Users").child(currentUserId).child("device_token")
                                .setValue(deviceToken);

                        sendUserToMainActivity();
                        Toast.makeText(RegisterActivity.this, "Account created succesfully!", Toast.LENGTH_SHORT).show();
                        loadingBar.dismiss();
                    }
                    else
                    {
                        String message = task.getException().toString();
                        Toast.makeText(RegisterActivity.this, "Error: "+message, Toast.LENGTH_SHORT).show();
                        loadingBar.dismiss();
                    }
                }
            });
        }
    }

    private void Initializefields()
    {
        CreateAccountButton = (Button) findViewById(R.id.register_button);
        UserEmail = (EditText) findViewById(R.id.register_email);
        UserPassword = (EditText) findViewById(R.id.register_password);
        AlreadyHaveAccountLink = (TextView) findViewById(R.id.already_have_account_link);
        loadingBar = new ProgressDialog(this);
    }

    private void sendUserToLoginActivity()
    {
        Intent loginIntend = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(loginIntend);
    }

    private void sendUserToMainActivity()
    {
        Intent mainIntend = new Intent(RegisterActivity.this, MainActivity.class);
        mainIntend.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(mainIntend);
        finish();
    }
}
