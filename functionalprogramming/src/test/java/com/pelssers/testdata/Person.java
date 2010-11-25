package com.pelssers.testdata;

public class Person {

	private String fName;
	private String lName;
	private Integer age;
	
	public Person(String fName, String lName, Integer age) {
		this.fName = fName;
		this.lName = lName;
		this.age = age;
	}

	public String getfName() {
		return fName;
	}

	public String getlName() {
		return lName;
	}

	public Integer getAge() {
		return age;
	}
	
	public String toString() {
		return fName + " " + lName + " " + age;
	}
}
