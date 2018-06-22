package com.manage.biz.entity;
import java.io.Serializable;
/**
 *	表名：g_identity_auth
 *  注释:身份认证表（g_identity_auth）
功能描述：存储用户身份认证信息。
 */
 
public class IdentityAuth implements Serializable{
	private static final long serialVersionUID = 1L;
	/**认证编号*/	
	private java.lang.String authId;
	/**用户编号*/	
	private java.lang.String uid;
	/**真实姓名*/	
	private java.lang.String realName;
	/**证件类型:1-身份证;2-护照;3-军官证;4-台湾居民通行证;5-港澳居民通行证;*/	
	private java.lang.Integer certificateType;
	/**证件号码*/	
	private java.lang.String certificateNumber;
	/**是否是认证商家true/false*/	
	private java.lang.Integer isAuthSupplier;
	/**证件背面图片编号*/	
	private java.lang.String reverseImgId;
	/**证件证面图片编号*/	
	private java.lang.String frontImgId;
	/**手持证件图片编号*/	
	private java.lang.String inHandImgId;
	/**认证状态:1-未认证;2-认证中;3-已通过认证;4-未通过认证;*/	
	private java.lang.Integer authStatus;
	/**反馈*/	
	private java.lang.String feedback;
	/**记录状态0-正常;1-异常;*/	
	private java.lang.Integer status;
	/**备注*/	
	private java.lang.String remark;
	/**数据表版本,默认1*/	
	private java.lang.Integer version;
	/**创建时间格式:yyyy-MM-dd HH:ss:mm*/	
	private java.sql.Timestamp createTime;
	/**更新时间格式:yyyy-MM-dd HH:ss:mm*/	
	private java.sql.Timestamp updatedTime;
	public java.lang.String getAuthId() {
		return authId;
	}
	public void setAuthId(java.lang.String authId) {
		this.authId = authId;
	}
	public java.lang.String getUid() {
		return uid;
	}
	public void setUid(java.lang.String uid) {
		this.uid = uid;
	}
	public java.lang.String getRealName() {
		return realName;
	}
	public void setRealName(java.lang.String realName) {
		this.realName = realName;
	}
	public java.lang.Integer getCertificateType() {
		return certificateType;
	}
	public void setCertificateType(java.lang.Integer certificateType) {
		this.certificateType = certificateType;
	}
	public java.lang.String getCertificateNumber() {
		return certificateNumber;
	}
	public void setCertificateNumber(java.lang.String certificateNumber) {
		this.certificateNumber = certificateNumber;
	}
	public java.lang.Integer getIsAuthSupplier() {
		return isAuthSupplier;
	}
	public void setIsAuthSupplier(java.lang.Integer isAuthSupplier) {
		this.isAuthSupplier = isAuthSupplier;
	}
	public java.lang.String getReverseImgId() {
		return reverseImgId;
	}
	public void setReverseImgId(java.lang.String reverseImgId) {
		this.reverseImgId = reverseImgId;
	}
	public java.lang.String getFrontImgId() {
		return frontImgId;
	}
	public void setFrontImgId(java.lang.String frontImgId) {
		this.frontImgId = frontImgId;
	}
	public java.lang.String getInHandImgId() {
		return inHandImgId;
	}
	public void setInHandImgId(java.lang.String inHandImgId) {
		this.inHandImgId = inHandImgId;
	}
	public java.lang.Integer getAuthStatus() {
		return authStatus;
	}
	public void setAuthStatus(java.lang.Integer authStatus) {
		this.authStatus = authStatus;
	}
	public java.lang.String getFeedback() {
		return feedback;
	}
	public void setFeedback(java.lang.String feedback) {
		this.feedback = feedback;
	}
	public java.lang.Integer getStatus() {
		return status;
	}
	public void setStatus(java.lang.Integer status) {
		this.status = status;
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
