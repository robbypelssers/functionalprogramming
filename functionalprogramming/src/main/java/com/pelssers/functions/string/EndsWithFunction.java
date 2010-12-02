package com.pelssers.functions.string;

import com.pelssers.functions.conditional.AbstractConditionPredicate;

public class EndsWithFunction extends AbstractConditionPredicate<String> {

	public EndsWithFunction(String suffix) {
		super(suffix);
	}

	@Override
	public Boolean apply(String object) {
		return object.endsWith(getValue());
	}



}
