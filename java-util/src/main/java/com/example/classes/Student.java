package com.example.classes;

public class Student extends People{

    static{
        System.out.println("子类的静态方法");
    }
    {
        System.out.println("子类的初始化");
    }
    public Student() {
        System.out.println("子类的构造");
    }
}
