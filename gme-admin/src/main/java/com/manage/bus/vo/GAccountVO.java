package com.manage.bus.vo;


import com.manage.base.entity.BaseVO;

/**
* 账户表（g_account）
功能描述：存储用户账户信息。查询bean
*/
public class GAccountVO extends BaseVO{

	private static final long serialVersionUID = 1L;

	/**
	 * 用户姓名
	 */
	private String real_name;
	/**
	 * 银行卡类型 1-借记卡;2-信用卡;
	 */
	private Integer card_type;
	/**
	 * 转账状态1-未审核;2-通过审核;
	 */
	private Integer audit_status;
	/**
	 * 账户状态
	 */
	private Integer account_status;
	public String getReal_name() {
		return real_name;
	}
	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}
	public Integer getCard_type() {
		return card_type;
	}
	public void setCard_type(Integer card_type) {
		this.card_type = card_type;
	}
	public Integer getAudit_status() {
		return audit_status;
	}
	public void setAudit_status(Integer audit_status) {
		this.audit_status = audit_status;
	}
	public Integer getAccount_status() {
		return account_status;
	}
	public void setAccount_status(Integer account_status) {
		this.account_status = account_status;
	}

}
