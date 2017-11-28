package com.example.qps;

import java.util.ArrayDeque;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xupeng
 *
 *         单位时间访问量控制拒绝访问限制
 */
public class ProductRejectApp {

	static String ip = "192.168.1.190";

	static Map<String, ArrayDeque<Date>> map = new ConcurrentHashMap<String, ArrayDeque<Date>>();

	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		executorService.execute(new RequestTask(2000));
		executorService.execute(new RequestTask(5000));
		executorService.execute(new RequestTask(10000));
		executorService.execute(new RequestTask(20000));
		executorService.execute(new RequestTask(30000));
		executorService.shutdown();
	}

	static class RequestTask implements Runnable {

		private int x;

		public RequestTask(int x) {
			this.x = x;
		}

		@Override
		public void run() {
			try {
				while (true) {
					ArrayDeque<Date> arrayDeque = map.get(ip);
					if (arrayDeque == null) {
						arrayDeque = new ArrayDeque<Date>();
						arrayDeque.addLast(new Date());
						map.put(ip, arrayDeque);
					} else {
						synchronized (arrayDeque) {
							if (arrayDeque.size() < 100) {
								arrayDeque.addLast(new Date());
							} else {
								if (isReject(new Date(), arrayDeque.getFirst(),
										60)) {
									System.out.println("服务被拒绝");
									Thread.sleep(x);
								}
								arrayDeque.removeFirst();
								arrayDeque.addLast(new Date());
							}
						}
					}
					System.out.println(arrayDeque.size());
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static boolean isReject(Date now, Date old, int ms) {
		if ((System.currentTimeMillis() - old.getTime()) < ms * 1000) {
			return true;
		} else {
			return false;
		}

	}

}
