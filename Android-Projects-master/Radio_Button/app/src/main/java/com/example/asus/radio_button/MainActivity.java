package com.example.asus.radio_button;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RadioGroup radioGroup;
    private RadioButton genderButton;
    private Button resultButton;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroupId);
        resultButton = (Button) findViewById(R.id.buttonId);
        textView = (TextView) findViewById(R.id.textId);

        resultButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int selectedId = radioGroup.getCheckedRadioButtonId();
        genderButton = (RadioButton) findViewById(selectedId);

        String text = "You have selected: " + genderButton.getText().toString();
        textView.setText(text);

    }
}
