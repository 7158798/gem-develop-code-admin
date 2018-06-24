package com.manage.biz.entity;
import java.io.Serializable;
import java.math.BigDecimal;
/**
 *	表名：g_trade_record_coin_usdt
 *  注释:委托交易记录表（g_trade_record_coin_usdt）
 */
 
public class TradeRecordCoinUsdt implements Serializable{
	private static final long serialVersionUID = 1L;
	/**记录编号*/	
	private java.lang.String id;
	/**交易类型1-买；2-卖*/	
	private java.lang.Integer tradeType;
	/**交易对编号*/	
	private java.lang.String pairId;
	/**交易对符号*/	
	private java.lang.String pairSymbol;
	/**订单编号*/	
	private java.lang.String orderId;
	/**原始用户编号*/	
	private java.lang.String objectUid;
	/**交易日期*/	
	private java.sql.Timestamp tradeTime;
	/**交易价格*/	
	private java.math.BigDecimal tradePrice;
	/**订单数量*/	
	private java.math.BigDecimal orderNumber;
	/**金额*/	
	private java.math.BigDecimal amount;
	/**交易状态1-交易中;2-已付款;3-交易成功(放行);4-交易失败;5-系统取消;6-系统放行;*/	
	private java.lang.Integer tradeStatus;
	/**交易用户编号*/	
	private java.lang.String uid;
	/**手续费编号存储平台财务表（g_finance）的finance_id*/	
	private java.lang.String financeId;
	/**备注*/	
	private java.lang.String remark;
	/**数据表版本,默认1*/	
	private java.lang.Integer version;
	/**创建时间格式:yyyy-MM-dd HH:ss:mm*/	
	private java.sql.Timestamp createTime;
	/**更新时间格式:yyyy-MM-dd HH:ss:mm*/	
	private java.sql.Timestamp updatedTime;
	
	/**
	 * 手续费
	 */
	private BigDecimal serviceCharge;

	public java.lang.String getId() {
		return id;
	}

	public void setId(java.lang.String id) {
		this.id = id;
	}

	public java.lang.Integer getTradeType() {
		return tradeType;
	}

	public void setTradeType(java.lang.Integer tradeType) {
		this.tradeType = tradeType;
	}

	public java.lang.String getPairId() {
		return pairId;
	}

	public void setPairId(java.lang.String pairId) {
		this.pairId = pairId;
	}

	public java.lang.String getPairSymbol() {
		return pairSymbol;
	}

	public void setPairSymbol(java.lang.String pairSymbol) {
		this.pairSymbol = pairSymbol;
	}

	public java.lang.String getOrderId() {
		return orderId;
	}

	public void setOrderId(java.lang.String orderId) {
		this.orderId = orderId;
	}

	public java.lang.String getObjectUid() {
		return objectUid;
	}

	public void setObjectUid(java.lang.String objectUid) {
		this.objectUid = objectUid;
	}

	public java.sql.Timestamp getTradeTime() {
		return tradeTime;
	}

	public void setTradeTime(java.sql.Timestamp tradeTime) {
		this.tradeTime = tradeTime;
	}

	public java.math.BigDecimal getTradePrice() {
		return tradePrice;
	}

	public void setTradePrice(java.math.BigDecimal tradePrice) {
		this.tradePrice = tradePrice;
	}

	public java.math.BigDecimal getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(java.math.BigDecimal orderNumber) {
		this.orderNumber = orderNumber;
	}

	public java.math.BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(java.math.BigDecimal amount) {
		this.amount = amount;
	}

	public java.lang.Integer getTradeStatus() {
		return tradeStatus;
	}

	public void setTradeStatus(java.lang.Integer tradeStatus) {
		this.tradeStatus = tradeStatus;
	}

	public java.lang.String getUid() {
		return uid;
	}

	public void setUid(java.lang.String uid) {
		this.uid = uid;
	}

	public java.lang.String getFinanceId() {
		return financeId;
	}

	public void setFinanceId(java.lang.String financeId) {
		this.financeId = financeId;
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

	public BigDecimal getServiceCharge() {
		return serviceCharge;
	}

	public void setServiceCharge(BigDecimal serviceCharge) {
		this.serviceCharge = serviceCharge;
	}
}
