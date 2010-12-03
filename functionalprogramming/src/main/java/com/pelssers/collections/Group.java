package com.pelssers.collections;

import java.util.ArrayList;
import java.util.List;

import com.pelssers.lang.Function;
import com.pelssers.lang.Groupable;
import com.pelssers.lang.RichIterable;

public class Group<S,T> implements Groupable<S, T> {

	private S key;
	private List<T> elements;
	
	public Group(final S key) {
		this.key = key;
		this.elements = new ArrayList<T>();
	}
	
	@Override
	public Groupable<S,T> add(T object) {
		this.elements.add(object);
		return this;
	}

	@Override
	public RichIterable<T> getElements() {
		return RichIterator.fromIterable(elements);
	}

	@Override
	public S getGroupingKey() {
		return this.key;
	}
	
	public static <S,T> Function<S, Groupable<S,T>> _getGroupingKey() {
		return new Function<S,Groupable<S,T>>() {
			@Override
			public S apply(Groupable<S, T> groupable) {
				return groupable.getGroupingKey();
			}
		};
	}

}
