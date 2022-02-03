package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HThreadPool {
	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(3);
		
		for(int i=0; i<1000; i++) {
			int taskNo = i;
			pool.execute(() -> {
				String message = String.format("%s : Task %d", Thread.currentThread().getName(), taskNo);
				System.out.println(message);
			});
		}
		pool.shutdown();
		
//		ThreadPool pool = new ThreadPool(3, 10);
//		
//		for(int i=0; i<10000; i++) {
//			int taskNo = i;
//			pool.execute(() -> {
//				String message = String.format("%s : Task %d", Thread.currentThread().getName(), taskNo);
//				System.out.println(message);
//			});
//		}
//		pool.waitUntilAllTasksFinished();
//		pool.stop();
	}
	
	
}

//Creating your own thread pool
class ThreadPool {
	private BlockingQueue<Runnable> taskQueue = null;
	private List<PoolThreadRunnable> runnables = new ArrayList<>();
	private boolean isStopped = false;
	
	public ThreadPool(int noOfThreads, int maxThreads) {
		taskQueue = new ArrayBlockingQueue<Runnable>(maxThreads);
		
		for(int i=0; i<noOfThreads; i++) {
			PoolThreadRunnable poolThreadRunnable = 
					new PoolThreadRunnable(taskQueue);
			runnables.add(poolThreadRunnable);
		}
		for(PoolThreadRunnable runnable: runnables) {
			new Thread(runnable).start();
		}
	}
	
	public synchronized void execute(Runnable task) {
		if(this.isStopped) throw new 
		IllegalStateException("ThreadPool is stopped");
		this.taskQueue.offer(task);
	}
	
	public synchronized void stop() {
		this.isStopped = true;
		for(PoolThreadRunnable runnable: runnables) {
			runnable.doStop();
		}
	}
	
	public synchronized void waitUntilAllTasksFinished() {
		while(this.taskQueue.size()>0) {
			try {
				Thread.sleep(1);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
}

class PoolThreadRunnable implements Runnable {
	private Thread thread = null;
	private BlockingQueue<Runnable> taskQueue = null;
	private boolean isStopped = false;

	public PoolThreadRunnable(BlockingQueue<Runnable> taskQueue) {
		this.taskQueue = taskQueue;
	}
	
	@Override
	public void run() {
		this.thread = Thread.currentThread();
		while(!isStopped()) {
			try {
				Runnable runnable = (Runnable) taskQueue.take();
				runnable.run();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	public synchronized void doStop() {
		isStopped = true;
		this.thread.interrupt();
	}
	
	public synchronized boolean isStopped() {
		return isStopped;
	}
	
	
}