package com.example.junitproject;

import org.junit.Test;
import com.example.junitproject.Converter;

import static org.junit.Assert.*;

public class ConverterTest
{

    @Test
    public void fahrenheitToCelcius()
    {
        int input = 212;
        int output;
        int expected = 100;

        Converter cn = new Converter();
        String str = Integer.toString(input);
        output = Integer.parseInt(cn.fahrenheitToCelcius(str));

        System.out.println(output);
        assertEquals(expected,output);

    }

    @Test
    public void celciusToFahrenheit()
    {
        int input = 100;
        int output;
        int expected = 212;

        Converter cn = new Converter();
        String str = Integer.toString(input);
        output = Integer.parseInt(cn.celciusToFahrenheit(str));
        System.out.println(output);

        assertEquals(expected,output);
    }
}