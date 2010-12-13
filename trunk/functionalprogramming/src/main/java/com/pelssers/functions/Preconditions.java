package com.pelssers.functions;

import static com.pelssers.functions.Precondition.*;
public class Preconditions {

	public static <T> T checkIsNull(T reference) {
		return precondition(Predicates.<T>isNull()).apply(reference);
	}
	
	public static <T> T checkIsNotNull(T reference) {
		return precondition(Predicates.<T>isNotNull()).apply(reference);
	}
	
	public static <T extends Comparable<T>> T checkIsLt(T reference, T value) {
		return precondition(Predicates.<T>lt(value)).apply(reference);
	}
	
	public static <T extends Comparable<T>> T checkIsGt(T reference, T value) {
		return precondition(Predicates.<T>gt(value)).apply(reference);
	}
	
	public static <T extends Comparable<T>> T checkIsLte(T reference, T value) {
		return precondition(Predicates.<T>lte(value)).apply(reference);
	}
	
	public static <T extends Comparable<T>> T checkIsGte(T reference, T value) {
		return precondition(Predicates.<T>gte(value)).apply(reference);
	}	
		
}
