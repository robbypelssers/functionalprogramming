package com.pelssers.lang;

public class AbstractTuple implements Tuple {
    
	private Object[] objects;
	
	public AbstractTuple() {
		objects = new Object[10];		
	}
	
	public <A> AbstractTuple(final A o1) {
		this();
		objects[0] = o1;		
	}
		
	public <A,B>AbstractTuple(final A o1, final B o2) {
        this();
		objects[0] = o1;
		objects[1] = o2;		
	}
	
	public <A,B,C>AbstractTuple(final A o1, final B o2, final C o3) {
        this();
		objects[0] = o1;
		objects[1] = o2;
		objects[2] = o3;
	}
	
	public <A,B,C,D>AbstractTuple(final A o1, final B o2, final C o3, final D o4) {
        this();
		objects[0] = o1;
		objects[1] = o2;
		objects[2] = o3;
		objects[3] = o4;		
	}
	
	public <A,B,C,D,E>AbstractTuple(final A o1, final B o2, final C o3, final D o4, final E o5) {
        this();
		objects[0] = o1;
		objects[1] = o2;
		objects[2] = o3;
		objects[3] = o4;
		objects[4] = o5;			
	}
	
	public <A,B,C,D,E,F>AbstractTuple(final A o1, final B o2, final C o3, final D o4, final E o5, final F o6) {
        this();
		objects[0] = o1;
		objects[1] = o2;
		objects[2] = o3;
		objects[3] = o4;
		objects[4] = o5;
		objects[5] = o6;		
	}
	
	public <A,B,C,D,E,F,G>AbstractTuple(final A o1, final B o2, final C o3, final D o4, final E o5, final F o6, final G o7) {
        this();
		objects[0] = o1;
		objects[1] = o2;
		objects[2] = o3;
		objects[3] = o4;
		objects[4] = o5;
		objects[5] = o6;
		objects[6] = o7;		
	}
	
	public <A,B,C,D,E,F,G,H>AbstractTuple(final A o1, final B o2, final C o3, final D o4, final E o5, final F o6, final G o7, final H o8) {
        this();
		objects[0] = o1;
		objects[1] = o2;
		objects[2] = o3;
		objects[3] = o4;
		objects[4] = o5;
		objects[5] = o6;
		objects[6] = o7;
		objects[7] = o8;		
	}	
	
	public <A,B,C,D,E,F,G,H,I>AbstractTuple(final A o1, final B o2, final C o3, final D o4, final E o5, final F o6, final G o7, final H o8, final I o9) {
        this();
		objects[0] = o1;
		objects[1] = o2;
		objects[2] = o3;
		objects[3] = o4;
		objects[4] = o5;
		objects[5] = o6;
		objects[6] = o7;
		objects[7] = o8;
		objects[8] = o9;
	}
	
	public <A,B,C,D,E,F,G,H,I,J>AbstractTuple(final A o1, final B o2, final C o3, final D o4, final E o5, final F o6, final G o7, final H o8, final I o9, final J o10) {
		this();
		objects[0] = o1;
		objects[1] = o2;
		objects[2] = o3;
		objects[3] = o4;
		objects[4] = o5;
		objects[5] = o6;
		objects[6] = o7;
		objects[7] = o8;
		objects[8] = o9;
		objects[9] = o10;		
	}
	
	public Object get1() {
		return objects[0];
	}
	
	public Object get2() {
		return objects[1];
	}
	
	public Object get3() {
		return objects[2];
	}
	
	public Object get4() {
		return objects[3];
	}
	
	public Object get5() {
		return objects[4];
	}
	
	public Object get6() {
		return objects[5];
	}
	
	public Object get7() {
		return objects[6];
	}
	
	public Object get8() {
		return objects[7];
	}
	
	public Object get9() {
		return objects[8];
	}	
	
	public Object get10() {
		return objects[9];
	}	
	
}
