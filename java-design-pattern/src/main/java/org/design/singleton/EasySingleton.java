package org.design.singleton;

/**
 * 类EasySingleton.java的实现描述： 枚举实现
 * 我们可以通过EasySingleton.INSTANCE来访问实例，这比调用getInstance
 * ()方法简单多了。创建枚举默认就是线程安全的，所以不需要担心double checked locking，而且还能防止反序列化导致重新创建新的对象。
 * 
 * @author xupeng 2017年10月10日 下午5:04:00
 */
public enum EasySingleton {
    INSTANCE(1);

    private int x;

    private EasySingleton(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

}
