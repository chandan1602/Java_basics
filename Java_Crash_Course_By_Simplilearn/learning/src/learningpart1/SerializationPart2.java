package learningpart1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class SerializationPart2 {
	public static void main(String[] args) {
		try {
			SerializationPart1 s = new SerializationPart1("Chandan");
			s.setX(999);
			//Creating stream and writing object
			FileOutputStream fout = new FileOutputStream("f.txt");
			ObjectOutputStream out = new ObjectOutputStream(fout);
			out.writeObject(s);
			out.flush();
			//Closing stream
			out.close();
			System.out.println("success");
		} catch (Exception e) {
			System.out.println(e);
		}
		
		//DE-SERIALIZATION
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("f.txt"));
			SerializationPart1 s = (SerializationPart1) in.readObject();
			System.out.println("Object deserialized successfully!");
			System.out.println("NAME is " + s.name + " : Transient variable " + s.getX());
			in.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
