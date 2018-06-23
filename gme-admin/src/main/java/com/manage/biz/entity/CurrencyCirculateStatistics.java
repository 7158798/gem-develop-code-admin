package com.manage.biz.entity;
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
/**   
 * @Project：gme-admin   
 * @Class：CurrencyCirculateStatistics   
 * @Description 类描述：   
 * @Author：zhou  
 * @Date：2018年6月22日 下午11:22:36   
 * @version      
 */
public class CurrencyCirculateStatistics implements Serializable{
	
	private static final long serialVersionUID = 1L;
	/**编号*/	
	private java.lang.String volumeId;
	/**币种编号*/	
	private java.lang.String currencyId;
	/**币种代码*/	
	private java.lang.String currencySymbol;
	/**价格*/	
	private java.math.BigDecimal currentPrice;
	/**交易量*/	
	private java.math.BigDecimal tradeVolume;
	/**总市值*/	
	private java.math.BigDecimal totalValue;
	/**日涨跌*/	
	private java.math.BigDecimal dailyChange;
	public java.lang.String getVolumeId() {
		return volumeId;
	}
	public void setVolumeId(java.lang.String volumeId) {
		this.volumeId = volumeId;
	}
	public java.lang.String getCurrencyId() {
		return currencyId;
	}
	public void setCurrencyId(java.lang.String currencyId) {
		this.currencyId = currencyId;
	}
	public java.lang.String getCurrencySymbol() {
		return currencySymbol;
	}
	public void setCurrencySymbol(java.lang.String currencySymbol) {
		this.currencySymbol = currencySymbol;
	}
	public java.math.BigDecimal getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(java.math.BigDecimal currentPrice) {
		this.currentPrice = currentPrice;
	}
	public java.math.BigDecimal getTradeVolume() {
		return tradeVolume;
	}
	public void setTradeVolume(java.math.BigDecimal tradeVolume) {
		this.tradeVolume = tradeVolume;
	}
	public java.math.BigDecimal getTotalValue() {
		return totalValue;
	}
	public void setTotalValue(java.math.BigDecimal totalValue) {
		this.totalValue = totalValue;
	}
	public java.math.BigDecimal getDailyChange() {
		return dailyChange;
	}
	public void setDailyChange(java.math.BigDecimal dailyChange) {
		this.dailyChange = dailyChange;
	}
}
