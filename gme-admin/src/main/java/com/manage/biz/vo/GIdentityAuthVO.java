package com.manage.biz.vo;


import com.manage.base.entity.BaseVO;

/**
* 身份认证表（g_identity_auth）
功能描述：存储用户身份认证信息。查询bean
*/
public class GIdentityAuthVO extends BaseVO{

	private static final long serialVersionUID = 1L;

	/**
	 * 真实姓名
	 */
	private String real_name;
	/**
	 * 证件类型 1-身份证;2-护照;3-军官证;4-台湾居民通行证;5-港澳居民通行证;
	 */
	private Integer certificate_type; 
	/**
	 * 是否是商家 0不是 1是
	 */
	private Integer is_auth_supplier;
	/**
	 * 认证状态 1-未认证;2-认证中;3-已通过认证;4-未通过认证;
	 */
	private Integer auth_status;
	/**
	 * 记录状态 0-正常;1-异常;
	 */
	private Integer status;
	public String getReal_name() {
		return real_name;
	}
	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}
	public Integer getCertificate_type() {
		return certificate_type;
	}
	public void setCertificate_type(Integer certificate_type) {
		this.certificate_type = certificate_type;
	}
	public Integer getIs_auth_supplier() {
		return is_auth_supplier;
	}
	public void setIs_auth_supplier(Integer is_auth_supplier) {
		this.is_auth_supplier = is_auth_supplier;
	}
	public Integer getAuth_status() {
		return auth_status;
	}
	public void setAuth_status(Integer auth_status) {
		this.auth_status = auth_status;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
}
