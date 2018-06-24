package com.manage.biz.vo;


import com.manage.base.entity.BaseVO;

/**
* 委托单历史订单表（g_entrust_order_record_usdt）
功能描述：存储币币交易的委托单历史记录。
查询bean
*/
public class EntrustOrderRecordUsdtVO extends BaseVO{

	private static final long serialVersionUID = 1L;
	/**
	 * 委托单号
	 */
	private String orderId;
	/**
	 * 用户编号
	 */
	private String uid;
	/**
	 * 交易类型；1-买入;2-卖出;
	 */
	private Integer entrustType;
	/**
	 * 订单状态：1挂单中;2-已完成;3-未成交;4-撤销;
	 */
	private Integer orderStatus;
	/**
	 * 交易状态:1完全成交;2-部分成交;
	 */
	private Integer dealStatus;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public Integer getEntrustType() {
		return entrustType;
	}
	public void setEntrustType(Integer entrustType) {
		this.entrustType = entrustType;
	}
	public Integer getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Integer getDealStatus() {
		return dealStatus;
	}
	public void setDealStatus(Integer dealStatus) {
		this.dealStatus = dealStatus;
	}
	
}
