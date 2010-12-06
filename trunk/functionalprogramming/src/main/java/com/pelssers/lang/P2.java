package com.pelssers.lang;

import static com.pelssers.functions.Preconditions.*;

public class P2<A,B> {

	private final A o1;
	private final B o2;
	
	public P2(A o1, B o2) {
		this.o1 = checkIsNotNull(o1);
		this.o2 = checkIsNotNull(o2);
	}
	
	public static <A,B> P2<A,B> of(A o1, B o2) {
		return new P2<A,B>(o1, o2);
	}
	
	public A get1() {
		return this.o1;
	}
	
	public B get2() {
		return this.o2;
	}
	
	@Override
	public String toString() {
		return "[1:" + get1().toString() + ", 2: " + get2().toString() + "]";
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
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if (!(object instanceof P2<?,?>)) {
			return false;
		}
		return this.get1().equals(((P2<A,B>)object).get1()) && this.get2().equals(((P2<A,B>)object).get2());
	}
	
	@Override
	public int hashCode() {
		return get1().hashCode() + get2().hashCode();
	}	
	
}
