package com.pelssers.lang;

import org.junit.Test;

import junit.framework.Assert;

public class TupleTest {

	@Test
	public void testTuple2() {
		Tuple tuple = new Tuple2<String, Integer>("Welcome", 33);
		Assert.assertEquals("Welcome", tuple.get1());
		Assert.assertEquals(33, tuple.get2());
		Assert.assertNull(tuple.get3());
	}
	
	@Test
	public void testTuple3() {
		Tuple tuple = new Tuple3<String, Integer, Boolean>("Welcome", 33, true);
		Assert.assertEquals("Welcome", tuple.get1());
		Assert.assertEquals(33, tuple.get2());	
		Assert.assertEquals(true, tuple.get3());			
	}
	
}
