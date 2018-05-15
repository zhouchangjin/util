package com.gamewolf.util.crytography;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class EncoderUtil {
	
	final static Base64.Encoder encoder = Base64.getEncoder();
	
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

}
