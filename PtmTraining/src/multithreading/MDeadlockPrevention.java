package multithreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//1. Lock Reordering
//Just change the order the execution of locks as in LDeadlock.java
//2. Timeout back-off
//Both runnables are given random time to re-attempt locking.
//If same time is given, situtation results in livelock
//3. Deadlock detection

public class MDeadlockPrevention {
	public static void main(String[] args) {
		 Lock l1 = new ReentrantLock();
		 Lock l2 = new ReentrantLock();
		 
		 Runnable r1 = new MRunnable1Timeout(l1, l2);
		 Runnable r2 = new MRunnable2Timeout(l1, l2);
		 
		 Thread t1 = new Thread(r1);
		 Thread t2 = new Thread(r2);
		 
		 t1.start();
		 t2.start();
	}
}

//First Locks lock1
//waits for 3sec
//Tries to lock lock2
class MRunnable1Timeout implements Runnable {
	private Lock lock1 = null;
	private Lock lock2 = null;
	
	public MRunnable1Timeout(Lock lock1, Lock lock2) {
		this.lock1 = lock1; 
		this.lock2 = lock2;
	}
	
	@Override
	public void run() {
		String threadname = Thread.currentThread().getName();
		while(true) {
			int failureCount = 0;
			while(!tryLockBothLocks()) {
				failureCount++;
				System.err.println(threadname + " failed to lock both locks. " + 
				"Waiting a bit before retrying ["+failureCount+" tries]");
				sleep(100L*((long) Math.random()));
			}
			if(failureCount > 0) {
				System.out.println(threadname + " succeeded in locking"
						+ " both locks- after "+ failureCount + " failures.");
			}
			
			//do something
			
			System.out.println("Unlocking lock1");
			lock1.unlock();
			System.out.println("Unlocking lock2");
			lock2.unlock();
		}	

	}

	private void sleep(long l) {
		try {
			Thread.sleep(l);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private boolean tryLockBothLocks() {
		String threadName = Thread.currentThread().getName();
		try {
			boolean lock1succeded = lock1.tryLock(1000, TimeUnit.MILLISECONDS);
			if(!lock1succeded) return false;
		} catch (InterruptedException e) {
			System.out.println(threadName + " interrupted trying to lock lock1");
			return false;
		}
		
		try {
			boolean lock2succeded = lock2.tryLock(1000, TimeUnit.MILLISECONDS);
			if(!lock2succeded) {
				lock1.unlock();
				return false;
			}
		} catch (InterruptedException e) {
			System.out.println(threadName + " interrupted trying to lock lock2");
			return false;
		}
		return true;
	}
	
	
}


//First Locks lock2
//waits for 3sec
//Tries to lock lock1
class MRunnable2Timeout implements Runnable {
	private Lock lock1 = null;
	private Lock lock2 = null;
	
	public MRunnable2Timeout(Lock lock1, Lock lock2) {
		this.lock1 = lock1;
		this.lock2 = lock2;
	}
	
	@Override
	public void run() {
		String threadname = Thread.currentThread().getName();
		while(true) {
			int failureCount = 0;
			while(!tryLockBothLocks()) {
				failureCount++;
				System.err.println(threadname + " failed to lock both locks. " + 
				"Waiting a bit before retrying ["+failureCount+" tries]");
				sleep(100L*((long) Math.random()));
			}
			if(failureCount > 0) {
				System.out.println(threadname + " succeeded in locking"
						+ " both locks- after "+ failureCount + " failures.");
			}
			
			//do something
			
			System.out.println("Unlocking lock1");
			lock1.unlock();
			System.out.println("Unlocking lock2");
			lock2.unlock();
		}	

	}

	private void sleep(long l) {
		try {
			Thread.sleep(l);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private boolean tryLockBothLocks() {
		String threadName = Thread.currentThread().getName();
		try {
			boolean lock2succeded = lock2.tryLock(1000, TimeUnit.MILLISECONDS);
			if(!lock2succeded) return false;
		} catch (InterruptedException e) {
			System.out.println(threadName + " interrupted trying to lock lock2");
			return false;
		}
		
		try {
			boolean lock1succeded = lock1.tryLock(1000, TimeUnit.MILLISECONDS);
			if(!lock1succeded) {
				lock2.unlock();
				return false;
			}
		} catch (InterruptedException e) {
			System.out.println(threadName + " interrupted trying to lock lock1");
			return false;
		}
		return true;
	}

	
	
}