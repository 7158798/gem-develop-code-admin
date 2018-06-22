package com.manage.biz.entity;
import java.io.Serializable;
import java.math.BigDecimal;
/**
 *	表名：g_trade_record_coin_usdt
 *  注释:委托交易记录表（g_trade_record_coin_usdt）
 */
 
public class GTradeRecordCoinUsdt implements Serializable{
	private static final long serialVersionUID = 1L;
	/**记录编号*/	
	private java.lang.String id;
	/**交易类型1-买；2-卖*/	
	private java.lang.Integer trade_type;
	/**交易对编号*/	
	private java.lang.String pair_id;
	/**交易对符号*/	
	private java.lang.String pair_symbol;
	/**订单编号*/	
	private java.lang.String order_id;
	/**原始用户编号*/	
	private java.lang.String object_uid;
	/**交易日期*/	
	private java.sql.Timestamp trade_time;
	/**交易价格*/	
	private java.math.BigDecimal trade_price;
	/**订单数量*/	
	private java.math.BigDecimal order_number;
	/**金额*/	
	private java.math.BigDecimal amount;
	/**交易状态1-交易中;2-已付款;3-交易成功(放行);4-交易失败;5-系统取消;6-系统放行;*/	
	private java.lang.Integer trade_status;
	/**交易用户编号*/	
	private java.lang.String uid;
	/**手续费编号存储平台财务表（g_finance）的finance_id*/	
	private java.lang.String finance_id;
	/**备注*/	
	private java.lang.String remark;
	/**数据表版本,默认1*/	
	private java.lang.Integer version;
	/**创建时间格式:yyyy-MM-dd HH:ss:mm*/	
	private java.sql.Timestamp create_time;
	/**更新时间格式:yyyy-MM-dd HH:ss:mm*/	
	private java.sql.Timestamp updated_time;
	
	/**
	 * 手续费
	 */
	private BigDecimal service_charge;
	
	public BigDecimal getService_charge() {
		return service_charge;
	}
	public void setService_charge(BigDecimal service_charge) {
		this.service_charge = service_charge;
	}
	public void setId(java.lang.String id){
		this.id=id;
	}
	public java.lang.String getId(){
		return this.id;
	}
	public void setTrade_type(java.lang.Integer trade_type){
		this.trade_type=trade_type;
	}
	public java.lang.Integer getTrade_type(){
		return this.trade_type;
	}
	public void setPair_id(java.lang.String pair_id){
		this.pair_id=pair_id;
	}
	public java.lang.String getPair_id(){
		return this.pair_id;
	}
	public void setPair_symbol(java.lang.String pair_symbol){
		this.pair_symbol=pair_symbol;
	}
	public java.lang.String getPair_symbol(){
		return this.pair_symbol;
	}
	public void setOrder_id(java.lang.String order_id){
		this.order_id=order_id;
	}
	public java.lang.String getOrder_id(){
		return this.order_id;
	}
	public void setObject_uid(java.lang.String object_uid){
		this.object_uid=object_uid;
	}
	public java.lang.String getObject_uid(){
		return this.object_uid;
	}
	public void setTrade_time(java.sql.Timestamp trade_time){
		this.trade_time=trade_time;
	}
	public java.sql.Timestamp getTrade_time(){
		return this.trade_time;
	}
	public void setTrade_price(java.math.BigDecimal trade_price){
		this.trade_price=trade_price;
	}
	public java.math.BigDecimal getTrade_price(){
		return this.trade_price;
	}
	public void setOrder_number(java.math.BigDecimal order_number){
		this.order_number=order_number;
	}
	public java.math.BigDecimal getOrder_number(){
		return this.order_number;
	}
	public void setAmount(java.math.BigDecimal amount){
		this.amount=amount;
	}
	public java.math.BigDecimal getAmount(){
		return this.amount;
	}
	public void setTrade_status(java.lang.Integer trade_status){
		this.trade_status=trade_status;
	}
	public java.lang.Integer getTrade_status(){
		return this.trade_status;
	}
	public void setUid(java.lang.String uid){
		this.uid=uid;
	}
	public java.lang.String getUid(){
		return this.uid;
	}
	public void setFinance_id(java.lang.String finance_id){
		this.finance_id=finance_id;
	}
	public java.lang.String getFinance_id(){
		return this.finance_id;
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
