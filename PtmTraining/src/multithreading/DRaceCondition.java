package multithreading;

//Certain other scenarios
//One thread reads, other writes
//Two threads access the same object, but do not write to the same object
//ConcurrentHashMap Example

public class DRaceCondition {
	public static void main(String[] args) {
		Runnable runnable = new DMyThread();
		Thread t1 = new Thread(runnable);
		Thread t2 = new Thread(runnable);
		t1.start();
		t2.start();
	}
}

class DMyThread implements Runnable {
	private int count;
	@Override
	public void run() {
		for(long i=0; i<100_000_000; i++) {
			synchronized (this) { //Eliminates race condition and gives right final result as 200M
				this.count++;
			}
		}
		System.out.println(Thread.currentThread().getName() + " : " + this.count);
	}
}
