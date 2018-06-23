package com.manage.biz.vo;


import com.manage.base.entity.BaseVO;

/**
* 币种交易对表查询bean
*/
public class CurrencyTradePairVO extends BaseVO{
	
	private static final long serialVersionUID = 1L;
	/**
	 * 是否启用；0-否;1-是;
	 */
	private Integer isEnable;
	/**
	 * 是否推荐:0-否;1-是;
	 */
	private Integer isElite;
	public Integer getIsEnable() {
		return isEnable;
	}
	public void setIsEnable(Integer isEnable) {
		this.isEnable = isEnable;
	}
	public Integer getIsElite() {
		return isElite;
	}
	public void setIsElite(Integer isElite) {
		this.isElite = isElite;
	}
	

}
