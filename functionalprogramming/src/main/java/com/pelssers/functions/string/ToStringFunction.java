package com.pelssers.functions.string;

import com.pelssers.lang.Function;

public class ToStringFunction<T> implements Function<String, T> {

	@Override
	public String apply(T object) {
		return object.toString();
	}

}
