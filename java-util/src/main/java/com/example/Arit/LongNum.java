package com.example.Arit;

import java.math.BigDecimal;

public class LongNum {
    public static void main(String[] args) {
//        BigDecimal bd = new BigDecimal(9999999999999999999999999999.999999999999); //100亿
//        System.out.println(bd);
//        System.out.println(bd.intValue());
//        System.out.println(bd.doubleValue());
//        getNum(bd);
        Long db=999999999999999999L;
        System.out.println(db);
        getNum(db);

    }

    public static void getNum(BigDecimal bd) {
        System.out.println(bd);
        System.out.println(bd.toString());
    }
    
    public static void getNum(Long bd) {
        System.out.println(bd);
        System.out.println(bd.toString());
    }
}
