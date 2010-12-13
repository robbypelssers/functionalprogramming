package com.pelssers.functions.conditional;

public class LessThenPredicate<T extends Comparable<T>> extends AbstractConditionPredicate<T>  {

	public LessThenPredicate(T value) {
		super(value);
	}
	@Override
	public Boolean apply(T object) {
		return object.compareTo(getValue()) < 0;
	}	
}
