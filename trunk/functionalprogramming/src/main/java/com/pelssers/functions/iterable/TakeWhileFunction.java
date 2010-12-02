package com.pelssers.functions.iterable;

import java.util.ArrayList;
import java.util.List;

import com.pelssers.collections.RichCollection;
import com.pelssers.functions.Functions;
import com.pelssers.lang.Effect;
import com.pelssers.lang.Function2;
import com.pelssers.lang.Predicate;
import com.pelssers.lang.RichIterable;

public class TakeWhileFunction<T> implements Function2<RichIterable<T>, Iterable<T>, Predicate<T>> {

	@Override
	public RichIterable<T> apply(final Iterable<T> iterable, final Predicate<T> predicate) {
		final List<T> result = new ArrayList<T>();
		Functions.<T>doWhile().apply(
				iterable, 
				predicate, 
				new Effect<T>() {
					@Override
					public void apply(T object) {
						result.add(object);
					}
				}
        );
		return RichCollection.fromIterable(result);
	}
	
}
