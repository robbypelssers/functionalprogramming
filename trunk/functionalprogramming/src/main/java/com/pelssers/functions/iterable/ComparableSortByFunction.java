package com.pelssers.functions.iterable;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.pelssers.collections.CollectionsUtil;
import com.pelssers.collections.RichIterator;
import com.pelssers.lang.Function;
import com.pelssers.lang.Function3;
import com.pelssers.lang.RichIterable;

public class ComparableSortByFunction<S,T> implements Function3<RichIterable<T>, Iterable<T>, Function<S,T>, Comparator<S>> {

	@Override
	public RichIterable<T> apply(final Iterable<T> iterable, final Function<S, T> f, final Comparator<S> comparator) {
		List<T> list = CollectionsUtil.toList(iterable);
		Collections.sort(
			list, 
			new Comparator<T>() {
				@Override
				public int compare(T o1, T o2) {
					return comparator.compare(f.apply(o1), f.apply(o2));
				}
			}
		);
		return new RichIterator<T>(list);
	}

}
