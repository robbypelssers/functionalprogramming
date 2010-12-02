package com.pelssers.functions.string;

import com.pelssers.functions.conditional.AbstractConditionPredicate;

public class StartsWithFunction extends AbstractConditionPredicate<String> {

	public StartsWithFunction(String prefix) {
		super(prefix);
	}

	@Override
	public Boolean apply(String object) {
		return object.startsWith(getValue());
	}
}
