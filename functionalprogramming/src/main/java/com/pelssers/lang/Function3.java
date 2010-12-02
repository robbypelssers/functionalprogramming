package com.pelssers.lang;

public interface Function3<S,T,U,V> {
    
	S apply(final T object1, final U object2, V object3);
	
}
