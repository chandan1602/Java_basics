package learningpart1;

/*
 * 
 * -Process 
 * has a self-contained execution environment.
 * has a complete, private set of basic run-time resources,
 * has its own memory space
 * 
 * -Threads
 * lightweight processes
 * process can have multiple threads
 * creating thread required less resources than creating a process
 * Thread has different states:
 * 	1. ready
 * 	2. running
 * 	3. waiting for IO from user
 * 	4. dead when execution complete
 * 	5. sleep when thread is paused
 * 
 * Two different ways of implementing thread
 * 1. extends Thread
 * Most simple use case
 * 
 * 2. implements Runnable
 * Used when we are already inheriting one class, so we can't 
 * inherit Thread Class because java doesn't support Multiple Inheritance
 * 
 */

class Thread1 extends Thread {
	@Override
	public void run() {
		try {
			System.out.println("Thread1 is running");
		} catch (Exception e) {
			System.out.println("Exception raised " + e);
		}
	}
}

class Thread2 implements Runnable {
	@Override
	public void run() {
		try {
			System.out.println("Thread2 is running");
		} catch (Exception e) {
			System.out.println("Exception raised " + e);
		}
	}
}


public class Multithreading {
	public static void main(String[] args) {
		int n = 10;
		//The threads created do not execute in order they are created.
		//The thread the gets the CPU idle first is executed first
		for (int i=0; i<n; i++) {
			Thread1 t1 = new Thread1();
			t1.start();
			
			Thread t2 = new Thread(new Thread2());
			t2.start();
		}
	}
}