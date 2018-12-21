package com.common.util;

public enum ResultFlagConstants {
	
	RESULT_SUCCESS("success", "0000"),
	RESULT_ERROR("fail", "9999");
	
	ResultFlagConstants(String msg, String code){
		this.msg = msg;
		this.code = code;
	}
	private String msg;
	private String code;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
}
