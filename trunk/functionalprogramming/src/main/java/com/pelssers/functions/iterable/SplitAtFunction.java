package com.pelssers.functions.iterable;

import java.util.ArrayList;
import java.util.List;

import com.pelssers.collections.RichIterator;
import com.pelssers.lang.Function2;
import com.pelssers.lang.P2;
import com.pelssers.lang.RichIterable;

public class SplitAtFunction<T> implements Function2<P2<RichIterable<T>, RichIterable<T>>, Iterable<T>, Integer> {

	@Override
	public P2<RichIterable<T>, RichIterable<T>> apply(Iterable<T> iterable, Integer number) {
		List<T> left = new ArrayList<T>();
		List<T> right = new ArrayList<T>();
		int index = 0;
		for (T object : iterable) {
			if (index < number) {
				left.add(object);
			} else {
				right.add(object);
			}
			index++;
		}
		return 
		    new P2<RichIterable<T>, RichIterable<T>>(
		        RichIterator.fromIterable(left),
		        RichIterator.fromIterable(right)
		    );
	}

}
