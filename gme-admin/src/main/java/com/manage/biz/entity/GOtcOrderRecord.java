package com.manage.biz.entity;
import java.io.Serializable;
/**
 *	表名：g_otc_order_record
 *  注释:OTC历史订单表（g_otc_order_record）
 */
 
public class GOtcOrderRecord implements Serializable{
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
	/**交易对象姓名*/	
	private java.lang.String object_uid;
	/**交易对象编号*/	
	private java.lang.String object_name;
	/**备注*/	
	private java.lang.String remark;
	/**数据表版本,默认1*/	
	private java.lang.Integer version;
	/**创建时间格式:yyyy-MM-dd HH:ss:mm*/	
	private java.sql.Timestamp create_time;
	/**更新时间格式:yyyy-MM-dd HH:ss:mm*/	
	private java.sql.Timestamp updated_time;
	
	/**
	 * 媒介币种
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
	public void setObject_uid(java.lang.String object_uid){
		this.object_uid=object_uid;
	}
	public java.lang.String getObject_uid(){
		return this.object_uid;
	}
	public void setObject_name(java.lang.String object_name){
		this.object_name=object_name;
	}
	public java.lang.String getObject_name(){
		return this.object_name;
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
