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
	
	public static Date str2Date2(String strDate){
		Date d= null;
		try {
			d = new SimpleDateFormat("yyyy-MM").parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}
	
	public static String date2Str2(Date date){
		return new SimpleDateFormat("yyyy-MM-dd").format(date);
	}
	
	/**生成一连串字符串*/
	public static String generateStr(Date date){
		return new SimpleDateFormat("yyyyMMddhhmmssSSSS").format(date);
	}
	
}
