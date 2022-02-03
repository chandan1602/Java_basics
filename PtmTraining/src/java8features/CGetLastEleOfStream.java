package java8features;

import java.util.Arrays;
import java.util.List;

public class CGetLastEleOfStream {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("node", "java", "c++", "react", "javascript");
		//Method 0
		//Without stream
		String result = list.get(list.size() - 1);
		System.out.println(result);
		
		//Method 1
		//Stream.reduce
		result = list.stream().reduce((first, second) -> second).orElse("no last element");
		System.out.println(result);
		
		//Method 2
		//Stream.skip
		String result2 = list.stream().skip(list.size() - 1).findFirst().orElse("no last element");
		System.out.println(result2);
		
		
	}
}
