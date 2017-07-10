package com.example.date;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SimpleDateFormateThreadTest {

    static final String patten1 = "yyyy-MM-dd";
    static final String patten2 = "yyyy-MM";
    static final String dateStr = "2017-05-17 17:40";

    static class SimpleDateFormateThread1 extends Thread {
        @Override
        public void run() {
            DateUtils.parse(dateStr, patten1);
        }
    }

    static class SimpleDateFormateThread2 extends Thread {
        @Override
        public void run() {
            DateUtils.parse(dateStr, patten2);
        }
    }

    public static void main(String[] args) {
        Thread t1 = new SimpleDateFormateThread1();
        Thread t2 = new SimpleDateFormateThread2();
        ExecutorService exec = Executors.newFixedThreadPool(1);
        exec.execute(t1);
        exec.execute(t2);
        exec.shutdown();

        sleep(1000);

        System.out.println("双线程执行: ");
        ExecutorService exec2 = Executors.newFixedThreadPool(2);
        exec2.execute(t1);
        exec2.execute(t2);
        exec2.shutdown();
    }

    private static void sleep(long millSec) {
        try {
            TimeUnit.MILLISECONDS.sleep(millSec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
