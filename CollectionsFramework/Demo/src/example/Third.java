package example;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
 * Collections Framework:
 
 3. Map Interface:
  
  a. HashMap Class
  	-Syntax
  	----------------------------
  	Map<Key, Value> numbers = new HashMap<>();
  	
  	Functions:
  	put(Key, Value) //Insert Key-Value
  	remove(key)
  	containsKey(), containsValue() //boolean
  	putIfAbsent(Key, Value) //Inserts if key is absent
  	entrySet() //Iteration Method1
  	keySet(), values() //Iteration Method2
  	isEmpty() //boolean
  	clear()
  	
  b. TreeMap Class
  	 -Inserts keys in Binary search tree, and keeps on sorting tree
  	 -O(log(n))
  	 -Syntax
  	 ------------------------------
  	 Map<Key, Value> numbers = new TreeMap<>();
  	
  
 */


public class Third {
	public static void main(String[] args) {
		Map<String, Integer> numbers = new HashMap<>();
		
		numbers.put("One", 1);
		numbers.put("Two", 2);
		numbers.put("Three", 3);
		System.out.println(numbers);
//		if(!numbers.containsKey("Two")) {			
//			numbers.put("Two", 23);
//		}
		numbers.putIfAbsent("Two", 23);
		
		//Iteration Method 1
//		for (Map.Entry<String, Integer> e: numbers.entrySet()) {
//			System.out.println(e);
//			System.out.println(e.getKey() + " : " + e.getValue());
//		}
		
		//Iteration method 2
		for (String key: numbers.keySet()) {
			System.out.println(key);
		}
		for (Integer value: numbers.values()) {
			System.out.println(value);
		}
		System.out.println(numbers.containsValue(3));
		System.out.println(numbers.isEmpty());
		numbers.remove("Three");
		System.out.println(numbers);
		numbers.clear();
		System.out.println(numbers);
		
		
		
		
		
		
		///////////////////////////////////////////
		System.out.println("\n/////////////////////////////////");
		System.out.println("TREEMAP EXAMPLE");
		Map<String, Integer> treemap = new TreeMap<>();
		
		treemap.put("One", 1);
		treemap.put("Two", 2);
		treemap.put("Three", 3);
		System.out.println(treemap);
//		if(!treemap.containsKey("Two")) {			
//			treemap.put("Two", 23);
//		}
		treemap.putIfAbsent("Two", 23);
		
		//Iteration Method 1
//		for (Map.Entry<String, Integer> e: treemap.entrySet()) {
//			System.out.println(e);
//			System.out.println(e.getKey() + " : " + e.getValue());
//		}
		List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String,Integer>>(treemap.entrySet());
		System.out.println("MAP TO LIST : " + list);
		
		//Iteration method 2
		for (String key: treemap.keySet()) {
			System.out.println(key);
		}
		for (Integer value: treemap.values()) {
			System.out.println(value);
		}
		System.out.println(treemap.containsValue(3));
		System.out.println(treemap.isEmpty());
		treemap.remove("Three");
		System.out.println(treemap);
		treemap.clear();
		System.out.println(treemap);
		
		System.out.println("supercalifragilisticexpialidocious".length());
		
	}
}
