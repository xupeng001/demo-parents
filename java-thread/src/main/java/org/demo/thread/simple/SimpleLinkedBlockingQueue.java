package org.demo.thread.simple;

import java.util.concurrent.LinkedBlockingQueue;

import org.junit.Test;

public class SimpleLinkedBlockingQueue {

    @Test
    public void demo(){
        LinkedBlockingQueue<Integer> queue=new LinkedBlockingQueue<>(2);
        queue.add(1);
        queue.add(2);
//        queue.add(3);
//        queue.add(4);
        System.out.println(queue.size());
    }
}
