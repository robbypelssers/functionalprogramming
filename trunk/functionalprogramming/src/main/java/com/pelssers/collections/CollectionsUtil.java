package com.pelssers.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class CollectionsUtil {
	
	public static <T> List<T> listOf(T... elements) {
		return Arrays.asList(elements);
	}
	
	public static <T> List<T> toList(final Iterable<T> iterable) {
		final List<T> list = new  ArrayList<T>();
		for (Iterator<T> i = iterable.iterator(); i.hasNext();) {
			list.add(i.next());
		}
		return list;
	}
	
	public static <T> Set<T> toSet(final Iterable<T> iterable) {
		final Set<T> set = new TreeSet<T>();
		for (Iterator<T> i = iterable.iterator(); i.hasNext();) {
			set.add(i.next());
		}
		return set;
	}
	
	public static <T> ArrayList<T> arrayListOf(T... objects) {
		final ArrayList<T> list = new ArrayList<T>();
		for (T object : objects) {
			list.add(object);
		}
		return list;
	}
	
	public static <T> LinkedList<T> linkedListOf(T... objects) {
		final LinkedList<T> list = new LinkedList<T>();
		for (T object : objects) {
			list.add(object);
		}
		return list;		
	}
	
	public static <S,T> Map<S,T> newHashMap() {
		return new HashMap<S,T>();
	}
	
	public static <T> List<T> newArrayList() {
		return new ArrayList<T>();
	}	
	
	@SuppressWarnings("unused")
	public static <T> int sizeOf(Iterable<T> iterable) {
		int size = 0;
		for (T object : iterable) {
			size++;
		}
		return size;
	}
	
}
