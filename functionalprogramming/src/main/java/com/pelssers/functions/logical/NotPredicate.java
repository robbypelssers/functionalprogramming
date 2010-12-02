package com.pelssers.functions.logical;

import com.pelssers.lang.Predicate;

public class NotPredicate<T> implements Predicate<T> {
	
	private Predicate<T> p;
	
	public NotPredicate(Predicate<T> p) {
		this.p = p;
	}
	@Override
	public Boolean apply(final T object) {
		return !p.apply(object);
	}
}
