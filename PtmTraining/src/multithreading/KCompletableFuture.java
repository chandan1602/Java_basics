package multithreading;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class KCompletableFuture {
	public static void main(String[] args) {
//		ExecutorService executorService = Executors.newFixedThreadPool(10);
//		executorService.shutdown();
//		//This can loose progress and starts cancelling all tasks
//		List<Runnable> runnables = 
//				executorService.shutdownNow();
		//If in case some tasks were not able to cancel
		
		
//		try {
//			executorService.awaitTermination(
//					3000L, TimeUnit.MILLISECONDS);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		
		
		
		
		//Completable Future -> The promises of Java
		//supplyAsync -> Task performed by first thread
		//thenAccept -> Task performed by same thread
		//thenApply -> Task of mapping like fn performed by same thread
		//thenApplyAsync -> Task performed by another thread
		System.out.println(Thread.currentThread().getName());
		create()
			.thenApply(data -> data*2)
			.thenApply(data -> data+1)
			.thenAccept(data -> printIt(data))
			.thenRun(() -> System.out.println("all done"))
			.thenRun(() -> System.out.println("not really"))
			.thenRun(() -> System.out.println("keep on going"));
		
		//Combine
		create(2).thenCombine(create(3), (a,b) -> a+b)
			.thenAccept(System.out::println);
		
		//for one to one use map->it returns Stream<>
		//for one to many if we use map -> it returns Stream<Stream>>
		//for one to many use flatMap -> it returns Stream<>
		//compose is for flatMap
		create(2).thenCompose(data -> create(data))
		.thenAccept(System.out::println);
		
	}
	
	private static ForkJoinPool fjp = new ForkJoinPool(10);
	
	private static void printIt(Integer data) {
		System.out.println(data);
		System.out.println("printIt : " + Thread.currentThread().getName());
	}

	public static int compute() {
		System.out.println("COMPUTE : " + Thread.currentThread().getName());
		return 2;
	}
	
	public static CompletableFuture<Integer> create() {
		return CompletableFuture.supplyAsync(() -> compute());
//		return CompletableFuture.supplyAsync(() -> compute(), fjp);
	}
	
	public static CompletableFuture<Integer> create(int n) {
		return CompletableFuture.supplyAsync(() -> n);
//		return CompletableFuture.supplyAsync(() -> compute(), fjp);
	}
	
	
	
}
