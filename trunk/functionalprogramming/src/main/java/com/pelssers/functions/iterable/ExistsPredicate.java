package com.pelssers.functions.iterable;

import com.pelssers.lang.Predicate;
import com.pelssers.lang.Predicate2;

public class ExistsPredicate<T> implements Predicate2<Iterable<T>, Predicate<T>> {

	@Override
	public Boolean apply(Iterable<T> iterable, Predicate<T> predicate) {
		Boolean result = false;
		for (T object : iterable) {
			if (predicate.apply(object)) {
				return true;
			}
		}			
		return result;
	}
	
}
