package com.pelssers.functions.iterable;

import java.util.Iterator;

import com.pelssers.lang.Predicate;
import com.pelssers.lang.Predicate2;

public class ForAllPredicate<T> implements Predicate2<Iterable<T>, Predicate<T>> {
	@Override
	public Boolean apply(Iterable<T> iterable, Predicate<T> predicate) {
		Boolean result = true;
		for (Iterator<T> i = iterable.iterator(); i.hasNext() && result;) {
			T next = i.next();
			result = predicate.apply(next);
		}
		return result;
	}
}
