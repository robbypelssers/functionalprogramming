package com.pelssers.functions;

import static com.pelssers.functions.Precondition.*;
public class Preconditions {

	public static <T> T checkIsNull(T reference) {
		return precondition(Predicates.<T>isNull()).apply(reference);
	}
	
	public static <T> T checkIsNotNull(T reference) {
		return precondition(Predicates.<T>isNotNull()).apply(reference);
	}
}
