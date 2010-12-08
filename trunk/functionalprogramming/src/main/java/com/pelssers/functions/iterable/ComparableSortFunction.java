package com.pelssers.functions.iterable;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.pelssers.collections.CollectionsUtil;
import com.pelssers.collections.RichIterator;
import com.pelssers.lang.Function2;
import com.pelssers.lang.RichIterable;

public class ComparableSortFunction<T> implements Function2<RichIterable<T>, Iterable<T>, Comparator<T>> {

	@Override
	public RichIterable<T> apply(final Iterable<T> iterable, final Comparator<T> comparator) {
		List<T> list = CollectionsUtil.toList(iterable);
		Collections.sort(list, comparator);
		return new RichIterator<T>(list);
	}

}
