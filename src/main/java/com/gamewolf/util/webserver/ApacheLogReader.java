package com.gamewolf.util.webserver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ApacheLogReader {
	
	public static List<ApacheLog> readApacheLog(String fileName){
		List<ApacheLog> list=new ArrayList<ApacheLog>();
		File f=new File(fileName);
		try {
			BufferedReader br=new BufferedReader(new FileReader(f));
			String line=null;
			
			while((line=br.readLine())!=null) {
				String parts[]=line.split(" ");
				int length=parts.length;
				String ip=parts[0];
				String datePart1=parts[3].replace("[", "");
				String datePart2=parts[4].replace("]", "");
				String dateStr=datePart1+" "+datePart2;
				SimpleDateFormat sdf=new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss Z",Locale.ENGLISH);
				Date time=sdf.parse(dateStr);

				if(length==7) {
					
				}else {
					
				}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	
	public static void main(String args[]) {
		System.out.println("====");
		readApacheLog("c:/log.txt");
		
	}

}
