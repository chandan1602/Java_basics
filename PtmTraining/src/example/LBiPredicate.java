package example;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class LBiPredicate {
	public static void main(String[] args) {
		//BiPredicate is a Functional Interface
		//Accepts two args and returns a boolean
		BiPredicate<String, Integer> filter = (x,y) -> {
			return x.length()==y;
		};
		boolean result = filter.test("chandan", 7);
		System.out.println(result);
		
		result = filter.test("java", 3);
		System.out.println(result);
		
		//BiPredicate is same as BiFunction with a Boolean as return type
		BiFunction<String, Integer, Boolean> func = (x,y)->{
			return x.length()==y;
		};
		System.out.println(func.apply("chandan", 7));
	}
}
