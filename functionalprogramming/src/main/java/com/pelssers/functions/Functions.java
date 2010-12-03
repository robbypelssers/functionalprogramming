package com.pelssers.functions;

import com.pelssers.functions.iterable.DistinctFunction;
import com.pelssers.functions.iterable.DoUntillFunction;
import com.pelssers.functions.iterable.DoWhileFunction;
import com.pelssers.functions.iterable.DropLeftFunction;
import com.pelssers.functions.iterable.DropRightFunction;
import com.pelssers.functions.iterable.FilterFunction;
import com.pelssers.functions.iterable.FoldLeftFunction;
import com.pelssers.functions.iterable.FoldRightFunction;
import com.pelssers.functions.iterable.ForEachFunction;
import com.pelssers.functions.iterable.GroupByFunction;
import com.pelssers.functions.iterable.MapFunction;
import com.pelssers.functions.iterable.PartitionFunction;
import com.pelssers.functions.iterable.PollFunction;
import com.pelssers.functions.iterable.PopFunction;
import com.pelssers.functions.iterable.SplitAtFunction;
import com.pelssers.functions.iterable.TakeLeftFunction;
import com.pelssers.functions.iterable.TakeRightFunction;
import com.pelssers.functions.iterable.TakeWhileFunction;
import com.pelssers.functions.string.StringJoinFunction;
import com.pelssers.functions.string.ToStringFunction;
import com.pelssers.lang.Effect;
import com.pelssers.lang.Function;
import com.pelssers.lang.Function2;
import com.pelssers.lang.Function3;
import com.pelssers.lang.Function5;
import com.pelssers.lang.Groupable;
import com.pelssers.lang.P2;
import com.pelssers.lang.Predicate;
import com.pelssers.lang.RichIterable;


public class Functions {
	public static <T> Function2<RichIterable<T>,Iterable<T>, Predicate<T>> filter() {
		return new FilterFunction<T>();
	}
	
	public static <S,T> Function2<RichIterable<S>,Iterable<T>, Function<S,T>> map() {
		return new MapFunction<S,T>();
	}
		
	public static <S,T> Function2<RichIterable<Groupable<S, T>>, Iterable<T>, Function<S,T>> groupBy() {
		return new GroupByFunction<S, T>();
	}
	
	public static <T> Function<RichIterable<T>,Iterable<T>> distinct() {
		return new DistinctFunction<T>();
	}
	
	public static <T> Function2<RichIterable<T>,Iterable<T>, Integer> takeLeft() {
		return new TakeLeftFunction<T>();
	}
	
	public static <T> Function2<RichIterable<T>,Iterable<T>, Integer> takeRight() {
		return new TakeRightFunction<T>();
	}
	
	public static <T> Function2<RichIterable<T>,Iterable<T>, Integer> dropLeft() {
		return new DropLeftFunction<T>();
	}
	
	public static <T> Function2<RichIterable<T>,Iterable<T>, Integer> dropRight() {
		return new DropRightFunction<T>();
	}
	
	public static <T> Function2<RichIterable<T>,Iterable<T>, Effect<T>> forEach() {
		return new ForEachFunction<T>();
	}
	
	public static <T> Function3<RichIterable<T>,Iterable<T>, Predicate<T>, Effect<T>> doWhile() {
		return new DoWhileFunction<T>();
	}
	
	public static <T> Function3<RichIterable<T>,Iterable<T>, Predicate<T>, Effect<T>> doUntill() {
		return new DoUntillFunction<T>();
	}	
	
	public static <T> Function<String, T> toString() {
		return new ToStringFunction<T>();
	}
	
	public static <T> Function5<String,Iterable<T>, Function<String,T>, String, String, String> stringJoin() {
		return new StringJoinFunction<T>();
	}
	
	public static <T> Function2<RichIterable<RichIterable<T>>,Iterable<T>, Integer> partition() {
		return new PartitionFunction<T>();
	}
	
	public static <T> Function2<RichIterable<T>, Iterable<T>, Predicate<T>> takeWhile() {
		return new TakeWhileFunction<T>();
	}
	
	public static <T> Function2<P2<RichIterable<T>, RichIterable<T>>, Iterable<T>, Integer> splitAt() {
		return new SplitAtFunction<T>();
	}
	
	public static <T> Function<P2<T, RichIterable<T>>, Iterable<T>> poll() {
		return new PollFunction<T>();
	}
	
	public static <T> Function<P2<T, RichIterable<T>>, Iterable<T>> pop() {
		return new PopFunction<T>();
	}	
	
	public static <T> Function3<T, Iterable<T>, T, Function2<T,T,T>> foldLeft() {
		return new FoldLeftFunction<T>();
	}
	
	public static <T> Function3<T, Iterable<T>, T, Function2<T,T,T>> foldRight() {
		return new FoldRightFunction<T>();
	}	

}