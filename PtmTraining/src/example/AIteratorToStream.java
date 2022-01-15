package example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class AIteratorToStream {
	public static void main(String[] args) {
		System.out.println("Converting Iterator to Stream!");
		List<String> list = new ArrayList<>();
		list.add("10");
		list.add("20");
;		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
//		list.add(3);
//		List<Integer> ls = list.stream()
//				.filter(e -> e%2==0)
//				.map(e -> e*2)
//				.collect(Collectors.toList());
//		System.out.println(ls);
		//Iterator -> Spliterator -> Stream -> List
		List<Integer> result = StreamSupport.stream(
				Spliterators.spliteratorUnknownSize(
						it,
						Spliterator.ORDERED), 
				false)
				.map(x -> x.length())
				.collect(Collectors.toList());
		result.forEach(x -> System.out.print(x + " "));
		System.out.println("\n" + result.getClass());
		
		System.out.println("Converting Iterable to Stream since it has the spliterable() method");
		Iterable<Integer> it2 = Arrays.asList(1,2,3,4,5);
		
		//Iterable -> Spliterators -> Stream -> List
		List<Integer> result2 = StreamSupport.stream(
				it2.spliterator(), false)
				.map(x -> x*10)
				.collect(Collectors.toList());
		result2.forEach(x -> System.out.print(x + " "));
		System.out.println("\n" + result2.getClass());
		
		
		
		
		
		
		
		
		
		/////////////////////////////////////////////////////
		//Finding Duplicate Elements in a Stream
		
		
	}
}
