package com.sc.common.util;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

public class UuidUtil {

	public static String getUUID(){
		return StringUtils.replaceAll(UUID.randomUUID().toString(), "-", "");
	}

}
