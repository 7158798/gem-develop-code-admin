package com.manage.biz.vo;


import com.manage.base.entity.BaseVO;

/**
* OTC交易记录表（g_trade_record_otc_usdt）查询bean
*/
public class GTradeRecordOtcUsdtVO extends BaseVO{

	private static final long serialVersionUID = 1L;
	/**
	 * 订单编号
	 */
	private String order_id;
	/**
	 * 交易用户编号
	 */
	private String uid;
	/**
	 * 原始用户编号
	 */
	private String object_uid;
	/**
	 * 交易类型1-买；2-卖
	 */
	private Integer trade_type;
	/**
	 * 交易状态1-交易中;2-已付款;3-交易成功(放行);4-交易失败;5-系统取消;6-系统放行;
	 */
	private Integer trade_status;
	
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getObject_uid() {
		return object_uid;
	}
	public void setObject_uid(String object_uid) {
		this.object_uid = object_uid;
	}
	public Integer getTrade_type() {
		return trade_type;
	}
	public void setTrade_type(Integer trade_type) {
		this.trade_type = trade_type;
	}
	public Integer getTrade_status() {
		return trade_status;
	}
	public void setTrade_status(Integer trade_status) {
		this.trade_status = trade_status;
	}
}
