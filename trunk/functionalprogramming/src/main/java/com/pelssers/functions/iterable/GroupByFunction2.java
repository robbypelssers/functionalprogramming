package com.pelssers.functions.iterable;

import com.pelssers.collections.Groups;
import com.pelssers.lang.Function;
import com.pelssers.lang.Function3;
import com.pelssers.lang.Groupable;
import com.pelssers.lang.GroupableComposite;
import com.pelssers.lang.P2;
import com.pelssers.lang.RichIterable;

public class GroupByFunction2<P,S,T> implements Function3<RichIterable<Groupable<P2<P,S>, T>>, Iterable<T>, Function<P,T>, Function<S,T>> {

	@Override
	public RichIterable<Groupable<P2<P, S>, T>> apply(Iterable<T> iterable, Function<P, T> f1, Function<S, T> f2) {
		GroupableComposite<P2<P,S>,T> groups = new Groups<P2<P,S>,T>();
		for (T object : iterable) {
			P key1 =  f1.apply(object);
			S key2 =  f2.apply(object);
			groups.add(P2.<P,S>of(key1, key2), object);
		}
		return groups.getGroups();
	}

}
