package com.sc.common.constant;

public enum ResponseEnum {

	RESPONSE_SUCCESS("000000", "处理成功"),
	RESPONSE_FAIL("100000", "处理失败"),
	RESPONSE_ERROR_SYSTEM("100001", "对不起，系统繁忙!"),
	RESPONSE_ERROR_PARAM("100002", "输入参数有误"),
	/**以下定义具体业务异常*/
	RESPONSE_ERROR_NULL("100001", "没有查询到该条记录"),
	;
	
	
	private final String code;

	private final String msg;

	ResponseEnum(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
	
}
