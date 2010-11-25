package com.pelssers.functions.factories;

import com.pelssers.functions.CharacterFunction;
import com.pelssers.functions.impl.AbstractCharacterFunction;
import java.lang.Character;

public class CharacterFunctions {
	
	public static CharacterFunction<Character> toUpperCase() {
		return new AbstractCharacterFunction<Character>() {
			@Override
			public Character apply(Character object) {
				return Character.toUpperCase(object);
			}
		};
	}
	
	public static CharacterFunction<Character> toLowerCase() {
		return new AbstractCharacterFunction<Character>() {
			@Override
			public Character apply(Character object) {
				return Character.toLowerCase(object);
			}
		};
	}	

}
