package com.pelssers.collections;

import java.util.Iterator;
import java.util.Map;

import com.pelssers.functions.Function;
import com.pelssers.functions.PredicateFunction;
import com.pelssers.functions.VoidFunction;

public interface Groupable<T> extends Iterable<T> {

	Boolean exists(PredicateFunction<T> p);
	void forEach(VoidFunction<T> v);
	Groupable<T> add(T object);
	T get(int index);
	Groupable<T> filter(PredicateFunction<T> p);
	<S> Groupable<S> map(Function<S,T> f);
	int size();
	Groupable<T> takeLeft(int number);
	Groupable<T> takeRight(int number);
	Groupable<T> dropLeft(int number);
	Groupable<T> dropRight(int number);
	Iterator<T> iterator();
	void doWhile(PredicateFunction<T> p, VoidFunction<T> v);
	void doUntill(final PredicateFunction<T> p, final VoidFunction<T> v);
	void printAll();
	<S> Map<S, Groupable<T>> groupBy(Function<S,T> f);
	String stringJoin(Function<String, T> f, String delimiter);
	String stringJoin(String delimiter);
	Groupable<T> distinct();
}
