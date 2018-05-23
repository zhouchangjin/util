package com.gamewolf.util.crytography;

import java.io.UnsupportedEncodingException;
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
	
	public static void main(String args[]) {
		System.out.print(EncoderUtil.base64Decode("NzU1NjgwMzAwMjk1NA=="));
	}

}
