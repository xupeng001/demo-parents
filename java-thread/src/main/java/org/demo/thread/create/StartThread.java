package org.demo.thread.create;

/**
 * 类StartThread.java的实现描述：TODO 类实现描述 
 * @author xupeng 2017年9月22日 上午10:49:09
 */
/**
 * 继承实现
 * <p>
 * 此实现方法 一个类只能初始化一个线程，资源独享
 * </p>
 */
public class StartThread extends Thread {

    @Override
    public void run() {
        System.out.println("--------------");
    }
    public static void main(String[] args) {
        new StartThread().start();
    }
}
