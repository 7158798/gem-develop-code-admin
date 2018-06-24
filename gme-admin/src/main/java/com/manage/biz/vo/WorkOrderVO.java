package com.manage.biz.vo;


import com.manage.base.entity.BaseVO;

/**
* 工单表（g_work_order）
功能描述：存储工单信息。
查询bean
*/
public class WorkOrderVO extends BaseVO{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 业务编号
	 */
	private String bizId;
	/**
	 * 账户id
	 */
	private String accountId;
	/**
	 * 手机号
	 */
	private String phoneCode;
	/**
	 * 工单类型1充值;2提现;3申诉;4仲裁;5其他
	 */
	private Integer workType;
	/**
	 * 工单状态1-未处理;2-处理中;3-已处理;
	 */
	private Integer workStatus;
	public String getBizId() {
		return bizId;
	}
	public void setBizId(String bizId) {
		this.bizId = bizId;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getPhoneCode() {
		return phoneCode;
	}
	public void setPhoneCode(String phoneCode) {
		this.phoneCode = phoneCode;
	}
	public Integer getWorkType() {
		return workType;
	}
	public void setWorkType(Integer workType) {
		this.workType = workType;
	}
	public Integer getWorkStatus() {
		return workStatus;
	}
	public void setWorkStatus(Integer workStatus) {
		this.workStatus = workStatus;
	}
	
}
