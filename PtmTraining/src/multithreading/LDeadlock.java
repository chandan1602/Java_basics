package multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LDeadlock {
	public static void main(String[] args) {
		 Lock l1 = new ReentrantLock();
		 Lock l2 = new ReentrantLock();
		 
		 Runnable r1 = new LRunnable1(l1, l2);
		 Runnable r2 = new LRunnable2(l1, l2);
		 
		 Thread t1 = new Thread(r1);
		 Thread t2 = new Thread(r2);
		 
		 t1.start();
		 t2.start();
	}
}


//First Locks lock1
//waits for 3sec
//Tries to lock lock2
class LRunnable1 implements Runnable {
	private Lock lock1 = null;
	private Lock lock2 = null;
	
	public LRunnable1(Lock lock1, Lock lock2) {
		this.lock1 = lock1;
		this.lock2 = lock2;
	}
	
	@Override
	public void run() {
		String threadname = Thread.currentThread().getName();
		System.out.println(threadname + " attempting to lock lock1");
		lock1.lock();
		System.out.println(threadname + "locked lock1");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(threadname + " attempting to lock lock2");
		lock2.lock();
		System.out.println("locked lock2");
		
		//do somethinf
		
		System.out.println("Unlocking lock1");
		lock1.unlock();
		System.out.println("Unlocking lock2");
		lock2.unlock();
	}
	
	
}


//First Locks lock2
//waits for 3sec
//Tries to lock lock1
class LRunnable2 implements Runnable {
	private Lock lock1 = null;
	private Lock lock2 = null;
	
	public LRunnable2(Lock lock1, Lock lock2) {
		this.lock1 = lock1;
		this.lock2 = lock2;
	}
	
	@Override
	public void run() {
		String threadname = Thread.currentThread().getName();
		System.out.println(threadname + " attempting to lock lock2");
		lock2.lock();
		System.out.println(threadname + "locked lock2");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(threadname + " attempting to lock lock1");
		lock1.lock();
		System.out.println("locked lock1");
		
		//do something
		
		System.out.println("Unlocking lock1");
		lock1.unlock();
		System.out.println("Unlocking lock2");
		lock2.unlock();
	}
	
	
}