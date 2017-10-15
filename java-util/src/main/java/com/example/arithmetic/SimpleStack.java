package com.example.arithmetic;

/**
 * @author xupeng 实现一个简单的栈
 */
public class SimpleStack<E> {

    /**
     * 游标
     */
    int      head         = 0;

    int      size         = 0;

    int      DEFAULT_SIZE = 100;

    Object[] elements     = new Object[DEFAULT_SIZE];

    public boolean add(E e) {
        if (head < 0) {
            head = 0;
        }
        if (size < 0) {
            size = 0;
        }
        elements[head++] = e;
        size++;
        return true;
    }

    public E pop() {
        if (head == 0) {
            return null;
        }
        @SuppressWarnings("unchecked")
        E a = (E) elements[--head];
        elements[head] = null;
        size--;
        return a;
    }

    public int size() {
        if (size > 0) {
            return size;
        }
        return 0;

    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        SimpleStack<Integer> queue = new SimpleStack<Integer>();
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            queue.pop();
        }
        System.out.println(queue.size());
        System.out.println(queue.isEmpty());
        while (!queue.isEmpty()) {
            System.out.println(queue.pop());
        }
    }
}
