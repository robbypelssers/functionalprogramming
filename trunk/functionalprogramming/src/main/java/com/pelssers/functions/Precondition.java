package com.pelssers.functions;

import static com.pelssers.functions.Predicates.not;

import com.pelssers.lang.Function;
import com.pelssers.lang.Predicate;

public class Precondition<T> implements Function<T,T> {
	private Predicate<T> predicate;
	public Precondition(Predicate<T> predicate) {
		this.predicate = not(predicate);
	}
	
	@Override
	public T apply(T object) {
		if (predicate.apply(object)) {
			throw new IllegalArgumentException();
		}
		return object;
	}
	
	public static <T> Precondition<T> precondition(Predicate<T> predicate) {
	    return new Precondition<T>(predicate);
    }	
}
