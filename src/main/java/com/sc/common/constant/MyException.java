package com.sc.common.constant;

public class MyException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	private String errCode;
	private String errMsg;

	public MyException() {
		super();
	}

	public MyException(String message, Throwable cause) {
		super(message, cause);
		this.errCode = "操作失败";
		this.errMsg = message;
	}

	public MyException(String message) {
		super(message);
		this.errCode = "操作失败";
		this.errMsg = message;
	}

	public MyException(Throwable cause) {
		super(cause);
	}

	public MyException(String errCode, String errMsg) {
		super(errCode + ":" + errMsg);
		this.errCode = errCode;
		this.errMsg = errMsg;
	}
	

	public MyException(String errCode, String errMsg, Throwable cause) {
		super(errCode + ":" + errMsg, cause);
		this.errCode = errCode;
		this.errMsg = errMsg;
	}

	public MyException(String errCode, String errMsg, String logMsg) {
		super(errCode + ":" + errMsg);
		this.errCode = errCode;
		this.errMsg = errMsg;
	}

	public String getErrCode() {
		return this.errCode;
	}

	public String getErrMsg() {
		return this.errMsg;
	}

}
