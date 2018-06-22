package com.manage.biz.vo;


import com.manage.base.entity.BaseVO;

/**
* 币种交易对表查询bean
*/
public class GCurrencyTradePairVO extends BaseVO{
	
	private static final long serialVersionUID = 1L;
	/**
	 * 是否启用；0-否;1-是;
	 */
	private Integer is_enable;
	/**
	 * 是否推荐:0-否;1-是;
	 */
	private Integer is_elite;
	public Integer getIs_enable() {
		return is_enable;
	}
	public void setIs_enable(Integer is_enable) {
		this.is_enable = is_enable;
	}
	public Integer getIs_elite() {
		return is_elite;
	}
	public void setIs_elite(Integer is_elite) {
		this.is_elite = is_elite;
	}
	

}
