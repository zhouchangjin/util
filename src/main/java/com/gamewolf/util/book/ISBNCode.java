package com.gamewolf.util.book;

public class ISBNCode {
	
	public static Integer check(String code) {
		Integer result=0;
		char[] codes=code.toCharArray();
		int total=0;
		
		for(int i=0;i<codes.length;i++) {
			if(i%2==0) {
				int num=Integer.parseInt(new String(""+codes[i]));
				//System.out.println(num);
				total+=num;
				
			}else {
				int num=Integer.parseInt(new String(""+codes[i]));
				total+=num*3;
			}
			
		}
		result=10-total%10;
		if(result==10) {
			result=0;
		}
		return result;
	}
	
	public static boolean IsbnValidation(String isbn) {
		if(isbn.matches("(978|979)[0-9]{10}")) {
			String code12=isbn.substring(0, 12);
			int last=check(code12);				
			String code13=code12+last;
			if(!code13.equals(isbn)) {
				return false;
			}else {
				return true;
			}
		}else {
			return false;
		}
	}
	
	public static boolean isChinese(String isbn) {
		if(isbn.startsWith("9787")) {
			return true;
		}else {
			return false;
		}
	}
	
	
	public static void main(String args[]) {
		System.out.println(check("978780746001"));
		System.out.println(IsbnValidation("A797805689905"));
	}

}
