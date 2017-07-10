package com.example.Arit;

import java.math.BigDecimal;
import java.math.BigInteger;

public class NumDemo {
    public static void main(String[] args) {

        Object value=0;
        BigDecimal bigDecimal = new BigDecimal(new BigInteger(value.toString()));
        System.out.println(bigDecimal.movePointLeft(2));
    }
}
