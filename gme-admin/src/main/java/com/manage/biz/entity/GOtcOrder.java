package com.manage.biz.entity;
import java.io.Serializable;
/**
 *	表名：g_otc_order
 *  注释:OTC订单表（g_otc_order）
功能描述：存储OTC订单信息。

 */
 
public class GOtcOrder implements Serializable{
	private static final long serialVersionUID = 1L;
	/**OTC编号*/	
	private java.lang.String entry_order_id;
	/**订单号;无重复32位订单号*/	
	private java.lang.String order_id;
	/**挂单用户编号*/	
	private java.lang.String uid;
	/**业务类型:1-买家;2-卖家;*/	
	private java.lang.Integer order_type;
	/**媒介币种*/	
	private java.lang.String currency_id;
	/**人民币价格*/	
	private java.math.BigDecimal order_price;
	/**数量*/	
	private java.math.BigDecimal order_number;
	/**总金额*/	
	private java.math.BigDecimal order_amount;
	/**订单状态：1挂单中;2-全部成交;3-部分成交;4-撤销;5-挂单超时;*/	
	private java.lang.Integer order_status;
	/**注意，解决僵尸单方案：如果遇到最后数量余额小于该字段设置的最小交易数量则自动默认成交,不受该字段限制;*/	
	private java.math.BigDecimal order_min_number;
	/**支付方式：00-前两位表示是否银行卡支付;00-中间两位表示是否支付宝支付;00-最后两位表示是否微信支付;其中，01表示是;02表示否;*/	
	private java.lang.String order_pay_type;
	/**挂单时长限制（单位：小时）默认0表示无限制*/	
	private java.lang.Integer order_duration;
	/**备注*/	
	private java.lang.String remark;
	/**数据表版本,默认1*/	
	private java.lang.Integer version;
	/**创建时间格式:yyyy-MM-dd HH:ss:mm*/	
	private java.sql.Timestamp create_time;
	/**更新时间格式:yyyy-MM-dd HH:ss:mm*/	
	private java.sql.Timestamp updated_time;
	
	/**
	 * 币种符号
	 */
	private String currency_symbol;
	
	public String getCurrency_symbol() {
		return currency_symbol;
	}
	public void setCurrency_symbol(String currency_symbol) {
		this.currency_symbol = currency_symbol;
	}
	public void setEntry_order_id(java.lang.String entry_order_id){
		this.entry_order_id=entry_order_id;
	}
	public java.lang.String getEntry_order_id(){
		return this.entry_order_id;
	}
	public void setOrder_id(java.lang.String order_id){
		this.order_id=order_id;
	}
	public java.lang.String getOrder_id(){
		return this.order_id;
	}
	public void setUid(java.lang.String uid){
		this.uid=uid;
	}
	public java.lang.String getUid(){
		return this.uid;
	}
	public void setOrder_type(java.lang.Integer order_type){
		this.order_type=order_type;
	}
	public java.lang.Integer getOrder_type(){
		return this.order_type;
	}
	public void setCurrency_id(java.lang.String currency_id){
		this.currency_id=currency_id;
	}
	public java.lang.String getCurrency_id(){
		return this.currency_id;
	}
	public void setOrder_price(java.math.BigDecimal order_price){
		this.order_price=order_price;
	}
	public java.math.BigDecimal getOrder_price(){
		return this.order_price;
	}
	public void setOrder_number(java.math.BigDecimal order_number){
		this.order_number=order_number;
	}
	public java.math.BigDecimal getOrder_number(){
		return this.order_number;
	}
	public void setOrder_amount(java.math.BigDecimal order_amount){
		this.order_amount=order_amount;
	}
	public java.math.BigDecimal getOrder_amount(){
		return this.order_amount;
	}
	public void setOrder_status(java.lang.Integer order_status){
		this.order_status=order_status;
	}
	public java.lang.Integer getOrder_status(){
		return this.order_status;
	}
	public void setOrder_min_number(java.math.BigDecimal order_min_number){
		this.order_min_number=order_min_number;
	}
	public java.math.BigDecimal getOrder_min_number(){
		return this.order_min_number;
	}
	public void setOrder_pay_type(java.lang.String order_pay_type){
		this.order_pay_type=order_pay_type;
	}
	public java.lang.String getOrder_pay_type(){
		return this.order_pay_type;
	}
	public void setOrder_duration(java.lang.Integer order_duration){
		this.order_duration=order_duration;
	}
	public java.lang.Integer getOrder_duration(){
		return this.order_duration;
	}
	public void setRemark(java.lang.String remark){
		this.remark=remark;
	}
	public java.lang.String getRemark(){
		return this.remark;
	}
	public void setVersion(java.lang.Integer version){
		this.version=version;
	}
	public java.lang.Integer getVersion(){
		return this.version;
	}
	public void setCreate_time(java.sql.Timestamp create_time){
		this.create_time=create_time;
	}
	public java.sql.Timestamp getCreate_time(){
		return this.create_time;
	}
	public void setUpdated_time(java.sql.Timestamp updated_time){
		this.updated_time=updated_time;
	}
	public java.sql.Timestamp getUpdated_time(){
		return this.updated_time;
	}
}
