package com.pelssers.functions.impl;

import static com.pelssers.lang.Unit.unit;

import com.pelssers.collections.Groupable;
import com.pelssers.functions.VoidFunction;
import com.pelssers.lang.Unit;

public class SystemFunctions {

	public static <T> VoidFunction<T> println() {
	    VoidFunction<T> v = new VoidFunction<T>() {
		    @Override
		    public Unit apply(T object) {
			    System.out.println(object);
			    return unit();
		    }
	    };	
	    return v;
    }
	
	public static <T> VoidFunction<Groupable<T>> printlnAll() {
	    VoidFunction<Groupable<T>> v = new VoidFunction<Groupable<T>>() {
			@Override
			public Unit apply(Groupable<T> group) {
				for (T object : group) {
					println().apply(object);
				}
				return unit();
			}
	    };
	    return v;
	}
		
}
