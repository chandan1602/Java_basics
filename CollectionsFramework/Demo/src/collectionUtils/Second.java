package collectionUtils;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/*
 *	Collections Framework:

 2. Set Interface

  a. HashSet Class
  	-Unordered (like a bag, you keep on putting values in it, and it throws out randomly )
  	-It generates hash of each element, and checks if incoming element has the same hash or not
  	-Syntax
  	-------------------------
  	Set<Integer> set = new HashSet<>();
  	
  	Functions:
  	add()
  	remove()
  	contains() //boolean
  	isEmpty() //boolean
  	size() //number of elements
  	clear()
  	
  b. LinkedHashSet Class
  	-Ordered
  	-Syntax:
  	---------------------------
  	Set<Integer> linkedset = new LinkedHashSet<>();
  	
  	Functions:
  	Same as HashSet
  	
  c. TreeSet Class
  	-Sorted
  	-Syntax:
  	------------------------------
  	Set<Integer> treeset = new TreeSet<>();
  	-Time Complexity O(log(n))
  	Functions:
  	Same as HashSet
  	
 * 
 */

class Student implements Comparable<Student> {
	String name;
	int rollNo;
	
	public Student(String name, int rollNo) {
		this.name = name;
		this.rollNo = rollNo;
	}
	
	@Override
		public String toString() {
			return "Student{" + "name='" + name +
					"', rollNo=" + rollNo + '}';
		}
	
	@Override
		public boolean equals(Object o) {
			if(this==o) return true;
			if(o==null || getClass()!=o.getClass()) return false;
			Student student = (Student) o;
			return rollNo == student.rollNo;
		}
	
	@Override
		public int hashCode() {
			return Objects.hash(rollNo);
		}
	
	@Override
	public int compareTo(Student that) {
		return this.rollNo - that.rollNo;
	};
	
}

public class Second {
	public static void common(Set<Integer> set) {
		set.add(32);
		set.add(2);
		set.add(54);
		set.add(21);
		set.add(65);
		System.out.println(set);
		
		set.remove(2);
		System.out.println(set);
		
		System.out.println(set.contains(32));
		System.out.println(set.contains(2));
		
		System.out.println(set.isEmpty());
		
		System.out.println(set.size());
		
		set.clear();
		System.out.println(set);
	}
	
	public static void main(String[] args) {
		///////////////////////////////////////////
		//HASHSET
		Set<Integer> set = new HashSet<>();
		common(set);		
//		
//		Set<ArrayDeque<Integer>> s = new HashSet();\
//		Arrays.
//		s.add(Arrays.asList(1,2,3));
//		s.add(Arrays.asList(1,2,3));
//		
//		Set<List<Integer>> list = (Set<List<Integer>>) s;
//		System.out.println("CHECKING LIST IN SET :: " + s);
		
		
		///////////////////////////////////////////
		System.out.println("\n/////////////////////////////////");
		System.out.println("LINKED HASHSET STARTS\n");
		
		Set<Integer> linkedset = new LinkedHashSet<>();
		common(linkedset);

		
		

		///////////////////////////////////////////
		System.out.println("\n/////////////////////////////////");
		System.out.println("TREE SET STARTS\n");

		Set<Integer> treeset = new TreeSet<>();
		common(treeset);
		
		
		
		///////////////////////////////////////////
		System.out.println("\n/////////////////////////////////");
		System.out.println("BASIC EXAMPLE");
		Set<Student> studentset = new HashSet<>();
		
		studentset.add(new Student("Anuj", 2));
		studentset.add(new Student("Ramesh", 4));
		studentset.add(new Student("Shivam", 3));
		studentset.add(new Student("Rohit", 2));
		
		System.out.println(studentset);
		
		

		
	}
}
