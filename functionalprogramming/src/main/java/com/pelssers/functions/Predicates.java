package com.pelssers.functions;

import com.pelssers.functions.conditional.EqualToPredicate;
import com.pelssers.functions.conditional.LessThenOrEqualPredicate;
import com.pelssers.functions.conditional.LessThenPredicate;
import com.pelssers.functions.iterable.ExistsPredicate;
import com.pelssers.functions.iterable.ForAllPredicate;
import com.pelssers.functions.iterable.InPredicate;
import com.pelssers.functions.iterable.IsRangePredicate;
import com.pelssers.functions.logical.AndPredicate;
import com.pelssers.functions.logical.NotPredicate;
import com.pelssers.functions.logical.OrPredicate;
import com.pelssers.lang.CompositePredicate;
import com.pelssers.lang.Function;
import com.pelssers.lang.Predicate;
import com.pelssers.lang.Predicate2;

public class Predicates {
	
	public static <T> Predicate<T> not(Predicate<T> p) {
		return new NotPredicate<T>(p);
	}
		
	public static <T> Predicate<T> isNull() {
		return new Predicate<T>() {
			@Override
			public Boolean apply(final T object) {
				return object == null;
			}
		};
	}
	
	public static <T> Predicate<T> isNotNull() {
		return not(Predicates.<T>isNull());
	}	
	
	public static <S,T> Predicate<T> property(Predicate<S> predicate, Function<S,T> extractor) {
		return new PropertyPredicate<S,T>(predicate, extractor);
	}
			
	public static <T> Predicate<T> equalTo(T value) {
		return new EqualToPredicate<T>(value);
	}
	
	public static <T> Predicate<T> in(Iterable<T> iterable) {
		return new InPredicate<T>(iterable);
	}
	
	public static <T> CompositePredicate<T> And() {
		return new AndPredicate<T>();
	}
		
	public static <T> CompositePredicate<T> Or() {
		return new OrPredicate<T>();
	}
	
	public static <T> Predicate2<Iterable<T>, Predicate<T>> exists() {
	    return new ExistsPredicate<T>();	
	}
	
	public static <T> Predicate2<Iterable<T>, Predicate<T>> forAll() {
		return new ForAllPredicate<T>();
	}
	
	public static <T extends Comparable<T>> Predicate<T> lt(T value) {
		return new LessThenPredicate<T>(value);
	}
	
	public static <T extends Comparable<T>> Predicate<T> lte(T value) {
	    return new LessThenOrEqualPredicate<T>(value);
    }	
	
	public static <T extends Comparable<T>> Predicate<T> gt(T value) {
	    return not(lte(value));
    }

    public static <T extends Comparable<T>> Predicate<T> gte(T value) {
	    return not(lt(value));
    }
    
	public static <T extends Comparable<T>> Predicate<T> between(T value1, T value2) {
		return Predicates.<T>And().add(gte(value1)).add(lte(value2));
	} 	
	
	public static  <T extends Comparable<T>> Predicate<Iterable<T>> isRange() {
		return new IsRangePredicate<T>();
	}
}
