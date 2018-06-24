package com.manage.biz.entity;
import java.io.Serializable;
/**
 *	表名：g_supplier_info
 *  注释:商家信息表（g_supplier_info）
功能描述：存储商家统计数据信息。
 */
 
public class SupplierInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	/***/	
	private java.lang.String uid;
	/**商家名称*/	
	private java.lang.String supplierName;
	/**是否认证；1-是;2-否*/	
	private java.lang.Integer isAuth;
	/**币种类型*/	
	private java.lang.String currencyId;
	/**币种符号*/	
	private java.lang.String currencySymbol;
	/**订单总数*/	
	private java.lang.Integer totalNumber;
	/**总成交数*/	
	private java.lang.Integer totalDealNumber;
	/**取消次数；每天最多取消三次，超过次数禁止OTC交易（系统撤销订单除外）*/	
	private java.lang.Integer cancelTime;
	/**被投诉次数；投诉5次或以上，禁止OTC交易*/	
	private java.lang.Integer complainedNumber;
	/**保证金*/	
	private java.math.BigDecimal deposit;
	/**被冻结的保证金*/	
	private java.math.BigDecimal frozenDeposit;
	/**商家状态；1-正常;2-冻结;*/	
	private java.lang.Integer supplierStatus;
	/**token生成规则：MD5(key+uid+is_auth+total_number+total_deal_number+cancel_time+complained_number+deposit+frozen_deposit); 程序操作记录行均需要生成token与该字段进行验证*/	
	private java.lang.String token;
	/**备注*/	
	private java.lang.String remark;
	/**数据表版本,默认1*/	
	private java.lang.Integer version;
	/**创建时间格式:yyyy-MM-dd HH:ss:mm*/	
	private java.sql.Timestamp createTime;
	/**更新时间格式:yyyy-MM-dd HH:ss:mm*/	
	private java.sql.Timestamp updatedTime;
	
	/**
	 * 是否是媒介币 0不是 1是
	 */
	private Integer isToken;

	public java.lang.String getUid() {
		return uid;
	}

	public void setUid(java.lang.String uid) {
		this.uid = uid;
	}

	public java.lang.String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(java.lang.String supplierName) {
		this.supplierName = supplierName;
	}

	public java.lang.Integer getIsAuth() {
		return isAuth;
	}

	public void setIsAuth(java.lang.Integer isAuth) {
		this.isAuth = isAuth;
	}

	public java.lang.String getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(java.lang.String currencyId) {
		this.currencyId = currencyId;
	}

	public java.lang.String getCurrencySymbol() {
		return currencySymbol;
	}

	public void setCurrencySymbol(java.lang.String currencySymbol) {
		this.currencySymbol = currencySymbol;
	}

	public java.lang.Integer getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(java.lang.Integer totalNumber) {
		this.totalNumber = totalNumber;
	}

	public java.lang.Integer getTotalDealNumber() {
		return totalDealNumber;
	}

	public void setTotalDealNumber(java.lang.Integer totalDealNumber) {
		this.totalDealNumber = totalDealNumber;
	}

	public java.lang.Integer getCancelTime() {
		return cancelTime;
	}

	public void setCancelTime(java.lang.Integer cancelTime) {
		this.cancelTime = cancelTime;
	}

	public java.lang.Integer getComplainedNumber() {
		return complainedNumber;
	}

	public void setComplainedNumber(java.lang.Integer complainedNumber) {
		this.complainedNumber = complainedNumber;
	}

	public java.math.BigDecimal getDeposit() {
		return deposit;
	}

	public void setDeposit(java.math.BigDecimal deposit) {
		this.deposit = deposit;
	}

	public java.math.BigDecimal getFrozenDeposit() {
		return frozenDeposit;
	}

	public void setFrozenDeposit(java.math.BigDecimal frozenDeposit) {
		this.frozenDeposit = frozenDeposit;
	}

	public java.lang.Integer getSupplierStatus() {
		return supplierStatus;
	}

	public void setSupplierStatus(java.lang.Integer supplierStatus) {
		this.supplierStatus = supplierStatus;
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

	public Integer getIsToken() {
		return isToken;
	}

	public void setIsToken(Integer isToken) {
		this.isToken = isToken;
	}
}
