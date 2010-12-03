package com.pelssers.functions.iterable;

import java.util.ArrayList;
import java.util.List;

import com.pelssers.collections.RichIterator;
import com.pelssers.lang.Function2;
import com.pelssers.lang.RichIterable;

public class PartitionFunction<T> implements Function2<RichIterable<RichIterable<T>>,Iterable<T>, Integer> {

	@Override
	public RichIterable<RichIterable<T>> apply(Iterable<T> iterable, Integer size) {
		final List<RichIterable<T>> list = new ArrayList<RichIterable<T>>();
		RichIterable<T> richIterable = RichIterator.fromIterable(iterable);
		while (richIterable.size() > 0) {
			list.add(richIterable.takeLeft(size));
			richIterable = richIterable.dropLeft(size);
		}
		return RichIterator.fromIterable(list);
	}

}
