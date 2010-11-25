package com.pelssers.functions.factories;

import com.pelssers.collections.Group;
import com.pelssers.collections.Groupable;
import com.pelssers.functions.StringFunction;
import com.pelssers.functions.impl.AbstractFunction;
import com.pelssers.functions.impl.AbstractStringFunction;

public class StringFunctions {

	public static StringFunction toUpperCase() {
		return new AbstractStringFunction() {
			@Override
			public String apply(String object) {
				return object.toUpperCase();
			}
		};
	}
	
	public static StringFunction toLowerCase() {
		return new AbstractStringFunction() {
			@Override
			public String apply(String object) {
				return object.toLowerCase();
			}
		};		
	}
	
	public static StringFunction trim() {
		return new AbstractStringFunction() {
			@Override
			public String apply(String object) {
				return object.trim();
			}
		};		
	}
	
	public static AbstractFunction<Groupable<String>, String> splitWords() {
		return new AbstractFunction<Groupable<String>, String>() {
			@Override
			public Groupable<String> apply(String object) {				
				return new Group<String>(object.split("\\s"));
			}
		};
	}
	
	public static StringFunction capitalize() {
		return new AbstractStringFunction() {
			@Override
			public String apply(String object) {				
				return object.length() > 0 ? Character.toUpperCase(object.charAt(0)) + object.substring(1) : object;
			}
		};		
	}
	
	public static StringFunction capitalizeAll() {
		return new AbstractStringFunction() {
			@Override
			public String apply(String object) {
				//first split the string into 1 or more words
				Groupable<String> words = splitWords().apply(object);
				//next capitalize the first letter of each word
				Groupable<String> capitalized = words.map(capitalize());
				return capitalized.stringJoin(" ");
			}
		};		
	}
}
