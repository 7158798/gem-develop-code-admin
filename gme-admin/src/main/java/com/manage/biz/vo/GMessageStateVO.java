package com.manage.biz.vo;


import com.manage.base.entity.BaseVO;

/**
* 短信邮件发送状态表（g_message_state）
功能描述：存储短信邮件发送状态信息。
查询bean
*/
public class GMessageStateVO extends BaseVO{

	private static final long serialVersionUID = 1L;
	/**
	 * 业务编号
	 */
	private String biz_id;
	/**
	 * 用户编号
	 */
	private String uid;
	/**
	 * 业务类型1短信验证码；2邮箱验证码；3邮箱激活码
	 */
	private Integer type;
	public String getBiz_id() {
		return biz_id;
	}
	public void setBiz_id(String biz_id) {
		this.biz_id = biz_id;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
}
