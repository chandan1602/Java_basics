package java11features;

import java.util.function.IntUnaryOperator;

public class EUnicode10 {
	
	public static void main(String[] args) {
		String codepoint = "U+1F92A";
		System.out.println(covertCodePoints(codepoint));
	}

	private static char[] covertCodePoints(String codepoint) {
		Integer i = Integer.valueOf(codepoint.substring(2), 16); //UTF-16
		char[] chars = Character.toChars(i);
		return chars;
	}
	
}
