package com.manage.biz.entity;
import java.io.Serializable;
/**
 *	表名：g_currency_trade_pair
 *  注释:币种交易对表
 */
 
public class CurrencyTradePair implements Serializable{
	
	private static final long serialVersionUID = 1L;
	/**交易对编号*/	
	private java.lang.String pairId;
	/**交易对顺序号*/	
	private java.lang.Integer pairSn;
	/**如：ltc_usdt*/	
	private java.lang.String pairSymbol;
	/***/	
	private java.lang.String pairDesc;
	/**币种表（g_currency）的currency_id*/	
	private java.lang.String currencyId;
	/**币种平台交易手续费千分之2，就是0.002*/	
	private java.math.BigDecimal serviceCharge;
	/**币种表（g_currency）的token_id*/	
	private java.lang.String currencyTokenId;
	/**媒介币平台服务手续费千分之2，就是0.002*/	
	private java.math.BigDecimal tokenServiceCharge;
	/**交易价格上限；警告阀值，不展示给用户看，出发后报警通知运维人员。后续操作，待定。*/	
	private java.math.BigDecimal tradeMaxPrice;
	/**交易价格下限*/	
	private java.math.BigDecimal tradeMinPrice;
	/**交易数量下限*/	
	private java.math.BigDecimal tradeNumberLowerLimit;
	/**是否启用；0-否;1-是;*/	
	private java.lang.Integer isEnable;
	/**是否推荐:0-否;1-是;*/	
	private java.lang.Integer isElite;
	/**备注*/	
	private java.lang.String remark;
	/**数据表版本,默认1*/	
	private java.lang.Integer version;
	/**创建时间格式:yyyy-MM-dd HH:ss:mm*/	
	private java.sql.Timestamp createTime;
	/**更新时间格式:yyyy-MM-dd HH:ss:mm*/	
	private java.sql.Timestamp updatedTime;
	public java.lang.String getPairId() {
		return pairId;
	}
	public void setPairId(java.lang.String pairId) {
		this.pairId = pairId;
	}
	public java.lang.Integer getPairSn() {
		return pairSn;
	}
	public void setPairSn(java.lang.Integer pairSn) {
		this.pairSn = pairSn;
	}
	public java.lang.String getPairSymbol() {
		return pairSymbol;
	}
	public void setPairSymbol(java.lang.String pairSymbol) {
		this.pairSymbol = pairSymbol;
	}
	public java.lang.String getPairDesc() {
		return pairDesc;
	}
	public void setPairDesc(java.lang.String pairDesc) {
		this.pairDesc = pairDesc;
	}
	public java.lang.String getCurrencyId() {
		return currencyId;
	}
	public void setCurrencyId(java.lang.String currencyId) {
		this.currencyId = currencyId;
	}
	public java.math.BigDecimal getServiceCharge() {
		return serviceCharge;
	}
	public void setServiceCharge(java.math.BigDecimal serviceCharge) {
		this.serviceCharge = serviceCharge;
	}
	public java.lang.String getCurrencyTokenId() {
		return currencyTokenId;
	}
	public void setCurrencyTokenId(java.lang.String currencyTokenId) {
		this.currencyTokenId = currencyTokenId;
	}
	public java.math.BigDecimal getTokenServiceCharge() {
		return tokenServiceCharge;
	}
	public void setTokenServiceCharge(java.math.BigDecimal tokenServiceCharge) {
		this.tokenServiceCharge = tokenServiceCharge;
	}
	public java.math.BigDecimal getTradeMaxPrice() {
		return tradeMaxPrice;
	}
	public void setTradeMaxPrice(java.math.BigDecimal tradeMaxPrice) {
		this.tradeMaxPrice = tradeMaxPrice;
	}
	public java.math.BigDecimal getTradeMinPrice() {
		return tradeMinPrice;
	}
	public void setTradeMinPrice(java.math.BigDecimal tradeMinPrice) {
		this.tradeMinPrice = tradeMinPrice;
	}
	public java.math.BigDecimal getTradeNumberLowerLimit() {
		return tradeNumberLowerLimit;
	}
	public void setTradeNumberLowerLimit(java.math.BigDecimal tradeNumberLowerLimit) {
		this.tradeNumberLowerLimit = tradeNumberLowerLimit;
	}
	public java.lang.Integer getIsEnable() {
		return isEnable;
	}
	public void setIsEnable(java.lang.Integer isEnable) {
		this.isEnable = isEnable;
	}
	public java.lang.Integer getIsElite() {
		return isElite;
	}
	public void setIsElite(java.lang.Integer isElite) {
		this.isElite = isElite;
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
