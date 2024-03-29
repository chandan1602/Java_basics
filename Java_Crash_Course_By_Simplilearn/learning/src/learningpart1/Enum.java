/*
 * 
 * --------Definition--------
 * Enum is a language construct used when a fixed set of named values is desired.
 * Enables for a variable to be a set of predefined constants
 * All Enums implicitly extend java.lang.Enum 
 * 
 * 
 * 
 * -------SYNTAX-----------
 * -enum keyword is used
 * -names of enum type's field are in uppercase letters.
 * Example: public enum Day {
 *   SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
 * }
 * 
 * 
 */


package learningpart1;

enum Color {
	RED("red"), GREEN("green"), BLUE("blue"), WHO("World Health Organization");
	private String value;
	Color(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}


public class Enum {
	public static void main(String[] args) {
		Color c1 = Color.WHO;
		System.out.println("WHO Enum name : " + c1.name());
		System.out.println("WHO Enum value : " + c1.getValue());
		
		for(Color color : Color.values()) {
			System.out.println("Enum " + color.name() + " : " + color.getValue());
		}
	}
}

