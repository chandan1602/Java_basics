package example;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/*
 * Collections Framework:
 		
 1. List Interface
 
  a. ArrayList Class
 	 -Syntax:
 	 -------------------
 	 ArrayList<String> ar = new ArrayList<>();
 	 
 	 Functions:
 	 add(index, element);
 	 get(index);
 	 set(index, element)
 	 remove(index) //remove by index
 	 remove(Integer.valueOf(value)) //remove by value
 	 Behind the Scenes:
 	 I. On adding first element an array of size 10 is created
 	 II. If 10 size is reached, new array of size n+n/2+1 is created
 	 
 b. Stack Class	 
 	-Syntax:
 	-------------------
 	Stack<String> st = new Stack<>();
 	
 	Functions:
 	push(element)
 	peek()
 	pop()
 	
 c. Queue and LinkedList Class
 	-Together because Linked-List is implementing Queue
 	-Syntax:
 	-------------------
 	Queue<Integer> queue = new LinkedList<>();
 	
 	Functions:
 	offer(element) //Insert at rear of queue [f,r1] <- r2 => [f,r1,r2]
 				   //Returns true/false
 	add(element)   //Same as offer
 				   //Returns true/exception
 	poll() //Removes and returns front of queue [f,r1,r2] => f
 		   //Returns null if queue is empty
 	remove()	//Same as poll
 				//Throws Exception if queue is empty
 	peek() //return front of queue [f,r1,r2] => f
 	element() //same as peek but throws exception if queue empty
 	
 d. List and LinkedList Class
 	-Syntax:
 	----------------------------
 	List<Integer> list = new LinkedList<>();
 	
 	Functions:
 	Same as list
 	
 e. PriorityQueue Class
 	-Default creates min heap
 	-By default all the functions give smallest element the highest priority
 	-Syntax:
 	----------------------------
 	PriorityQueue<Integer> pq = new PriorityQueue<>();
 	OR
 	Queue<Integer> pq = new PriorityQueue<>();
 	FOR MAX HEAP:
 	Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
 	
 	Functions:
 	Same as Queue
 	
 
 f. ArrayDeque Class
 	-Insertion, Deletion and Peek Available at both front and rear
 	-Syntax:
 	---------------------------
 	ArrayDeque<Integer> adq = new ArrayDeque<>();
 	
 	Functions:
 	Same as Queue +
 	offerFirst(), peekFirst(), pollFirst() //Work at Beginning
 	offerLast(), peekLast, pollLast() //Work at Ending
 	
 */


public class First {
	public static void main(String[] args) {
		///////////////////////////////////////////
		//ARRAYLIST
		ArrayList<Integer> list1 = new ArrayList();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		System.out.println("List1 : " + list1);
		
		list1.add(1, 50);
		System.out.println("List1 : " + list1);
		
		ArrayList<Integer> list2 = new ArrayList();
		list2.add(1000);
		
		//Appending all list items
		list1.addAll(list2);
		System.out.println("List1 : " + list1);	
		
		//Get list item
		System.out.println(list1.get(1));
		
		//Remove by Index
		list1.remove(1);
		System.out.println("List1 : " + list1);
		
		//Remove by value
		list1.remove(Integer.valueOf(1000));
		System.out.println("List1 : " + list1);
		
		//Update an item
		list1.set(0, 4);
		System.out.println("List1 : " + list1);
		
		//Find in O(N)
		System.out.println(list1.contains(4));
		System.out.println(list1.contains(8));
		
		//Traversing array
		//method 1
//		for(int i=0; i<list1.size(); i++) {
//			System.out.println(list1.get(i));
//		}
		
		//method 2
		for(Integer element: list1) {
			System.out.println(element);
		}
		
		//method 3
//		Iterator<Integer> it = list1.iterator();
//		
//		while(it.hasNext()) {
//			System.out.println(it.next());
//		}
		
		//Empty the list
		list1.clear();
		System.out.println("List1 : " + list1);
		
		
		
		
		
		
		///////////////////////////////////////////
		System.out.println("\n/////////////////////////////////");
		System.out.println("STACK STARTS\n");
		//STACK
		Stack<String> animals = new Stack<>();
		animals.push("Lion");
		animals.push("Dog");
		animals.push("Horse");
		animals.push("Cat");
		System.out.println("Stack : " + animals);
		
		//GET TOP ELEMENT
		System.out.println("TOP : " + animals.peek());
		
		animals.pop();
		System.out.println("POP->TOP: " + animals.peek());
		
		
		
		
		
		
		
		
		///////////////////////////////////////////
		System.out.println("\n/////////////////////////////////");
		System.out.println("QUEUE AND LINKED LIST STARTS\n");
		
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(12);
		queue.offer(13);
		queue.offer(14);
		System.out.println(queue);
		
		System.out.println("Front : " + queue.peek());
		System.out.println("Pop the front : " + queue.poll());
		System.out.println(queue);
		
		
		
		
		
		
		///////////////////////////////////////////
		System.out.println("\n/////////////////////////////////");
		System.out.println("PRIORITY QUEUE STARTS\n");
		
		System.out.println("Implementing Min Heap(Default)");
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		//Queue<Integer> pq = new PriorityQueue<>();
		pq.offer(40);
		pq.offer(100);
		pq.offer(13);
		pq.offer(14);
		System.out.println(pq);
		pq.poll();
		System.out.println(pq);
		System.out.println("PEEK : " + pq.peek());
		
		System.out.println("Implementing Max Heap");
		PriorityQueue<Integer> pq2 = new PriorityQueue<>(Comparator.reverseOrder());
		//Queue<Integer> pq = new PriorityQueue<>();
		pq2.offer(40);
		pq2.offer(100);
		pq2.offer(13);
		pq2.offer(14);
		System.out.println(pq2);
		pq2.poll();
		System.out.println(pq2);
		System.out.println("PEEK : " + pq2.peek());
		
		
		
		
		
		
		///////////////////////////////////////////
		System.out.println("\n/////////////////////////////////");
		System.out.println("ARRAY DEQUE STARTS\n");
		
		ArrayDeque<Integer> adq = new ArrayDeque<>();
		
		adq.offer(23);
		adq.offerFirst(12);
		adq.offerLast(45);
		adq.offer(26); 
		System.out.println(adq);
		
		System.out.println(adq.peek());
		System.out.println(adq.peekFirst());
		System.out.println(adq.peekLast());
		
		System.out.println(adq.poll());
		System.out.println("poll() " + adq);
		
		System.out.println(adq.pollFirst());
		System.out.println("pollFirst() "+adq);
		
		System.out.println(adq.pollLast());
		System.out.println("pollLast() "+adq);
		
		
		
		
		
		
		

		
	}
}
