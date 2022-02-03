package multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ILock {
	public static void main(String[] args) {
//		Counter counter = new Counter();
//		Thread t1 = new Thread(() -> {
//			for(int i=0; i<10000; i++) {
//				counter.inc();
//			
//			}
//		});
		
		
//		lockBasics();
		
//		lockInterruptibility();
		
		tryLock();
	}

	private static void tryLock() {
		Lock lock = new ReentrantLock();
		try {
			boolean lockSuccessful = lock.tryLock(); //does not provide fairness
			System.out.println("Lock successful : " + lockSuccessful);			
		} finally {
			lock.unlock();
		}
		
	}

	private static void lockInterruptibility() {
		Lock lock = new ReentrantLock();
//		Thread.currentThread().interrupt();
		try {
			//will only lock if thread trying to lock has not been interrupted
			//else exception is thrown
			lock.lockInterruptibly(); 
			lock.unlock();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static void lockBasics() {
		Lock lock = new ReentrantLock(false);
		Runnable runnable = () -> {
			lockSleepUnlock(lock, 1000);
		};
		Thread t1 = new Thread(runnable, "T1");
		Thread t2 = new Thread(runnable, "T2");
		Thread t3 = new Thread(runnable, "T3");
		
		t1.start();
		t2.start();
		t3.start();
	}

	private static void lockSleepUnlock(Lock lock, int timeInMillis) {
		try {
			lock.lock();
			printThreadMsg(" holds the lock");
			sleep(timeInMillis);
		} finally {
			lock.unlock();
		}
	}

	private static void sleep(int timeInMillis) {
		try {
			Thread.sleep(timeInMillis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static void printThreadMsg(String string) {
		System.out.println(Thread.currentThread().getName() + string);		
	}
}

class Counter {
	private long count = 0;
	
	private Lock lock = new ReentrantLock(true); //true is for lock fairness
	
	public void inc() {
		try {
			lock.lock();
			this.count++;
		} finally {
			lock.unlock();
		}
	}

	public long getCount() {
		try {
			lock.lock();
			return this.count;
		} finally {
			lock.unlock();
		}
	}
}
