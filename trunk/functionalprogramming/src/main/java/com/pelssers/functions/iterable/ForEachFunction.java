package com.pelssers.functions.iterable;

import com.pelssers.collections.RichCollection;
import com.pelssers.lang.Effect;
import com.pelssers.lang.Function2;
import com.pelssers.lang.RichIterable;

public class ForEachFunction<T> implements Function2<RichIterable<T>,Iterable<T>, Effect<T>> {

	@Override
	public RichIterable<T> apply(Iterable<T> iterable, Effect<T> effect) {
		for (T object : iterable) {
			effect.apply(object);
		}
		return RichCollection.fromIterable(iterable);
	}
	
}
