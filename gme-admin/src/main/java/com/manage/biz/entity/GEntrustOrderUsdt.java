package com.manage.biz.entity;
import java.io.Serializable;
/**
 *	表名：g_entrust_order_usdt
 *  注释:委托订单表（g_entrust_order_usdt）
功能描述：存储币币交易的委托单历史记录。每个交易区生成一张委托订单表。entrust_order_id

 */
 
public class GEntrustOrderUsdt implements Serializable{
	private static final long serialVersionUID = 1L;
	/**编号；无重复32位订单号*/	
	private java.lang.String entrust_order_id;
	/**委托单号；*/	
	private java.lang.String order_id;
	/**用户编号；*/	
	private java.lang.String uid;
	/**交易对编号；币种交易对表（g_currency_trade_pair）*/	
	private java.lang.String pair_id;
	/**交易类型；1-买入;2-卖出;*/	
	private java.lang.Integer entrust_type;
	/**下单日期；*/	
	private java.sql.Timestamp order_time;
	/**价格(USDT)；这个价格就是USDT的价格*/	
	private java.math.BigDecimal entrust_price;
	/**订单量；交易币种的挂单量*/	
	private java.math.BigDecimal entrust_amount;
	/**已成交数量；*/	
	private java.math.BigDecimal finished_amount;
	/**未成交数量；*/	
	private java.math.BigDecimal unfinished_amount;
	/**订单状态；1-委托中;2-全部成交;3-部分成交;4撤销;*/	
	private java.lang.Integer order_status;
	/**订单完成日期；委托下单日期 / 格式:yyyy-MM-dd HH:ss:mm*/	
	private java.sql.Timestamp order_finished_time;
	/**备注*/	
	private java.lang.String remark;
	/**数据表版本,默认1*/	
	private java.lang.Integer version;
	/**创建时间格式:yyyy-MM-dd HH:ss:mm*/	
	private java.sql.Timestamp create_time;
	/**更新时间格式:yyyy-MM-dd HH:ss:mm*/	
	private java.sql.Timestamp updated_time;
	
	public void setEntrust_order_id(java.lang.String entrust_order_id){
		this.entrust_order_id=entrust_order_id;
	}
	public java.lang.String getEntrust_order_id(){
		return this.entrust_order_id;
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
	public void setPair_id(java.lang.String pair_id){
		this.pair_id=pair_id;
	}
	public java.lang.String getPair_id(){
		return this.pair_id;
	}
	public void setEntrust_type(java.lang.Integer entrust_type){
		this.entrust_type=entrust_type;
	}
	public java.lang.Integer getEntrust_type(){
		return this.entrust_type;
	}
	public void setOrder_time(java.sql.Timestamp order_time){
		this.order_time=order_time;
	}
	public java.sql.Timestamp getOrder_time(){
		return this.order_time;
	}
	public void setEntrust_price(java.math.BigDecimal entrust_price){
		this.entrust_price=entrust_price;
	}
	public java.math.BigDecimal getEntrust_price(){
		return this.entrust_price;
	}
	public void setEntrust_amount(java.math.BigDecimal entrust_amount){
		this.entrust_amount=entrust_amount;
	}
	public java.math.BigDecimal getEntrust_amount(){
		return this.entrust_amount;
	}
	public void setFinished_amount(java.math.BigDecimal finished_amount){
		this.finished_amount=finished_amount;
	}
	public java.math.BigDecimal getFinished_amount(){
		return this.finished_amount;
	}
	public void setUnfinished_amount(java.math.BigDecimal unfinished_amount){
		this.unfinished_amount=unfinished_amount;
	}
	public java.math.BigDecimal getUnfinished_amount(){
		return this.unfinished_amount;
	}
	public void setOrder_status(java.lang.Integer order_status){
		this.order_status=order_status;
	}
	public java.lang.Integer getOrder_status(){
		return this.order_status;
	}
	public void setOrder_finished_time(java.sql.Timestamp order_finished_time){
		this.order_finished_time=order_finished_time;
	}
	public java.sql.Timestamp getOrder_finished_time(){
		return this.order_finished_time;
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
