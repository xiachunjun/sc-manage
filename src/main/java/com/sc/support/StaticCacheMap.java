package com.sc.support;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StaticCacheMap {
	private static Map<String, Object> CACHE_MAP = new ConcurrentHashMap<String, Object>();

	public static void put(String key, Object value) {
		CACHE_MAP.put(key, value);
	}

	public static Object get(String key) {
		return CACHE_MAP.get(key);
	}

	public static Object remove(String key) {
		return CACHE_MAP.remove(key);
	}
}
