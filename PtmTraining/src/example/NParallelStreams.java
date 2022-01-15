package example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import javax.naming.LimitExceededException;

public class NParallelStreams {
	public static void main(String[] args) {
		//Example 1
		//using parallel
		System.out.println("Normal....");
		IntStream range = IntStream.rangeClosed(1, 10);
		range.forEach(System.out::println);
		
		System.out.println("Parallel...");
		IntStream range2 = IntStream.rangeClosed(1, 10);
		range2.parallel().forEach(System.out::println);
		
		
		
		//Example 2
		//using parallelStream
		System.out.println("Normal");
	
		List<String> alpha = getData();
		alpha.stream().forEach(System.out::println);
		
		System.out.println("Parallel...");
		List<String> alpha2 = getData();
		alpha2.parallelStream().forEach(System.out::println);
		
		
		
		//Example 3
		//Whether range is parallel
		range = IntStream.rangeClosed(1, 10);
		System.out.println("Is range Parallel? " + range.isParallel());
		IntStream ps = range.parallel();
		System.out.println("Is range Parallel? " + ps.isParallel());
		
		
		
		//Example 4
		//Printing Thread name
		System.out.println("-------------\nNormal...");
		range = IntStream.rangeClosed(1, 5);
		range.forEach(x -> {
			System.out.println("Thread : " + Thread.currentThread().getName() + ", value: " + x);
		});
		System.out.println("Parallel...");
		range = IntStream.rangeClosed(1, 5);
		range.parallel().forEach(x -> {
			System.out.println("thread : " + Thread.currentThread().getName() + ", value: " + x);
		});
		
		
		
		
		//Example 5
		//Print primes upto 1 million;
		long count = Stream.iterate(0, n -> n+1)
				.limit(1_000_000)
				.parallel() //with this 23s, without this 1m 10s
				.filter(NParallelStreams::isPrime)
				.peek(x -> System.out.format("%s\t",x))
				.count();
		System.out.println("\nTotal: " + count);
	}
	
	private static List<String> getData() {
		List<String> alpha = new ArrayList<>();
		
		int n = 97;
		while(n<=122) {
			char c = (char) n;
			alpha.add(String.valueOf(c));
			n++;
		}
		return alpha;
	}
	
	public static boolean isPrime(int number) {
		if(number<=1) return false;
		return !IntStream.rangeClosed(2, (int)Math.sqrt(number)).anyMatch(i -> number%i==0);
	}
}
