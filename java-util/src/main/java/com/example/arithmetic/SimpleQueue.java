package com.example.arithmetic;

/**
 * @author xupeng
 *
 *         实现一个简单的队列
 */
public class SimpleQueue<E> {

	int tail = 0;
	int head = 0;

	int DEFAULT_SIZE = 100;

	Object[] elements = new Object[DEFAULT_SIZE];

	public boolean add(E e) {
		if (head < 0) {
			head = 0;
		}
		elements[head++] = e;
		return true;
	}

	public E pop() {
		@SuppressWarnings("unchecked")
		E a = (E) elements[tail];
		elements[tail] = null;
		tail++;
		return a;
	}

	public int size() {
		return head - tail;
	}

	public boolean isEmpty() {
		if (head == tail) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		SimpleQueue<Integer> queue = new SimpleQueue<Integer>();
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			queue.add(i);
		}
		System.out.println(queue.size());
		System.out.println(queue.isEmpty());
		while (!queue.isEmpty()) {
			System.out.println(queue.pop());
		}
	}
}
