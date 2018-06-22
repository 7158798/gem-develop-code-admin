package com.manage.biz.entity;
import java.io.Serializable;
/**
 *	表名：g_asset
 *  注释:资产表（g_asset）
功能描述：存储用户币种资产信息。
 */
 
public class Asset implements Serializable{
	private static final long serialVersionUID = 1L;
	/**资产编号*/	
	private java.lang.String assetId;
	/**用户编号*/	
	private java.lang.String uid;
	/**账号ID；用户账号ID，全局唯一*/	
	private java.lang.Integer accountId;
	/**币种*/	
	private java.lang.String currencyId;
	/**总资产*/	
	private java.math.BigDecimal totalAssets;
	/**可用资产*/	
	private java.math.BigDecimal usableAssets;
	/**冻结资产*/	
	private java.math.BigDecimal frozenAssets;
	/**0-正常;1-冻结;*/	
	private java.lang.Integer status;
	/**token生成规则：MD5(key+uid+account_id+currency_id+total_assets+*/	
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
	 * 币种符号
	 */
	private String currencySymbol;

	public java.lang.String getAssetId() {
		return assetId;
	}

	public void setAssetId(java.lang.String assetId) {
		this.assetId = assetId;
	}

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

	public java.lang.String getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(java.lang.String currencyId) {
		this.currencyId = currencyId;
	}

	public java.math.BigDecimal getTotalAssets() {
		return totalAssets;
	}

	public void setTotalAssets(java.math.BigDecimal totalAssets) {
		this.totalAssets = totalAssets;
	}

	public java.math.BigDecimal getUsableAssets() {
		return usableAssets;
	}

	public void setUsableAssets(java.math.BigDecimal usableAssets) {
		this.usableAssets = usableAssets;
	}

	public java.math.BigDecimal getFrozenAssets() {
		return frozenAssets;
	}

	public void setFrozenAssets(java.math.BigDecimal frozenAssets) {
		this.frozenAssets = frozenAssets;
	}

	public java.lang.Integer getStatus() {
		return status;
	}

	public void setStatus(java.lang.Integer status) {
		this.status = status;
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

	public String getCurrencySymbol() {
		return currencySymbol;
	}

	public void setCurrencySymbol(String currencySymbol) {
		this.currencySymbol = currencySymbol;
	}
}
