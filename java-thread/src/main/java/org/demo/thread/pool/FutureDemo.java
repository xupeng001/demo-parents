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
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.assertj.core.util.Lists;

public class FutureDemo {

	public static void main(String[] args) {

		ExecutorService executorService = Executors.newSingleThreadExecutor();

		try {
			long start = System.currentTimeMillis();
			BuildTask buildTask = null;
			List<BuildTask> tasks = new ArrayList<FutureDemo.BuildTask>(1000000);
			for (int i = 0; i < 1000000; i++) {
				buildTask = new BuildTask();
				tasks.add(buildTask);
			}
			System.out.println(System.currentTimeMillis() - start);
			start = System.currentTimeMillis();
			List<Future<String>> futures = executorService.invokeAll(tasks, 10,
					TimeUnit.SECONDS);
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

	static class BuildTask implements Callable<String> {

		@Override
		public String call() throws Exception {
			return UUID.randomUUID().toString();
		}

	}
}
