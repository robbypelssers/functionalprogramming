package com.pelssers.functions.conditional;

public class LessThenPredicate<T extends Number> extends AbstractConditionPredicate<T>  {

	public LessThenPredicate(T value) {
		super(value);
	}
	@Override
	public Boolean apply(T object) {
		return object.doubleValue() < getValue().doubleValue();
	}	
}
