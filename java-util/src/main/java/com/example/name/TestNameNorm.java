package com.example.name;

/**
 * 类TestNameNorm.java的实现描述：TODO 类实现描述
 * 
 * @author xupeng 2017年3月16日 下午12:00:01
 */
public class TestNameNorm {
    /**
     * 命名规范 java可以用 $ 、字母、下划线开头 赋值静态块先执行
     */
    static {
        _i = 1;
    }

    /**
     * 类实例化之前就已经赋值
     */
    public static int _i = 0;

    {
        _i = 2;
    }

    public TestNameNorm() {
        _i = 4;
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        System.out.println(_i);
        /**
         * 对象实例化的时候会执行本地代码块重新赋值,并且构造执行在本地代码块执行之后
         */
        TestNameNorm norm = new TestNameNorm();

        System.out.println(_i);
    }

}
