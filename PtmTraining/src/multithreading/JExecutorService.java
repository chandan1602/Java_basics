package multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class JExecutorService {
	public static void main(String[] args) {
//		ExecutorService executorService = 
//				Executors.newFixedThreadPool(10);
		int corePoolSize = 10;
		int maxPoolSize = 20;
		long keepAliveTime = 3000;
		
		ExecutorService executorService = 
				new ThreadPoolExecutor(
						corePoolSize, 
						maxPoolSize, 
						keepAliveTime, 
						TimeUnit.MILLISECONDS, 
						new ArrayBlockingQueue<Runnable>(128));
		executorService.execute(newRunnable("Task 1"));
		executorService.execute(newRunnable("Task 2"));
		executorService.execute(newRunnable("Task 3"));
		
		//Future
		System.out.println("-----------FUTURE 1---------------");
		Future future = executorService.submit(newRunnable("Future Task 1"));
		System.out.println(future.isDone());
		
		try {
			future.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		System.out.println(future.isDone());
		
		System.out.println("-----------FUTURE 2---------------");
		//Using Callable
		Future future2 = executorService.submit(newCallable("Future Task 2 With Callable"));
		System.out.println(future2.isDone());
		
		//To cancel future
//		boolean mayInterrupt = true;
//		boolean wasCancelled = future2.cancel(mayInterrupt);
//		System.out.println(wasCancelled);
		
		try {
			String result = (String) future2.get();
			System.out.println(result);
		} catch (InterruptedException | ExecutionException | CancellationException e) {
			e.printStackTrace();
		}
		
		System.out.println(future2.isDone());
		System.out.println(future2.isCancelled());
		
		
		//Other methods of executorService include 
		//invokeAny -> first response is saved rest api's are cancelled
		//invokeAll -> All results are collected.
		executorService.shutdown();
	}

	
	
	private static Callable newCallable(String string) {
		return new Callable() {
			@Override
			public Object call() throws Exception {
				String completeMsg = Thread.currentThread().getName() + 
						": " + string;
				return completeMsg;
			}
		};
	}



	private static Runnable newRunnable(String string) {
		return new Runnable() {
			@Override
			public void run() {
				String completeMsg = Thread.currentThread().getName() + 
						": " + string;
				System.out.println(completeMsg);
			}
		};
	}
}
