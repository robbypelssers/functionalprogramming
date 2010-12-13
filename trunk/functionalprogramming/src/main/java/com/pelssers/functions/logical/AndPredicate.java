package com.pelssers.functions.logical;

import com.pelssers.functions.AbstractCompositePredicate;
import com.pelssers.functions.Predicates;
import com.pelssers.lang.Predicate;

public class AndPredicate<T> extends AbstractCompositePredicate<T> {
		
	@Override
	public Boolean apply(final T object) {
		return Predicates.<Predicate<T>>forAll().apply(
				getPredicates(), 
				new Predicate<Predicate<T>>() {
					@Override
					public Boolean apply(Predicate<T> predicate) {
						return predicate.apply(object);
					}
				}
		);
	}	
}
