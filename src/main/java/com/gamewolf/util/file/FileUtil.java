package com.gamewolf.util.file;

import java.io.File;

public class FileUtil {
	
	
	public static void CreateFolder(String fileName) {
		File f=new File(fileName);
		if(!f.exists()) {
			f.mkdir();
		}
	}
	


}
