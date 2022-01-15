package example;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BFindDuplicatesInStream {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(5, 3, 4, 1, 3, 7, 2, 9, 9, 4);
		//Method 1 -> By Use of Sets
		//Set.add() returns false if the elements
		//was already in a set
		//JMH Benchmark -> Fastest
		Set<Integer> result = findDuplicateBySetAdd(list);
		result.forEach(x -> System.out.print(x + " "));
		System.out.println("\n");
		
		
		
		//Method 2 -> By use of Map and Collectors.groupingBy
		//Create a map by COllectors.groupingBy &
		//Find the elements that count>1
		result = findDuplicatesByGrouping(list);
		result.forEach(x -> System.out.print(x + " "));
		System.out.println("\n");
		
		
		
		
		//Method 3 -> It compares each item with a list
		// - Collections.frequency(list, i)
		//JMH Benchmark -> Slowest
		result = findDuplicatesByFrequency(list);
		result.forEach(x -> System.out.print(x + " "));
		System.out.println("\n");
			
		
	}
	
	public static <T> Set<T> findDuplicateBySetAdd(List<T> list) {
		Set<T> items = new HashSet<>();
		return list.stream()
				.filter(n -> !items.add(n))
				.collect(Collectors.toSet());
	}
	
	public static <T> Set<T> findDuplicatesByGrouping(List<T> list) {
		return list.stream()
				.collect(Collectors.groupingBy(Function.identity(), 
						Collectors.counting()))
				.entrySet().stream()
				.filter(m -> m.getValue() > 1)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
	}
	
	public static <T> Set<T> findDuplicatesByFrequency(List<T> list) {
		return list.stream()
				.filter(i -> Collections.frequency(list, i) > 1)
				.collect(Collectors.toSet());
	}
}
