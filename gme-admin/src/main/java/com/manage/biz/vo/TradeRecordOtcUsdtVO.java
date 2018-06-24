package com.manage.biz.vo;


import com.manage.base.entity.BaseVO;

/**
* OTC交易记录表（g_trade_record_otc_usdt）查询bean
*/
public class TradeRecordOtcUsdtVO extends BaseVO{

	private static final long serialVersionUID = 1L;
	/**
	 * 订单编号
	 */
	private String orderId;
	/**
	 * 交易用户编号
	 */
	private String uid;
	/**
	 * 原始用户编号
	 */
	private String objectUid;
	/**
	 * 交易类型1-买；2-卖
	 */
	private Integer tradeType;
	/**
	 * 交易状态1-交易中;2-已付款;3-交易成功(放行);4-交易失败;5-系统取消;6-系统放行;
	 */
	private Integer tradeStatus;
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
	public String getObjectUid() {
		return objectUid;
	}
	public void setObjectUid(String objectUid) {
		this.objectUid = objectUid;
	}
	public Integer getTradeType() {
		return tradeType;
	}
	public void setTradeType(Integer tradeType) {
		this.tradeType = tradeType;
	}
	public Integer getTradeStatus() {
		return tradeStatus;
	}
	public void setTradeStatus(Integer tradeStatus) {
		this.tradeStatus = tradeStatus;
	}
}
