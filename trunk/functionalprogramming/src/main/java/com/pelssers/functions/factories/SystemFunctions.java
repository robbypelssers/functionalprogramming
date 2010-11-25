package com.pelssers.functions.factories;

import com.pelssers.functions.impl.AbstractVoidFunction;

public class SystemFunctions {

	public static <T> AbstractVoidFunction<T> println() {
	    AbstractVoidFunction<T> v = new AbstractVoidFunction<T>() {
		    @Override
		    public void apply(T object) {
			    System.out.println(object);
		    }
	    };	
	    return v;
    }
	
}
