package com.pelssers.lang;

public class Tuple1<A> extends AbstractTuple {

	public Tuple1(A o1) {
		super(o1);
	}
	
	@SuppressWarnings("unchecked")
	public A get1() {
		return (A) super.get1();
	}	
	
}
