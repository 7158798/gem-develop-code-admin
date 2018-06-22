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
	private String biz_id;
	/**
	 * 业务类型 1-提现;2-充值;3-交易
	 */
	private Integer biz_type;
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
	public String getBiz_id() {
		return biz_id;
	}
	public void setBiz_id(String biz_id) {
		this.biz_id = biz_id;
	}
	public Integer getBiz_type() {
		return biz_type;
	}
	public void setBiz_type(Integer biz_type) {
		this.biz_type = biz_type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
