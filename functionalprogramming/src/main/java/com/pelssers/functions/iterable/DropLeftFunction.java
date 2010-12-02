package com.pelssers.functions.iterable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.pelssers.collections.RichCollection;
import com.pelssers.lang.Function2;
import com.pelssers.lang.RichIterable;

public class DropLeftFunction<T> implements Function2<RichIterable<T>,Iterable<T>, Integer> {

	@Override
	public RichIterable<T> apply(Iterable<T> iterable, Integer number) {
		List<T> result = new ArrayList<T>();
		int index = 1;
        for (Iterator<T> i = iterable.iterator(); i.hasNext();) {
        	T next = i.next();
            if (index > number) {
        	    result.add(next);
            }
        	index++;        	
        }
		return RichCollection.fromIterable(result);		

	}
}
