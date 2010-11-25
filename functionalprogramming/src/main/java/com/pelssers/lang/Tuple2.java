package com.pelssers.lang;

public class Tuple2<A,B> extends AbstractTuple {

	public  Tuple2(A o1, B o2) {
        super(o1, o2);
	}
	
	@SuppressWarnings("unchecked")
	public A get1() {
		return (A) super.get1();
	}
	
	@SuppressWarnings("unchecked")
	public B get2() {
		return (B) super.get2();
	}
}
