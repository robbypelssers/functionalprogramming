package com.pelssers.lang;

public interface RichComparable<T extends Comparable<T>> extends RichIterable<T> {

	
	RichComparable<T> sort();
		
}
