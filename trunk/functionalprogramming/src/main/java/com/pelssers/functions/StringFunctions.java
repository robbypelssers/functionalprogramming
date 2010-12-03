package com.pelssers.functions;

import com.pelssers.functions.string.ConcatFunction;
import com.pelssers.functions.string.EndsWithFunction;
import com.pelssers.functions.string.SplitFunction;
import com.pelssers.functions.string.StartsWithFunction;
import com.pelssers.functions.string.ToLowerCaseFunction;
import com.pelssers.functions.string.ToUpperCaseFunction;
import com.pelssers.functions.string.TrimFunction;
import com.pelssers.lang.Function;
import com.pelssers.lang.Function2;
import com.pelssers.lang.Predicate;
import com.pelssers.lang.RichIterable;

public class StringFunctions {

	public static Function2<RichIterable<String>, String, String> split() {
		return new SplitFunction();
	}
	
	public static Function<String, String> toUpperCase() {
		return new ToUpperCaseFunction();
	}
	
	public static Function<String, String> toLowerCase() {
		return new ToLowerCaseFunction();
	}	
	
	public static Function<String, String> trim() {
		return new TrimFunction();
	}
	
	public static Predicate<String> startsWith(String prefix) {
		return new StartsWithFunction(prefix);
	}
	
	public static Predicate<String> endsWith(String suffix) {
		return new EndsWithFunction(suffix);
	}	
	
	public static Function2<String, String, String> concat() {
		return new ConcatFunction();
	}
	
}
