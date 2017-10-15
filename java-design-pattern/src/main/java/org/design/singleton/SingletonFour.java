package org.design.singleton;

/**
 * 类Singleton.java的实现描述:饿汉式 static final field 缺点是它不是一种懒加载模式（lazy
 * initialization），单例会在加载类后一开始就被初始化，即使客户端没有调用
 * getInstance()方法。饿汉式的创建方式在一些场景中将无法使用：譬如 Singleton 实例的创建是依赖参数或者配置文件的，在
 * getInstance() 之前必须调用某个方法设置参数给它，那样这种单例写法就无法使用了。
 * 
 * @author xupeng 2017年10月9日 下午6:07:21
 */
public class SingletonFour {
    //类加载时就初始化
    private static final SingletonFour instance = new SingletonFour();

    private SingletonFour() {
    }

    public static SingletonFour getInstance() {
        return instance;
    }
}
