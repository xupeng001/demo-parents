package org.design.singleton;

/**
 * 类Singleton.java的实现描述:懒汉式，线程安全
 * 
 * @author xupeng 2017年10月9日 下午6:07:21
 */
public class SingletonTwo {
    private static SingletonTwo instance;

    private SingletonTwo() {
    }

    public static synchronized SingletonTwo getInstance() {
        if (instance == null) {
            instance = new SingletonTwo();
        }
        return instance;
    }
}
