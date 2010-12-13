package com.pelssers.functions;

import org.junit.Test;

import junit.framework.Assert;

import com.pelssers.collections.RichIterator;
import com.pelssers.lang.RichIterable;

public class IsRangeTest {

	
	@Test
	public void testIsRange() {
		RichIterable<Integer> numbers = new RichIterator<Integer>(2, 3, 4, 5, 6, 7);
		Assert.assertEquals(Boolean.TRUE, Predicates.<Integer>isRange().apply(numbers));
	}
}
