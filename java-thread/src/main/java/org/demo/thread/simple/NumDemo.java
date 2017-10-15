package org.demo.thread.simple;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 类NumDemo.java的实现描述：TODO 类实现描述
 * 
 * @author xupeng 2017年9月25日 下午4:16:43
 */
public class NumDemo {
    //workerCount
    private final AtomicInteger ctl        = new AtomicInteger(ctlOf(RUNNING, 0));
    private static final int    COUNT_BITS = Integer.SIZE - 3;
    private static final int    CAPACITY   = (1 << COUNT_BITS) - 1;
    // runState is stored in the high-order bits
    private static final int    RUNNING    = -1 << COUNT_BITS;
    private static final int    SHUTDOWN   = 0 << COUNT_BITS;
    private static final int    STOP       = 1 << COUNT_BITS;
    //左移COUNT_BITS位 
    //<<  按位左移运算符。左操作数按位左移右操作数指定的位数。  A << 2得到240，即 1111 0000 
    private static final int    TIDYING    = 2 << COUNT_BITS;
    private static final int    TERMINATED = 3 << COUNT_BITS;

    //    http://www.runoob.com/java/java-operators.html
    //〜   按位补运算符翻转操作数的每一位，即0变成1，1变成0。 （〜A）得到-61，即1100 0011
    private static int runStateOf(int c) {
        return c & ~CAPACITY;
    }

    private static int workerCountOf(int c) {
        return c & CAPACITY;
    }
    private static int workerCountOfBCK(int c) {
        return c & 5;
    }
    private static int ctlOf(int rs, int wc) {
        return rs | wc;
    }

    public static void main(String[] args) {
        System.out.println(COUNT_BITS);
        System.out.println((1 << COUNT_BITS) - 1);
        System.out.println(Math.pow(2, 31) - 1);
        System.out.println("********************************");
        System.out.println(RUNNING);
        System.out.println(SHUTDOWN);
        System.out.println(STOP);
        System.out.println(TIDYING);
        System.out.println(TERMINATED);
        System.out.println("********************************");
        System.out.println(Integer.toBinaryString(Integer.SIZE));
        System.out.println(Integer.toBinaryString(COUNT_BITS));
        System.out.println(Integer.toBinaryString(RUNNING));
        System.out.println(Integer.toBinaryString(SHUTDOWN));
        System.out.println(Integer.toBinaryString(STOP));
        System.out.println(Integer.toBinaryString(TIDYING));
        System.out.println(Integer.toBinaryString(TERMINATED));
        System.out.println("********************************");
        System.out.println(runStateOf(10));
        System.out.println(workerCountOf(10));
        System.out.println("************************************");
        System.out.println(workerCountOfBCK(0));
        System.out.println(workerCountOfBCK(1));
        System.out.println(workerCountOfBCK(2));
        System.out.println(workerCountOfBCK(3));
        System.out.println(workerCountOfBCK(4));
        System.out.println(workerCountOfBCK(5));
        System.out.println(workerCountOfBCK(6));
    }
}
