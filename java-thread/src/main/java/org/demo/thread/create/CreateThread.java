package org.demo.thread.create;

/**
 * 类CreateThread.java的实现描述：介绍下实例化线程的几种方式
 * 
 * @author xupeng 2017年9月21日 下午5:29:20
 */
public class CreateThread {

    /**
     * 继承实现
     * <p>
     * 此实现方法 一个类只能初始化一个线程，资源独享
     * </p>
     */
    class ThreadOne extends Thread {

    }

    /**
     * 实现接口
     * <p>
     * 此实现方法 一个类可以初始化多个线程，线程之间资源共享
     * </p>
     */
    class ThreadTwo implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getId() + " " + Thread.currentThread().getName() + ":"
                    + Thread.currentThread().getState());

        }

    }
}
