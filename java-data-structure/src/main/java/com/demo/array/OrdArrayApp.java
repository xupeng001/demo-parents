package com.demo.array;

/**
 * 类OrdArrayApp.java的实现描述：
 * 
 * @author xupeng 2017年9月11日 上午10:52:56
 */
public class OrdArrayApp {

    public static void main(String[] args) {

        int max = 100;
        OrdArray arr = new OrdArray(max);
        for (int i = 0; i < 30; i++) {
            arr.insert(i);
        }
        arr.delete(100);
        arr.display();
        arr.delete(20);
        arr.display();
        System.out.println("index : " + arr.find(100));
        System.out.println("index : " + arr.find(20));
        System.out.println("index : " + arr.find(10));
        System.out.println(arr.findHight());
    }
}
