package com.example.qps;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xupeng
 *
 *         单位时间访问量控制拒绝访问限制
 */
public class RejectApp {

	static String ip = "192.168.1.190";

	static Map<String, RequestApp> map = new ConcurrentHashMap<String, RequestApp>();

	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		executorService.execute(new RequestTask(1000));
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
					// Thread.sleep(200);
					RequestApp requestApp = map.get(ip);
					if (requestApp == null) {
						map.put(ip, RequestApp.newInstance(100));
					} else {
						requestApp = requestApp.add();
						map.put(ip, requestApp);
						System.out.println(requestApp.getSize());
						if (requestApp.isFlag()) {
							System.out.println("服务被拒绝");
							Thread.sleep(x);
							continue;
						}
					}

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	static class RequestApp {

		private volatile static RequestApp INSTANCE;

		private RequestApp() {
			// TODO Auto-generated constructor stub
		}

		public static RequestApp newInstance(int threshold) {
			if (INSTANCE == null) {
				synchronized (RequestApp.class) {
					if (INSTANCE == null) {
						INSTANCE = new RequestApp();
						INSTANCE.setThreshold(threshold);
						return INSTANCE;
					}
				}
			}
			return INSTANCE;

		}

		/**
		 * 最高阈值
		 */
		private int threshold;

		public int getThreshold() {
			return threshold;
		}

		public int getSize() {
			return infos.size();
		}

		public void setThreshold(int threshold) {
			this.threshold = threshold;
		}

		private boolean flag = false;

		public boolean isFlag() {
			return flag;
		}

		ArrayDeque<RequestInfo> infos = new ArrayDeque<RejectApp.RequestInfo>();

		// final LinkedList<RequestInfo> infos = new
		// LinkedList<RejectApp.RequestInfo>();

		public RequestApp add() {
			synchronized (infos) {

				if (infos.size() < threshold) {
					infos.addLast(new RequestInfo(ip, System
							.currentTimeMillis()));
					return this;
				}

				if (infos.size() > threshold) {
					throw new RuntimeException("超过阈值");
				}

				/**
				 * 一分钟以内超过了100次
				 */
				if ((System.currentTimeMillis() - infos.getFirst().getMs()) <= 60000) {
					flag = true;
				} else {
					flag = false;
				}
				/**
				 * 在链表最后一个位置添加数据，并且移除链表第一个
				 */
				infos.addLast(new RequestInfo(ip, System.currentTimeMillis()));
				infos.removeFirst();
				return this;
			}
		}

	}

	static class RequestInfo {

		String ip;

		long ms;

		public String getIp() {
			return ip;
		}

		public void setIp(String ip) {
			this.ip = ip;
		}

		public long getMs() {
			return ms;
		}

		public void setMs(long ms) {
			this.ms = ms;
		}

		public RequestInfo(String ip, long ms) {
			super();
			this.ip = ip;
			this.ms = ms;
		}

	}
}
