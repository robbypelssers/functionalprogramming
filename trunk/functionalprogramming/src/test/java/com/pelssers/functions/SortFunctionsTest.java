package com.pelssers.functions;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.pelssers.collections.RichComparator;
import com.pelssers.collections.RichIterator;
import com.pelssers.domain.Person;
import com.pelssers.lang.RichComparable;
import com.pelssers.lang.RichIterable;

public class SortFunctionsTest {

	
	private RichComparable<Integer> numbers;
	private RichIterable<Person> persons;
	
	@Before
	public void setup() {
		numbers = new RichComparator<Integer>(4, 6, 8, 2, 7, 5, 10, 7, 6, 5, 11, 3);	
		persons = new RichIterator<Person>(
			      new Person("Robby", "Pelssers", 33, false),
			      new Person("Robert", "Janssen", 36, false),
			      new Person("Davy", "Pelssers", 33, true),
			      new Person("Ron", "Peters", 35, true),
			      new Person("David", "Beckham", 38, true),
			      new Person("Jan", "Hermans", 33, false),
			      new Person("John", "Hendrix", 28, true),
			      new Person("John", "Vissers", 30, true),
			      new Person("Dimitri", "Janssen", 39, false),
			      new Person("Jan", "Peters", 39, true)
			  );		
	}
	
	@Test
	public void testNaturalSortFunctionApply() {
		RichIterable<Integer> sortedNumbers = Functions.<Integer>naturalSort().apply(numbers);
		Assert.assertEquals(new Integer(2), sortedNumbers.first());
		Assert.assertEquals(new Integer(11), sortedNumbers.last());
	}
	
	@Test
	public void testNaturalSort() {
		RichComparable<Integer> sortedNumbers = numbers.sort();
		Assert.assertEquals(new Integer(2), sortedNumbers.first());
		Assert.assertEquals(new Integer(11), sortedNumbers.last());		
	}
	
	@Test
	public void testNaturalSortByFunctionApply() {
        RichIterable<Person> sortedByFirstName = Functions.<String, Person>naturalSortBy().apply(persons, Person._getFirstName());
        Assert.assertEquals("David", sortedByFirstName.first().getFirstName());
        Assert.assertEquals("Ron", sortedByFirstName.last().getFirstName());        
	}
	
	@Test
	public void testNaturalSortBy() {
        RichIterable<Person> sortedByFirstName = persons.sortBy(Person._getFirstName());
        Assert.assertEquals("David", sortedByFirstName.first().getFirstName());
        Assert.assertEquals("Ron", sortedByFirstName.last().getFirstName());   		
	}
}
