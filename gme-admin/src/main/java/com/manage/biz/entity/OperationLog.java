package com.manage.biz.entity;
import java.io.Serializable;
/**
 *	表名：g_operation_log
 *  注释:操作日志表（g_operation_log）
功能描述：存储用户业务操作日志信息。

 */
 
public class OperationLog implements Serializable{
	private static final long serialVersionUID = 1L;
	/**编号*/	
	private java.lang.String id;
	/**业务类型*/	
	private java.lang.Integer bizType;
	/**业务编号*/	
	private java.lang.String bizId;
	/**业务描述*/	
	private java.lang.String bizDesc;
	/**客户端IP*/	
	private java.lang.String clientIp;
	/**用户编号*/	
	private java.lang.String uid;
	/**客户端类型 pc / ios / ard*/	
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
	public java.lang.String getId() {
		return id;
	}
	public void setId(java.lang.String id) {
		this.id = id;
	}
	public java.lang.Integer getBizType() {
		return bizType;
	}
	public void setBizType(java.lang.Integer bizType) {
		this.bizType = bizType;
	}
	public java.lang.String getBizId() {
		return bizId;
	}
	public void setBizId(java.lang.String bizId) {
		this.bizId = bizId;
	}
	public java.lang.String getBizDesc() {
		return bizDesc;
	}
	public void setBizDesc(java.lang.String bizDesc) {
		this.bizDesc = bizDesc;
	}
	public java.lang.String getClientIp() {
		return clientIp;
	}
	public void setClientIp(java.lang.String clientIp) {
		this.clientIp = clientIp;
	}
	public java.lang.String getUid() {
		return uid;
	}
	public void setUid(java.lang.String uid) {
		this.uid = uid;
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
