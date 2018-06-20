package com.manage.bus.vo;


import com.manage.base.entity.BaseVO;

/**
* 工单表（g_work_order）
功能描述：存储工单信息。
查询bean
*/
public class GWorkOrderVO extends BaseVO{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 业务编号
	 */
	private String biz_id;
	/**
	 * 账户id
	 */
	private String account_id;
	/**
	 * 手机号
	 */
	private String phone_code;
	/**
	 * 工单类型1充值;2提现;3申诉;4仲裁;5其他
	 */
	private Integer work_type;
	/**
	 * 工单状态1-未处理;2-处理中;3-已处理;
	 */
	private Integer work_status;
	public String getBiz_id() {
		return biz_id;
	}
	public void setBiz_id(String biz_id) {
		this.biz_id = biz_id;
	}
	public String getAccount_id() {
		return account_id;
	}
	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}
	public String getPhone_code() {
		return phone_code;
	}
	public void setPhone_code(String phone_code) {
		this.phone_code = phone_code;
	}
	public Integer getWork_type() {
		return work_type;
	}
	public void setWork_type(Integer work_type) {
		this.work_type = work_type;
	}
	public Integer getWork_status() {
		return work_status;
	}
	public void setWork_status(Integer work_status) {
		this.work_status = work_status;
	}
}
