package com.gamewolf.util.lang;

public class Pair<L,R> {
	
	L left;
	
	R right;
	
	public Pair(L l,R r){
		left=l;
		right=r;
	}
	
	public L getLeft() {
		return left;
	}
	
	public R getRight() {
		return right;
	}
	
	public L getKey() {
		return left;
	}
	
	public R getValue() {
		return right;
	}

}
