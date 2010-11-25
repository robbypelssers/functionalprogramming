package com.pelssers.lang;

public class Tuple4<A,B,C,D> extends AbstractTuple {

	public Tuple4(A o1, B o2, C o3, D o4) {
		super(o1, o2, o3, o4);		
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
	
	@SuppressWarnings("unchecked")
	public D get4() {
		return (D) super.get4();
	}	
	
}
