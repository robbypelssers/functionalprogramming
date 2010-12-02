package com.pelssers.functions.iterable;

import com.pelssers.collections.CollectionsUtil;
import com.pelssers.functions.Functions;
import com.pelssers.lang.Function2;
import com.pelssers.lang.RichIterable;

public class DropRightFunction<T> implements Function2<RichIterable<T>,Iterable<T>, Integer> {

	@Override
	public RichIterable<T> apply(Iterable<T> iterable, Integer number) {
		int size = CollectionsUtil.sizeOf(iterable);
		int takeLeft = number >= size ? 0 : size - number;
		return Functions.<T>takeLeft().apply(iterable, takeLeft);
	}
	
}
