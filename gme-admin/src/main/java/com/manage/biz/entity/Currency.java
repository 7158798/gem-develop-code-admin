package com.manage.biz.entity;
import java.io.Serializable;
/**
 *	表名：g_currency
 *  注释:币种表（g_currency）
功能描述：存储币种信息。
 */
 
public class Currency implements Serializable{
	
	private static final long serialVersionUID = 1L;
	/**币种编号*/	
	private java.lang.String currencyId;
	/**顺序号，递增*/	
	private java.lang.Integer currencySn;
	/**币种符号*/	
	private java.lang.String currencySymbol;
	/**币种描述*/	
	private java.lang.String currencyDesc;
	/**币种图标*/	
	private java.lang.String iconId;
	/**中文名*/	
	private java.lang.String nameCN;
	/**英文名*/	
	private java.lang.String nameEN;
	/**启用日期*/	
	private java.sql.Timestamp enableTime;
	/**是否是媒介币0-不是;1-是;*/	
	private java.lang.Integer isToken;
	/**操作者编号*/	
	private java.lang.String operatorUid;
	/**操作者*/	
	private java.lang.String operatorName;
	/**提现配置编号；存储币种提现配置表（g_withdrawal_config）的config_id*/	
	private java.lang.String currencyConfigId;
	/**充值/提现(0000四位)：00-前两位表示是否充值;00-后两位表示是否提现;其中01表示是;02表示否;*/	
	private java.lang.String isOpen;
	/**1-启用(默认);2-冻结;*/	
	private java.lang.Integer isEnable;
	/**发行量*/	
	private java.math.BigDecimal supply;
	/**流通总量*/	
	private java.math.BigDecimal circulation;
	/**备注*/	
	private java.lang.String remark;
	/**数据表版本,默认1*/	
	private java.lang.Integer version;
	/**创建时间格式:yyyy-MM-dd HH:ss:mm*/	
	private java.sql.Timestamp createTime;
	/**更新时间格式:yyyy-MM-dd HH:ss:mm*/	
	private java.sql.Timestamp updatedTime;
	
	/** 币种图标上传*/
	private String iconIdImg;
	
	
	public String getIconIdImg() {
		return iconIdImg;
	}
	public void setIconIdImg(String iconIdImg) {
		this.iconIdImg = iconIdImg;
	}
	public java.lang.String getCurrencyId() {
		return currencyId;
	}
	public void setCurrencyId(java.lang.String currencyId) {
		this.currencyId = currencyId;
	}
	public java.lang.Integer getCurrencySn() {
		return currencySn;
	}
	public void setCurrencySn(java.lang.Integer currencySn) {
		this.currencySn = currencySn;
	}
	public java.lang.String getCurrencySymbol() {
		return currencySymbol;
	}
	public void setCurrencySymbol(java.lang.String currencySymbol) {
		this.currencySymbol = currencySymbol;
	}
	public java.lang.String getCurrencyDesc() {
		return currencyDesc;
	}
	public void setCurrencyDesc(java.lang.String currencyDesc) {
		this.currencyDesc = currencyDesc;
	}
	public java.lang.String getIconId() {
		return iconId;
	}
	public void setIconId(java.lang.String iconId) {
		this.iconId = iconId;
	}
	public java.lang.String getNameCN() {
		return nameCN;
	}
	public void setNameCN(java.lang.String nameCN) {
		this.nameCN = nameCN;
	}
	public java.lang.String getNameEN() {
		return nameEN;
	}
	public void setNameEN(java.lang.String nameEN) {
		this.nameEN = nameEN;
	}
	public java.sql.Timestamp getEnableTime() {
		return enableTime;
	}
	public void setEnableTime(java.sql.Timestamp enableTime) {
		this.enableTime = enableTime;
	}
	public java.lang.Integer getIsToken() {
		return isToken;
	}
	public void setIsToken(java.lang.Integer isToken) {
		this.isToken = isToken;
	}
	public java.lang.String getOperatorUid() {
		return operatorUid;
	}
	public void setOperatorUid(java.lang.String operatorUid) {
		this.operatorUid = operatorUid;
	}
	public java.lang.String getOperatorName() {
		return operatorName;
	}
	public void setOperatorName(java.lang.String operatorName) {
		this.operatorName = operatorName;
	}
	public java.lang.String getCurrencyConfigId() {
		return currencyConfigId;
	}
	public void setCurrencyConfigId(java.lang.String currencyConfigId) {
		this.currencyConfigId = currencyConfigId;
	}
	public java.lang.String getIsOpen() {
		return isOpen;
	}
	public void setIsOpen(java.lang.String isOpen) {
		this.isOpen = isOpen;
	}
	public java.lang.Integer getIsEnable() {
		return isEnable;
	}
	public void setIsEnable(java.lang.Integer isEnable) {
		this.isEnable = isEnable;
	}
	public java.math.BigDecimal getSupply() {
		return supply;
	}
	public void setSupply(java.math.BigDecimal supply) {
		this.supply = supply;
	}
	public java.math.BigDecimal getCirculation() {
		return circulation;
	}
	public void setCirculation(java.math.BigDecimal circulation) {
		this.circulation = circulation;
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
