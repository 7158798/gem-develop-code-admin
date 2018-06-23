package com.manage.biz.vo;


import java.io.Serializable;
import java.util.Date;

import com.manage.base.entity.BaseVO;

/**
* 币种表（g_currency）
功能描述：存储币种信息。查询bean
*/
public class CurrencyVO extends BaseVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 币种符号
	 */
	private String currencySymbol;
	/**
	 * 是否是媒介币 0不是-1是
	 */
	private Integer isToken;
	/**
	 * 充值/提现 充值/提现(0000四位)：00-前两位表示是否充值;00-后两位表示是否提现;其中01表示是;02表示否;
	 */
	private String isOpen;
	/**
	 * 启用/冻结 1启用-2冻结
	 */
	private Integer isEnable;
	/**
	 * 启用开始时间
	 */
	private Date bgCreateDate; 
	/**
	 * 启用结束时间
	 */
	private Date endCreateDate;
	public String getCurrencySymbol() {
		return currencySymbol;
	}
	public void setCurrencySymbol(String currencySymbol) {
		this.currencySymbol = currencySymbol;
	}
	public Integer getIsToken() {
		return isToken;
	}
	public void setIsToken(Integer isToken) {
		this.isToken = isToken;
	}
	public String getIsOpen() {
		return isOpen;
	}
	public void setIsOpen(String isOpen) {
		this.isOpen = isOpen;
	}
	public Integer getIsEnable() {
		return isEnable;
	}
	public void setIsEnable(Integer isEnable) {
		this.isEnable = isEnable;
	}
	public Date getBgCreateDate() {
		return bgCreateDate;
	}
	public void setBgCreateDate(Date bgCreateDate) {
		this.bgCreateDate = bgCreateDate;
	}
	public Date getEndCreateDate() {
		return endCreateDate;
	}
	public void setEndCreateDate(Date endCreateDate) {
		this.endCreateDate = endCreateDate;
	}
}
