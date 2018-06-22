package com.manage.util;

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
     * 其他内容
     */
	private Object data;
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
}