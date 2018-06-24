package com.manage.biz.entity;
import java.io.Serializable;
/**
 *	表名：g_login_log
 *  注释:登录日志表（g_login_log）
功能描述：存储用户登录日志信息。

 */
 
public class LoginLog implements Serializable{
	private static final long serialVersionUID = 1L;
	/**编号*/	
	private java.lang.String logId;
	/**用户编号*/	
	private java.lang.String uid;
	/**登录账号*/	
	private java.lang.String account;
	/**IP*/	
	private java.lang.String loginIp;
	/**IP归属地址*/	
	private java.lang.String home_address;
	/**登录客户端pc / ios / ard*/	
	private java.lang.String clientType;
	/**HTTP信息	*/	
	private java.lang.String httpUserAgent;
	/**状态success  / failed.*/	
	private java.lang.String status;
	/**异常信息*/	
	private java.lang.String errorReason;
	/**备注*/	
	private java.lang.String remark;
	/**数据表版本,默认1*/	
	private java.lang.Integer version;
	/**创建时间格式:yyyy-MM-dd HH:ss:mm*/	
	private java.sql.Timestamp createTime;
	/**更新时间格式:yyyy-MM-dd HH:ss:mm*/	
	private java.sql.Timestamp updatedTime;
	public java.lang.String getLogId() {
		return logId;
	}
	public void setLogId(java.lang.String logId) {
		this.logId = logId;
	}
	public java.lang.String getUid() {
		return uid;
	}
	public void setUid(java.lang.String uid) {
		this.uid = uid;
	}
	public java.lang.String getAccount() {
		return account;
	}
	public void setAccount(java.lang.String account) {
		this.account = account;
	}
	public java.lang.String getLoginIp() {
		return loginIp;
	}
	public void setLoginIp(java.lang.String loginIp) {
		this.loginIp = loginIp;
	}
	public java.lang.String getHome_address() {
		return home_address;
	}
	public void setHome_address(java.lang.String home_address) {
		this.home_address = home_address;
	}
	public java.lang.String getClientType() {
		return clientType;
	}
	public void setClientType(java.lang.String clientType) {
		this.clientType = clientType;
	}
	public java.lang.String getHttpUserAgent() {
		return httpUserAgent;
	}
	public void setHttpUserAgent(java.lang.String httpUserAgent) {
		this.httpUserAgent = httpUserAgent;
	}
	public java.lang.String getStatus() {
		return status;
	}
	public void setStatus(java.lang.String status) {
		this.status = status;
	}
	public java.lang.String getErrorReason() {
		return errorReason;
	}
	public void setErrorReason(java.lang.String errorReason) {
		this.errorReason = errorReason;
	}
	public java.lang.String getRemark() {
		return remark;
	}
	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}
	public java.lang.Integer getVersion() {
		return version;
	}
	public void setVersion(java.lang.Integer version) {
		this.version = version;
	}
	public java.sql.Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(java.sql.Timestamp createTime) {
		this.createTime = createTime;
	}
	public java.sql.Timestamp getUpdatedTime() {
		return updatedTime;
	}
	public void setUpdatedTime(java.sql.Timestamp updatedTime) {
		this.updatedTime = updatedTime;
	}
}
