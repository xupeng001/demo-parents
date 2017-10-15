package com.demo.linkList;

import org.junit.Test;

public class LinkedListApp {

    @Test
    public void testLinked() {
        LinkedList list = new LinkedList();
        list.add(100);
        list.add(40);
        list.add(20);
        System.out.println(list.size());
        list.dispaly();
        System.out.println("remove 1 " + list.remove(1));
        System.out.println("remove 100 " + list.remove(100));
        System.out.println(list.size());
        list.dispaly();
    }
}
