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
public class GCurrencyCirculateStatisticsVO extends BaseVO{
	
	private static final long serialVersionUID = 1L;
	/**
	 * 币种编号
	 */
	private String currency_id;
	/**
	 * 币种代码
	 */
	private String currency_symbol;
	public String getCurrency_id() {
		return currency_id;
	}
	public void setCurrency_id(String currency_id) {
		this.currency_id = currency_id;
	}
	public String getCurrency_symbol() {
		return currency_symbol;
	}
	public void setCurrency_symbol(String currency_symbol) {
		this.currency_symbol = currency_symbol;
	}
	
}
