package com.pelssers.functions.impl;

import com.pelssers.functions.PredicateFunction;
import com.pelssers.lang.Tuple;

/**
 * Predicate class
 */
public abstract class AbstractPredicateFunction<T> extends AbstractFunction<Boolean, T> implements PredicateFunction<T> {

	public AbstractPredicateFunction() {
		this(null);
	}
	
	public AbstractPredicateFunction(Tuple tuple) {
		super(tuple);
	}
	
}
