package org.demo.thread.simple;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;

public class SimpleField {

    private final BlockingQueue<Runnable> workQueue;

    public SimpleField(BlockingQueue<Runnable> workQueue) {
        this.workQueue = workQueue;
    }

    public void set(BlockingQueue<Runnable> workQueue) {
        //                this.workQueue = workQueue;
    }

    //    private static final BlockingQueue<Runnable> workQueue;
    //
    //    public SimpleField(BlockingQueue<Runnable> workQueue) {
    //        this.workQueue = workQueue;
    //    }
    //
    //    public void set(BlockingQueue<Runnable> workQueue) {
    //                this.workQueue = workQueue;
    //    }
}
