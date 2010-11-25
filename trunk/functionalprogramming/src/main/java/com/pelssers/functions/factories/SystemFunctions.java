package com.pelssers.functions.factories;

import com.pelssers.collections.Groupable;
import com.pelssers.functions.VoidFunction;
import com.pelssers.functions.impl.AbstractVoidFunction;
import com.pelssers.lang.Unit;
import static com.pelssers.lang.Unit.unit;

public class SystemFunctions {

	public static <T> VoidFunction<T> println() {
	    VoidFunction<T> v = new AbstractVoidFunction<T>() {
		    @Override
		    public Unit apply(T object) {
			    System.out.println(object);
			    return unit();
		    }
	    };	
	    return v;
    }
	
	public static <T> VoidFunction<Groupable<T>> printlnAll() {
	    VoidFunction<Groupable<T>> v = new AbstractVoidFunction<Groupable<T>>() {
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
