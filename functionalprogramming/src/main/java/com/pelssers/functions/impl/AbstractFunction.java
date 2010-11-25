package com.pelssers.functions.impl;

import com.pelssers.functions.Function;
import com.pelssers.lang.Tuple;

/**
 * Function class
 */
public abstract class AbstractFunction<S,T> implements Function<S,T>{

	private Tuple tuple;
	
	public AbstractFunction() {
		this(null);
	}
	
	public AbstractFunction(Tuple tuple) {
		this.tuple = tuple;
	}
	
	public abstract S apply(T object);
	
	public Tuple getTuple() {
		return this.tuple;
	}
}
