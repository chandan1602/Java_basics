package multithreading;

public class CThreadExample {
	public static void main(String[] args) {
		Runnable runnable = () -> {
			for(int i=0; i<5; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Running");
			}
		};
		Thread thread = new Thread(runnable);
		thread.setDaemon(true); //Terminates this thread when the main thread terminates
		thread.start();
		
		try {
			thread.join(); //Waits for this thread to die
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//Threads in java are managed by the operating system
		//OS based threads are necessary sometimes
		//Project LOOM - filters
		
		
	}
}
