package com.pelssers.functions.conditional;

public class EqualToPredicate<T> extends AbstractConditionPredicate<T>  {
	public EqualToPredicate(T value) {
		super(value);
	}
	
	@Override
	public Boolean apply(final T object) {
		return getValue() == object || (getValue() != null && getValue().equals(object));
	}
}
