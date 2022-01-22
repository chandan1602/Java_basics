package com.example.crudproject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
class Student {
	@Id
//	@SequenceGenerator(
//			name = "student_sequence",
//			sequenceName = "student_sequence",
//			allocationSize = 1
//		)
	@GeneratedValue(
			strategy = GenerationType.AUTO
//			,generator = "student_sequence"
			)
	private String id;
	
	private String name;
	private int age;
	private String address;
	
	public Student() {
	}
	
	public Student(String name, int age, String address) {
		this.name = name;
		this.age = age;
		this.address = address;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getAddress() {
		return address;
	}

	public void setId(String id) {
		this.id = id;
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
	
	
	
}
