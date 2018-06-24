package com.manage.biz.entity;
import java.io.Serializable;
/**
 *	表名：g_message_state
 *  注释:短信邮件发送状态表（g_message_state）
功能描述：存储短信邮件发送状态信息。

 */
 
public class MessageState implements Serializable{
	private static final long serialVersionUID = 1L;
	/**编号*/	
	private java.lang.String id;
	/**业务类型*/	
	private java.lang.Integer type;
	/**国家代码*/	
	private java.lang.String countryCode;
	/**接收账号*/	
	private java.lang.String receiver;
	/**发送状态*/	
	private java.lang.String status;
	/**异常描述*/	
	private java.lang.String errorReason;
	/**业务编号*/	
	private java.lang.String bizId;
	/**业务概述*/	
	private java.lang.String bizDesc;
	/**业务内容*/	
	private java.lang.String bizContent;
	/**用户编号*/	
	private java.lang.String uid;
	/**IP*/	
	private java.lang.String clientIp;
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
	public java.lang.Integer getType() {
		return type;
	}
	public void setType(java.lang.Integer type) {
		this.type = type;
	}
	public java.lang.String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(java.lang.String countryCode) {
		this.countryCode = countryCode;
	}
	public java.lang.String getReceiver() {
		return receiver;
	}
	public void setReceiver(java.lang.String receiver) {
		this.receiver = receiver;
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
	public java.lang.String getBizContent() {
		return bizContent;
	}
	public void setBizContent(java.lang.String bizContent) {
		this.bizContent = bizContent;
	}
	public java.lang.String getUid() {
		return uid;
	}
	public void setUid(java.lang.String uid) {
		this.uid = uid;
	}
	public java.lang.String getClientIp() {
		return clientIp;
	}
	public void setClientIp(java.lang.String clientIp) {
		this.clientIp = clientIp;
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
