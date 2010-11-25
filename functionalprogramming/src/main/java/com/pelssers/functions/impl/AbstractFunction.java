package com.pelssers.functions.impl;

import com.pelssers.functions.Function;

/**
 * Function class
 */
public abstract class AbstractFunction<S,T> implements Function<S,T>{
	
	public AbstractFunction() {
	}
	
	public abstract S apply(T object);
	
}
