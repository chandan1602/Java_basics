package example;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class GIntStreamToInt {
	public static void main(String[] args) {
		//Example 1:
		//IntStream -> int
		int[] num = {1,2,3,4,5};
		//1. int[] -> IntStream
		IntStream stream = Arrays.stream(num);
		//2. OptionalInt
		OptionalInt first = stream.findFirst();
		//3. getAsInt()
		int result = first.getAsInt();
		System.out.println(result);
		//one line
		System.out.println(Arrays.stream(num).findFirst().getAsInt());
		
		
		
		//Example 2:
		//IntStream -> int[] or Integer[]
		//InputStream -> int[]
		stream = Arrays.stream(num);
		int[] ints = stream.toArray();
		//IntStream -> Integer[]
		IntStream stream2 = Arrays.stream(num);
		Integer[] integers = stream2.boxed().toArray(Integer[]::new);
		
	}
}
