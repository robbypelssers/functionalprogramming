package com.pelssers.lang;

public class P3<A,B,C> {

	private final A o1;
	private final B o2;
	private final C o3;
	
	public P3(A o1, B o2, C o3) {
		this.o1 = o1;
		this.o2 = o2;
		this.o3 = o3;
	}
	
	public A get1() {
		return this.o1;
	}
	
	public B get2() {
		return this.o2;
	}
	
	public C get3() {
		return this.o3;
	}
	
	public Function<A, P3<A,B,C>> _get1() {
		return new Function<A, P3<A,B,C>>() {
			@Override
			public A apply(P3<A, B, C> p3) {
				return p3.get1();
			}
		};
	}
	
	public Function<B, P3<A,B,C>> _get2() {
		return new Function<B, P3<A,B,C>>() {
			@Override
			public B apply(P3<A, B, C> p3) {
				return p3.get2();
			}
		};
	}
	
	public Function<C, P3<A,B,C>> _get3() {
		return new Function<C, P3<A,B,C>>() {
			@Override
			public C apply(P3<A, B, C> p3) {
				return p3.get3();
			}
		};
	}	
	
}
