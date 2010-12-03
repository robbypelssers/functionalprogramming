package com.pelssers.functions.iterable;

import java.util.ArrayList;
import java.util.List;

import com.pelssers.collections.RichIterator;
import com.pelssers.lang.Function2;
import com.pelssers.lang.Predicate;
import com.pelssers.lang.RichIterable;

public class FilterFunction<T> implements Function2<RichIterable<T>,Iterable<T>, Predicate<T>> {
	@Override
	public RichIterable<T> apply(final Iterable<T> iterable, final Predicate<T> predicate) {
		final List<T> list = new ArrayList<T>();
		for (T object : iterable ) {
			if (predicate.apply(object)) {
				list.add(object);
			}
		}
		return RichIterator.fromIterable(list);
	}
}
