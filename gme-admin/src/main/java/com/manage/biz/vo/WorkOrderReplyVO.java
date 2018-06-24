package com.manage.biz.vo;


import com.manage.base.entity.BaseVO;

/**
* 工单答复表（g_work_order_reply）
功能描述：存储工单答复信息。		
查询bean
*/
public class WorkOrderReplyVO extends BaseVO{

	private static final long serialVersionUID = 1L;
	/**
	 * 主题编号
	 */
	private String subjectId;
	/**
	 * 答复者UID
	 */
	private String uid;
	/**
	 * 答复角色0-客服;1-用户(提工单者);
	 */
	private Integer type;
	
	public String getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
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
