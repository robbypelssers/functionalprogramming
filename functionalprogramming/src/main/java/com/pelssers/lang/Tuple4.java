package com.pelssers.lang;

public class Tuple4<A,B,C,D> {

	private A o1;
	private B o2;
	private C o3;
	private D o4;
	
	public Tuple4(A o1, B o2, C o3, D o4) {
        this.o1 = o1;
        this.o2 = o2;
        this.o3 = o3;
        this.o4 = o4;
	}
	
	public A get1() {
		return o1;
	}
	
	public B get2() {
		return o2;
	}	
	
	public C get3() {
		return o3;
	}	
	
	public D get4() {
		return o4;
	}
	
}
