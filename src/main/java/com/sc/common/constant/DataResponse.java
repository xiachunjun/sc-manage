package com.sc.common.constant;

import java.util.HashMap;
import java.util.Map;

public class DataResponse {

	private String resultCode;

	private String resultMessage;

	Map<String, Object> dataMap = null;

	public DataResponse() {
		
	}

	public DataResponse(ResponseEnum responseEnum) {
		this.resultCode = responseEnum.getCode();
		this.resultMessage = responseEnum.getMsg();
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	public void put(String key, Object value) {
		if (null == this.dataMap) {
			this.dataMap = new HashMap<String, Object>();
		}
		this.dataMap.put(key, value);
	}

	public Object get(String key) {
		if (null == this.dataMap) {
			this.dataMap = new HashMap<String, Object>();
		}
		return this.dataMap.get(key);
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	
}
