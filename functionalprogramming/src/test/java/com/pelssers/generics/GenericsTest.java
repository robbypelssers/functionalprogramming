package com.pelssers.generics;

import static com.pelssers.functions.impl.ObjectFunctions.*;
import junit.framework.Assert;

import org.junit.Test;

import com.pelssers.testdata.Person;

public class GenericsTest {

	@Test
	public void testGetter() {
        Person person = new Person("Robby", "Pelssers", 33);
        String fName = (String) get("getFirstName").apply(person);
        Assert.assertEquals(person.getFirstName(), fName);
	}
	
	
}
