package com.manage.bus.vo;


import com.manage.base.entity.BaseVO;

/**
* 登录日志表（g_login_log）
功能描述：存储用户登录日志信息。
查询bean
*/
public class GLoginLogVO extends BaseVO{

	private static final long serialVersionUID = 1L;
	/**
	 * 用户编号
	 */
	private String uid;
	/**
	 * 登录账号
	 */
	private String account;
	/**
	 * ip
	 */
	private String login_ip;
	/**
	 * 状态
	 */
	private String status;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getLogin_ip() {
		return login_ip;
	}
	public void setLogin_ip(String login_ip) {
		this.login_ip = login_ip;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
