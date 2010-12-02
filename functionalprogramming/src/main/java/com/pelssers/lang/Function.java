package com.pelssers.lang;

public interface Function<S,T> {
	S apply(final T object);
}
