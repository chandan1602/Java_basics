package example;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class KBiConsumer {
	public static void main(String[] args) {
		//BiConsumer is a fnctional interface
		//it takes two arguments and returns nothing
		BiConsumer<Integer, Integer> addTwo = (x,y) -> System.out.println(x+y);
		addTwo.accept(1, 2);
		
		//Higher Order Function
		//accepts BiConsumer as an argument
		//create a generic addTwo to join two objects
		addTwo(1,2,(x,y)->System.out.println(x+y));
		addTwo("Node", ".js", (x,y) -> System.out.println(x+y));
		
		//Map.forEach
		Map<Integer, String> map = new LinkedHashMap<>();

        map.put(1, "Java");
        map.put(2, "C++");
        map.put(3, "Rust");
        map.put(4, "JavaScript");
        map.put(5, "Go");
        System.out.println("\n Map.forEach Method");
        map.forEach((k,v)->System.out.println(k+":"+v));
	}
	static <T> void addTwo(T a1, T a2, BiConsumer<T, T> c) {
		c.accept(a1, a2);
	}
}
