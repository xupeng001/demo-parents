package com.demo.stack;

/**
 * 类SimpleStack.java的实现描述：TODO 类实现描述
 * 
 * @author xupeng 2017年9月11日 下午3:33:50
 */
public class SimpleStack {

    private int arr[];
    private int max = Integer.MAX_VALUE;
    private int top;

    public SimpleStack(int x) {
        max = x;
        arr = new int[max];
        top = -1;
    }

    public SimpleStack() {
        arr = new int[max];
        top = -1;
    }

    public void push(int value) {
        arr[++top] = value;
    }

    public int peek() {
        return arr[top];
    }

    public int pop() {
        return arr[top--];
    }

    public boolean isEmpty() {
        if (top == -1) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if (top == max - 1) {
            return true;
        }
        return false;
    }
}
