package com.example.arithmetic;

/**
 * @author xupeng
 * 
 * 
 *         简单队列的实现
 * 
 *         特性：先进先出
 */
public class Queue {

	/**
	 * 头部游标
	 */
	int head;
	/**
	 * 末尾游标
	 */
	int tail;

	/**
	 * 默认初始大小
	 */
	private int DEFAULT_SIZE = 8;

	/**
	 * 容器
	 */
	private String[] strs = new String[DEFAULT_SIZE];

	/**
	 * 出队
	 * 
	 * @return
	 */
	public String pop() {
		int h = head;
		String result = strs[h];
		if (result == null)
			return null;
		strs[h] = null; // Must null out slot
		head = (h + 1) & (strs.length - 1);
		return result;
	}

	/**
	 * 入队
	 * 
	 * @return
	 */
	public boolean join(String str) {
		strs[tail] = str;
		if ((tail = (tail + 1) & (strs.length - 1)) == head) {
			assert head == tail;
			int p = head;
			int n = strs.length;
			int r = n - p; // number of elements to the right of p
			int newCapacity = n << 1;
			if (newCapacity < 0)
				throw new IllegalStateException("Sorry, deque too big");
			String[] a = new String[newCapacity];
			System.arraycopy(strs, p, a, 0, r);
			System.arraycopy(strs, 0, a, r, p);
			strs = a;
			head = 0;
			tail = n;
		}
		return true;
	}

	public static void main(String[] args) {
		Queue queue = new Queue();
		for (int i = 0; i < 24; i++) {
			queue.join("a" + i);
		}
		System.err.println(queue.head);
		System.err.println(queue.tail);
		for (int i = 0; i < 24; i++) {
			System.out.println(queue.pop());
		}

	}
}
