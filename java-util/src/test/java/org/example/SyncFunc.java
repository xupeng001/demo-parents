package org.example;

//public class SyncFunc {

//
//	public synchronized void func1() {
//		System.out.println(Thread.currentThread().getName() + " is running");
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		System.out.println(Thread.currentThread().getName() + " is stop");
//	}
//
//	public static void main(String[] args) {
//
//		NewThread newThread1 = new NewThread();
//		NewThread newThread2 = new NewThread();
//		NewThread newThread3 = new NewThread();
//
//		newThread1.start();
//		newThread2.start();
//		newThread3.start();
//
//	}
//}
////
////class NewThread extends Thread {
////
////	SyncFunc syncFunc = new SyncFunc();
////
////	@Override
////	public void run() {
////		syncFunc.func1();
////	}
////
////}
//
//
//class NewThread extends Thread {
//
//	SyncFunc syncFunc = new SyncFunc();
//
//	@Override
//	public void run() {
//		syncFunc.func1();
//	}
//
//}

//public class SyncFunc {  
//	  
//    public synchronized void func1() {  
//        System.out.println(Thread.currentThread().getName() + " is running");  
//        try {  
//            Thread.sleep(3000);  
//        } catch (InterruptedException e) {  
//            e.printStackTrace();  
//        }  
//        System.out.println(Thread.currentThread().getName() + " is stop");  
//    }  
//  
//    public static void main(String[] args) {  
//  
//        NewThread newThread1 = new NewThread();  
//        NewThread newThread2 = new NewThread();  
//        NewThread newThread3 = new NewThread();  
//  
//        newThread1.start();  
//        newThread2.start();  
//        newThread3.start();  
//  
//    }  
//}  
//  
class NewThread extends Thread {

	SyncFunc syncFunc = new SyncFunc();

	@Override
	public void run() {
		syncFunc.func1();
	}

}

public class SyncFunc {

	private Object lock = new Object();

	public void func1() {
		synchronized (lock) {
			System.out.println(Thread.currentThread().getName() + " is running");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " is stop");
		}

	}

	public static void main(String[] args) {

		SyncFunc syncFunc = new SyncFunc();
		NewThread newThread1 = new NewThread();
		NewThread newThread2 = new NewThread();
		NewThread newThread3 = new NewThread();
		// NewThread newThread1 = new NewThread(syncFunc);
		// NewThread newThread2 = new NewThread(syncFunc);
		// NewThread newThread3 = new NewThread(syncFunc);

		newThread1.start();
		newThread2.start();
		newThread3.start();

	}
}

// class NewThread extends Thread {
//
// SyncFunc syncFunc;
//
// public NewThread(SyncFunc syncFunc) {
// this.syncFunc = syncFunc;
// }
//
// @Override
// public void run() {
// syncFunc.func1();
// }
//
// }
