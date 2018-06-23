package com.manage.util;

import java.util.Map;

/**
 * 
 * @Project：gme-admin   
 * @Class：ResponseResult   
 * @Description gme-admin-web响应的格式    
 * @Author：zhou   
 * @Date：2018年6月22日 下午9:01:01   
 * @version V1.0
 */
public class ResponseResult {
	
	/**
     * 返回状态码
     */
	private String status;
	/**
     * 返回内容
     */
	private String message;
	/**
     * 返回内容
     */
	private Object data;
	/**
	 * 其他内容
	 */
	private Map<String, Object> ext;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public Map<String, Object> getExt() {
		return ext;
	}
	public void setExt(Map<String, Object> ext) {
		this.ext = ext;
	}
}