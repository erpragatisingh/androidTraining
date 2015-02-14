package com.test.java;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyTime {
	public static void main(String[] args) {
		
		String dateStart = "01/14/2012 09:29:58";
		String dateStop = "11/15/2013 10:31:48";
 
		//HH converts hour in 24 hours format (0-23), day calculation
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
 
		Date d1 =new  Date();
		Date d2 = new  Date();;
 
		try {
			//d1 = format.parse(dateStart);
			//d2 = format.parse(dateStop);
 
			//in milliseconds
			long diff = d2.getTime() - d1.getTime();
 
			long diffSeconds = diff / 1000 % 60;
			long diffMinutes = diff / (60 * 1000) % 60;
			long diffHours = diff / (60 * 60 * 1000) % 24;
			long diffDays = diff / (24 * 60 * 60 * 1000);
 
			System.out.print(diffDays + " days \n, ");
			System.out.print(diffHours + " hours \n , ");
			System.out.print(diffMinutes + " minutes\n, ");
			System.out.print(diffSeconds + " seconds.\n");
			System.out.println(d1);
 
		} catch (Exception e) {
			e.printStackTrace();
		}
 
	}
		
		
	}


