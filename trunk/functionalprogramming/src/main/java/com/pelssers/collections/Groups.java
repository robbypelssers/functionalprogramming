package com.pelssers.collections;

import java.util.HashMap;
import java.util.Map;

import com.pelssers.lang.Groupable;
import com.pelssers.lang.GroupableComposite;
import com.pelssers.lang.RichIterable;

public class Groups<S,T> implements GroupableComposite<S, T> {

	private Map<S, Groupable<S,T>> groups;
	
	public Groups() {
		this.groups = new HashMap<S,Groupable<S,T>>();
	}
	
	@Override
	public GroupableComposite<S, T> add(S key, T item) {
        if (groups.containsKey(key)) {
        	groups.get(key).add(item);
        } else {
        	groups.put(key, new Group<S,T>(key).add(item));
        }
		return this;
	}

	@Override
	public RichIterable<Groupable<S, T>> getGroups() {
		return RichCollection.fromIterable(groups.values());
	}

}
