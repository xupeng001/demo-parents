package com.example.thread;

public class WorkerDemo {

    public static void main(String[] args) {

        Runnable task1 = new Runnable() {

            @Override
            public void run() {
                System.out.println("111111111111111111111");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }

                System.out.println("111111111111111111111");
            }
        };

        Runnable task2 = new Runnable() {

            @Override
            public void run() {
                System.out.println("2222222222222222");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }

                System.out.println("222222222222222");
            }
        };

        ThreadDemo demo = new ThreadDemo();
        demo.getTasks().add(task1);

        demo.start();

        demo.getTasks().add(task2);
        demo.getTasks().add(task2);
        demo.getTasks().add(task1);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
        }
        System.out.println("===========================");
        demo.getTasks().add(task2);
        demo.getTasks().add(task1);
        Thread.interrupted();
    }
}
