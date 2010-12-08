package com.pelssers.functions.iterable;

import java.util.Collections;
import java.util.List;

import com.pelssers.collections.CollectionsUtil;
import com.pelssers.collections.RichComparator;
import com.pelssers.lang.Function;
import com.pelssers.lang.RichComparable;

public class NaturalSortFunction<T extends Comparable<T>> implements Function<RichComparable<T>,Iterable<T>> {
	
	@Override
	public RichComparable<T> apply(final Iterable<T> iterable) {
		List<T> list = CollectionsUtil.toList(iterable);
		Collections.sort(list);
		return new RichComparator<T>(list);
	}
}
