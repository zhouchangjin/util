package com.gamewolf.util.book;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class BookExtractor {
	
	public static final String priceReg="\\D*(\\d+(\\.\\d+)?)\\D*";
	
	public static final String kaibenReg="大*(\\d+)开\\D*";
	
	public static String getPriceFromText(String text) {
		
		if(text.matches(priceReg)) {
			
			Pattern p=Pattern.compile(priceReg);
			Matcher matcher=p.matcher(text);
			if(matcher.find()) {
				String findStr=matcher.group(1);
				return findStr;
			}else {
				return "";
			}
			
		}else {
			return "";
			
		}
	}
	
	public static int getKaiben(String kaibenText) {
		if(kaibenText==null) {
			return 1005;
		}else if(kaibenText.matches(kaibenReg)) {
			Pattern p=Pattern.compile(kaibenReg);
			Matcher matcher=p.matcher(kaibenText);
			if(matcher.find()) {
				String findStr=matcher.group(1);
				int ind=Integer.parseInt(findStr);
				if(kaibenText.startsWith("大")) {
					ind++;
				}
				return ind;
			}else {
				return 1005;
			}
		}else {
			if(kaibenText.equals("A5")) {
				return 1004;
			}else if(kaibenText.equals("异形开")) {
				return 1003;
			}else if(kaibenText.equals("对开")){
				return 1001;
			}else if(kaibenText.equals("全开")){
				return 1002;
			}else if(kaibenText.equals("套装多开")){
				return 1000;
			}else if(kaibenText.equals("其他")){
				return 1005;
			}else {
				return 1005;
			}
		}
	}
	
	
	public static void main(String args[]) {
		String kaibenText="A5";
		System.out.println(getKaiben(kaibenText));
	}

}
