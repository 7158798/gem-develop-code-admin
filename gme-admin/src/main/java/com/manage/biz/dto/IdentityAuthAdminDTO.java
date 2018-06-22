package com.manage.biz.dto;

import java.io.Serializable;
import java.util.Date;

/**   
 * @Project：gme-admin   
 * @Class：IdentityAuthAdminDTO   
 * @Description    
 * @Author：zhou   
 * @Date：2018年6月22日 下午9:34:03   
 * @version V1.0    
 */
public class IdentityAuthAdminDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	
	/**
	 * 认证编号
	 */
	private String id;// authId

	/**
	 * 用户编号
	 */
	private String uid;

	/**
	 * 真实姓名
	 */
	private String realName;

	/**
	 * 证件类型:1-身份证;2-护照;3-军官证;4-台湾居民通行证;5-港澳居民通行证;
	 */
	private Integer certificateType;

	/**
	 * 证件号码
	 */
	private String certificateNumber;

	/**
	 * 是否是认证商家true/false
	 */
	private Integer isAuthSupplier;

	/**
	 * 证件背面图片编号
	 */
	private String reverseImgId;

	/**
	 * 证件证面图片编号
	 */
	private String frontImgId;

	/**
	 * 手持证件图片编号
	 */
	private String inHandImgId;

	/**
	 * 认证状态:1-未认证;2-认证中;3-已通过认证;4-未通过认证;
	 */
	private Integer authStatus;

	/**
	 * 反馈
	 */
	private String feedback;

	/**
	 * 记录状态0-正常;1-异常;
	 */
	private Integer status;

	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 创建时间格式:yyyy-MM-dd HH:ss:mm
	 */
	private Date createTime;

	/**
	 * 更新时间格式:yyyy-MM-dd HH:ss:mm
	 */
	private Date updatedTime;
	
	
	private String reverseImgPreview;
	private String reverseImgUrl;
	private String frontImgPreview;
	private String frontImgUrl;
	private String inHandImgPreview;
	private String inHandImgUrl;

	public String getReverseImgPreview() {
		return reverseImgPreview;
	}

	public void setReverseImgPreview(String reverseImgPreview) {
		this.reverseImgPreview = reverseImgPreview;
	}

	public String getReverseImgUrl() {
		return reverseImgUrl;
	}

	public void setReverseImgUrl(String reverseImgUrl) {
		this.reverseImgUrl = reverseImgUrl;
	}

	public String getFrontImgPreview() {
		return frontImgPreview;
	}

	public void setFrontImgPreview(String frontImgPreview) {
		this.frontImgPreview = frontImgPreview;
	}

	public String getFrontImgUrl() {
		return frontImgUrl;
	}

	public void setFrontImgUrl(String frontImgUrl) {
		this.frontImgUrl = frontImgUrl;
	}

	public String getInHandImgPreview() {
		return inHandImgPreview;
	}

	public void setInHandImgPreview(String inHandImgPreview) {
		this.inHandImgPreview = inHandImgPreview;
	}

	public String getInHandImgUrl() {
		return inHandImgUrl;
	}

	public void setInHandImgUrl(String inHandImgUrl) {
		this.inHandImgUrl = inHandImgUrl;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Integer getCertificateType() {
		return certificateType;
	}

	public void setCertificateType(Integer certificateType) {
		this.certificateType = certificateType;
	}

	public String getCertificateNumber() {
		return certificateNumber;
	}

	public void setCertificateNumber(String certificateNumber) {
		this.certificateNumber = certificateNumber;
	}

	public Integer getIsAuthSupplier() {
		return isAuthSupplier;
	}

	public void setIsAuthSupplier(Integer isAuthSupplier) {
		this.isAuthSupplier = isAuthSupplier;
	}

	public String getReverseImgId() {
		return reverseImgId;
	}

	public void setReverseImgId(String reverseImgId) {
		this.reverseImgId = reverseImgId;
	}

	public String getFrontImgId() {
		return frontImgId;
	}

	public void setFrontImgId(String frontImgId) {
		this.frontImgId = frontImgId;
	}

	public String getInHandImgId() {
		return inHandImgId;
	}

	public void setInHandImgId(String inHandImgId) {
		this.inHandImgId = inHandImgId;
	}

	public Integer getAuthStatus() {
		return authStatus;
	}

	public void setAuthStatus(Integer authStatus) {
		this.authStatus = authStatus;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}


}
