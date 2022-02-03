package multithreading;

public class AThreadCreation {
	public static class MyThread extends Thread {
		@Override
		public void run() {
			System.out.println("My Thread is running");
		}
	}
	
	public static class MyRunnable implements Runnable {
		@Override
		public void run() {
			System.out.println("My Runnable is running");
		}
	}
	
	
	public static void main(String[] args) {
		//METHOD 1
		MyThread thread1 = new MyThread();
		thread1.start();
		
		//METHOD 2
		Thread thread2 = new Thread(new MyRunnable());
		thread2.start();
		
		//METHOD 3
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				System.out.println("anaonymous class example thread is running");
				
			}
		};
		Thread thread3 = new Thread(runnable);
		thread3.start();
		
		
		//CONTAINS CERTAIN METHODS
		//METHOD 4
		Runnable runnable2 = () -> {
			String threadname = Thread.currentThread().getName();
			System.out.println("lambda expression thread is running " + threadname);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(threadname + "Finished");
		};
		Thread thread4 = new Thread(runnable2, "My thread 4");
		thread4.start();
	}
}
