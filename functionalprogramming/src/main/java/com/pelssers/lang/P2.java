package com.pelssers.lang;

public class P2<A,B> {

	private final A o1;
	private final B o2;
	
	public P2(A o1, B o2) {
		this.o1 = o1;
		this.o2 = o2;
	}
	
	public A get1() {
		return this.o1;
	}
	
	public B get2() {
		return this.o2;
	}
	
	public Function<A, P2<A,B>> _get1() {
		return new Function<A, P2<A,B>>() {
			@Override
			public A apply(P2<A,B> p2) {
				return p2.get1();
			}
		};
	}	
	
	public Function<B, P2<A,B>> _get2() {
		return new Function<B, P2<A,B>>() {
			@Override
			public B apply(P2<A,B> p2) {
				return p2.get2();
			}
		};
	}	
}
