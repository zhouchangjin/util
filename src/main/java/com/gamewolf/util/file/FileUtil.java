package com.gamewolf.util.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javafx.util.Pair;

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
	
	public static ArrayList<String> listSubFolders(String path){

		ArrayList<String> resFolders=new ArrayList<String>();
		File f=new File(path);
		if(f.isDirectory()) {
			File[] files=f.listFiles();
			for(File file:files) {
				if(file.isDirectory()) {
					String folderName=file.getName();
					resFolders.add(folderName);
				}
			}
		}
		return resFolders;
	}
	
	public static ArrayList<String> listFolders(String path,String suffix){
		
		ArrayList<String> rfiles=new ArrayList<String>();
		File f=new File(path);
		if(f.isDirectory()) {
			File[] files=f.listFiles();
			for(File file:files) {
				if(file.isFile()) {
					String fileName=file.getName();
					String parts[]=fileName.split("\\.");
					if(parts.length==2) {
						if(parts[1].equals(suffix)){
							rfiles.add(parts[0]);
						}
					}
				}
			}
		}
		return rfiles;
		
	}
	
	/**
	 * 
	 * @param parent 搜索目录
	 * @param suffix 搜索后缀
	 * @param relativePath 默认是"/"
	 * @return
	 */
	private static void scanFolder(String parent,String suffix,String relativePath,ArrayList<Pair<String,String>> result){
		
		String path=parent+relativePath;		
		ArrayList<String> subFolders=listSubFolders(path);
		ArrayList<String> files=listFolders(path, suffix);
		if(subFolders.size()>0) {
			for(String folderName:subFolders) {
				String newRelativePath=relativePath+folderName+"/";
				scanFolder(parent, suffix,newRelativePath,result);
			}
		}
		for(String fileName:files) {
			
			Pair<String,String> pair=new Pair<String, String>(relativePath, fileName);
			result.add(pair);
		}
	}
	
	public static ArrayList<Pair<String,String>> scanFolder(String folder,String suffix) {
		ArrayList<Pair<String, String>> list=new ArrayList<Pair<String,String>>();
		scanFolder(folder, suffix,"/",list);
		return list;
	}
}
