package com.example.string;

import java.util.ArrayList;
import java.util.List;

public class TestString {
    public void fun(String str) {
        str = " 张柏芝 ";
    }

    public static void main(String args[]) {
        TestString t = new TestString();
        String str = " 郭美美 ";
        t.fun(str);
        System.out.println(str);
        say(str);
        System.out.println(str);
        int count = 1;
        add(count);
        System.out.println(count);
        List<Integer> list = new ArrayList<Integer>(10);
        add1(list);
        System.out.println(list.size());
        add2(list);
        System.out.println(list.size());
    }

    private static void say(String str) {
        str = "say";
    }

    private static void add(int i) {
        i++;
    }

    private static void add1(List<Integer> list) {
        list = new ArrayList<Integer>(10);
        list.add(1);
    }
    private static void add2(List<Integer> list) {
        list.add(1);
    }
    
    
    
    
}
