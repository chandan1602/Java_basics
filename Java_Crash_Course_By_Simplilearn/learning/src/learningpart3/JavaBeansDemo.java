package learningpart3;

import java.io.Serializable;
//Three properties
//1. contains setter and getter methods
//2. constructor
//3. should implement serializable


public class JavaBeansDemo implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	private String address;
	public JavaBeansDemo() {
		// TODO Auto-generated constructor stub
	}	
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void getName() {
		System.out.println(this.name);
	}
	public void getAge() {
		System.out.println(this.age);
	}
	public void getAddress() {
		System.out.println(this.address);
	}
}
