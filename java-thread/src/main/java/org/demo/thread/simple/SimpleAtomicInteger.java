package org.demo.thread.simple;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

public class SimpleAtomicInteger {

    @Test
    public void test() {
        AtomicInteger ctl = new AtomicInteger(100);

        System.out.println(ctl.get());
        System.out.println(ctl.get());
        System.out.println(ctl.get());
        System.out.println(ctl.compareAndSet(100, 1000));
        System.out.println(ctl.get());
        System.out.println(ctl.incrementAndGet());
    }
}
