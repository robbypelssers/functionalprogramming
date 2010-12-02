package com.pelssers.functions.string;

import com.pelssers.lang.Function;

public class TrimFunction implements Function<String, String>  {

	@Override
	public String apply(String object) {
		return object.trim();
	}

}
