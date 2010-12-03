package com.pelssers.functions.string;

import com.pelssers.lang.Function2;

public class ConcatFunction implements Function2<String, String, String> {

	@Override
	public String apply(String object1, String object2) {
		return object1.concat(object2);
	}



}
