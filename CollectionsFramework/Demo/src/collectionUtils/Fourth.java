package collectionUtils;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/*
 1. Arrays Class:
 	Syntax:
 	-----------------
 	int arr[] = {};
 	
 	Functions:
 	Arrays.binarySearch(array_name, key) //returns index
 	Arrays.sort(array_name, fromIndex, toIndex) //QuickSort
 	Arrays.parallelSort() //for multiple processors
 						  // Element count must be greater than 8192 else quick sort is run
 	Arrays.fill(array_name, value) 
 	
 2. Collections Class(A part of collections framework):
 	Syntax:
 	------------------
 	-Functions:
 	Collections.min(array_name);
 	Collections.max(array_name);
 	Collections.frequency(array_name, element);
 	Collections.sort(array_name);
 * 
 */

public class Fourth {
	public static void main(String[] args) {
		int a[] = {1,2,3,4,5,5,6,7,80};
		int index = Arrays.binarySearch(a, 4);
		System.out.println("4 is on index : " + index);
		
		Arrays.sort(a);
		for(int i: a) {
			System.out.print(i + " ");
		}
		System.out.println("\n");
		Arrays.fill(a, 12);
		for(int i: a) {
			System.out.print(i + " ");
		}
		System.out.println("\n");
		
		
		
		
		
		
		///////////////////////////////////////////
		System.out.println("\n/////////////////////////////////");
		System.out.println("COLLECTION CLASS STARTS\n");

		List<Integer> list = new ArrayList();
		list.add(34);
		list.add(12);
		list.add(9);
		list.add(9);
		list.add(76);
		list.add(29);
		list.add(75);
		
		System.out.println("min element is " + Collections.min(list));
		System.out.println("max element is "+ Collections.max(list));
		System.out.println("frequency of 9 is"+ Collections.frequency(list, 9));
		
		Collections.sort(list);
		System.out.println(list);
		Collections.sort(list, Comparator.reverseOrder());
		System.out.println(list);
		
		
		
		
		
		
		///////////////////////////////////////////
		System.out.println("\n/////////////////////////////////");
		System.out.println("EXAMPLE STARTS\n");
		List<Student> slist = new ArrayList<Student>();
		
		slist.add(new Student("Anuj", 2));
		slist.add(new Student("Ramesh", 4));
		slist.add(new Student("Shivam", 3));
		slist.add(new Student("Rohit", 2));
		
		Student s1 = new Student("Anuj", 2);
		Student s2 = new Student("Rohit", 3);
		
		System.out.println(s1.compareTo(s2));
		Collections.sort(slist);
		System.out.println(slist);

		Collections.sort(slist, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				return o1.name.compareTo(o2.name);
			}
		});
		System.out.println(slist);
		
		//Sorting by Lambda Function Comparator
		Collections.sort(slist, (o1, o2) -> o1.name.compareTo(o2.name));
		System.out.println(slist);
		
		
		Test t = new Test();
		t.setName(Arrays.asList(2));
		System.out.println(t.getName());
		StringBuilder s = new StringBuilder("chandan");
		s.replace(0, 1, "b");
		System.out.println(s);
		Person p1 = new A().builder().setName("Chandan").build();
		Person p2 = new B().builder().setAge(22).build();
		Integer.bitCount(10);
	}

}

interface Testing {
	public List<Integer> name = Arrays.asList(0);
	void setName(List<Integer> name);
	public Integer getName();
}

class Test implements Testing {
	public void pv(boolean... a1 ) {
		System.out.println(a1);
	}

	@Override
	public void setName(List<Integer> name) {
		this.name.set(0, 1);
	}

	@Override
	public Integer getName() {
		return this.name.get(0);
	}
	
	
}

interface Person{

}

class A implements Person {
	String name;
	A() {}
	A(String name) {
		this.name = name;
	}
	public ABuilder builder() {
		return new ABuilder();
	}
	class ABuilder {
		ABuilder setName(String s) {
			name = s;
			return this;
		}
		
		public A build() {
			return new A(name);
		}
	}
}

class B implements Person {
	int age;
	B() {}
	B(int age) {
		this.age = age;
	}
	public BBuilder builder() {
		return new BBuilder();
	}
	class BBuilder {
		BBuilder setAge(int n) {
			age = n;
			return this;
		}
		
		public B build() {
			return new B(age);
		}
	}
}

class C<T> {
	public void testPerson(Person p) {
		
	}
}