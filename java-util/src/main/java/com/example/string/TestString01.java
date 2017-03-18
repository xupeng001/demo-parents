package com.example.string;

import org.junit.Test;

public class TestString01 {

    @Test
    public void test() {
        int i = 1;
        testInteger(i);
        System.out.println(i);
        String str="str";
        System.out.println(Integer.toHexString(str.hashCode()));
        testString(str);
        System.out.println(Integer.toHexString(str.hashCode()));
        System.out.println(str);
        testString1(str);
        System.out.println(str);
    }

    public void testInteger(Integer integer) {
        
        integer++;
    }
    public void testString (String str){
        System.out.println(Integer.toHexString(str.hashCode()));
        str="TestString";
        System.out.println(Integer.toHexString(str.hashCode()));
    }
    public String testString1 (String str){
        str="TestString";
        return str;
    }
}
