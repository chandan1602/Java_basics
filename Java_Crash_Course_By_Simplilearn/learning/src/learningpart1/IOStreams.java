package learningpart1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


//Stream is a sequence of data

//An I/O Stream represents an input source or an output destination
//including disk files. devices, other programs, and memory arrays

//Streams support different types of data
//	-simple bytes
//	-primitive data types
//	-localized characters
//	-objects

//stream Classes:
/*
 * 1 java.io.InputStream
 * 2 java.io.OutputStream
 * 3 java.lang.System
 * 4 java.io.Reader
 * 5 java.io.Writer
 */

//Scenario 1 : Using Bytes Stream
class ByteStreamExample {
	public void exec() throws IOException{
		FileInputStream inStream = null;
		FileOutputStream outStream = null;
		String sep = System.getProperty("file.separator");
		try {
			inStream = new FileInputStream("files"+sep+"src.txt");
			outStream= new FileOutputStream("files"+sep+"dest.txt");
			
			//reads a byte at a time, if it reached end of the file,
			//it returns -1
			int content;
			while((content = inStream.read())!=-1) {
				outStream.write((byte) content);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		} finally {
			if(inStream!=null) {
				inStream.close();
			}
			if(outStream != null) {
				outStream.close();
			}
		}
	}
}

//Scenario 2: Using Character Stream
class CharacterStreamExample {
	public void exec() throws IOException{
		FileReader inStream = null;
		FileWriter outStream = null;
		String sep = System.getProperty("file.separator");
		try {
			inStream = new FileReader("files"+sep+"src.txt");
			outStream= new FileWriter("files"+sep+"dest.txt");
			
			//reads a byte at a time, if it reached end of the file,
			//it returns -1
			int content;
			while((content = inStream.read())!=-1) {
				outStream.append((char) content);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		} finally {
			if(inStream!=null) {
				inStream.close();
			}
			if(outStream != null) {
				outStream.close();
			}
		}
	}
}

public class IOStreams {
	public static void main(String[] args) throws IOException{
		ByteStreamExample obj = new ByteStreamExample();
		obj.exec();
	}
}