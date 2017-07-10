package com.example.thread;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * 类BuildBaseInfoThread.java的实现描述：TODO 类实现描述
 * 
 * @author xupeng 2017年5月15日 下午6:58:01
 */
public class BuildBaseInfoThread extends Thread {

    private CountDownLatch latch;
    private List<String>   result;

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            result.add("baseInfo");
       
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            latch.countDown();
            System.out.println(latch.getCount());
        }
    }

    public BuildBaseInfoThread(CountDownLatch latch, List<String> result) {
        super();
        this.latch = latch;
        this.result = result;
    }
}
