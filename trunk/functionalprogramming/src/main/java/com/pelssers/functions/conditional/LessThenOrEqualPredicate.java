package com.pelssers.functions.conditional;

public class LessThenOrEqualPredicate<T extends Number> extends AbstractConditionPredicate<T> {
	
    public LessThenOrEqualPredicate(T value) {
    	super(value);
    }
 
	@Override
	public Boolean apply(T object) {
		return object.doubleValue() <= getValue().doubleValue();
	}    
    
}
