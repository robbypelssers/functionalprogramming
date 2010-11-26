package com.pelssers.functions.impl;

import java.lang.reflect.Method;

import com.pelssers.functions.Function;

public class ObjectFunctions {

	public static <T> Function<Object,T> get(String getter) {
		return new GetterPredicate<T>(getter);
	}
		
	private static class GetterPredicate<T> implements Function<Object,T> {
		private String getter;
		public GetterPredicate(String getter) {
			this.getter = getter;
		}
		@Override
		public Object apply(T object)  {
			Object value = null;
			try {
				Method method = object.getClass().getMethod(getter);
				value = method.invoke(object);
			} catch(Exception e) {
				
			}
			return value;
		}
	}
}
