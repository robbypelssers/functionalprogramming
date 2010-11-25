package com.pelssers.collections;

import java.util.Map;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.pelssers.functions.Function;
import com.pelssers.functions.PredicateFunction;
import com.pelssers.functions.factories.SystemFunctions;
import com.pelssers.functions.impl.AbstractFunction;
import com.pelssers.functions.impl.AbstractPredicateFunction;
import com.pelssers.lang.Tuple1;
import com.pelssers.lang.Tuple2;
import com.pelssers.testdata.Person;

public class GroupTest {

	private Groupable<Person> persons;
	private Groupable<Integer> numbers;
	private Groupable<String> words;

	
	@Before
	public void setup() {
		persons = 
		  new Group<Person>()
			.add(new Person("Robby", "Pelssers", 33))
			.add(new Person("Davy", "Pelssers", 33))
			.add(new Person("John", "Walker", 32))
			.add(new Person("Tim", "Nelissen", 38))
			.add(new Person("Roger", "Janssen", 33));
		numbers = 
			new Group<Integer>()
			.add(5)
			.add(8)
			.add(12)
			.add(8)
			.add(3)
			.add(7);
		words =
			new Group<String>()
		    .add("duplicate")
		    .add("After")
		    .add("Before")
		    .add("duplicate")
		    .add("Last");
	}
	
	@Test
	public void testExists() {
		PredicateFunction<Person> p = new AbstractPredicateFunction<Person>(new Tuple2<String, Integer>("Pelssers", 33)) {
			@Override
			public Boolean apply(Person object) {
				return object.getlName().equals(getTuple().get1()) &&  object.getAge().equals(getTuple().get2());
			}
		};
		
		Boolean containsPerson = persons.exists(p);
		Assert.assertEquals(true, containsPerson.booleanValue());
	}
	
	@Test
	public void testFilter() {
		PredicateFunction<Person> p = new AbstractPredicateFunction<Person>(new Tuple1<Integer>(33)) {
			@Override
			public Boolean apply(Person object) {
				return object.getAge().equals(getTuple().get1());
			}
		};	
		Assert.assertEquals(3, persons.filter(p).size());	
	}
	
	@Test
	public void testForEach() {
		persons.forEach(SystemFunctions.<Person>println());
	}
	
	@Test
	public void testMap() {
		Function<String,Person> mapper = new AbstractFunction<String,Person>() {
			@Override
			public String apply(Person object) {
				return object.getfName() + " " + object.getlName();
			}
		};
		Groupable<String> fullNames = persons.map(mapper);
		SystemFunctions.<String>printlnAll().apply(fullNames);
	}
	
	@Test
	public void testDoWhile() {
		PredicateFunction<Person> p = new AbstractPredicateFunction<Person>(new Tuple1<Integer>(33)) {
			@Override
			public Boolean apply(Person object) {
				return object.getAge().equals(getTuple().get1());
			}
		};
		persons.doWhile(p, SystemFunctions.<Person>println());
	}
	
	@Test
	public void testDoUntill() {
		PredicateFunction<Person> p = new AbstractPredicateFunction<Person>(new Tuple1<Integer>(38)) {
			@Override
			public Boolean apply(Person object) {
				return object.getAge().equals(getTuple().get1());
			}
		};
		persons.doUntill(p, SystemFunctions.<Person>println());	
		
	}
	
	@Test
	public void testStringJoin() {
		Function<String, Person> f = new AbstractFunction<String, Person>() {
			@Override
			public String apply(Person object) {
				return "{fName: " + object.getfName()+ ", lName: " + object.getlName() + "}" ;
			}
		};
		String joined = persons.stringJoin(f, ",");
		System.out.println(joined);
	}
	
	@Test
	public void testTakeLeft1() {
		Groupable<Person> result = persons.takeLeft(4);
		Assert.assertEquals(4, result.size());
	}
	
	@Test
	public void testTakeLeft2() {
		Groupable<Person> result = persons.takeLeft(7);
		Assert.assertEquals(5, result.size());
	}	
	
	@Test
	public void testTakeRight1() {
		Groupable<Person> result = persons.takeRight(4);
		Assert.assertEquals(4, result.size());
	}
	
	@Test
	public void testTakeRight2() {
		Groupable<Person> result = persons.takeRight(7);
		Assert.assertEquals(5, result.size());
	}	
	
	@Test
	public void testDropLeft1() {
		Groupable<Person> result = persons.dropLeft(2);
		Assert.assertEquals(3, result.size());
	}
	
	@Test
	public void testDropLeft2() {
		Groupable<Person> result = persons.dropLeft(6);
		Assert.assertEquals(0, result.size());
	}	
	
	@Test
	public void testDropRight1() {
		Groupable<Person> result = persons.dropRight(3);
		Assert.assertEquals(2, result.size());
	}
	
	@Test
	public void testDropRight2() {
		Groupable<Person> result = persons.dropRight(6);
		Assert.assertEquals(0, result.size());
	}	
	
	@Test
	public void testGroupBy() {
		Function<Integer, Person> toKey = new AbstractFunction<Integer, Person>() {
			@Override
			public Integer apply(Person object) {
				return object.getAge();
			}
		};
		
		Map<Integer, Groupable<Person>> map = persons.groupBy(toKey);
		Assert.assertEquals(3, map.get(33).size());
		Assert.assertEquals(1, map.get(32).size());
		Assert.assertEquals(1, map.get(38).size());
	}
	
	public void testDistinct() {
		Assert.assertEquals(5, numbers.distinct().size());
		Assert.assertEquals(4, words.distinct().size());
	}
	

}
