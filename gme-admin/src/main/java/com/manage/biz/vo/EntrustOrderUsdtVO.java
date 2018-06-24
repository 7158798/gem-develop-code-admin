package com.manage.biz.vo;


import com.manage.base.entity.BaseVO;

/**
* 委托订单表（g_entrust_order_usdt）
功能描述：存储币币交易的委托单历史记录。每个交易区生成一张委托订单表。entrust_order_id
查询bean
*/
public class EntrustOrderUsdtVO extends BaseVO{

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
	 * 订单状态；1-委托中;2-全部成交;3-部分成交;4撤销;
	 */
	private Integer orderStatus;
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
	
}
