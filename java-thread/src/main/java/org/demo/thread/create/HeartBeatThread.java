package org.demo.thread.create;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.fasterxml.jackson.core.sym.Name;

/**
 * 类HeartBeatThread.java的实现描述：TODO 类实现描述
 * 
 * @author xupeng 2017年10月31日 下午2:23:36
 */
public class HeartBeatThread implements Runnable {

    private String name;

    public HeartBeatThread(String name, ScheduledExecutorService executorService, int delay, TimeUnit unit) {
        super();
        this.name = name;
        this.executorService = executorService;
        this.delay = delay;
        this.unit = unit;
    }

    private ScheduledExecutorService executorService;

    private int                      delay;

    private TimeUnit                 unit;

    @Override
    public void run() {
        System.out.println(getName() + "-->  id: " + Thread.currentThread().getId() + "   activeCount : "
                + Thread.activeCount() + "   status :" + Thread.currentThread().getState());
        if (!executorService.isShutdown()) {
            executorService.schedule(this, delay, unit);
        }
    }

    private String getName() {
        return name;
    }

}
