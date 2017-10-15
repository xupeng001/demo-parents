package org.design.singleton;

/**
 * 类Singleton.java的实现描述:懒汉式，线程不安全
 * 
 * 
 * @author xupeng 2017年10月9日 下午6:07:21
 */
public class SingletonOne {
    private static SingletonOne instance;

    private SingletonOne() {
    }

    public static SingletonOne getInstance() {
        if (instance == null) {
            instance = new SingletonOne();
        }
        return instance;
    }
}
