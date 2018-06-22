package com.manage.biz.vo;


import com.manage.base.entity.BaseVO;

/**
* 工单答复表（g_work_order_reply）
功能描述：存储工单答复信息。		
查询bean
*/
public class GWorkOrderReplyVO extends BaseVO{

	private static final long serialVersionUID = 1L;
	/**
	 * 主题编号
	 */
	private String subject_id;
	/**
	 * 答复者UID
	 */
	private String uid;
	/**
	 * 答复角色0-客服;1-用户(提工单者);
	 */
	private Integer type;
	public String getSubject_id() {
		return subject_id;
	}
	public void setSubject_id(String subject_id) {
		this.subject_id = subject_id;
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
