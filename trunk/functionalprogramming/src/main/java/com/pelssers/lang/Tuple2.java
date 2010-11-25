package com.pelssers.lang;

public class Tuple2<A,B>  {

	private A o1;
	private B o2;
	
	public Tuple2(A o1, B o2) {
        this.o1 = o1;
        this.o2 = o2;
	}
	
	public A get1() {
		return o1;
	}
	
	public B get2() {
		return o2;
	}
}
