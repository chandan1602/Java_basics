package example;

import Encapsulation.Intro;

public class MainClass {
	public static void main(String[] args) {
		Person p1 = new Person();
		p1.age = 24;
		p1.name = "FIRST";
		System.out.println(p1.age);
		Person p2 = new Person("SECOND", 31);
		System.out.println(p2.age);
		
		p1.eat();
		p2.walk(); //Compile time polymorphism
		p2.walk(2);
		System.out.println(Person.count);
		Developer d1 = new Developer("THIRD", 41);
		d1.walk();
		
		Intro obj = new Intro();
		obj.doWork();
	}
}

class Developer extends Person {
	public Developer(String name, int age) {
		super(name, age); //Calling Parent Constructor
	}
	
	public void walk() { //Runtime Polymorphism
		System.out.println("Developer " + name + " is walking.");
	}
	
	
}

class Person {
	protected String name;
	int age;
	static int count; //it becomes property of class
	public Person() {
		count++;
		System.out.println("Creating an object");
	}
	public Person(String name, int age) {
		this(); //Calling Person() Constructor
		this.name = name;
		this.age = age;
	}
	
	void walk() {
		System.out.println(name + " is walking");
	}	
	void eat() {
		System.out.println(name + " is eating");
	}
	void walk(int steps) {
		System.out.println(name + " walked " + steps + " steps.");
	}
}