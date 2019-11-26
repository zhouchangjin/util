package com.gamewolf.util.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileUtil {
	
	
	public static void CreateFolder(String fileName) {
		File f=new File(fileName);
		if(!f.exists()) {
			f.mkdirs();
		}
	}

	public static String readTxtFile(String filePath) {
		StringBuffer sb=new StringBuffer();
		File file=new File(filePath);
		try {
			
			
			BufferedReader br=new BufferedReader(new FileReader(file));
			String line=null;
			while((line=br.readLine())!=null) {
				
				sb.append(line);
			}
			br.close();
		} catch (FileNotFoundException e) {
			return sb.toString();
		} catch (IOException e) {
			return sb.toString();
		}
		return sb.toString();
	}
}
