package com.gamewolf.util.crytography;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class EncoderUtil {
	
	final static Base64.Encoder encoder = Base64.getEncoder();
	final static Base64.Decoder decoder = Base64.getDecoder();
	
	public static String base64Encode(String text) {
		
		byte[] textByte;
		try {
			textByte = text.getBytes("UTF-8");
			final String encodedText = encoder.encodeToString(textByte);
			return encodedText;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static String base64Decode(String text) {
		byte[] textByte;
		try {
			textByte = text.getBytes("UTF-8");
			final String decodetext = new String(decoder.decode(textByte));
			return decodetext;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	public static String MD5(String str){
		 byte [] buf = str.getBytes();
	        MessageDigest md5;
			try {
				md5 = MessageDigest.getInstance("MD5");
				 md5.update(buf);
			        byte [] tmp = md5.digest();
			        StringBuilder sb = new StringBuilder();
			        for (byte b:tmp) {
			        	String s=Integer.toHexString(b&0xff);
			        	if(s.length()==1){
			        		s="0"+s;
			        	}
			            sb.append(s);
			        }
			        return sb.toString();
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "";

	}
	
	public static String MD5(String str,int length){
		return MD5(str).substring(0, length);
	}
	
	public static String MD5(String str,int length,boolean isUppercase) {
		if(isUppercase) {
			return MD5(str).substring(0, length).toUpperCase();
		}else {
			return MD5(str).substring(0, length).toLowerCase();
		}
		
	}
	
	public static void main(String args[]) {
		System.out.print(EncoderUtil.MD5("你好",24));
	}

}
