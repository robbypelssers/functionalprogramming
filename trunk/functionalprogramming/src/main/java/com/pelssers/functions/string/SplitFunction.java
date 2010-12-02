package com.pelssers.functions.string;

import com.pelssers.collections.RichCollection;
import com.pelssers.lang.Function2;
import com.pelssers.lang.RichIterable;

public class SplitFunction implements Function2<RichIterable<String>, String, String> {

	@Override
	public RichIterable<String> apply(String object, String regex) {
		return RichCollection.<String>fromArray(object.split(regex));
	}
	
}
