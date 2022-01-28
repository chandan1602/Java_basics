package learningpart3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Package java.util.regex
 * 
 * Classes:
 * 
 * Pattern
 * 	-represents compiled regular expression
 * 	
 * Matcher
 * 	-provides engine framework that compiles and understands the pattern
 * 	-and finds it in the search string -> true/false
 * 
 * PatternSyntaxException
 * 
 * 
 * Metacharacters means different in regex
 * 	-Supported MCs are:
 * 		- <([{\^-=$!|]})?*+.>
 * 
 * Character Classes:
 * 	-[abc] 
 * 		[] means strictly find
 * 		It will try to find exactly a,b,c
 * 	-[^abc]
 * 		^ means negation 
 * 		It will try to match any character except a,b,c
 * 	-[a-zA-Z] 
 * 		- represents range
 * 		a through z, or A through Z
 * 	-[a-d[m-p]]
 * 		[[]] represents Union 
 * 		a through d, or m through p
 * 	-[a-z&&[def]]
 * 		&& represents intersection 
 * 		d, e, or f
 * 	-[a-z&&[^bc]]
 * 		subtraction
 * 		a through z, except b and c
 * 	-[a-z&&[^m-p]]
 * 		subtraction
 * 		a through z, except m through p
 * 
 * 
 * Predefined Character Classes:
 * 	. : Any character
 * 	\d : A digit([0-9])
 * 	\D : A non-digit([^0-9])
 * 	\s : A whitespace character
 * 	\S : A non whitespace character([^\s])
 * 	\w : A word character([a-zA-Z_0-9])
 * 	\W : A non word character([^\w]) 
 * 
 * 
 */


public class RegularExpressions {
	public static void main(String[] args) {
//		String regexStr = ".*[a-z][0-9]."; //true
		String regexStr = "batcatpat(nat"; //false
		
		//.means any character
		//* means any number
		//hence .* means any number of characters
		//Summary: any number of characters followed by word/s 
		//from a-z followed by integer/s from 0-9 followed by any character
		
		Pattern pattern = Pattern.compile(regexStr);
		
		Matcher matcher = pattern.matcher("12345646adadaf242341234");
		boolean matchFound = matcher.find();
		if(matchFound) System.out.println("Match found");
		else System.out.println("Match not found");
	}
}
