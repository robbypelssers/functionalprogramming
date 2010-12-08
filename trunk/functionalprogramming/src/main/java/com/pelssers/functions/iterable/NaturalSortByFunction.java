package com.pelssers.functions.iterable;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.pelssers.collections.CollectionsUtil;
import com.pelssers.collections.RichIterator;
import com.pelssers.lang.Function;
import com.pelssers.lang.Function2;
import com.pelssers.lang.RichIterable;

public class NaturalSortByFunction<S extends Comparable<S>,T> implements Function2<RichIterable<T>, Iterable<T>, Function<S,T>> {

	@Override
	public RichIterable<T> apply(final Iterable<T> iterable, final Function<S, T> f) {
		List<T> list = CollectionsUtil.toList(iterable);
		Collections.sort(
			list,
			new Comparator<T>() {
				@Override
				public int compare(T o1, T o2) {
					return f.apply(o1).compareTo(f.apply(o2));
				}
			}
		);
		return new RichIterator<T>(list);
	}
}
