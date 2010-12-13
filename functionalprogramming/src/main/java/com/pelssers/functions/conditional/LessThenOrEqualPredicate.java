package com.pelssers.functions.conditional;

public class LessThenOrEqualPredicate<T extends Comparable<T>> extends AbstractConditionPredicate<T> {
	
    public LessThenOrEqualPredicate(T value) {
    	super(value);
    }
 
	@Override
	public Boolean apply(T object) {
		return object.compareTo(getValue()) <= 0;
	}    
    
}
