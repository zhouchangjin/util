package com.gamewolf.util.webserver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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
		String line=null;
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss Z",Locale.ENGLISH);
		try {
			BufferedReader br=new BufferedReader(new FileReader(f));
			while((line=br.readLine())!=null) {
				
				String parts[]=line.split(" ");
				int length=parts.length;
				int bytesCnt=-1;
				ApacheLog log=new ApacheLog();
				
				
				String ip=parts[0];
				String datePart1=parts[3].replace("[", "");
				String datePart2=parts[4].replace("]", "");
				String methodStr=parts[5].replace("\"", "");
				String dateStr=datePart1+" "+datePart2;
				Date time=sdf.parse(dateStr);
				if(methodStr.equals("-")) {
					String code=parts[6];
					log.setIpAddress(ip);
					log.setResponceCode(code);
					log.setTime(time);
					list.add(log);
					continue;
				
				}
				String urlStr=parts[6];
				String fullUrl="http://"+domainName+""+urlStr;
				String httpVersion=parts[7].replace("\"", "");
				String statusCode=parts[8];
				
				if(parts[9].equals("-")) {
					bytesCnt=0;
				}else {
					bytesCnt=Integer.parseInt(parts[9]);
				}
				
				log.setIpAddress(ip);
				log.setTime(time);
				log.setMethod(methodStr);
				log.setResource(urlStr);
				log.setFullUrl(fullUrl);
				log.setResponceCode(statusCode);
				log.setBytesCount(bytesCnt);
				log.setDomainName(domainName);
				log.setHttpVersion(httpVersion);
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
		} catch (NumberFormatException e) {
			System.out.println(line);
			e.printStackTrace();
		}
		return list;
		
	}
	/**
	 * Output LogFile to csv format
	 * @param file
	 */
	public static void output(String inputFilefile,String outPutFile,String domainName ) {
		List<ApacheLog> logs=readApacheLog(inputFilefile, domainName);
		outputApacheLog(outPutFile, logs);
	}
	
	public static void outputApacheLog(String outputFile,List<ApacheLog> list) {
		try {
			BufferedWriter bw=new BufferedWriter(new FileWriter(new File(outputFile)));
			for(ApacheLog log:list) {
				SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
				String line=log.getIpAddress()+","+sdf.format(log.getTime())+","+log.getMethod()+","+log.getFullUrl()+","+log.getResource()+","+log.getDomainName()+","+log.getHttpVersion()+","+log.getResponceCode()+","+log.getBytesCount()+","+log.getRefer()+","+log.getBrowser();
				bw.write(line);
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	public static void main(String args[]) {
		output("c:/2018_03_12_51meiyu.cn-access.log","c:/log12.csv","www.51meiyu.cn");
		
	}

}
