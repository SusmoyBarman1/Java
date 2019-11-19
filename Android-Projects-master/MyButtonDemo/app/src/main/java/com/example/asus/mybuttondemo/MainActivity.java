package com.example.asus.mybuttondemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button buttonId;
    private TextView textView;
    private Button loginButton,logoutButton;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonId = (Button) findViewById(R.id.loginButtonId);
        textView = (TextView) findViewById(R.id.textViewId);
        loginButton = (Button) findViewById(R.id.loginButtonId);
        logoutButton = (Button) findViewById(R.id.logoutButtonId);

        /**
        Handler handler = new Handler();
        loginButton.setOnClickListener(handler);
        logoutButton.setOnClickListener(handler);
         */
    }

    public void showMessage(View v){
        if(v.getId() == R.id.loginButtonId)
        {
            //textView.setText("Login Button is clicked");
            //Toast toast = Toast.makeText(MainActivity.this,"Login Button is clicked",Toast.LENGTH_SHORT);
            //toast.show();
            Log.d("tag","Login button is clicked");
        }
        else
        {
            //textView.setText("Logout Button is clicked");
            //Toast toast = Toast.makeText(MainActivity.this,"Logout Button is clicked",Toast.LENGTH_SHORT);
            //toast.show();
            Log.d("tag","Logout button is clicked");
        }
    }
/**
    class Handler implements OnClickListener{

        @Override
        public void onClick(View v) {
            if(v.getId() == R.id.loginButtonId)
            {
                textView.setText("Login Button is clicked");
            }
            else
            {
                textView.setText("Logout Button is clicked");
            }
        }
    }
    */
}
