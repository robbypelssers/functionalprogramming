package com.pelssers.functions;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.pelssers.collections.Group;
import com.pelssers.collections.Groupable;
import com.pelssers.functions.impl.StringFunctions;

public class StringFunctionsTest {

	private Groupable<String> words;	
	
	@Before
	public void setup() {
		words =
			new Group<String>()
		    .add("duplicate")
		    .add("After")
		    .add("Before")
		    .add("duplicate")
		    .add("Last");		
	}
	
	@Test
	public void testToUpperCase() {
		Groupable<String> uppercase = words.map(StringFunctions.toUpperCase());
		Assert.assertEquals("DUPLICATE", uppercase.get(0));
	}
	
	@Test
	public void testToLowerCase() {
		Groupable<String> lowercase = words.map(StringFunctions.toLowerCase());
		Assert.assertEquals("after", lowercase.get(1));
	}
	
	@Test
	public void testSplitWords() {
		String sentence = "I would like to see more of this.";
		Assert.assertEquals(8, StringFunctions.splitWords().apply(sentence).size());
	}
	
	@Test
	public void testCapitalize() {
		String word1 = "another";
		String word2 = "b";
		String word3 = "";
		Assert.assertEquals("Another", StringFunctions.capitalize().apply(word1));
		Assert.assertEquals("B", StringFunctions.capitalize().apply(word2));
		Assert.assertEquals("", StringFunctions.capitalize().apply(word3));		
	}
	
	@Test
	public void testCapitalizeAll() {
		String sentence = "once upon a time there was a princess";
		Assert.assertEquals(
				"Once Upon A Time There Was A Princess", 
				StringFunctions.capitalizeAll().apply(sentence)
        );
	}
	
}
