package com.pelssers.functions.iterable;

import com.pelssers.collections.CollectionsUtil;
import com.pelssers.collections.RichCollection;
import com.pelssers.lang.Function;
import com.pelssers.lang.RichIterable;

public class DistinctFunction<T> implements Function<RichIterable<T>,Iterable<T>> {

	@Override
	public RichIterable<T> apply(Iterable<T> iterable) {
        return RichCollection.fromIterable(CollectionsUtil.toSet(iterable));
	}

}
