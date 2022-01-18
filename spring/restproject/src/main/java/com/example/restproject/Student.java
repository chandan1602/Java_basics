package com.example.restproject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
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
	
	
	
}
