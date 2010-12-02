package com.pelssers.lang;

public interface Groupable<S,T> {

	S getGroupingKey();
	RichIterable<T> getElements();
	Groupable<S,T> add(T object);
	
}
