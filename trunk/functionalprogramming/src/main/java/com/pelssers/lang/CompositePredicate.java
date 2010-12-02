package com.pelssers.lang;

import java.util.List;

public interface CompositePredicate<T> extends Predicate<T> {

	CompositePredicate<T> add(Predicate<T> predicate);
	List<Predicate<T>> getPredicates();
	
}
