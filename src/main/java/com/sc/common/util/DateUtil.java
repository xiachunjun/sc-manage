package com.sc.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	
	public static String date2Str(Date date){
		return new SimpleDateFormat("yyyy/MM/dd").format(date);
	}

	
}
