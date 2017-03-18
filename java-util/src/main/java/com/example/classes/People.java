package com.example.classes;

public class People {

    static{
        System.out.println("父类的静态方法");
    }
    {
        System.out.println("父类的初始化");
    }
    public People() {
        System.out.println("父类的构造");
    }
}
