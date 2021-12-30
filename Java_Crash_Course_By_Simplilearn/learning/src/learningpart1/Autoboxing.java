/*
 * 
 * Autoboxing is the automatic conversion that the java compiler makes
 * between primitive types and their corresponding object wrapper classes
 * 
 */

package learningpart1;

public class Autoboxing {
	public static void main(String[] args) {
		int i = 10;
		
		//Autobox
		Integer iObj = Integer.valueOf(i);
		System.out.println("Value of Integer obj : " + iObj);
		
		//Auto-unbox
		int i1 = iObj;
		System.out.println("Value of i1 : " + i1);
		
		char x = 'a';
		//Autobox
		Character charObj = Character.valueOf(x);
		
		//Auto-unbox
		char ch = charObj;
		System.out.println("Value of ch : " + ch);
		System.out.println("Value of charObj : " + charObj);
		
	}
}
