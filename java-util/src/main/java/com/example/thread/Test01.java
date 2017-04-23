package com.example.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Test01 {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        test(1);
        System.out.println(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        test(10);
        System.out.println(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        test(100);
        System.out.println(System.currentTimeMillis() - start);

    }

    public static void test(int num) {
        Account account = new Account();
        ExecutorService service = Executors.newFixedThreadPool(num);

        for (int i = 1; i <= 100; i++) {
            service.execute(new AddMoneyThread(account, 1));
        }

        service.shutdown();

        //        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) service;
        //        System.out.println(threadPoolExecutor.getActiveCount());
        //        System.out.println(threadPoolExecutor.getPoolSize());
        //        System.out.println(threadPoolExecutor.getCompletedTaskCount());
        //        System.out.println(threadPoolExecutor.getMaximumPoolSize());

        while (!service.isTerminated()) {
        }
        System.out.println("账户余额: " + account.getBalance());
    }
}
