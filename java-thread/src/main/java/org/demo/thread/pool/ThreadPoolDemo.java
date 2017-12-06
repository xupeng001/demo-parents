package org.demo.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;
import org.demo.thread.create.RunThread;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

/**
 * 类ThreadPoolDemo.java的实现描述：线程池的实现
 * 
 * @author xupeng 2017年9月21日 下午5:40:42
 */
public class ThreadPoolDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 3000; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
            executorService.execute(new RunThread("run " + i));
        }

    }

    /**
     * 固定大小 无边界队列
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
        ExecutorService executorService = Executors.newScheduledThreadPool(1);
        executorService = Executors.newScheduledThreadPool(1, new ThreadFactoryBuilder().build());
        executorService.execute(new RunThread("run 1"));
        executorService.execute(new RunThread("run 2"));
        executorService.shutdown();

    }
   

}
