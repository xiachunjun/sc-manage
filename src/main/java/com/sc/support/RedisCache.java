package com.sc.support;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;

@Component
public class RedisCache {
	private static final Logger logger = LoggerFactory.getLogger(RedisCache.class);

	@Autowired
	private RedisTemplate<Object, Object> redisTemplate;

	/**
	 * @param key
	 * @param value
	 * @param seconds
	 */
	public void setStrWithExpiry(String key, String value, int seconds) {
		if (StringUtils.isBlank(key)) {
			logger.error("RedisCache.setWithExpiry==key为空！");
			return;
		}
		try {
			redisTemplate.opsForValue().set(key, value, seconds, TimeUnit.SECONDS);
		} catch (Exception e) {
			logger.error("RedisCache.setWithExpiry===", e);
			throw e;
		}
	}

	/**
	 * @param key
	 * @param value
	 * @param seconds
	 */
	public void setObjWithExpiry(String key, Object value, int seconds) {
		setStrWithExpiry(key, JSONObject.toJSONString(value), seconds);
	}

	/**
	 * @param key
	 * @return
	 */
	public String getStr(String key) {
		String res = null;
		if (StringUtils.isEmpty(key)) {
			return res;
		}
		Object val = redisTemplate.opsForValue().get(key);
		if (null != val) {
			res = String.valueOf(val);
		}
		return res;
	}

	public <T> T getObject(String key, Class<T> clazz) {
		String resultJson = getStr(key);
		try {
			if (!StringUtils.isEmpty(resultJson) && null != clazz) {
				T t = JSONObject.parseObject(resultJson, clazz);
				return t;
			}
		} catch (Exception e) {
			logger.error("RedisCache.getObject===key=" + key);
			logger.error("RedisCache.getObject===", e);
		}
		return null;
	}

	/**
	 * 设置值，无失效日期
	 * 
	 * @param key
	 * @param value
	 */
	public void setStr(String key, String value) {
		if (StringUtils.isEmpty(key)) {
			logger.error("MerchantRedisCache.setStr==key为空！");
			return;
		}
		try {
			redisTemplate.opsForValue().set(key, value);
		} catch (Exception e) {
			logger.error("MerchantRedisCache.setStr===", e);
			throw e;
		}
	}

	/**
	 * @param key
	 * @param value：
	 *            Integer类型
	 * @param milliseconds：
	 *            毫秒值
	 */
	public void setIntWithExpiry(String key, Integer value, long milliseconds) {
		if (StringUtils.isBlank(key)) {
			logger.error("RedisCache.setIntWithExpiry==key为空！");
			return;
		}
		try {
			redisTemplate.opsForValue().set(key, value, milliseconds, TimeUnit.MILLISECONDS);
		} catch (Exception e) {
			logger.error("RedisCache.setIntWithExpiry===", e);
			return;
		}
	}

	/**
	 * 递增
	 * 
	 * @param redisKey
	 * @param byNum
	 *            按byNum数递增
	 * @return
	 */
	public Long incr(String redisKey, Integer byNum) {
		Long count = 0L;
		try {
			count = this.redisTemplate.opsForValue().increment(redisKey, byNum);
		} catch (Exception e) {
			logger.error("RedisCache.incr===", e);
		}
		return count;
	}

	/**
	 * 删除key
	 * 
	 * @param redisKey
	 */
	public void delete(String redisKey) {
		try {
			this.redisTemplate.opsForValue().getOperations().delete(redisKey);
		} catch (Exception e) {
			logger.error("RedisCache.del===", e);
			throw e;
		}
	}

	/**
	 * @param key
	 * @param value
	 */
	public void setObj(String key, Object value) {
		if (StringUtils.isBlank(key)) {
			logger.error("RedisCache.setObj==key为空！");
			return;
		}
		try {
			redisTemplate.opsForValue().set(key, value);
		} catch (Exception e) {
			logger.error("RedisCache.setObj===", e);
			throw e;
		}
	}

	/**
	 * 获取剩余的有效时间
	 * 
	 * @param key
	 * @return
	 */
	public Long getExpireByKey(String key) {
		if (StringUtils.isBlank(key)) {
			logger.error("RedisCache.getExpireByKey==key为空！");
			return null;
		}
		try {
			return redisTemplate.opsForValue().getOperations().getExpire(key);
		} catch (Exception e) {
			logger.error("RedisCache.getExpireByKey===", e);
			throw e;
		}
	}

	/**
	 * 给key设置过期时间
	 * 
	 * @param key
	 * @param time
	 * @return
	 */
	public boolean expire(String key, Integer time) {
		if (StringUtils.isBlank(key)) {
			logger.error("RedisCache.expire==key为空！");
			return false;
		}
		try {
			return redisTemplate.opsForValue().getOperations().expire(key, time, TimeUnit.SECONDS);
		} catch (Exception e) {
			logger.error("RedisCache.expire===", e);
			throw e;
		}
	}

	/**
	 * 批量删除
	 * 
	 * @param keyList
	 * @return
	 */
	public boolean listDel(final List<String> keyList) {
		try {
			boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
				public Boolean doInRedis(RedisConnection connection) {
					for (String key : keyList) {
						connection.del(key.getBytes());
					}
					return true;
				}
			}, false, true);
			return result;
		} catch (Exception e) {
			logger.error("RedisCache.listDel===", e);
			throw e;
		}
	}

}
