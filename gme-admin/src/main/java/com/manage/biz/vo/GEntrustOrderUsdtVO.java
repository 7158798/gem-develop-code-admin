package com.manage.biz.vo;


import com.manage.base.entity.BaseVO;

/**
* 委托订单表（g_entrust_order_usdt）
功能描述：存储币币交易的委托单历史记录。每个交易区生成一张委托订单表。entrust_order_id
查询bean
*/
public class GEntrustOrderUsdtVO extends BaseVO{

	private static final long serialVersionUID = 1L;
	/**
	 * 委托单号
	 */
	private String order_id;
	/**
	 * 用户编号
	 */
	private String uid;
	/**
	 * 交易类型；1-买入;2-卖出;
	 */
	private Integer entrust_type;
	/**
	 * 订单状态；1-委托中;2-全部成交;3-部分成交;4撤销;
	 */
	private Integer order_status;
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
	public Integer getEntrust_type() {
		return entrust_type;
	}
	public void setEntrust_type(Integer entrust_type) {
		this.entrust_type = entrust_type;
	}
	public Integer getOrder_status() {
		return order_status;
	}
	public void setOrder_status(Integer order_status) {
		this.order_status = order_status;
	}
}
