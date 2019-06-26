package com.gamewolf.util.lang;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	
	
	public static final long millisecondsPerDay=1000*60*60*24;
	
	public static int getWeekYear(Date time) {
		Calendar ca=Calendar.getInstance();
		ca.setTime(time);
		int week=ca.get(Calendar.WEEK_OF_YEAR);
		return week;
	}
	
	public static String getWeekStr(Date date){
		String[] weeks = {"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int week_index = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if(week_index<0){
		week_index = 0;
		}
		return weeks[week_index];
	}
		
	public static String toDate(Date date,String dateFormat) {
		//simple date format 线程不安全。
		SimpleDateFormat sdf=new SimpleDateFormat(dateFormat);
		return sdf.format(date);
		
	}
	
	public static String toCommonDate(Date date) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}
	
	public static String toCommonDateTime(Date date) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
	
	public static Date parseCommonDate(String dateStr) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static int dayCnt(Date dateBegin,Date dateEnd) {
		
		long start=dateBegin.getTime();
		long end=dateEnd.getTime();
		long middle=(end-start)/millisecondsPerDay;
		return (int)middle;
	}
	
	public static int minuteCnt(Date dateBegin,Date dateEnd) {
		long start=dateBegin.getTime();
		long end=dateEnd.getTime();
		long middle=(end-start)/(60000);
		return (int)middle;
	}
	
	public static String showDate(Date date) {
		String editString="刚刚";
		
		long time=date.getTime();
		long now=new Date().getTime();
		int dayUnit=24*60*60*1000;
		int hourUnit=60*60*1000;
		int days=(int) ((now-time)/dayUnit);
		if(days==0) {
			int hours=(int) ((now-time)/hourUnit);
			if(hours==0) {
				int minutes=(int) ((now-time)/60/1000);
				if(minutes==0) {
					
				}else {
					editString=minutes+"分钟前";
				}
				
			}else {
				editString=hours+"小时前";
			}
		}else {
			editString=days+"天前";
		}
		return editString;
	}

	public static Date nextMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, 1);
		return calendar.getTime();
	}

	public static Date nextSeason(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, 3);
		return calendar.getTime();
	}

	public static Date nextYear(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.YEAR, 1);
		return calendar.getTime();
	}

	public static Date nextWeek(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.WEEK_OF_YEAR, 1);
		return calendar.getTime();
	}
	
	public static Date nextDays(Date start,int dayCnt) {
		long endTime=start.getTime()+dayCnt*millisecondsPerDay;
		Date endDate=new Date(endTime);
		return endDate;
	}

	public static Date today() {
		 Calendar calendar = Calendar.getInstance();
         calendar.setTime(new Date());
         calendar.set(Calendar.HOUR_OF_DAY, 0);
         calendar.set(Calendar.MINUTE, 0);
         calendar.set(Calendar.SECOND, 0);
         Date zero = calendar.getTime();
         return zero;
	}
	
	public static Date dateStart(Date time) {
		 Calendar calendar = Calendar.getInstance();
         calendar.setTime(time);
         calendar.set(Calendar.HOUR_OF_DAY, 0);
         calendar.set(Calendar.MINUTE, 0);
         calendar.set(Calendar.SECOND, 0);
         Date zero = calendar.getTime();
         return zero;
	}
	
	public static Date yesterday() {
		Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.add(Calendar.DAY_OF_YEAR, -1);
        Date zero = calendar.getTime();
        return zero;
	}
	
	public static Date before(Date currentTime,int days) {
		Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentTime);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.add(Calendar.DAY_OF_YEAR, -1*days);
        Date zero = calendar.getTime();
        return zero;
	}
	
	
	public static int intTime(Date time) {
		int intTime= (int)(time.getTime()/1000);
		return intTime;
	}
	
	public static Date getIntTime(int time) {
		long longTime=((long)time)*1000;
		Date date=new Date(longTime);
		return date;
	}

}
