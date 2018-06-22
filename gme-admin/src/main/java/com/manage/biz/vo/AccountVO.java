package com.manage.biz.vo;


import com.manage.base.entity.BaseVO;

/**
* 账户表（g_account）
功能描述：存储用户账户信息。查询bean
*/
public class AccountVO extends BaseVO{

	private static final long serialVersionUID = 1L;

	/**
	 * 用户姓名
	 */
	private String realName;
	/**
	 * 银行卡类型 1-借记卡;2-信用卡;
	 */
	private Integer cardType;
	/**
	 * 转账状态1-未审核;2-通过审核;
	 */
	private Integer auditStatus;
	/**
	 * 账户状态
	 */
	private Integer accountStatus;
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public Integer getCardType() {
		return cardType;
	}
	public void setCardType(Integer cardType) {
		this.cardType = cardType;
	}
	public Integer getAuditStatus() {
		return auditStatus;
	}
	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
	}
	public Integer getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(Integer accountStatus) {
		this.accountStatus = accountStatus;
	}
}
