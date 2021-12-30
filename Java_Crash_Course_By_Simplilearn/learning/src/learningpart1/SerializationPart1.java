/*
 * SERIALIZATION
 * -Conversion of state of object into byte stream
 * DE-SERIALIZATION
 * -Conversion of byte stream back to object
 * 
 *----Implementation
 *Serializable interface has to be implemented using 'implements'
 */

package learningpart1;

import java.io.Serializable;

public class SerializationPart1 implements Serializable {
	private static final long serialVersionUID = 1L;
	String name;
	transient int x; //This variable will not be Serialized
	public SerializationPart1(String name) {
		this.name = name;
	}
	public void setX(int val) {
		x=val;
	}
	public int getX() {
		return this.x;
	}
	
	public static void main(String[] args) {
		System.out.println("Hello World");
	}
	
}