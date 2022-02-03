package multithreading;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class NBlockingQueue {
	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<String> blockingQueue = 
				new ArrayBlockingQueue<String>(3);
		blockingQueue.put("element 1");
		blockingQueue.put("element 2");
		
		//blockingQueue insertion Methods
		//1. put: blocks the queue if space is full
		//2. add: throws an exception if sapce is full
		//3. offer: return bool if ele was enqueued or not
		//4. offer with timeout: waits for time provided if space not available, else returns bool if space still not available
		
		
		String ele1 = blockingQueue.take();
		String ele2 = blockingQueue.take();
		
		//blockingQueue removal methods
		//1. take: blocks until element becomes available
		//2. poll: returns null if no element
		//3. poll with timeout: waits for time provided if space not available, else returns null if element still not available
		//4. remove: Does not Dequeue, it removes element if present in BlockingQueue
		
		System.out.println(ele1);
		System.out.println(ele2);  
		
		//Drain Methods
		blockingQueue.put("element 1");
		blockingQueue.put("element 2");
		Collection dest = new ArrayList();
		blockingQueue.drainTo(dest);
		System.out.println(dest);
		blockingQueue.put("element 3");
		blockingQueue.put("element 4");
		blockingQueue.drainTo(dest, 1);
		System.out.println(dest);
		
		//Other methods
		//1. peek: first ele of the queue 
		//2. remainingCapacity
		//3. contains
	}
}
