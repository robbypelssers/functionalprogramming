package com.pelssers.collections;

import static com.pelssers.functions.impl.Predicates.endsWith;
import static com.pelssers.functions.impl.Predicates.eq;
import static com.pelssers.functions.impl.Predicates.eqBy;
import static com.pelssers.functions.impl.Predicates.gt;
import static com.pelssers.functions.impl.Predicates.lt;
import static com.pelssers.functions.impl.Predicates.startsWith;
import static com.pelssers.functions.impl.Predicates.startsWithBy;

import java.util.Map;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.pelssers.functions.Function;
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
		Assert.assertEquals(Boolean.TRUE, persons.exists(eqBy("getAge", 38)));
	}
	
	@Test
	public void testGreatherThen() {
		Assert.assertEquals(Boolean.TRUE, numbers.forAll(gt(2)));
	}
	
	@Test
	public void testLessThen() {
		Assert.assertEquals(Boolean.FALSE, numbers.forAll(lt(10)));		
	}
	
	@Test
	public void testEndsWith() {
		Assert.assertEquals(2, words.filter(endsWith("te")).size());
	}
	
	@Test
	public void testStartsWith() {
		Assert.assertEquals(2, words.filter(startsWith("dup")).size());		
	}
	
	@Test
	public void testFilter() {	
		Assert.assertEquals(3, persons.filter(eqBy("getAge", 33)).size());	
	}
	
	@Test
	public void testPersonStartsWith() {
		Assert.assertEquals(2, persons.filter(startsWithBy("getFirstName", "Ro")).size());
	}
	
	@Test
	public void testFilterByPerson() {
        Person person = new Person("Robby", "Pelssers", 33);		
		Assert.assertEquals(1, persons.filter(eq(person)).size());
	}
	
	@Test
	public void testFilterByString() {
		Assert.assertEquals(2, words.filter(eq("duplicate")).size());
	}
	
	@Test
	public void testFilterByNumber() {
		Assert.assertEquals(2, numbers.filter(eq(8)).size());
	}
	
	@Test
	public void testFilterByGetter() {
		Assert.assertEquals(2, persons.filter(eqBy("getLastName", "Pelssers")).size());
	}
	
	@Test
	public void testForEach() {
//		persons.forEach(SystemFunctions.<Person>println());
	}
	
	@Test
	public void testMap() {
		Function<String,Person> mapper = new Function<String,Person>() {
			@Override
			public String apply(Person object) {
				return object.getFirstName() + " " + object.getLastName();
			}
		};
		Groupable<String> fullNames = persons.map(mapper);
		Assert.assertEquals("Robby Pelssers", fullNames.get(0));
	}
	
	@Test
	public void testDoWhile() {
//		persons.doWhile(eqBy("getAge", 33), SystemFunctions.<Person>println());
	}
	
	@Test
	public void testDoUntill() {
//		persons.doUntill(eqBy("getAge", 38), SystemFunctions.<Person>println());
	}
	
	@Test
	public void testStringJoin() {
		Function<String, Person> f = new Function<String, Person>() {
			@Override
			public String apply(Person object) {
				return object.getFirstName();
			}
		};
		String joinedFirstNames = persons.stringJoin(f, ",");
		Assert.assertEquals("Robby,Davy,John,Tim,Roger", joinedFirstNames);
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
		Function<Integer, Person> toKey = new Function<Integer, Person>() {
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
	
	@Test
	public void testDistinct() {
		Assert.assertEquals(5, numbers.distinct().size());
		Assert.assertEquals(4, words.distinct().size());
	}
}
