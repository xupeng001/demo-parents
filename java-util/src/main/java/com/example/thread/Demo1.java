package com.example.thread;

//实现4个线程，两个线程加1，两个线程减1
public class Demo1 {

	private static int j = 0;
	private A a = new A();

	// 构造函数
	public Demo1() {

		System.out.println("j的初始值为:" + j);
		for (int i = 0; i < 2; i++) {

			new Thread(new Runnable() {

				public void run() {

					for (int k = 0; k < 5; k++) {
						a.add1();
					}
				}
			}).start();

			new Thread(new Runnable() {

				public void run() {

					for (int k = 0; k < 5; k++) {
						a.delete1();
					}
				}
			}).start();
		}
	}

	class A {

		public synchronized void add1() {

			j++;
			System.out.println(Thread.currentThread().getName() + "对j加1，目前j="
					+ Demo1.j);
		}

		public synchronized void delete1() {

			j--;
			System.out.println(Thread.currentThread().getName() + "对j减1，目前j="
					+ Demo1.j);
		}
	}

	// 用于测试的主函数
	public static void main(String[] args) {

		Demo1 demo = new Demo1();
	}
}