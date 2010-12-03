package com.pelssers.functions.iterable;

import com.pelssers.collections.RichIterator;
import com.pelssers.functions.Functions;
import com.pelssers.lang.Function2;
import com.pelssers.lang.Function3;
import com.pelssers.lang.P2;
import com.pelssers.lang.RichIterable;

public class FoldRightFunction<T> implements Function3<T, Iterable<T>, T, Function2<T,T,T>> {

	@Override
	public T apply(Iterable<T> iterable, T start, Function2<T, T, T> binop) {
		T result = start;
		RichIterable<T> richIterator = RichIterator.fromIterable(iterable);
		while (richIterator.size() > 0) {
			P2<T, RichIterable<T>> pair = Functions.<T>poll().apply(richIterator);
			result = binop.apply(result, pair.get1());
			richIterator = pair.get2();
		}
		return result;
	}
	

}
