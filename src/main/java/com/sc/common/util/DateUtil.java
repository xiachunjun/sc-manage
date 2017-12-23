package com.sc.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	
	public static String date2Str(Date date){
		return new SimpleDateFormat("yyyy/MM/dd").format(date);
	}

	public static Date str2Date(String strDate){
		Date d= null;
		try {
			d = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}

//	public static void main(String[] args) {
//		System.out.println(date2Str(str2Date("2017-01-01")));
//	}
}
