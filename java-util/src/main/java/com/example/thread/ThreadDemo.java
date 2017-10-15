package com.example.thread;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ThreadDemo extends Thread {

    private ConcurrentLinkedQueue<Runnable> tasks = new ConcurrentLinkedQueue<Runnable>();

    @Override
    public void run() {
        for (;;) {
            if (tasks.isEmpty()) {
                System.out.println("---------------------");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            } else {
                tasks.poll().run();
            }
        }

    }

    public int getCount() {
        return tasks.size();
    }

    public ConcurrentLinkedQueue<Runnable> getTasks() {
        return tasks;
    }

    public ThreadDemo() {
    }

}
