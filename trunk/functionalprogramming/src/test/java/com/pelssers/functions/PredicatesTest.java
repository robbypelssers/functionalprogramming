package com.pelssers.functions;

import static com.pelssers.collections.CollectionsUtil.listOf;
import static com.pelssers.functions.Predicates.*;
import static com.pelssers.functions.StringFunctions.*;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.pelssers.collections.RichIterator;
import com.pelssers.domain.Person;
import com.pelssers.lang.Groupable;
import com.pelssers.lang.P2;
import com.pelssers.lang.RichIterable;

public class PredicatesTest {

	private RichIterable<Integer> numbers;
	private RichIterable<Person> persons;
	
	@Before
	public void setup() {
		numbers = new RichIterator<Integer>(2, 4, 6, 8, 7, 5, 10, 7, 6, 5, 11, 3);
		persons = new RichIterator<Person>(
				      new Person("Robby", "Pelssers", 33, false),
				      new Person("Robert", "Janssen", 36, false),
				      new Person("Davy", "Pelssers", 33, true),
				      new Person("Ron", "Peters", 35, false),
				      new Person("David", "Beckham", 38, true),
				      new Person("Jan", "Hermans", 33, false),
				      new Person("John", "Hendrix", 28, true),
				      new Person("John", "Vissers", 30, true),
				      new Person("Dimitri", "Janssen", 39, false),
				      new Person("Jan", "Peters", 39, true)
				  );
	}
	
	@Test
	public void testExists() {
		Assert.assertEquals(Boolean.TRUE, numbers.exists(lt(8)));
	}
	
	@Test
	public void testLessThen() {
		Assert.assertEquals(Boolean.TRUE, numbers.forAll(lt(12)));
	}
	
	@Test
	public void testLessThenOrEqual() {
		Assert.assertEquals(Boolean.TRUE, numbers.forAll(lte(11)));		
	}
	
	@Test
	public void testGreatherThen() {
		Assert.assertEquals(Boolean.TRUE, numbers.forAll(gt(1)));		
	}
	
	@Test
	public void testGreatherThenOrEqual() {
		Assert.assertEquals(Boolean.TRUE, numbers.forAll(gte(2)));		
	}
	
	@Test
	public void testBetween() {
		Assert.assertEquals(8, numbers.filter(between(5, 10)).size());
	}
	
	@Test
	public void testIn() {
		Assert.assertEquals(4, numbers.filter(in(listOf(5,6))).size());
	}
	
	@Test
	public void testEqualTo() {
		Assert.assertEquals(2, numbers.filter(equalTo(7)).size());
	}
	
	@Test
	public void testPropertyEqualToFilter_byAge() {
		RichIterable<Person> personsOfAge33 = persons.filter(property(equalTo(33), Person._getAge()));
		Assert.assertEquals(3, personsOfAge33.size());
	}
	
	@Test
	public void testPropertyEqualToFilter_byAge2() {
		RichIterable<Person> personsOfAgeLessThen35 = persons.filter(property(lt(35), Person._getAge()));
		Assert.assertEquals(5, personsOfAgeLessThen35.size());
	}	
	
	@Test
	public void testPropertyEqualToFilter_byIsMarried() {
		RichIterable<Person> marriedPersons = persons.filter(property(equalTo(true), Person._isMarried()));
		Assert.assertEquals(5, marriedPersons.size());
	}
	
	@Test
	public void testAndPredicate() {
		RichIterable<Person> filtered = 
			persons.filter(
				Predicates.<Person>And()
				    .add(property(equalTo("John"), Person._getFirstName()))
				    .add(property(equalTo(true), Person._isMarried()))
			);
		Assert.assertEquals(2, filtered.size());				
	}
	
	@Test
	public void testOrPredicate() {
		RichIterable<Person> filtered = 
			persons.filter(
			   Predicates.<Person>Or()
			       .add(property(equalTo("Pelssers"), Person._getLastName()))
			       .add(property(equalTo(39), Person._getAge()))
			);
		Assert.assertEquals(4, filtered.size());
	}
	
	@Test
	public void testAgeIn() {
		RichIterable<Person> filtered = persons.filter(
			property(in(listOf(33,39)), Person._getAge())
		);
		Assert.assertEquals(5, filtered.size());
	}
	
	@Test
	public void testMapPersonsToFirstNames() {
		RichIterable<String> firstNames = persons.map(Person._getFirstName());
		Assert.assertEquals(Boolean.TRUE, firstNames.contains("Robby"));
	}
	
	@Test
	public void testGroupByAge() {
		RichIterable<Groupable<Integer, Person>> groups = persons.groupBy(Person._getAge());
		Assert.assertEquals(7, groups.size());
		for (Groupable<Integer, Person> group : groups) {
			System.out.println("***************");
			System.out.println("key=" + group.getGroupingKey());
			for (Person person : group.getElements()) {
				System.out.println(person);
			}
		}
	}
	
	@Test
	public void testDistinct() {
		Assert.assertEquals(9, numbers.distinct().size());
	}
	
	@Test
	public void testStringJoinByName() {
		String result = persons.stringJoin(Person._getFirstName(), "[", "|", "]");
		Assert.assertEquals("[Robby|Robert|Davy|Ron|David|Jan|John|John|Dimitri|Jan]", result);
	}
	
	@Test
	public void testGetFirst() {
		Assert.assertEquals("Robby", persons.first().getFirstName());
	}
	
	@Test
	public void testGetLast() {
		Assert.assertEquals("Jan", persons.last().getFirstName());
	}
	
	@Test
	public void testPartition() {
		RichIterable<RichIterable<Person>>  partitions = persons.partition(3);
		for (RichIterable<Person> partition : partitions) {
			Assert.assertEquals(Boolean.TRUE, Boolean.valueOf(partition.size() == 3 || partition.size() == 1));
		}
	}
	
	@Test
	public void testTakeWhile() {
		RichIterable<Person>  result = persons.takeWhile(property(equalTo(false), Person._isMarried()));
		Assert.assertEquals(2, result.size());
	}
	
	@Test
	public void testSplitAt() {
		P2<RichIterable<Integer>, RichIterable<Integer>> pair = numbers.splitAt(5);
		Assert.assertEquals(5, pair.get1().size());
		Assert.assertEquals(7, pair.get2().size());
	}
	
	@Test
	public void testEndswith() {
		Assert.assertEquals(6, persons.filter(property(endsWith("s"), Person._getLastName())).size());
	}
	
	@Test
	public void testStartsWith() {
		Assert.assertEquals(3, persons.filter(property(startsWith("Ro"), Person._getFirstName())).size());
	}
	
}
