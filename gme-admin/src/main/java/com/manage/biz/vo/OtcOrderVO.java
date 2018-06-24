package com.manage.biz.vo;


import com.manage.base.entity.BaseVO;

/**
* OTC订单表（g_otc_order）
功能描述：存储OTC订单信息。
查询bean
*/
public class OtcOrderVO extends BaseVO{

	private static final long serialVersionUID = 1L;

	/**
	 * 订单号
	 */
	private String orderId;
	/**
	 * 挂单用户编号
	 */
	private String uid;
	/**
	 * 业务类型:1-买家;2-卖家;
	 */
	private Integer orderType;
	/**
	 * 订单状态：1挂单中;2-全部成交;3-部分成交;4-撤销;5-挂单超时;
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
	public Integer getOrderType() {
		return orderType;
	}
	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}
	public Integer getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	
}
