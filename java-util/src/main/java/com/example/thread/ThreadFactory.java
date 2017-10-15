package com.example.thread;

import java.util.concurrent.BlockingQueue;

public class ThreadFactory {

	public static Thread newThread(final BlockingQueue<Runnable> tasks) {
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				for (;;) {
					try {
						Runnable task = tasks.take(); // 阻塞方法，直到取到任务为止
						task.run();
					} catch (InterruptedException e) {
						throw new RuntimeException(e);
					}
				}
			}
		});
		return t;
	}

	private ThreadFactory() {
	}
}