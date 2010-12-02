package com.pelssers.lang;

public interface GroupableComposite<S,T> {

	GroupableComposite<S,T> add(S key, T item);
	RichIterable<Groupable<S,T>> getGroups();
	
}
