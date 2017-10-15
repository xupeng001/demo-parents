package org.design.singleton;

/**
 * 类Singleton.java的实现描述:双重检验锁
 * 
 * @author xupeng 2017年10月9日 下午6:07:21
 */
public class SingletonThree {
    /**
     * 解决代码重排导致的问题
     */
    private static volatile SingletonThree instance;

    private SingletonThree() {
    }

    public static SingletonThree getSingleton() {
        if (instance == null) { //Single Checked
            synchronized (SingletonThree.class) {
                if (instance == null) { //Double Checked
                    instance = new SingletonThree();
                }
            }
        }
        return instance;
    }
}
