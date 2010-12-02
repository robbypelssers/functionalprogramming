package com.pelssers.functions;

import com.pelssers.lang.Function;
import com.pelssers.lang.Predicate;

public class PropertyPredicate<S,T> implements Predicate<T> {
	private Function<S,T> extractor;		
    private Predicate<S> predicate;
	public PropertyPredicate(Predicate<S> predicate, Function<S,T> extractor) {
		this.extractor = extractor;
		this.predicate = predicate;
	}
	@Override
	public Boolean apply(T object) {
		return this.predicate.apply(this.extractor.apply(object));
	}
}
