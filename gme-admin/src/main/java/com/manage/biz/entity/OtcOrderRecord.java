package com.manage.biz.entity;
import java.io.Serializable;
/**
 *	表名：g_otc_order_record
 *  注释:OTC历史订单表（g_otc_order_record）
 */
 
public class OtcOrderRecord implements Serializable{
	private static final long serialVersionUID = 1L;
	/**OTC编号*/	
	private java.lang.String entryOrderId;
	/**订单号;无重复32位订单号*/	
	private java.lang.String orderId;
	/**挂单用户编号*/	
	private java.lang.String uid;
	/**业务类型:1-买家;2-卖家;*/	
	private java.lang.Integer orderType;
	/**媒介币种*/	
	private java.lang.String currencyId;
	/**人民币价格*/	
	private java.math.BigDecimal orderPrice;
	/**数量*/	
	private java.math.BigDecimal orderNumber;
	/**总金额*/	
	private java.math.BigDecimal orderAmount;
	/**订单状态：1挂单中;2-全部成交;3-部分成交;4-撤销;5-挂单超时;*/	
	private java.lang.Integer orderStatus;
	/**交易对象姓名*/	
	private java.lang.String objectUid;
	/**交易对象编号*/	
	private java.lang.String objectName;
	/**备注*/	
	private java.lang.String remark;
	/**数据表版本,默认1*/	
	private java.lang.Integer version;
	/**创建时间格式:yyyy-MM-dd HH:ss:mm*/	
	private java.sql.Timestamp createTime;
	/**更新时间格式:yyyy-MM-dd HH:ss:mm*/	
	private java.sql.Timestamp updatedTime;
	
	/**
	 * 媒介币种
	 */
	private String currencySymbol;

	public java.lang.String getEntryOrderId() {
		return entryOrderId;
	}

	public void setEntryOrderId(java.lang.String entryOrderId) {
		this.entryOrderId = entryOrderId;
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

	public java.lang.Integer getOrderType() {
		return orderType;
	}

	public void setOrderType(java.lang.Integer orderType) {
		this.orderType = orderType;
	}

	public java.lang.String getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(java.lang.String currencyId) {
		this.currencyId = currencyId;
	}

	public java.math.BigDecimal getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(java.math.BigDecimal orderPrice) {
		this.orderPrice = orderPrice;
	}

	public java.math.BigDecimal getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(java.math.BigDecimal orderNumber) {
		this.orderNumber = orderNumber;
	}

	public java.math.BigDecimal getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(java.math.BigDecimal orderAmount) {
		this.orderAmount = orderAmount;
	}

	public java.lang.Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(java.lang.Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public java.lang.String getObjectUid() {
		return objectUid;
	}

	public void setObjectUid(java.lang.String objectUid) {
		this.objectUid = objectUid;
	}

	public java.lang.String getObjectName() {
		return objectName;
	}

	public void setObjectName(java.lang.String objectName) {
		this.objectName = objectName;
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
