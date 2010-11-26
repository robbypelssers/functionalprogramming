package com.pelssers.functions.impl;

import com.pelssers.functions.PredicateFunction;
import static com.pelssers.functions.impl.ObjectFunctions.*;

public class Predicates {

	public static <T extends Number> PredicateFunction<T> lt(T number) {
		return new LessThenPredicate<T>(number);
	}
	
	public static <T extends Number> PredicateFunction<T> lte(T number) {
		return new LessThenOrEqualPredicate<T>(number);
	}	
	
	public static <T extends Number> PredicateFunction<T> gt(T number) {
		return new GreatherThenPredicate<T>(number);
	}
	
	public static <T extends Number> PredicateFunction<T> gte(T number) {
		return new GreatherThenOrEqualPredicate<T>(number);
	}	
	
	public static PredicateFunction<Object> endsWith(String suffix) {
		return new EndsWithPredicate(suffix);
	}
	
	public static PredicateFunction<Object> startsWith(String prefix) {
		return new StartsWithPredicate(prefix);
	}
	
	public static  PredicateFunction<Object> eq(Object object) {
		return new EqualsPredicate<Object>(object);
	}
	
	public static <T> PredicateFunction<T> eqBy(String getter, Object value) {
		return new EqualsByGetterPredicate<T>(getter, value);
	}
	
	private static class LessThenPredicate<T extends Number> implements PredicateFunction<T> {
		private T number;
		public LessThenPredicate(T number) {
			this.number = number;
		}
		@Override
		public Boolean apply(T object) {
			return object.doubleValue() < number.doubleValue();
		}
	}
	
	private static class LessThenOrEqualPredicate<T extends Number> implements PredicateFunction<T> {
		private T number;
		public LessThenOrEqualPredicate(T number) {
			this.number = number;
		}
		@Override
		public Boolean apply(T object) {
			return object.doubleValue() <= number.doubleValue();
		}
	}	
	
	private static class GreatherThenPredicate<T extends Number> implements PredicateFunction<T> {
		private T number;
		public GreatherThenPredicate(T number) {
			this.number = number;
		}
		@Override
		public Boolean apply(T object) {
			return object.doubleValue() > number.doubleValue() ;
		}
	}
	
	private static class GreatherThenOrEqualPredicate<T extends Number> implements PredicateFunction<T> {
		private T number;
		public GreatherThenOrEqualPredicate(T number) {
			this.number = number;
		}
		@Override
		public Boolean apply(T object) {
			return object.doubleValue() >= number.doubleValue() ;
		}
	}	
	
	private static class EndsWithPredicate implements PredicateFunction<Object> {
		private String suffix;
		public EndsWithPredicate(String suffix) {
			this.suffix = suffix;
		}
		@Override
		public Boolean apply(Object object) {
			return ((String)object).endsWith(suffix);
		}
	}
	
	private static class StartsWithPredicate implements PredicateFunction<Object> {
		private String prefix;
		public StartsWithPredicate(String prefix) {
			this.prefix = prefix;
		}
		@Override
		public Boolean apply(Object object) {
			return ((String)object).startsWith(prefix);
		}
		
	}
	
	private static class EqualsPredicate<T> implements PredicateFunction<T> {
		private T object2;
		public EqualsPredicate(T object2) {
			this.object2 = object2;
		}
		@Override
		public Boolean apply(T object1) {
			return object2.equals(object1);
		}
	}	
	
	private static class EqualsByGetterPredicate<T> implements PredicateFunction<T> {
		private String getter;
		private Object value;
		public EqualsByGetterPredicate(String getter, Object value) {
			this.getter = getter;
			this.value = value;
		}
		@Override
		public Boolean apply(T object) {
			Object getterValue = get(getter).apply(object);
			return value.equals(getterValue);
		}
	}
	
}
