package com.pelssers.functions.string;

import java.util.Iterator;

import com.pelssers.lang.Function;
import com.pelssers.lang.Function5;

public class StringJoinFunction<T> implements Function5<String,Iterable<T>, Function<String,T>, String, String, String>  {

	@Override
	public String apply(Iterable<T> iterable, Function<String, T> f, String before, String delimiter, String after) {
		StringBuilder sb = new StringBuilder();
		sb.append(before);
		Iterator<T> iterator = iterable.iterator();
		while (iterator.hasNext()) {
			sb.append(f.apply(iterator.next()));
			if (iterator.hasNext()) sb.append(delimiter);
		}
		sb.append(after);
		return sb.toString();
	}

}
