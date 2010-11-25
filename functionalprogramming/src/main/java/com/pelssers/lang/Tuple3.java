package com.pelssers.lang;

public class Tuple3<A,B,C>  {

	private A o1;
	private B o2;
	private C o3;
	
	public Tuple3(A o1, B o2, C o3) {
        this.o1 = o1;
        this.o2 = o2;
        this.o3 = o3;
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
	
}
