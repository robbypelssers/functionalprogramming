package com.pelssers.lang;

import org.junit.Test;

import com.pelssers.testdata.Person;

import junit.framework.Assert;

public class TupleTest {
	
	@Test
	public void testTuple1() {
		Person person = new Person("Robby", "Pelssers", 33);
		Tuple1<Person> tuple = new Tuple1<Person>(person);
		Assert.assertEquals(person, tuple.get1());		
	}

	@Test
	public void testTuple2() {
		Tuple2<String, Integer> tuple = new Tuple2<String, Integer>("Welcome", 33);
		Assert.assertEquals("Welcome", tuple.get1());
		Assert.assertEquals(new Integer(33), tuple.get2());
	}
	
	@Test
	public void testTuple3() {
		Tuple3<String, Integer, Boolean> tuple = new Tuple3<String, Integer, Boolean>("Welcome", 33, true);
		Assert.assertEquals("Welcome", tuple.get1());
		Assert.assertEquals(new Integer(33), tuple.get2());	
		Assert.assertEquals(Boolean.TRUE, tuple.get3());			
	}
	

	
}
