package com.example.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * 类BuildBaseInfoThread.java的实现描述：TODO 类实现描述
 * 
 * @author xupeng 2017年5月15日 下午6:58:01
 */
public class BuildExtendInfoThread extends Thread {

    private CountDownLatch latch;
    private List<String>   result;

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            List<String> list = new ArrayList<String>();
//            synchronized (result) {同步汇总
//                result.addAll(list);
//            }
            result.add("extend");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            latch.countDown();
            System.out.println(latch.getCount());
        }
    }

    public BuildExtendInfoThread(CountDownLatch latch, List<String> result) {
        super();
        this.latch = latch;
        this.result = result;
    }
}
