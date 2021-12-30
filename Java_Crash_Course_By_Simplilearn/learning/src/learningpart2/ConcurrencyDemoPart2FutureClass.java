package learningpart2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ConcurrencyDemoPart2FutureClass {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		
		Future<String> future = executorService.submit(() -> {
			Thread.sleep(10000);
			return "Completed";
		});
		
		try {
			while(!future.isDone()) {
				System.out.println("Task still in progress...wait");
				Thread.sleep(500);
			}
			
			System.out.println("Task completed!");
			String result = future.get(3000, TimeUnit.MILLISECONDS);
			System.out.println(result);
			
			executorService.shutdown();
			
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			// TODO: handle exception
			future.cancel(true);
			future.isDone();
			future.isCancelled();
		}
	}
}
