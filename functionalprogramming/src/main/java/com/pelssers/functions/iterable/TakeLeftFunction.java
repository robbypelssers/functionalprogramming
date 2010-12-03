package com.pelssers.functions.iterable;

import com.pelssers.functions.Functions;
import com.pelssers.lang.Function2;
import com.pelssers.lang.RichIterable;

public class TakeLeftFunction<T> implements Function2<RichIterable<T>,Iterable<T>, Integer> {

	@Override
	public RichIterable<T> apply(Iterable<T> iterable, Integer number) {
		return Functions.<T>splitAt().apply(iterable, number).get1();
	}

}
