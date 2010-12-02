package com.pelssers.functions.conditional;

import com.pelssers.lang.Predicate;

public abstract class AbstractConditionPredicate<T> implements Predicate<T> {
	
	private T value;
	
	public AbstractConditionPredicate(T value) {
		this.value = value;
	}
	public T getValue() { 
		return this.value;
	}
}
