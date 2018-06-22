package com.manage.biz.entity;
import java.io.Serializable;
/**
 *	表名：g_account
 *  注释:账户表（g_account）
功能描述：存储用户账户信息。
 */
 
public class Account implements Serializable{
	private static final long serialVersionUID = 1L;
	/**用户编号*/	
	private java.lang.String uid;
	/**账号ID；用户账号ID，全局唯一*/	
	private java.lang.Integer accountId;
	/**真实姓名*/	
	private java.lang.String realName;
	/**银行卡类型；1-借记卡;2-信用卡;*/	
	private java.lang.Integer cardType;
	/**银行卡号*/	
	private java.lang.String cardNumber;
	/**开户银行*/	
	private java.lang.String bankName;
	/**开户支行*/	
	private java.lang.String bankBranchName;
	/**支付宝二维码图片编号*/	
	private java.lang.String alipayQrcodeId;
	/**支付宝账号*/	
	private java.lang.String alipayAccount;
	/**支付宝绑定描述*/	
	private java.lang.String alipayDesc;
	/**微信钱包二维码图片编号*/	
	private java.lang.String wxQrcodeId;
	/**微信账号*/	
	private java.lang.String wxAccount;
	/**微信绑定描述*/	
	private java.lang.String wxDesc;
	/**转账账号1-未审核;2-通过审核;*/	
	private java.lang.Integer auditStatus;
	/**账户状态1-正常;2-冻结;*/	
	private java.lang.Integer accountStatus;
	/**token生成规则：MD5(key+uid+account_id+card_number+alipay_qrcode_id+alipay_account+wx_qrcode_id+wx_account+audit_status); 程序操作记录行均需要生成token与该字段进行验证*/	
	private java.lang.String token;
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
	public java.lang.Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(java.lang.Integer accountId) {
		this.accountId = accountId;
	}
	public java.lang.String getRealName() {
		return realName;
	}
	public void setRealName(java.lang.String realName) {
		this.realName = realName;
	}
	public java.lang.Integer getCardType() {
		return cardType;
	}
	public void setCardType(java.lang.Integer cardType) {
		this.cardType = cardType;
	}
	public java.lang.String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(java.lang.String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public java.lang.String getBankName() {
		return bankName;
	}
	public void setBankName(java.lang.String bankName) {
		this.bankName = bankName;
	}
	public java.lang.String getBankBranchName() {
		return bankBranchName;
	}
	public void setBankBranchName(java.lang.String bankBranchName) {
		this.bankBranchName = bankBranchName;
	}
	public java.lang.String getAlipayQrcodeId() {
		return alipayQrcodeId;
	}
	public void setAlipayQrcodeId(java.lang.String alipayQrcodeId) {
		this.alipayQrcodeId = alipayQrcodeId;
	}
	public java.lang.String getAlipayAccount() {
		return alipayAccount;
	}
	public void setAlipayAccount(java.lang.String alipayAccount) {
		this.alipayAccount = alipayAccount;
	}
	public java.lang.String getAlipayDesc() {
		return alipayDesc;
	}
	public void setAlipayDesc(java.lang.String alipayDesc) {
		this.alipayDesc = alipayDesc;
	}
	public java.lang.String getWxQrcodeId() {
		return wxQrcodeId;
	}
	public void setWxQrcodeId(java.lang.String wxQrcodeId) {
		this.wxQrcodeId = wxQrcodeId;
	}
	public java.lang.String getWxAccount() {
		return wxAccount;
	}
	public void setWxAccount(java.lang.String wxAccount) {
		this.wxAccount = wxAccount;
	}
	public java.lang.String getWxDesc() {
		return wxDesc;
	}
	public void setWxDesc(java.lang.String wxDesc) {
		this.wxDesc = wxDesc;
	}
	public java.lang.Integer getAuditStatus() {
		return auditStatus;
	}
	public void setAuditStatus(java.lang.Integer auditStatus) {
		this.auditStatus = auditStatus;
	}
	public java.lang.Integer getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(java.lang.Integer accountStatus) {
		this.accountStatus = accountStatus;
	}
	public java.lang.String getToken() {
		return token;
	}
	public void setToken(java.lang.String token) {
		this.token = token;
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
