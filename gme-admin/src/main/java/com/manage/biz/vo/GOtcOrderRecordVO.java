package com.manage.biz.vo;


import com.manage.base.entity.BaseVO;

/**
* OTC历史订单表（g_otc_order_record）查询bean
*/
public class GOtcOrderRecordVO extends BaseVO{

	private static final long serialVersionUID = 1L;
	/**
	 * 订单号
	 */
	private String order_id;
	/**
	 * 挂单用户编号
	 */
	private String uid;
	/**
	 * 交易对象编号
	 */
	private String object_uid;
	/**
	 * 业务类型:1-买家;2-卖家;
	 */
	private Integer order_type;
	/**
	 * 订单状态：1挂单中;2-全部成交;3-部分成交;4-撤销;5-挂单超时;
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
	public Integer getOrder_type() {
		return order_type;
	}
	public void setOrder_type(Integer order_type) {
		this.order_type = order_type;
	}
	public Integer getOrder_status() {
		return order_status;
	}
	public void setOrder_status(Integer order_status) {
		this.order_status = order_status;
	}
	public String getObject_uid() {
		return object_uid;
	}
	public void setObject_uid(String object_uid) {
		this.object_uid = object_uid;
	}

}
