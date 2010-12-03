package com.pelssers.functions.iterable;

import com.pelssers.collections.RichIterator;
import com.pelssers.lang.Function2;
import com.pelssers.lang.P2;
import com.pelssers.lang.RichIterable;

public class SplitAtFunction<T> implements Function2<P2<RichIterable<T>, RichIterable<T>>, Iterable<T>, Integer> {

	@Override
	public P2<RichIterable<T>, RichIterable<T>> apply(Iterable<T> iterable, Integer number) {
		RichIterable<T> richIterable = RichIterator.fromIterable(iterable);
		return new P2<RichIterable<T>, RichIterable<T>>(richIterable.takeLeft(number), richIterable.dropLeft(number));
	}

}
