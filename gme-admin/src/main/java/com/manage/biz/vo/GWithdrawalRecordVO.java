package com.manage.biz.vo;


import com.manage.base.entity.BaseVO;

/**
* 钱包提现记录表（g_withdrawal_record）
功能描述：存储钱包提现记录信息。
查询bean
*/
public class GWithdrawalRecordVO extends BaseVO{

	private static final long serialVersionUID = 1L;
	/**
	 * uid: 用户编号
	 */
	private String uid;
	/**
	 * withdrawalId: 提现编号
	 */
	private String withdrawalId;
	/**
	 * currencyId: 币种类型 1.usdt,2btc,3eth
	 */
	private Integer currencyId;
	/**
	 * status: 提现状态1-申请;2-处理中;3-已处理;4-已拒绝;5-撤销;
	 */
	private Integer status;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getWithdrawalId() {
		return withdrawalId;
	}
	public void setWithdrawalId(String withdrawalId) {
		this.withdrawalId = withdrawalId;
	}
	public Integer getCurrencyId() {
		return currencyId;
	}
	public void setCurrencyId(Integer currencyId) {
		this.currencyId = currencyId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
