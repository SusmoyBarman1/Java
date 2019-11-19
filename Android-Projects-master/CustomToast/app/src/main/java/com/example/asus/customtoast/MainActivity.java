package com.example.asus.customtoast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButton = (Button) findViewById(R.id.buttonId);
        loginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        // To find the custom layout
        LayoutInflater inflater = getLayoutInflater();

        // This statement returns a view, where the first argument returns an integer and the second
        // one return a view group

        View customView = inflater.inflate(R.layout.custom_toast_layout, (ViewGroup) findViewById(R.id.customToastId));

        Toast toast = new Toast(MainActivity.this);
        toast.setDuration(Toast.LENGTH_SHORT);

        // Setting the view of the toast
        toast.setView(customView);
        toast.show();
    }
}
