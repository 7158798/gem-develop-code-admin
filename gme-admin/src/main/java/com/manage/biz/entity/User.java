package com.manage.biz.entity;
import java.io.Serializable;
/**
 *	表名：g_user
 *  注释:用户表
功能描述：存储用户注册等相关信息
 */
 
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	/**用户编号GUID*/	
	private java.lang.String uid;
	/**用户名称*/	
	private java.lang.String name;
	/**登录密码；采用秘钥加密控制:*/	
	private java.lang.String password;
	/**国家号码；手机号前缀国家号码*/	
	private java.lang.String countryCode;
	/**用户手机；需要验证手机号格式*/	
	private java.lang.String phoneCode;
	/**用户邮箱；需要验证邮件地址格式*/	
	private java.lang.String mail;
	/**是否是商户:0-不是;1-是.默认0*/	
	private java.lang.Integer isSupplier;
	/**资金密码*/	
	private java.lang.String tradeAuth;
	/**最后登录时间*/	
	private java.sql.Timestamp lastLoginTime;
	/**是否修改过密码,true-修改过;false-未修改过;默认false*/	
	private java.lang.Integer isChangePassword;
	/**连续输错密码的次数*/	
	private java.lang.Integer passwordInputErrorCount;
	/**推广码*/	
	private java.lang.String promoCode;
	/**用户状态,用户账号状态(1/2)1-正常; 2-冻结;*/	
	private java.lang.Integer status;
	/**是否开启二次验证1-不需要;2-需要;*/	
	private java.lang.Integer isSecondVerify;
	/**备注*/	
	private java.lang.String remark;
	/**数据表版本,默认1*/	
	private java.lang.Integer version;
	/**创建时间格式:yyyy-MM-dd HH:ss:mm*/	
	private java.sql.Timestamp createTime;
	/**更新时间格式:yyyy-MM-dd HH:ss:mm*/	
	private java.sql.Timestamp updatedTime;
	public java.lang.String getUid() {
		return uid;
	}
	public void setUid(java.lang.String uid) {
		this.uid = uid;
	}
	public java.lang.String getName() {
		return name;
	}
	public void setName(java.lang.String name) {
		this.name = name;
	}
	public java.lang.String getPassword() {
		return password;
	}
	public void setPassword(java.lang.String password) {
		this.password = password;
	}
	public java.lang.String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(java.lang.String countryCode) {
		this.countryCode = countryCode;
	}
	public java.lang.String getPhoneCode() {
		return phoneCode;
	}
	public void setPhoneCode(java.lang.String phoneCode) {
		this.phoneCode = phoneCode;
	}
	public java.lang.String getMail() {
		return mail;
	}
	public void setMail(java.lang.String mail) {
		this.mail = mail;
	}
	public java.lang.Integer getIsSupplier() {
		return isSupplier;
	}
	public void setIsSupplier(java.lang.Integer isSupplier) {
		this.isSupplier = isSupplier;
	}
	public java.lang.String getTradeAuth() {
		return tradeAuth;
	}
	public void setTradeAuth(java.lang.String tradeAuth) {
		this.tradeAuth = tradeAuth;
	}
	public java.sql.Timestamp getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(java.sql.Timestamp lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public java.lang.Integer getIsChangePassword() {
		return isChangePassword;
	}
	public void setIsChangePassword(java.lang.Integer isChangePassword) {
		this.isChangePassword = isChangePassword;
	}
	public java.lang.Integer getPasswordInputErrorCount() {
		return passwordInputErrorCount;
	}
	public void setPasswordInputErrorCount(java.lang.Integer passwordInputErrorCount) {
		this.passwordInputErrorCount = passwordInputErrorCount;
	}
	public java.lang.String getPromoCode() {
		return promoCode;
	}
	public void setPromoCode(java.lang.String promoCode) {
		this.promoCode = promoCode;
	}
	public java.lang.Integer getStatus() {
		return status;
	}
	public void setStatus(java.lang.Integer status) {
		this.status = status;
	}
	public java.lang.Integer getIsSecondVerify() {
		return isSecondVerify;
	}
	public void setIsSecondVerify(java.lang.Integer isSecondVerify) {
		this.isSecondVerify = isSecondVerify;
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
