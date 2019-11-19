package com.example.junitproject;

import android.util.Log;

public class Converter
{

    private long ans;
    private char ch,operator;
    private long tmp1,tmp2;

    // Converts to celsius
    public String fahrenheitToCelcius(String fah)
    {
        int ans = Integer.parseInt(fah);
        ans = ((ans - 32) * 5 / 9);
        return Long.toString(ans);
    }

    // Converts to fahrenheit
    public String celciusToFahrenheit(String cel)
    {
        int ans = Integer.parseInt(cel);
        ans = ((ans*9) / 5) + 32;
        return Long.toString(ans);


        //float result = ((cel*9) / 5) + 32;
        //return  result;
    }
}
