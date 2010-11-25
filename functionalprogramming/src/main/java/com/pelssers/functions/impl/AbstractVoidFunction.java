package com.pelssers.functions.impl;

import com.pelssers.functions.VoidFunction;
import com.pelssers.lang.Tuple;


/**
 * Void Function class
 */
public abstract class AbstractVoidFunction<T> implements VoidFunction<T> {

	private Tuple tuple;
	
	public AbstractVoidFunction(Tuple tuple) {
		this.tuple = tuple;
	}
	
	public AbstractVoidFunction() {
		this(null);
	}
	
	public abstract void apply(T object);
	
	public Tuple getTuple() {
		return this.tuple;
	}
}
