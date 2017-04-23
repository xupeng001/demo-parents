package com.example.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTest {
    public static void main(String[] args) {

        ExecutorService pool = Executors.newSingleThreadExecutor();
        //创建实现了Runnable接口对象
        Thread tt1 = new MyThread();
        Thread tt2 = new MyThread();
        Thread tt3 = new MyThread();
        Thread tt4 = new MyThread();
        Thread tt5 = new MyThread();
        //将线程放入池中并执行
        pool.execute(tt1);
        pool.execute(tt2);
        pool.execute(tt3);
        pool.execute(tt4);
        pool.execute(tt5);

        
        
        
        
        
        
        //关闭
//        pool.shutdown();
    }
}
