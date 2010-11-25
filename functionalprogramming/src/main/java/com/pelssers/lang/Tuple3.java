package com.pelssers.lang;

public class Tuple3<A,B,C> extends AbstractTuple {

	public Tuple3(A o1, B o2, C o3) {
		super(o1, o2, o3);
	}
	
	@SuppressWarnings("unchecked")
	public A get1() {
		return (A) super.get1();
	}
	
	@SuppressWarnings("unchecked")
	public B get2() {
		return (B) super.get2();
	}
	
	@SuppressWarnings("unchecked")
	public C get3() {
		return (C) super.get3();
	}	
	
}
