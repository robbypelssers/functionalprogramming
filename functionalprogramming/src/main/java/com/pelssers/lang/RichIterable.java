package com.pelssers.lang;


public interface RichIterable<T> extends Iterable<T> {

	/**
	 * @param predicate
	 * @return true if this iterable contains at least 1 object for which predicate.apply(object) returns true
	 */
	Boolean exists(Predicate<T> predicate);
	
	/**
	 * @param predicate
	 * @return true if for all objects in this iterable predicate.apply(object) returns true
	 */
	Boolean forAll(Predicate<T> predicate);
	
	/**
	 * @param object
	 * @return true if this iterable contains {object}
	 */
	Boolean contains(T object);
	
	/**
	 * @param predicate
	 * @return a new RichIterable containing all objects from this iterable for which predicate.apply(object) returns true
	 */
	RichIterable<T> filter(Predicate<T> predicate);
	
	/**
	 * @param f: f<S,T> returns an object of type <S> after executing f.apply(T object)
	 * @return a new RichIterable containing objects of type <S>
	 */
	<S> RichIterable<S> map(Function<S,T> f);
	
	/**
	 * @param f: f<S,T> which returns groupingkey of type <S> from f.apply(T object)
	 * @return a new RichIterable containing Groupable<S,T>
	 */
	<S> RichIterable<Groupable<S, T>> groupBy(Function<S,T> f);
	
	/**
	 * @return a new RichIterable containing distinct objects meaning that there exists no combination of 
	 * e1 and e2 where e1.equals(e2) 
	 */
	RichIterable<T> distinct();
	
	/**
	 * @return the size of this iterable
	 */
	int size();
	
	/**
	 * @param n
	 * @return a new RichIterable containing the first n elements
	 */	
	RichIterable<T> takeLeft(int n);
	
	/**
	 * @param n
	 * @return a new RichIterable containing the last n elements
	 */	
	RichIterable<T> takeRight(int n);
	
	/**
	 * @param n
	 * @return a new RichIterable containing all elements except first n ones
	 */	
	RichIterable<T> dropLeft(int n);
	
	/**
	 * @param n
	 * @return a new RichIterable containing all elements except last n ones
	 */
	RichIterable<T> dropRight(int n);
	
	
	/**
	 * forEach applies the effect on each element
	 * @param effect 
	 * @return this RichIterable 
	 */
	RichIterable<T> forEach(Effect<T> effect);
	
	/**
	 * doWhile applies the effect on each element while predicate returns true 
	 * @param predicate
	 * @param effect
	 * @return this RichIterable
	 */
	RichIterable<T> doWhile(Predicate<T> predicate, Effect<T> effect);
	
	/**
	 * doUntill applies the effect on each element untill predicate returns true 
	 * @param predicate
	 * @param effect
	 * @return this RichIterable
	 */	
	RichIterable<T> doUntill(Predicate<T> predicate, Effect<T> effect);	
	

    /**
     * @param f
     * @param delimiter
     * @return a concatenated string from applying f on each element, starting with before, ending with after and separated by delimiter
     */
	String stringJoin(Function<String,T> f, String before, String delimiter, String after);
	
    /**
     * @param f
     * @param delimiter
     * @return a concatenated string from applying toString on each element, starting with before, ending with after and separated by delimiter
     */		
	String stringJoin(String before, String delimiter, String after);
	
	/**
	 * Tests whether this iterable is empty
	 * @return Boolean
	 */
	Boolean isEmpty();
	
	/**
	 * @return the first element or null if this iterable is empty
	 */
	T first();
	
	/**
	 * @return the last element or null if this iterable is empty
	 */	
	T last();
	
	/**
	 * @param size
	 * @return a new RichIterable containing RichIterable<T> of fixed {size} except for the last partition 
	 * if the elements don't divide evenly
	 */
	RichIterable<RichIterable<T>> partition(Integer size);
	
	/**
	 * @param predicate
	 * @return a new RichIterable containing all elements untill predicate.apply(T object) returns false
	 */
	RichIterable<T> takeWhile(Predicate<T> predicate);
	
	/**
	 * @param index
	 * @return returns a pair of 2 new RichIterables by splitting this iterable at {index}
	 */
	P2<RichIterable<T>, RichIterable<T>> splitAt(Integer index);
	
}
