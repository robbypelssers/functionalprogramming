package com.pelssers.functions;

import static com.pelssers.functions.StringFunctions.*;
import junit.framework.Assert;

import org.junit.Test;

import com.pelssers.lang.RichIterable;

public class StringFunctionsTest {

	@Test
	public void testToUpperCase() {
		Assert.assertEquals("GREAT", toUpperCase().apply("great"));
	}
	
	@Test
	public void testToLowerCase() {
		Assert.assertEquals("great", toLowerCase().apply("GREAT"));
	}
	
	@Test
	public void testSplit() {
		RichIterable<String> result = split().apply("help desk", "\\s");
		Assert.assertEquals("help", result.first());
		Assert.assertEquals("desk", result.last());
	}
	
	@Test
	public void testTrim() {
		Assert.assertEquals("help", trim().apply(" help "));
	}
	
	@Test
	public void testStartsWith() {
		Assert.assertEquals(Boolean.TRUE, startsWith("fir").apply("firstname"));
	}
	
	@Test
	public void testEndsWith() {
		Assert.assertEquals(Boolean.TRUE, endsWith("ame").apply("firstname"));		
	}
	
	@Test
	public void testConcat(){
		Assert.assertEquals("firstname", concat().apply("first", "name"));
	}
	
}
