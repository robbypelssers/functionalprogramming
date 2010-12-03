package com.pelssers.functions.iterable;

import com.pelssers.collections.RichIterator;
import com.pelssers.lang.Effect;
import com.pelssers.lang.Function3;
import com.pelssers.lang.Predicate;
import com.pelssers.lang.RichIterable;

public class DoUntillFunction<T> implements Function3<RichIterable<T>,Iterable<T>, Predicate<T>, Effect<T>> {

	@Override
	public RichIterable<T> apply(Iterable<T> iterable, Predicate<T> predicate, Effect<T> effect) {
		for (T object : iterable) {
			if (predicate.apply(object)) break;
			effect.apply(object);
		}
		return RichIterator.fromIterable(iterable);
	}
}
