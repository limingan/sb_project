package com.common.util;

public enum ResultFlagConstants {
	
	RESULT_SUCCESS("操作成功！", "0000"),
	RESULT_ERROR("系统异常，请稍后重试！", "9999"),
	RESULT_PARAM_IS_NULL("参数不能为空！", "8888");
	
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
