package com.pelssers.functions;

import java.util.ArrayList;
import java.util.List;

import com.pelssers.lang.CompositePredicate;
import com.pelssers.lang.Predicate;

public abstract class AbstractCompositePredicate<T> implements CompositePredicate<T> {
	private List<Predicate<T>> predicates;
	
	public AbstractCompositePredicate() {
		this.predicates = new ArrayList<Predicate<T>>();	
	}
	
	@Override
	public CompositePredicate<T> add(Predicate<T> predicate) {
		this.predicates.add(predicate);
		return this;
	}
	
	@Override
	public List<Predicate<T>> getPredicates() {
		return this.predicates;
	}
}
