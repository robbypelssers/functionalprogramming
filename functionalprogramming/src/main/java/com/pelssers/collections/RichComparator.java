package com.pelssers.collections;

import com.pelssers.functions.Functions;
import com.pelssers.lang.RichComparable;

@SuppressWarnings("unchecked")
public class RichComparator<T extends Comparable<T>> extends RichIterator<T> implements RichComparable<T> {

	
	private RichComparator() {
		super();	
	}
	

	public RichComparator(Iterable<T> iterable) {
        super(iterable);
	}
	
	public RichComparator(T... objects) {
        super(objects);	
	}	
	
	@Override
	public RichComparable<T> sort() {
		return Functions.<T>naturalSort().apply(elements);
	}
}
