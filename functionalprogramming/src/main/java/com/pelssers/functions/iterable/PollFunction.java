package com.pelssers.functions.iterable;

import com.pelssers.collections.RichIterator;
import com.pelssers.lang.Function;
import com.pelssers.lang.P2;
import com.pelssers.lang.RichIterable;

public class PollFunction<T> implements Function<P2<T, RichIterable<T>>, Iterable<T>> {

	@Override
	public P2<T, RichIterable<T>> apply(Iterable<T> iterable) {
		RichIterable<T> richIterable = RichIterator.fromIterable(iterable);
		return new P2<T, RichIterable<T>>(richIterable.first(), richIterable.dropLeft(1));
	}

}
