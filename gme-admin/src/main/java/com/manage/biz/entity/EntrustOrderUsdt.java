package com.manage.biz.entity;
import java.io.Serializable;
/**
 *	表名：g_entrust_order_usdt
 *  注释:委托订单表（g_entrust_order_usdt）
功能描述：存储币币交易的委托单历史记录。每个交易区生成一张委托订单表。entrust_order_id

 */
 
public class EntrustOrderUsdt implements Serializable{
	private static final long serialVersionUID = 1L;
	/**编号；无重复32位订单号*/	
	private java.lang.String entrustOrderId;
	/**委托单号；*/	
	private java.lang.String orderId;
	/**用户编号；*/	
	private java.lang.String uid;
	/**交易对编号；币种交易对表（g_currency_trade_pair）*/	
	private java.lang.String pairId;
	/**交易类型；1-买入;2-卖出;*/	
	private java.lang.Integer entrustType;
	/**下单日期；*/	
	private java.sql.Timestamp orderTime;
	/**价格(USDT)；这个价格就是USDT的价格*/	
	private java.math.BigDecimal entrustPrice;
	/**订单量；交易币种的挂单量*/	
	private java.math.BigDecimal entrustAmount;
	/**已成交数量；*/	
	private java.math.BigDecimal finishedAmount;
	/**未成交数量；*/	
	private java.math.BigDecimal unfinishedAmount;
	/**订单状态；1-委托中;2-全部成交;3-部分成交;4撤销;*/	
	private java.lang.Integer order_status;
	/**订单完成日期；委托下单日期 / 格式:yyyy-MM-dd HH:ss:mm*/	
	private java.sql.Timestamp orderFinishedTime;
	/**备注*/	
	private java.lang.String remark;
	/**数据表版本,默认1*/	
	private java.lang.Integer version;
	/**创建时间格式:yyyy-MM-dd HH:ss:mm*/	
	private java.sql.Timestamp createTime;
	/**更新时间格式:yyyy-MM-dd HH:ss:mm*/	
	private java.sql.Timestamp updatedTime;
	public java.lang.String getEntrustOrderId() {
		return entrustOrderId;
	}
	public void setEntrustOrderId(java.lang.String entrustOrderId) {
		this.entrustOrderId = entrustOrderId;
	}
	public java.lang.String getOrderId() {
		return orderId;
	}
	public void setOrderId(java.lang.String orderId) {
		this.orderId = orderId;
	}
	public java.lang.String getUid() {
		return uid;
	}
	public void setUid(java.lang.String uid) {
		this.uid = uid;
	}
	public java.lang.String getPairId() {
		return pairId;
	}
	public void setPairId(java.lang.String pairId) {
		this.pairId = pairId;
	}
	public java.lang.Integer getEntrustType() {
		return entrustType;
	}
	public void setEntrustType(java.lang.Integer entrustType) {
		this.entrustType = entrustType;
	}
	public java.sql.Timestamp getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(java.sql.Timestamp orderTime) {
		this.orderTime = orderTime;
	}
	public java.math.BigDecimal getEntrustPrice() {
		return entrustPrice;
	}
	public void setEntrustPrice(java.math.BigDecimal entrustPrice) {
		this.entrustPrice = entrustPrice;
	}
	public java.math.BigDecimal getEntrustAmount() {
		return entrustAmount;
	}
	public void setEntrustAmount(java.math.BigDecimal entrustAmount) {
		this.entrustAmount = entrustAmount;
	}
	public java.math.BigDecimal getFinishedAmount() {
		return finishedAmount;
	}
	public void setFinishedAmount(java.math.BigDecimal finishedAmount) {
		this.finishedAmount = finishedAmount;
	}
	public java.math.BigDecimal getUnfinishedAmount() {
		return unfinishedAmount;
	}
	public void setUnfinishedAmount(java.math.BigDecimal unfinishedAmount) {
		this.unfinishedAmount = unfinishedAmount;
	}
	public java.lang.Integer getOrder_status() {
		return order_status;
	}
	public void setOrder_status(java.lang.Integer order_status) {
		this.order_status = order_status;
	}
	public java.sql.Timestamp getOrderFinishedTime() {
		return orderFinishedTime;
	}
	public void setOrderFinishedTime(java.sql.Timestamp orderFinishedTime) {
		this.orderFinishedTime = orderFinishedTime;
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
