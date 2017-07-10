package com.example.date;

import java.util.Date;

public class DateUtilsTest {

	public static class TestSimpleDateFormatThreadSafe extends Thread {
		@Override
		public void run() {
			while (true) {
				try {
					this.join(2000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				System.out.println(this.getName() + ":"
						+ DateUtils.getYmd(new Date()));
			}
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			new TestSimpleDateFormatThreadSafe().start();
		}

	}
}
