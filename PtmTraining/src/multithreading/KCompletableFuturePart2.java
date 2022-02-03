package multithreading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;


public class KCompletableFuturePart2 {
	public static void main(String[] args) {
		CompletableFuture<Integer> future = new CompletableFuture<>();
//		future.completeOnTimeout(500, 3, TimeUnit.SECONDS); //complete on timeout
		future.orTimeout(3, TimeUnit.SECONDS); //blow up if not completed in 3 sec
		process(future);
		sleep(2000);
//		future.complete(2);
//		future.completeExceptionally(new RuntimeException("something went wrong"));
		sleep(5000);
	}

	private static void sleep(int i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static void process(CompletableFuture<Integer> future) {
		future
		.exceptionally(throwable -> handle(throwable))
		.thenApply(data -> data*2)
		.thenApply(data -> data + 1)
		.thenAccept(System.out::println);
	}

	private static int handle(Throwable throwable) {
		System.out.println("ERROR : " + throwable);
		return 100; //recovery
//		throw new RuntimeException("This is beyond repair"); //no recovery
	}
}
