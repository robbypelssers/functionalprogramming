package com.pelssers.functions.impl;

import com.pelssers.collections.Group;
import com.pelssers.collections.Groupable;
import com.pelssers.functions.StringFunction;

public class StringFunctions {

	public static StringFunction<String> toUpperCase() {
		return new StringFunction<String>() {
			@Override
			public String apply(String object) {
				return object.toUpperCase();
			}
		};
	}
	
	public static StringFunction<String> toLowerCase() {
		return new StringFunction<String>() {
			@Override
			public String apply(String object) {
				return object.toLowerCase();
			}
		};		
	}
	
	public static StringFunction<String> trim() {
		return new StringFunction<String>() {
			@Override
			public String apply(String object) {
				return object.trim();
			}
		};		
	}
	
	public static StringFunction<Groupable<String>> splitWords() {
		return new StringFunction<Groupable<String>>() {
			@Override
			public Groupable<String> apply(String object) {				
				return new Group<String>(object.split("\\s"));
			}
		};
	}	
	
	public static StringFunction<String> capitalize() {
		return new StringFunction<String>() {
			@Override
			public String apply(String object) {				
				return object.length() > 0 ? Character.toUpperCase(object.charAt(0)) + object.substring(1) : object;
			}
		};		
	}
	
	public static StringFunction<String> uncapitalize() {
		return new StringFunction<String>() {
			@Override
			public String apply(String object) {				
				return object.length() > 0 ? Character.toLowerCase(object.charAt(0)) + object.substring(1) : object;
			}
		};		
	}
		
	public static StringFunction<String> capitalizeAll() {
		return new StringFunction<String>() {
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
