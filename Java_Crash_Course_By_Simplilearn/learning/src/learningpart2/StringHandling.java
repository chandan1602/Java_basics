package learningpart2;

import java.util.Arrays;

public class StringHandling {
	public static void main(String[] args) {
		String s1 = "John is studying";
		String s2 = "in college";
		
		System.out.println(s1.length());
		
		String result = s1.concat(s2);
		System.out.println(result);
		
		String r = String.format("The name of the student is " + "%s, and the age is " + "%d", "John", 21);
		System.out.println(r);
		
		System.out.println(s1.charAt(5));
		
		if(s1.equals(s2)) {
			System.out.println("Equal");
		} else {
			System.out.println("Different");
		}
		
		System.out.println(s1.indexOf("y"));
		
		System.out.println(s1.replace('i', '$'));

		String[] arr = s1.split(" ");
		Arrays.asList(arr).forEach(System.out::println);
		
		String newS1 = s1.substring(1,5);
		System.out.println(newS1);
		
		
		
		
	}
}
