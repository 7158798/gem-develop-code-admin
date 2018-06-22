package com.manage.biz.entity;
import java.io.Serializable;
/**
 *	表名：g_currency_trade_pair
 *  注释:币种交易对表
 */
 
public class GCurrencyTradePair implements Serializable{
	
	private static final long serialVersionUID = 1L;
	/**交易对编号*/	
	private java.lang.String pair_id;
	/**交易对顺序号*/	
	private java.lang.Integer pair_sn;
	/**如：ltc_usdt*/	
	private java.lang.String pair_symbol;
	/***/	
	private java.lang.String pair_desc;
	/**币种表（g_currency）的currency_id*/	
	private java.lang.String currency_id;
	/**币种平台交易手续费千分之2，就是0.002*/	
	private java.math.BigDecimal service_charge;
	/**币种表（g_currency）的token_id*/	
	private java.lang.String currency_token_id;
	/**媒介币平台服务手续费千分之2，就是0.002*/	
	private java.math.BigDecimal token_service_charge;
	/**交易价格上限；警告阀值，不展示给用户看，出发后报警通知运维人员。后续操作，待定。*/	
	private java.math.BigDecimal trade_max_price;
	/**交易价格下限*/	
	private java.math.BigDecimal trade_min_price;
	/**交易数量下限*/	
	private java.math.BigDecimal trade_number_lower_limit;
	/**是否启用；0-否;1-是;*/	
	private java.lang.Integer is_enable;
	/**是否推荐:0-否;1-是;*/	
	private java.lang.Integer is_elite;
	/**备注*/	
	private java.lang.String remark;
	/**数据表版本,默认1*/	
	private java.lang.Integer version;
	/**创建时间格式:yyyy-MM-dd HH:ss:mm*/	
	private java.sql.Timestamp create_time;
	/**更新时间格式:yyyy-MM-dd HH:ss:mm*/	
	private java.sql.Timestamp updated_time;
	
	public void setPair_id(java.lang.String pair_id){
		this.pair_id=pair_id;
	}
	public java.lang.String getPair_id(){
		return this.pair_id;
	}
	public void setPair_sn(java.lang.Integer pair_sn){
		this.pair_sn=pair_sn;
	}
	public java.lang.Integer getPair_sn(){
		return this.pair_sn;
	}
	public void setPair_symbol(java.lang.String pair_symbol){
		this.pair_symbol=pair_symbol;
	}
	public java.lang.String getPair_symbol(){
		return this.pair_symbol;
	}
	public void setPair_desc(java.lang.String pair_desc){
		this.pair_desc=pair_desc;
	}
	public java.lang.String getPair_desc(){
		return this.pair_desc;
	}
	public void setCurrency_id(java.lang.String currency_id){
		this.currency_id=currency_id;
	}
	public java.lang.String getCurrency_id(){
		return this.currency_id;
	}
	public void setService_charge(java.math.BigDecimal service_charge){
		this.service_charge=service_charge;
	}
	public java.math.BigDecimal getService_charge(){
		return this.service_charge;
	}
	public void setCurrency_token_id(java.lang.String currency_token_id){
		this.currency_token_id=currency_token_id;
	}
	public java.lang.String getCurrency_token_id(){
		return this.currency_token_id;
	}
	public void setToken_service_charge(java.math.BigDecimal token_service_charge){
		this.token_service_charge=token_service_charge;
	}
	public java.math.BigDecimal getToken_service_charge(){
		return this.token_service_charge;
	}
	public void setTrade_max_price(java.math.BigDecimal trade_max_price){
		this.trade_max_price=trade_max_price;
	}
	public java.math.BigDecimal getTrade_max_price(){
		return this.trade_max_price;
	}
	public void setTrade_min_price(java.math.BigDecimal trade_min_price){
		this.trade_min_price=trade_min_price;
	}
	public java.math.BigDecimal getTrade_min_price(){
		return this.trade_min_price;
	}
	public void setTrade_number_lower_limit(java.math.BigDecimal trade_number_lower_limit){
		this.trade_number_lower_limit=trade_number_lower_limit;
	}
	public java.math.BigDecimal getTrade_number_lower_limit(){
		return this.trade_number_lower_limit;
	}
	
	public java.lang.Integer getIs_enable() {
		return is_enable;
	}
	public void setIs_enable(java.lang.Integer is_enable) {
		this.is_enable = is_enable;
	}
	public java.lang.Integer getIs_elite() {
		return is_elite;
	}
	public void setIs_elite(java.lang.Integer is_elite) {
		this.is_elite = is_elite;
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
