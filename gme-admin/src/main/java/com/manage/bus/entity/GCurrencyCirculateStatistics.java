package com.manage.bus.entity;
import java.io.Serializable;

/**
 * 
 * @Project：gme-admin   
 * @Class：GCurrencyCirculateStatistics   
 * @Description 类描述：   币种流通统计
 * @Author：zhou   
 * @Date：2018年6月12日 下午6:28:49   
 * @version V1.0
 */
public class GCurrencyCirculateStatistics implements Serializable{
	
	private static final long serialVersionUID = 1L;
	/**编号*/	
	private java.lang.String volume_id;
	/**币种编号*/	
	private java.lang.String currency_id;
	/**币种代码*/	
	private java.lang.String currency_symbol;
	/**价格*/	
	private java.math.BigDecimal current_price;
	/**交易量*/	
	private java.math.BigDecimal trade_volume;
	/**总市值*/	
	private java.math.BigDecimal total_value;
	/**日涨跌*/	
	private java.math.BigDecimal daily_change;
	
	public void setVolume_id(java.lang.String volume_id){
		this.volume_id=volume_id;
	}
	public java.lang.String getVolume_id(){
		return this.volume_id;
	}
	public void setCurrency_id(java.lang.String currency_id){
		this.currency_id=currency_id;
	}
	public java.lang.String getCurrency_id(){
		return this.currency_id;
	}
	public void setCurrency_symbol(java.lang.String currency_symbol){
		this.currency_symbol=currency_symbol;
	}
	public java.lang.String getCurrency_symbol(){
		return this.currency_symbol;
	}
	public void setCurrent_price(java.math.BigDecimal current_price){
		this.current_price=current_price;
	}
	public java.math.BigDecimal getCurrent_price(){
		return this.current_price;
	}
	public void setTrade_volume(java.math.BigDecimal trade_volume){
		this.trade_volume=trade_volume;
	}
	public java.math.BigDecimal getTrade_volume(){
		return this.trade_volume;
	}
	public void setTotal_value(java.math.BigDecimal total_value){
		this.total_value=total_value;
	}
	public java.math.BigDecimal getTotal_value(){
		return this.total_value;
	}
	public void setDaily_change(java.math.BigDecimal daily_change){
		this.daily_change=daily_change;
	}
	public java.math.BigDecimal getDaily_change(){
		return this.daily_change;
	}
}
