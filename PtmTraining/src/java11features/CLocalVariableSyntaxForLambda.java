package java11features;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//var keyword in lambda

public class CLocalVariableSyntaxForLambda {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("a", "b", "c", "");
		String result = list.stream()
				.map( (var x) -> x.toUpperCase())
				.collect(Collectors.joining(","));
		System.out.println(result);
	}
}

