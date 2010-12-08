package com.pelssers.functions.iterable;

import java.util.Collections;
import java.util.List;

import com.pelssers.collections.CollectionsUtil;
import com.pelssers.collections.RichIterator;
import com.pelssers.lang.Function;
import com.pelssers.lang.RichIterable;

public class NaturalSortFunction<T extends Comparable<T>> implements Function<RichIterable<T>,Iterable<T>> {
	
	@Override
	public RichIterable<T> apply(final Iterable<T> iterable) {
		List<T> list = CollectionsUtil.toList(iterable);
		Collections.sort(list);
		return new RichIterator<T>(list);
	}
}
