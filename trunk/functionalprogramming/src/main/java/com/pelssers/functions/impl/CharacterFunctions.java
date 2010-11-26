package com.pelssers.functions.impl;

import com.pelssers.functions.CharacterFunction;

public class CharacterFunctions {
	
	public static CharacterFunction<Character> toUpperCase() {
		return new CharacterFunction<Character>() {
			@Override
			public Character apply(Character object) {
				return Character.toUpperCase(object);
			}
		};
	}
	
	public static CharacterFunction<Character> toLowerCase() {
		return new CharacterFunction<Character>() {
			@Override
			public Character apply(Character object) {
				return Character.toLowerCase(object);
			}
		};
	}	

}
