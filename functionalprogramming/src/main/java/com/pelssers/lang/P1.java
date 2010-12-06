package com.pelssers.lang;

import static com.pelssers.functions.Preconditions.*;

public class P1<A> {
	
	private final A o1; 
	
	public P1(A o1) {
		this.o1 = checkIsNotNull(o1);
	}
	
	public static <A> P1<A> of(A o1) {
		return new P1<A>(o1);
	}	
	
	public A get1() {
		return this.o1;
	}
	
	@Override
	public String toString() {
		return "[1:" + get1().toString() + "]";
	}
	
	public Function<A, P1<A>> _get1() {
		return new Function<A, P1<A>>() {
			@Override
			public A apply(P1<A> p1) {
				return p1.get1();
			}
		};
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if (!(object instanceof P1<?>)) {
			return false;
		}
		return this.get1().equals(((P1<A>)object).get1());
	}
	
	@Override
	public int hashCode() {
		return get1().hashCode();
	}
}
