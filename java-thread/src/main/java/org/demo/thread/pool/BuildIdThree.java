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

public class BuildIdThree {
	static final ExecutorService executorService = Executors
			.newFixedThreadPool(5);

	public static void main(String[] args) throws InterruptedException {

		int num = 999;
		int x = Runtime.getRuntime().availableProcessors() * 10000;
		// x = 1;
		long start = System.currentTimeMillis();
		CountDownLatch latch = new CountDownLatch(x);
		Set<String> set = new HashSet<String>();
		ExecutorService service = Executors.newFixedThreadPool(5);
		// ExecutorService service = Executors.newCachedThreadPool();
		for (int i = 0; i < x; i++) {
			service.execute(new Builder(set, num, latch));
		}
		latch.await();

		System.out.println(System.currentTimeMillis() - start);
		System.out.println(set.size());
		service.shutdown();
		executorService.shutdown();

	}

	static class Builder implements Runnable {

		Set<String> set;

		public int x;

		CountDownLatch latch;

		public Builder(Set<String> set, int x, CountDownLatch latch) {
			super();
			this.set = set;
			this.x = x;
			this.latch = latch;
		}

		@Override
		public void run() {
			List<BuildTask> tempTasks = new ArrayList<BuildIdThree.BuildTask>(x);
			for (int i = x; i > 0; i--) {
				tempTasks.add(new BuildTask());
			}

			Set<String> tempSet = new HashSet<String>();
			try {
				List<Future<String>> futures = executorService
						.invokeAll(tempTasks);

				for (Future<String> future : futures) {
					tempSet.add(future.get());
				}

			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			synchronized (set) {
				set.addAll(tempSet);
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
