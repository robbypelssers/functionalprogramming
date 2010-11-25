package com.pelssers.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.pelssers.functions.Function;
import com.pelssers.functions.PredicateFunction;
import com.pelssers.functions.VoidFunction;
import com.pelssers.functions.factories.SystemFunctions;
import com.pelssers.functions.impl.MapperFunction;

public class Group<T> implements Groupable<T> {

	private ArrayList<T> collection;
		
	public Group() {
		this.collection = new ArrayList<T>();
	}	
	
	public Group(final Collection<T> collection) {
		this();
		for (Iterator<T> i = collection.iterator(); i.hasNext();) {
			this.collection.add(i.next());
		}
	}
	
	public Group(final T[] array) {
		this();
		for (T object : array) {
			add(object);
		}
	}
		
	public Boolean exists(final PredicateFunction<T> p) {
		Boolean exists = false;
		for (T object : this.collection) {
			if (p.apply(object)) {
				return true;
			}
		}
		return exists;
	}
	
	public void forEach(final VoidFunction<T> v) {
		for (T object : this.collection) {
			v.apply(object);
		}
	}
	
	public Groupable<T> filter(final PredicateFunction<T> p) {
		Groupable<T> filtered = new Group<T>();
		for (T object : this.collection) {
			if (p.apply(object)) {
				filtered.add(object);
			}
		}
		return filtered;
	}
	
	public <S> Groupable<S> map(final Function<S,T> f) {
		Groupable<S> mappedObjects = new Group<S>();
		for (T object : this.collection) {
			mappedObjects.add(f.apply(object));
		}
		return mappedObjects;
	}

	@Override
	public int size() {
		return this.collection.size();
	}

	@Override
	public Groupable<T> takeLeft(int number) {
		Groupable<T> result = new Group<T>();
		int index = 0;
        for (Iterator<T> i = iterator(); i.hasNext() && index  < number;) {
        	result.add(i.next());
        	index++;        	
        }
		return result;
	}

	@Override
	public Groupable<T> takeRight(int number) {
		int size = size();
		int dropLeft = number < size ? size - number : 0; 
		return dropLeft(dropLeft);
	}
	
	@Override
	public Groupable<T> dropLeft(int number) {
		Groupable<T> result = new Group<T>();
		int index = 1;
        for (Iterator<T> i = iterator(); i.hasNext();) {
        	T next = i.next();
            if (index > number) {
        	    result.add(next);
            }
        	index++;        	
        }
		return result;
	}

	@Override
	public Groupable<T> dropRight(int number) {
		int size = size();
		int takeLeft = number >= size ? 0 : size - number;
		return takeRight(takeLeft);
	}	

	@Override
	public Iterator<T> iterator() {
		return this.collection.iterator();
	}

	@Override
	public void doWhile(final PredicateFunction<T> p, final VoidFunction<T> v) {
		for (Iterator<T> i = iterator(); i.hasNext();) {
			T next = i.next();
			if (!p.apply(next)) {
				return;
			}
			v.apply(next);
		}
	}
	
	@Override
	public void doUntill(final PredicateFunction<T> p, final VoidFunction<T> v) {
		for (Iterator<T> i = iterator(); i.hasNext();) {
			T next = i.next();
			if (p.apply(next)) {
				return;
			}
			v.apply(next);
		}	
	}

	@Override
	public void printAll() {
		forEach(SystemFunctions.<T>println());
	}

	@Override
	public <S> Map<S, Groupable<T>> groupBy(final Function<S, T> f) {
		return new MapperFunction<S, T>(f).apply(this);
	}

	@Override
	public Groupable<T> add(T object) {
		this.collection.add(object);
		return this;
	}	
	
	public T get(int index) {
		return this.collection.get(index);
	}
	
	@Override
	public String stringJoin(Function<String, T> f, String delimiter) {
		StringBuilder sb = new StringBuilder();
		Iterator<T> i = iterator();
		while (i.hasNext()) {
			sb.append(f.apply(i.next()));
			if (i.hasNext()) {
				sb.append(delimiter);
			}
		}
		return sb.toString();
	}
	
	@Override
	public String stringJoin(String delimiter) {
		StringBuilder sb = new StringBuilder();
		Iterator<T> i = iterator();
		while (i.hasNext()) {
			sb.append(i.next().toString());
			if (i.hasNext()) {
				sb.append(delimiter);
			}
		}
		return sb.toString();		
	}
	
	@Override
	public Groupable<T> distinct() {
		Set<T> set = new TreeSet<T>();
		for (Iterator<T> i = iterator(); i.hasNext();) {
			set.add(i.next());
		}
		Groupable<T> result = new Group<T>(set);
		return result;
	}
}
