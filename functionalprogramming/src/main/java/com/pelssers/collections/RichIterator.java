package com.pelssers.collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import com.pelssers.functions.Functions;
import com.pelssers.functions.Predicates;
import com.pelssers.lang.Effect;
import com.pelssers.lang.Function;
import com.pelssers.lang.Function2;
import com.pelssers.lang.Groupable;
import com.pelssers.lang.P2;
import com.pelssers.lang.Predicate;
import com.pelssers.lang.RichIterable;

public class RichIterator<T> implements RichIterable<T> {

	final protected List<T> elements;
	
	private RichIterator() {
		elements = new ArrayList<T>();		
	}
	

	public RichIterator(Iterable<T> iterable) {
        this();
		for (T object : iterable) {
			elements.add(object);
		}
	}
	
	public RichIterator(T... objects) {
		this();
        for (T object : objects) {
        	elements.add(object);
        }		
	}
		
	public static <T> RichIterable<T> fromIterable(Iterable<T> iterable) {
		return new RichIterator<T>(iterable);
	}
	
	public static <T> RichIterable<T> fromArray(T[] array) {
		return new RichIterator<T>(array);
	}
		
	@Override
	public Iterator<T> iterator() {
        return elements.iterator();
	}
	
	public Boolean contains(T object) {
		return elements.contains(object);
	}
	
	@Override
	public Boolean exists(Predicate<T> predicate) {
		return Predicates.<T>exists().apply(elements, predicate);
	}

	@Override
	public Boolean forAll(Predicate<T> predicate) {
		return Predicates.<T>forAll().apply(elements, predicate);
	}
	
	@Override
	public RichIterable<T> filter(Predicate<T> predicate) {
		return Functions.<T>filter().apply(elements, predicate);	
	}
	
	@Override
	public <S> RichIterable<S> map(Function<S,T> f) {
		return Functions.<S,T>map().apply(elements, f);
	}
	
	@Override
    public <S> RichIterable<Groupable<S, T>> groupBy(Function<S,T> f) {
    	return Functions.<S,T>groupBy().apply(elements, f);
    }
	
	public <P,S> RichIterable<Groupable<P2<P, S>, T>> groupBy(Function<P,T> f1,Function<S,T> f2) {
		return Functions.<P,S,T>groupBy2().apply(elements, f1, f2);
	}
	
	@Override
	public RichIterable<T> distinct() {
		return Functions.<T>distinct().apply(elements);
	}
	
	@Override
	public RichIterable<T> takeLeft(int n) {
		return Functions.<T>takeLeft().apply(elements, n);
	}
	
	@Override
	public RichIterable<T> takeRight(int n) {
		return Functions.<T>takeRight().apply(elements, n);
	}
	
	@Override
	public RichIterable<T> dropLeft(int n) {
		return Functions.<T>dropLeft().apply(elements, n);
	}
	
	@Override
	public RichIterable<T> dropRight(int n) {
		return Functions.<T>dropRight().apply(elements, n);
	}
	
	@Override
	public int size(){
		return this.elements.size();
	}
	
	@Override
	public 	RichIterable<T> forEach(Effect<T> effect) {
		return Functions.<T>forEach().apply(elements, effect);
	}

	@Override
	public RichIterable<T> doWhile(Predicate<T> predicate, Effect<T> effect) {
		return Functions.<T>doWhile().apply(elements, predicate, effect);
	}
	
	@Override
	public RichIterable<T> doUntill(Predicate<T> predicate, Effect<T> effect) {
		return Functions.<T>doUntill().apply(elements, predicate, effect);		
	}
	
	@Override
	public String stringJoin(Function<String,T> f, String before, String delimiter, String after) {
		return Functions.<T>stringJoin().apply(elements, f, before, delimiter, after);
	}
	
	
	@Override
	public String stringJoin(String before, String delimiter, String after) {
		return stringJoin(Functions.<T>stringify(), before, delimiter, after);			
	}
	
	@Override
	public Boolean isEmpty() {
		return elements.isEmpty();
	}
	
	@Override
	public T first() {
		return isEmpty() ? null : elements.get(0);	
	}
	
	@Override	
	public T last() {
		return isEmpty() ? null : elements.get(size() - 1);
	}
	
	@Override
	public RichIterable<RichIterable<T>> partition(Integer size) {
		return Functions.<T>partition().apply(elements, size);
	}
	
	@Override
	public 	RichIterable<T> takeWhile(Predicate<T> predicate) {
		return Functions.<T>takeWhile().apply(elements, predicate);
	}
	
	@Override
	public P2<RichIterable<T>, RichIterable<T>> splitAt(Integer index) {
		return Functions.<T>splitAt().apply(elements, index);
	}
	
	@Override
	public T foldLeft(T start, Function2<T,T,T> binop) {
		return Functions.<T>foldLeft().apply(elements, start, binop);
	}
	
	@Override
	public T foldRight(T start, Function2<T,T,T> binop) {
		return Functions.<T>foldRight().apply(elements, start, binop);
	}	
	
	@Override
	public RichIterable<T> sort(Comparator<T> comparator) {
		return Functions.<T>comparableSort().apply(elements, comparator);
	}
	
	@Override
	public <S> RichIterable<T> sortBy(Function<S,T> f, Comparator<S> comparator) {
		return Functions.<S,T>comparableSortBy().apply(elements, f, comparator);
	}
	
	public <S extends Comparable<S>> RichIterable<T> sortBy(Function<S,T> f) {
		return Functions.<S,T>naturalSortBy().apply(elements, f);
	}
	
}
