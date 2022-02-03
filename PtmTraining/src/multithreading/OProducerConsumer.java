package multithreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class OProducerConsumer {
	public static void main(String[] args) {
		BlockingQueue<String> blockingQueue = 
				new ArrayBlockingQueue<String>(3);
		
		Producer producer = new Producer(blockingQueue);
		Consumer consumer = new Consumer(blockingQueue);
		
		Thread producerThread = new Thread(producer);
		Thread consumerThread = new Thread(consumer);
		producerThread.start();
		consumerThread.start();
	}
}

class Producer implements Runnable {
	BlockingQueue<String> blockingQueue = null;
	
	public Producer(BlockingQueue<String> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		while(true) {
			long timeInMillis = System.currentTimeMillis();
			try {
				this.blockingQueue.put(""+timeInMillis);
			} catch (InterruptedException e) {
				System.out.println("Producer was interrupted");
			}
			sleep(1000);
		}
	}

	private void sleep(long i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}

class Consumer implements Runnable {
	BlockingQueue<String> blockingQueue = null;
	
	public Consumer(BlockingQueue<String> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		while(true) {
			
			try {
				String ele = this.blockingQueue.take();
				System.out.println("consumed:"+ele);
			} catch (InterruptedException e) {
				System.out.println("Consumer was interrupted");
			}
		}
	}
	
}

//Locks and Conditions
class MyBlockingQueue<E> {
	private Queue<E> queue;
	private int max = 16;
	private ReentrantLock lock = new ReentrantLock(true);
	private Condition notEmpty = lock.newCondition();
	private Condition notFull = lock.newCondition();
	
	
	public MyBlockingQueue(int size) {
		queue = new LinkedList<>();
		this.max = size;
	}
	
	public void put(E e) {
		lock.lock();
		try {
			while(queue.size()==max) {
				notFull.await();
			}
			queue.add(e);
			notEmpty.signalAll();
		} catch(InterruptedException exception) {
			System.out.println("Put Interrupted");
		}
		finally {
			lock.unlock();
		}
		
	}
	
	public E take() {
		lock.lock();
		try {
			while(queue.size()==0) {
				notEmpty.await();
			}
			E item = queue.remove();
			notFull.signalAll();
			return item;
		} catch(InterruptedException exception) {
			System.out.println("Take Interrupted");
			return null;
		} finally {
			lock.unlock();
		}

	}
}
