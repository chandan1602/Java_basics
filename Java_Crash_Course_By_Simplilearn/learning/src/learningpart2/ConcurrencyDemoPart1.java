package learningpart2;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * package used : java.util.concurrent
 * -contains locks, atomic packages, executors
 * 
 * Some interesting classes are:
 * 1. Executors:
 * 	-interface for defining thread-like subsystems,
 * 	-including thread pools, async IO, lightweight task frameworks.
 * 
 * 2. ExecutorService:
 * 	-more complete async task execution framework
 * 
 * 3. Future:
 * 	-fetch the results of submitted task
 */



public class ConcurrencyDemoPart1 {
	public static void main(String[] args) {
		executorInvoke();
		executorServiceInvoke();
	}
	
	private static void executorInvoke() {
		Executor executor = new Caller();
		executor.execute(() -> {
			System.out.println("executor example");
		});
	}
	
	private static void executorServiceInvoke() {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		executorService.submit(() -> {
			System.out.println("executor service example");
		});
	}
}

class Caller implements Executor {
	@Override
	public void execute(Runnable runnable) {
		runnable.run();
	}
}