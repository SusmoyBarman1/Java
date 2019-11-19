package com.example.asus.simplecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText1, editText2;
    private Button addButton,subButton, mulButton,divButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText) findViewById(R.id.editText_1_id);
        editText2 = (EditText) findViewById(R.id.editText_2_id);

        addButton = (Button) findViewById(R.id.addButton);
        subButton = (Button) findViewById(R.id.subButton);
        mulButton = (Button) findViewById(R.id.mulButton);
        divButton = (Button) findViewById(R.id.divButton);

        resultTextView = (TextView) findViewById(R.id.result);


        addButton.setOnClickListener(this);
        subButton.setOnClickListener(this);
        mulButton.setOnClickListener(this);
        divButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        try
        {

            String number1 = editText1.getText().toString();
            String number2 = editText2.getText().toString();

            //Converting into double
            double num1 = Double.parseDouble(number1);
            double num2 = Double.parseDouble(number2);

            double answer = 0;
            if(v.getId() == R.id.addButton)
            {
                answer = num1 + num2;
            }
            else if(v.getId() == R.id.subButton)
            {
                answer = num1 - num2;
            }
            else if(v.getId() == R.id.mulButton)
            {
                answer = num1 * num2;
            }
            else if(v.getId() == R.id.divButton)
            {
                answer = num1 / num2;
            }
            resultTextView.setText("Result: "+ answer);

        }catch (Exception e)
        {
            Toast.makeText(MainActivity.this,"Please, Enter Numbers!",Toast.LENGTH_SHORT).show();
        }
    }
}
