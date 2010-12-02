package com.pelssers.functions.iterable;

import com.pelssers.lang.Predicate;

public class InPredicate<T> implements Predicate<T> {

	private final Iterable<T> iterable;
	
	public InPredicate(final Iterable<T> iterable) {
		this.iterable = iterable;
	}
	@Override
	public Boolean apply(T o) {
		if (o == null) {
			for (T object : this.iterable) {
				if (object == null) return true;
			}
		} else {
			for (T object : this.iterable) {
				if (o.equals(object)) return true;
			}			
		}
		return false;
	}	
}
