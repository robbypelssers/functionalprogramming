package com.pelssers.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.pelssers.functions.Functions;
import com.pelssers.functions.Predicates;
import com.pelssers.lang.Effect;
import com.pelssers.lang.Function;
import com.pelssers.lang.Groupable;
import com.pelssers.lang.P2;
import com.pelssers.lang.Predicate;
import com.pelssers.lang.RichIterable;

public class RichCollection<T> implements RichIterable<T> {

	private final List<T> elements;
	
	private RichCollection() {
		elements = new ArrayList<T>();		
	}

	public RichCollection(Iterable<T> iterable) {
        this();
		for (T object : iterable) {
			elements.add(object);
		}
	}
	
	public RichCollection(T[] array) {
		this();
        for (T object : array) {
        	elements.add(object);
        }
	}
	
	public static <T> RichIterable<T> fromIterable(Iterable<T> iterable) {
		return new RichCollection<T>(iterable);
	}
	
	public static <T> RichIterable<T> fromArray(T[] array) {
		return new RichCollection<T>(array);
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
		return stringJoin(Functions.<T>toString(), before, delimiter, after);			
	}
	
	@Override
	public Boolean isEmpty() {
		return elements.isEmpty();
	}
	
	@Override
	public T first() {
	    Iterator<T>  i = dropRight(size() - 1).iterator();
	    if (i.hasNext()) return i.next();
	    return null;	
	}
	
	@Override	
	public T last() {
	    Iterator<T>  i = dropLeft(size() -1).iterator();
	    if (i.hasNext()) return i.next();
	    return null;
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
	
}
