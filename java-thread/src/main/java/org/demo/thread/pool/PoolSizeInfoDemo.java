package org.demo.thread.pool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PoolSizeInfoDemo {

	public static void main(String[] args) throws InterruptedException {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 0L, TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<Runnable>(20), new RejectedExecutionHandlerImpl());

//		i= 5 6 7 10 20 25 27 30 40
		for (int i = 0; i < 60; i++) {
			executor.execute(new Task());
		}
		Thread.sleep(Integer.MAX_VALUE);

	}

	static class Task implements Runnable {
		public void run() {
			try {
				Thread.sleep(100000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	static class RejectedExecutionHandlerImpl implements RejectedExecutionHandler {

		@Override
		public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
			System.out.println(r + "拒绝");
		}

	}
}
