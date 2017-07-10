package com.example.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatTest {

    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("yyyy-MM-dd ");
        System.out.println(format.format(date));
        format.applyPattern("yyyy-MM-DD ");
        System.out.println(format.format(date));
        format.applyPattern("YYYY-MM-dd ");
        System.out.println(format.format(date));
        format.applyPattern("YYYY-MM-DD ");
        System.out.println(format.format(date));
        format.applyPattern("mm-dd :MM :YYYY");
        System.out.println(format.format(date));
    }
}
