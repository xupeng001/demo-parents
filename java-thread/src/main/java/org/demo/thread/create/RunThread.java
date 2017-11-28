package org.demo.thread.create;

/**
 * 实现接口
 * <p>
 * 此实现方法 一个类可以初始化多个线程，线程之间资源共享
 * </p>
 */
/**
 * 类RunThread.java的实现描述：TODO 类实现描述
 * 
 * @author xupeng 2017年9月22日 上午10:48:37
 */
public class RunThread implements Runnable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        System.out.println(getName() + "-->  id: " + Thread.currentThread().getId() + "   activeCount : "
                + Thread.activeCount() + "   status :" + Thread.currentThread().getState());

    }

    public RunThread() {
        super();
        // TODO Auto-generated constructor stub
    }

    public RunThread(String name) {

        this.name = name;
    }

}
