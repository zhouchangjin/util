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
	
	public static List<ApacheLog> readApacheLog(String fileName,String domainName){
		List<ApacheLog> list=new ArrayList<ApacheLog>();
		File f=new File(fileName);
		try {
			BufferedReader br=new BufferedReader(new FileReader(f));
			String line=null;
			
			while((line=br.readLine())!=null) {
				String parts[]=line.split(" ");
				int length=parts.length;
				
				String datePart1=parts[3].replace("[", "");
				String datePart2=parts[4].replace("]", "");
				String dateStr=datePart1+" "+datePart2;
				SimpleDateFormat sdf=new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss Z",Locale.ENGLISH);
				
				int bytesCnt=Integer.parseInt(parts[9]);
				String statusCode=parts[8];
				String httpVersion=parts[7].replace("\"", "");
				String urlStr=parts[6];
				String ip=parts[0];
				Date time=sdf.parse(dateStr);
				String methodStr=parts[5].replace("\"", "");
				String fullUrl="http://"+domainName+""+urlStr;
				
				ApacheLog log=new ApacheLog();
				log.setIpAddress(ip);
				log.setTime(time);
				log.setMethod(methodStr);
				log.setResource(urlStr);
				log.setFullUrl(fullUrl);
				log.setResponceCode(statusCode);
				log.setBytesCount(bytesCnt);
				if(length>9) {
					String refer=parts[10].replace("\"", "");
					log.setRefer(refer);
				}
				if(length>10) {
					String browser=parts[11];
					int start=line.indexOf(browser);
					String browserStr=line.substring(start);
					log.setBrowser(browserStr);
				}
				list.add(log);
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
		readApacheLog("c:/log.txt","www.51meiyu.cn");
		
	}

}
