package com.example.jvm;

/**
 * @author xupeng
 *
 */
public class StackErrorMock {
	private static int index = 1;

	public void call() {
		index++;
		call();
	}

	public static void main(String[] args) {
		StackErrorMock mock = new StackErrorMock();
		try {
			mock.call();
		} catch (Throwable e) {
			/**
			 * 多次执行栈深度是不一样的
			 */
			System.out.println("Stack deep : " + index);
			e.printStackTrace();
		}
	}
}