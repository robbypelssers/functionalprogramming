package com.pelssers.lang;

import static com.pelssers.functions.Preconditions.*;

public class P3<A,B,C> {

	private final A o1;
	private final B o2;
	private final C o3;
	
	public P3(A o1, B o2, C o3) {
		this.o1 = checkIsNotNull(o1);
		this.o2 = checkIsNotNull(o2);
		this.o3 = checkIsNotNull(o3);
	}
	
	public static <A,B,C> P3<A,B,C> of(A o1, B o2, C o3) {
		return new P3<A,B,C>(o1, o2, o3);
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
	
	@Override
	public String toString() {
		return "[1:" + get1().toString() + ", 2: " + get2().toString() + ", 3: " +  get3().toString() + "]";
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
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if (!(object instanceof P3<?,?,?>)) {
			return false;
		}
		return 
		    this.get1().equals(((P3<A,B,C>)object).get1()) && 
		    this.get2().equals(((P3<A,B,C>)object).get2()) &&
		    this.get3().equals(((P3<A,B,C>)object).get3());
	}
	
	@Override
	public int hashCode() {
		return get1().hashCode() + get2().hashCode() + get3().hashCode();
	}	
	
}
