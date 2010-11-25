package com.pelssers.functions.impl;

import java.util.HashMap;
import java.util.Map;

import com.pelssers.collections.Group;
import com.pelssers.collections.Groupable;
import com.pelssers.functions.Function;

public class MapperFunction<S, T> implements Function<Map<S, Groupable<T>>,Groupable<T>> {

	private Map<S, Groupable<T>> map;
	private Function<S,T> mapperFunction;
	
	public MapperFunction(final Function<S, T> mapperFunction) {
		this.map = new HashMap<S, Groupable<T>>();
		this.mapperFunction = mapperFunction;
	}

	@Override
	public Map<S, Groupable<T>> apply(Groupable<T> group) {
        for (T object : group) {
        	map(object);
        }	
		return map;
	}
	
	private void map(T object) {
		S key  = this.mapperFunction.apply(object);
        if (map.containsKey(key)) {
        	map.get(key).add(object);
        } else {
        	map.put(key, new Group<T>().add(object));
        }		
	}
}
