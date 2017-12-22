package com.sc.common.constant;

public enum ResponseEnum {

	RESPONSE_SUCCESS("00000", "处理成功"),
	RESPONSE_FAIL("10000", "处理失败"),
	RESPONSE_ERROR_SYSTEM("10001", "对不起，系统繁忙!"),
	RESPONSE_ERROR_PARAM("10002", "输入参数有误"),
	/**以下定义具体业务异常*/
	
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
