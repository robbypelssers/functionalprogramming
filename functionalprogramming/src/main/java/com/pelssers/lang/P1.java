package com.pelssers.lang;

public class P1<A> {
	
	private final A o1; 
	
	public P1(A o1) {
		this.o1 = o1;
	}
	
	public A get1() {
		return this.o1;
	}
	
	public Function<A, P1<A>> _get1() {
		return new Function<A, P1<A>>() {
			@Override
			public A apply(P1<A> p1) {
				return p1.get1();
			}
		};
	}
}
