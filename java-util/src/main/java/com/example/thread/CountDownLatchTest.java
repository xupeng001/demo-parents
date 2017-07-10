package com.example.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(2);
        List<String> result = new ArrayList<String>();

        new BuildBaseInfoThread(latch, result).start();

        new BuildExtendInfoThread(latch, result).start();

        System.out.println(result);
        try {
            latch.await();

            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
