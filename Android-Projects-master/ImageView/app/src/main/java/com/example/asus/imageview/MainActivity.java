package com.example.asus.imageview;

import android.app.Activity;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    private ImageView nipa,susu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nipa = (ImageView) findViewById(R.id.nipaId);
        susu = (ImageView) findViewById(R.id.susuId);

        nipa.setOnClickListener(this);
        susu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.nipaId)
        {
            Toast.makeText(MainActivity.this,"Hi, I'm Nipa Das",Toast.LENGTH_SHORT).show();
        }
        else if(v.getId() == R.id.susuId)
        {
            Toast.makeText(MainActivity.this,"Hi, I'm Susmoy Barman",Toast.LENGTH_SHORT).show();
        }
    }
}
