package com.manage.biz.vo;


import com.manage.base.entity.BaseVO;

/**
* 操作日志表（g_operation_log）
功能描述：存储用户业务操作日志信息。
查询bean
*/
public class GOperationLogVO extends BaseVO{

	private static final long serialVersionUID = 1L;

	/**
	 * 用户编号
	 */
	private String uid;
	/**
	 * 业务编号
	 */
	private String bizId;
	/**
	 * 业务类型 1-提现;2-充值;3-交易
	 */
	private Integer bizType;
	/**
	 * 状态success  / failed.
	 */
	private String status;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getBizId() {
		return bizId;
	}
	public void setBizId(String bizId) {
		this.bizId = bizId;
	}
	public Integer getBizType() {
		return bizType;
	}
	public void setBizType(Integer bizType) {
		this.bizType = bizType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
