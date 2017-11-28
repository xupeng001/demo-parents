package org.demo.thread.pool;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class BuildId {

	public static void main(String[] args) {

		ExecutorService executorService = Executors.newSingleThreadExecutor();

		try {
			int num = 1000;
			int x = Runtime.getRuntime().availableProcessors() * 10000;
			long start = System.currentTimeMillis();
			CountDownLatch latch = new CountDownLatch(x);
			List<BuildTask> tasks = new ArrayList<BuildId.BuildTask>(100000000);
			ExecutorService service = Executors.newCachedThreadPool();
			for (int i = 0; i < x; i++) {
				service.execute(new Builder(tasks, num, latch));
			}
			latch.await();
			service.shutdown();
			System.out.println(System.currentTimeMillis() - start);
			start = System.currentTimeMillis();
			List<Future<String>> futures = executorService.invokeAll(tasks);
			System.out.println(System.currentTimeMillis() - start);
			start = System.currentTimeMillis();
			Set<String> set = new HashSet<String>();
			for (Future<String> future : futures) {
				set.add(future.get());
			}
			System.out.println(set.size());
			System.out.println(System.currentTimeMillis() - start);
			start = System.currentTimeMillis();
			// System.out.println(set.toString());

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block

		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
		}

		System.out.println("finish");
		executorService.shutdown();

	}

	static class Builder implements Runnable {

		List<BuildTask> tasks;

		public int x;

		CountDownLatch latch;

		public Builder(List<BuildTask> tasks, int x, CountDownLatch latch) {
			super();
			this.tasks = tasks;
			this.x = x;
			this.latch = latch;
		}

		@Override
		public void run() {
			List<BuildTask> tempTasks = new ArrayList<BuildId.BuildTask>(x);
			for (int i = x; i > 0; i--) {
				tempTasks.add(new BuildTask());
			}
			synchronized (tasks) {
				tasks.addAll(tempTasks);
			}

			latch.countDown();

		}
	}

	static class BuildTask implements Callable<String> {

		@Override
		public String call() throws Exception {
			return UUID.randomUUID().toString();
		}

	}
}
