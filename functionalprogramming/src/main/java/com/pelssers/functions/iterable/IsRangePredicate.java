package com.pelssers.functions.iterable;

import java.util.Iterator;

import com.pelssers.lang.Predicate;

public class IsRangePredicate<T extends Comparable<T>> implements Predicate<Iterable<T>> {


	@Override
	public Boolean apply(Iterable<T> iterable) {
		boolean isRange = true;
		T o1 = null, o2 = null;
		Iterator<T> i = iterable.iterator();
		if (i.hasNext()) {
			o1 = i.next();
		}
		for (; i.hasNext(); ) {
			if (i.hasNext()) {
				o2 = i.next();
				//compare o1 and o2
				if (o1.compareTo(o2) >= 0) {
					return false;
				}
			}
			//now point o1 to o2
			o1 = o2;
		}
		return isRange;
	}

}
