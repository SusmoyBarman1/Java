package com.example.asus.checkbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {

    private CheckBox milkCheckBox,sugarCheckBox,waterCheckBox;
    private Button showListButton;
    private TextView resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        milkCheckBox = (CheckBox) findViewById(R.id.milkCheckBoxId);
        sugarCheckBox = (CheckBox) findViewById(R.id.sugarCheckBoxId);
        waterCheckBox = (CheckBox) findViewById(R.id.waterCheckBoxId);

        showListButton = (Button) findViewById(R.id.showButtonId);
        resultView = (TextView) findViewById(R.id.resultTextId);

        showListButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        StringBuilder stringBuilder = new StringBuilder();

        if(milkCheckBox.isChecked())
        {
            String item = "Milk";
            stringBuilder.append(item + " is selected.\n");
        }
        if(sugarCheckBox.isChecked())
        {
            String item = "Sugar";
            stringBuilder.append(item + " is selected.\n");
        }
        if(waterCheckBox.isChecked())
        {
            String item = "Water";
            stringBuilder.append(item + " is selected.\n");
        }

        resultView.setText(stringBuilder);
    }
}
