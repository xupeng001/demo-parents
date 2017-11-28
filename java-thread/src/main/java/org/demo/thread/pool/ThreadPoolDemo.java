package org.demo.thread.pool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.demo.thread.create.RunThread;
import org.junit.Test;

/**
 * 类ThreadPoolDemo.java的实现描述：线程池的实现
 * 
 * @author xupeng 2017年9月21日 下午5:40:42
 */
public class ThreadPoolDemo {

    //    public static void main(String[] args) {
    //        ExecutorService executorService = Executors.newFixedThreadPool(10);
    //        for (int i = 0; i < 3000; i++) {
    //            try {
    //                Thread.sleep(100);
    //            } catch (InterruptedException e) {
    //            }
    //            executorService.execute(new RunThread("run " + i));
    //        }
    //
    //    }

    /**
     * 固定大小 无边界队列
     * 
     * @DONE
     */

    @Test
    public void newFixedThreadPool() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService = Executors.newFixedThreadPool(1, new ThreadFactoryBuilder().build());
        RunThread run1 = new RunThread("run 1");
        executorService.execute(run1);
        executorService.shutdown();

    }

    /**
     * 工作窃取
     */
    @Test
    public void newWorkStealingPool() throws Exception {
        ExecutorService executorService = Executors.newWorkStealingPool();
        executorService = Executors.newWorkStealingPool(1);
        RunThread run1 = new RunThread("run 1");
        executorService.execute(run1);
        executorService.shutdown();

    }

    /**
     * 单线程 无边界队列
     */
    @Test
    public void newSingleThreadExecutor() throws Exception {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService = Executors.newSingleThreadExecutor(new ThreadFactoryBuilder().build());
        executorService.execute(new RunThread("run 1"));
        executorService.execute(new RunThread("run 2"));
        executorService.shutdown();

    }

    /**
     * 线程不足时创建
     */
    @Test
    public void newCachedThreadPool() throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService = Executors.newCachedThreadPool(new ThreadFactoryBuilder().build());
        executorService.execute(new RunThread("run 1"));
        executorService.execute(new RunThread("run 2"));
        executorService.shutdown();

    }

    /**
     * 定长支持定时周期执行任务
     */
    @Test
    public void newScheduledThreadPool() throws Exception {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        executorService.schedule(new RunThread("RUN 1"), 10, TimeUnit.SECONDS);

        //        executorService.execute(new RunThread("run 1"));
        //        executorService.execute(new RunThread("run 2"));
        //        executorService.shutdown();

    }

    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        //        executorService.schedule(new HeartBeatThread("RUN 1", executorService, 5, TimeUnit.SECONDS), 10,
        //                TimeUnit.SECONDS);
        //                executorService.scheduleAtFixedRate(new run("FixedRate"), 1, 1, TimeUnit.SECONDS);
        //                executorService = Executors.newScheduledThreadPool(1);
        //                executorService.scheduleWithFixedDelay(new run("FixedDelay"), 1, 1, TimeUnit.SECONDS);

        //        executorService.schedule(new CallDemo(), 1, TimeUnit.SECONDS);

        //        executorService.schedule(new RunThread("RUN 3"), 3, TimeUnit.SECONDS);
        //        executorService.execute(new RunThread("RUN 4"));
        //        executorService.schedule(new RunThread("RUN 4"), 4, TimeUnit.SECONDS);
        //        executorService.schedule(new RunThread("RUN 5"), 5, TimeUnit.SECONDS);
        //        executorService.shutdown();

    }

    static class run implements Runnable {

        String name;

        public run(String name) {
            super();
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("-----------" + name + "----------------");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
            }

        }
    }

    static class CallDemo implements Callable<String> {

        @Override
        public String call() throws Exception {
            System.out.println("-------call-------");
            return null;
        }

    }
}
