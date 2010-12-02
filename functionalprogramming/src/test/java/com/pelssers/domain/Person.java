package com.pelssers.domain;

import com.pelssers.lang.Function;
import static com.pelssers.functions.Preconditions.*;

public class Person {

	private String firstName;
	private String lastName;
	private Integer age;
	private Boolean isMarried;
	
	public Person(String firstName, String lastName, Integer age, Boolean isMarried) {
		this.firstName = checkIsNotNull(firstName);
		this.lastName = checkIsNotNull(lastName);
		this.age = checkIsNotNull(age);
		this.isMarried = checkIsNotNull(isMarried);
	}	
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Boolean getIsMarried() {
		return isMarried;
	}

	public void setIsMarried(Boolean isMarried) {
		this.isMarried = isMarried;
	}
	
	public String toString() {
		return getFirstName() + " " + getLastName();
	}
	
	public static Function<String, Person> _getFirstName() {
		return new Function<String, Person>() {
			@Override
			public String apply(Person object) {
				return object.getFirstName();
			}
		};
	}
	
	public static Function<String, Person>  _getLastName(){
		return new Function<String, Person>() {
			@Override
			public String apply(Person object) {
				return object.getLastName();
			}
		};
	}
	
	public static Function<Integer, Person> _getAge() {
		return new Function<Integer, Person>() {
			@Override
			public Integer apply(Person object) {
				return object.getAge();
			}
		};
	}
	
	public static Function<Boolean, Person> _isMarried() {
		return new Function<Boolean, Person>() {
			@Override
			public Boolean apply(Person object) {
				return object.isMarried;
			}
		};
	}
}
