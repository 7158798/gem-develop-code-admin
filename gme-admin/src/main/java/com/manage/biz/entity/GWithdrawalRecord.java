package com.manage.biz.entity;
import java.io.Serializable;
/**
 *	表名：g_withdrawal_record
 *  注释:钱包提现记录表（g_withdrawal_record）
功能描述：存储钱包提现记录信息。

 */
 
public class GWithdrawalRecord implements Serializable{
	private static final long serialVersionUID = 1L;
	/**编号*/	
	private java.lang.String id;
	/**提现单号*/	
	private java.lang.String withdrawalId;
	/**用户编号*/	
	private java.lang.String uid;
	/**币种编号*/	
	private java.lang.String currencyId;
	/**提现申请数量*/	
	private String requestAmount;
	/**到账实际数量*/	
	private String realAmount;
	/**手续费*/	
	private String serviceCharge;
	/**提现状态1-申请;2-处理中;3-已处理;4-已拒绝;5-撤销;*/	
	private java.lang.Integer status;
	/**钱包地址*/	
	private java.lang.String walletAddress;
	/**处理时间*/	
	private java.sql.Timestamp handleTime;
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
	public java.lang.String getWithdrawalId() {
		return withdrawalId;
	}
	public void setWithdrawalId(java.lang.String withdrawalId) {
		this.withdrawalId = withdrawalId;
	}
	public java.lang.String getUid() {
		return uid;
	}
	public void setUid(java.lang.String uid) {
		this.uid = uid;
	}
	public java.lang.String getCurrencyId() {
		return currencyId;
	}
	public void setCurrencyId(java.lang.String currencyId) {
		this.currencyId = currencyId;
	}
	
	public String getRequestAmount() {
		return requestAmount;
	}
	public void setRequestAmount(String requestAmount) {
		this.requestAmount = requestAmount;
	}
	
	public String getRealAmount() {
		return realAmount;
	}
	public void setRealAmount(String realAmount) {
		this.realAmount = realAmount;
	}
	
	public String getServiceCharge() {
		return serviceCharge;
	}
	public void setServiceCharge(String serviceCharge) {
		this.serviceCharge = serviceCharge;
	}
	public java.lang.Integer getStatus() {
		return status;
	}
	public void setStatus(java.lang.Integer status) {
		this.status = status;
	}
	public java.lang.String getWalletAddress() {
		return walletAddress;
	}
	public void setWalletAddress(java.lang.String walletAddress) {
		this.walletAddress = walletAddress;
	}
	public java.sql.Timestamp getHandleTime() {
		return handleTime;
	}
	public void setHandleTime(java.sql.Timestamp handleTime) {
		this.handleTime = handleTime;
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
