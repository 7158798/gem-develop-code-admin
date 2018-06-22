package com.manage.biz.vo;


import com.manage.base.entity.BaseVO;

/**
* 身份认证表（g_identity_auth）
功能描述：存储用户身份认证信息。查询bean
*/
public class IdentityAuthVO extends BaseVO{

	private static final long serialVersionUID = 1L;

	/**
	 * 真实姓名
	 */
	private String realName;
	/**
	 * 证件类型 1-身份证;2-护照;3-军官证;4-台湾居民通行证;5-港澳居民通行证;
	 */
	private Integer certificateType; 
	/**
	 * 是否是商家 0不是 1是
	 */
	private Integer isAuthSupplier;
	/**
	 * 认证状态 1-未认证;2-认证中;3-已通过认证;4-未通过认证;
	 */
	private Integer authStatus;
	/**
	 * 记录状态 0-正常;1-异常;
	 */
	private Integer status;
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
	public Integer getIsAuthSupplier() {
		return isAuthSupplier;
	}
	public void setIsAuthSupplier(Integer isAuthSupplier) {
		this.isAuthSupplier = isAuthSupplier;
	}
	public Integer getAuthStatus() {
		return authStatus;
	}
	public void setAuthStatus(Integer authStatus) {
		this.authStatus = authStatus;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
}
