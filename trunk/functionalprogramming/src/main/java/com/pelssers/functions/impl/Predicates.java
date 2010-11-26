package com.pelssers.functions.impl;

import com.pelssers.functions.PredicateFunction;

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
	
	public static PredicateFunction<String> endsWith(String suffix) {
		return new EndsWithPredicate(suffix);
	}
	
	public static PredicateFunction<String> startsWith(String prefix) {
		return new StartsWithPredicate(prefix);
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
	
	private static class EndsWithPredicate implements PredicateFunction<String> {
		private String suffix;
		public EndsWithPredicate(String suffix) {
			this.suffix = suffix;
		}
		@Override
		public Boolean apply(String object) {
			return object.endsWith(suffix);
		}
	}
	
	private static class StartsWithPredicate implements PredicateFunction<String> {
		private String prefix;
		public StartsWithPredicate(String prefix) {
			this.prefix = prefix;
		}
		@Override
		public Boolean apply(String object) {
			return object.startsWith(prefix);
		}
		
	}
	
}
