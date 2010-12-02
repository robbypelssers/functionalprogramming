package com.pelssers.functions.iterable;

import java.util.ArrayList;
import java.util.List;

import com.pelssers.collections.RichCollection;
import com.pelssers.lang.Function;
import com.pelssers.lang.Function2;
import com.pelssers.lang.RichIterable;

public class MapFunction<S,T> implements Function2<RichIterable<S>,Iterable<T>, Function<S,T>>{
	@Override
	public RichIterable<S> apply(final Iterable<T> iterable, final Function<S, T> f) {
		final List<S> list = new ArrayList<S>();
		for (T object : iterable) {
			list.add(f.apply(object));
		}
		return RichCollection.fromIterable(list);
	}
}
