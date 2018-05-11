package com.gamewolf.util.lang;

public class IntegerParser {
	public static final String IntStrReg="^[0-9]+$";
	
	public static int parsePositiveInt(String intStr) {
		if(intStr.matches(IntStrReg)) {
			return Integer.parseInt(intStr);
		}else {
			return -1;
		}
	}
	
	
	public static boolean isPosInt(String intStr) {
		return intStr.matches(IntStrReg);
	}
	
	public static void main(String args[]) {
		System.out.println(isPosInt("2c22"));
	}

}
