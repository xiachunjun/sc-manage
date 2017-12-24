package com.sc.common.constant;

public class ScException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	private String errCode;
	private String errMsg;

	public ScException() {
		super();
	}

	public ScException(String message, Throwable cause) {
		super(message, cause);
		this.errCode = "操作失败";
		this.errMsg = message;
	}

	public ScException(String message) {
		super(message);
		this.errCode = "操作失败";
		this.errMsg = message;
	}

	public ScException(Throwable cause) {
		super(cause);
	}

	public ScException(String errCode, String errMsg) {
		super(errCode + ":" + errMsg);
		this.errCode = errCode;
		this.errMsg = errMsg;
	}
	

	public ScException(String errCode, String errMsg, Throwable cause) {
		super(errCode + ":" + errMsg, cause);
		this.errCode = errCode;
		this.errMsg = errMsg;
	}

	public ScException(String errCode, String errMsg, String logMsg) {
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
