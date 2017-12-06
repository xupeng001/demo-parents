package com.example.arithmetic.fibonacci;

import java.io.IOException;

/**
 * 类Fibonacci.java的实现描述：斐波那契数列
 * 
 * @author xupeng 2017年8月29日 上午10:29:11
 */
public class FibonacciTest {

	public static void main1(String[] args) throws Exception {
		// for (int i = 0; i < 100; i++) {
		//// System.out.println(fibonacArr(1000000));
		// Thread.sleep(1000);
		// System.out.println(fibonacShotArr(1000000));
		//// System.out.println(fibonacVAR(1000000));
		// }
		Long start = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			fibonacShotArr(1000000);

		}
		long end = System.currentTimeMillis();
		System.err.println(end - start);
		start = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			fibonacVAR(1000000);

		}

		end = System.currentTimeMillis();
		System.err.println(end - start);

		start = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			fibonacArr(1000000);

		}

		end = System.currentTimeMillis();
		System.err.println(end - start);

		// System.out.println(fibonacShotArr(100));
		// System.out.println(fibonacVAR(100));

	}

	public static void main(String[] args) throws Exception {
		try {
			throw new IOException("1");
		} catch (IOException e) {
			throw new Exception("2");
		} catch (Exception e) {

			throw new Exception("3");
		} finally {
//			throw new Exception("4");
			System.out.println("---------");
		}
	}

	public static void main11(String[] args) {
		System.out.println(method());
	}

	public static int method() {
		int x = 1;
		try {
			return x;
		} catch (Exception e) {
			return 0;
		} finally {

			x = x + 12;

			System.out.println("---" + x);
		}

	}

	/**
	 * 线性复杂度
	 * 
	 * @param i
	 * @return
	 */
	private static long fibonacArr(int i) {
		if (i == 0) {
			return 0;
		}
		if (i == 1) {
			return 1;
		}
		long[] fn = new long[i + 1];
		fn[1] = 1;
		fn[0] = 1;
		for (int j = 2; j <= i; j++) {
			fn[j] = fn[j - 1] + fn[j - 2];
		}

		return fn[i];
	}

	/**
	 * 线性复杂度
	 * 
	 * @param i
	 * @return
	 */
	private static long fibonacShotArr(int i) {
		if (i == 0) {
			return 0;
		}
		if (i == 1) {
			return 1;
		}
		long[] fn = new long[3];
		fn[1] = 1;
		fn[0] = 1;
		for (int j = 2; j <= i; j++) {
			fn[2] = fn[0] + fn[1];
			fn[0] = fn[1];
			fn[1] = fn[2];

		}

		return fn[2];
	}

	/**
	 * 线性复杂度
	 * 
	 * @param i
	 * @return
	 */
	private static long fibonacVAR(int i) {
		if (i == 0) {
			return 0;
		}
		if (i == 1) {
			return 1;
		}
		long a = 1;
		long b = 1;
		long c = 2;
		for (int j = 2; j <= i; j++) {
			c = a + b;
			a = b;
			b = c;
		}
		return c;
	}

}
