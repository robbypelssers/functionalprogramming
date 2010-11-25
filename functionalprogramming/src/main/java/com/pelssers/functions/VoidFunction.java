package com.pelssers.functions;

import com.pelssers.lang.Unit;

public interface VoidFunction<T> extends Function<Unit, T>  {
	
	Unit apply(T object);

}
