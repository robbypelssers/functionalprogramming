package com.pelssers.functions.iterable;

import com.pelssers.collections.Groups;
import com.pelssers.lang.Function;
import com.pelssers.lang.Function2;
import com.pelssers.lang.Groupable;
import com.pelssers.lang.GroupableComposite;
import com.pelssers.lang.RichIterable;

public class GroupByFunction<S,T> implements Function2<RichIterable<Groupable<S, T>>, Iterable<T>, Function<S,T>> {

	@Override
	public RichIterable<Groupable<S, T>> apply(Iterable<T> iterable, Function<S, T> f) {
		GroupableComposite<S,T> groups = new Groups<S,T>();
		for (T object : iterable) {
			groups.add(f.apply(object), object);
		}
		return groups.getGroups();
	}

}
