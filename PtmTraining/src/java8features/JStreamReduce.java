package java8features;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JStreamReduce {
	public static void main(String[] args) {
		//Example 1
		int nums[] = {1,2,3,4,5,6,7,8,9,10};
		//Simple Code
		//		int sum = 0;
		//		for(int i : nums) {
		//			sum+=i;
		//		}
		//		System.out.println("Simple Method Sum: " + sum);
		//		int sum = Arrays.stream(nums).reduce(0, (a,b)->a+b);
		int sum = Arrays.stream(nums).reduce(0, Integer::sum);
		System.out.println("Sum by Reduce and Method Reference : " + sum);




		//New Topic
		//Convert Optional<String> to String
		List<String> list = Arrays.asList("a", "b", "c", "d", "e");
		Optional<String> result = list.stream()
				.filter(x -> x.length()==1)
				.findFirst();
		if(result.isPresent()) {
			System.out.println(result.get());
		}

		String s = list.stream().filter(x -> x.length()==1)
				.findFirst()
				.map(Object::toString)
				.orElse(null);
		System.out.println(s);





		//New Topic
		//forEach print with index
		String[] names = {"Java", "Node", "Javascript", "Rust", "Go"};
		List<String> collect = IntStream.range(0, names.length)
				.mapToObj(index -> index + ":" + names[index])
				.collect(Collectors.toList());

		collect.forEach(System.out::println);





		//New Topic
		//List with index
		List<String> list2 = Arrays.asList(names);
		HashMap<Integer, String> collect2 = list2
				.stream()
				.collect(HashMap<Integer, String>::new,
						(map, streamValue) -> map.put(map.size(), streamValue),
						(map, map2) -> {	
						});
		System.out.println("\nusing maps");
		collect2.forEach((k,v) -> System.out.println(k + ":" + v));
	}
}
