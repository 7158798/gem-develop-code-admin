package com.manage.biz.vo;


import com.manage.base.entity.BaseVO;

/**
 * 
 * @Project：gme-admin   
 * @Class：GCurrencyCirculateStatisticsVO 币种流通表    
 * @Description 类描述：   
 * @Author：zhou   
 * @Date：2018年6月11日 下午6:56:39   
 * @version V1.0
 */
public class CurrencyCirculateStatisticsVO extends BaseVO{
	
	private static final long serialVersionUID = 1L;
	/**
	 * 币种编号
	 */
	private String currencyId;
	/**
	 * 币种代码
	 */
	private String currencySymbol;
	public String getCurrencyId() {
		return currencyId;
	}
	public void setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
	}
	public String getCurrencySymbol() {
		return currencySymbol;
	}
	public void setCurrencySymbol(String currencySymbol) {
		this.currencySymbol = currencySymbol;
	}
}
