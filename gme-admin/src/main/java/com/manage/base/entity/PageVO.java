package com.manage.base.entity;

import java.io.Serializable;

public class PageVO implements Serializable{
	private static final long serialVersionUID = 1L;
	/**
	 * code: 状态
	 */
	private String code;
	/**
	 * message: 消息
	 */
	private String message;
	/**
	 * data:分页的对象
	 */
	private Object data;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
}
