package com.gamewolf.util.file;

import java.util.ArrayList;

import org.junit.Test;

import javafx.util.Pair;

public class TestFileUtil {
	
	@Test
	public void testListDirectory() {
		
		ArrayList<Pair<String,String>> list=FileUtil.scanFolder("c:/roms/nesroms","nes");
		for(Pair<String,String> pair:list) {
			String key=pair.getKey();
			String value=pair.getValue();
			System.out.println(key+"--"+value);
		}
		
	}

}
