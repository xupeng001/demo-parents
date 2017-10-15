package com.example.thread;

/*
 * function:主线程执行10次，子线程执行10次，
 * 此过程重复50次
 */
public class ThreadProblem {

	public ThreadProblem() {

		final Business bus = new Business();
		new Thread(new Runnable() {

			public void run() {

				for (int j = 0; j < 50; j++) {

					bus.sub(j);
				}
			}
		}).start();

		for (int j = 0; j < 50; j++) {

			bus.main(j);
		}
	}

	class Business {

		private boolean tag = true;

		public synchronized void sub(int num) {

			if (!tag) {

				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			for (int i = 0; i < 10; i++) {
				System.out.println("sub thread " + i + ",loop " + num + ".");
			}

			tag = false;
			notify();
		}

		public synchronized void main(int num) {

			if (tag) {

				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			for (int i = 0; i < 10; i++) {

				System.out.println("main thread " + i + ",loop " + num + ".");
			}

			tag = true;
			notify();
		}
	}

	public static void main(String[] args) {

		ThreadProblem problem = new ThreadProblem();
	}
}