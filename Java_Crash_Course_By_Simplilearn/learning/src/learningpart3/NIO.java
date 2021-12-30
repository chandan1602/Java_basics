package learningpart3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/*
 * 
 * Popular perception : Non Blocking IO
 * Classic meaning: Networking IO
 * 
 * Package created is java.nio
 * -Purpose of package is to support IO in multi-threading and non-blocking
 * 
 * -Some concepts are:
 * Buffers:
 	-read operation: from channel into the buffer
 	-write operation: from buffer into the channel
 	
 	1. Buffers are containers for data
 		Channels are basically like wires, represents connections to
 		the entities capable of performing IO operations 
 		
 	2. popular ops:
 		a. read() : for reading contents(bytes) from file
 		b. flip() : ready for a new sequence of channel-write
 		
 */

public class NIO {
	public static void main(String[] args) throws IOException {
		String sep = System.getProperty("file.separator");
		//Read demo
		String srcFilePath = "files"+sep+"src.txt";
		FileInputStream fin = new FileInputStream(srcFilePath);
		FileChannel readChannel = fin.getChannel();
		ByteBuffer readBuffer = ByteBuffer.allocate(1024);
		int result = readChannel.read(readBuffer);
		System.out.println("file read successfully "+result+"bytes");
		fin.close();
		
		//Write demo
		String destFilePath = "files"+sep+"dest.txt";
		FileOutputStream fout = new FileOutputStream(destFilePath);
		FileChannel writeChannel = fout.getChannel();
		ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
		String message = "this is a test string";
		writeBuffer.put(message.getBytes());
		writeBuffer.flip();
		writeChannel.write(writeBuffer);
		System.out.println("file written successfully");
		fout.close();
		
	}
}
