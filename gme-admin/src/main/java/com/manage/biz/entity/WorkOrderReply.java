package com.manage.biz.entity;
import java.io.Serializable;
/**
 *	表名：g_work_order_reply
 *  注释:工单答复表（g_work_order_reply）
功能描述：存储工单答复信息。		

 */
 
public class WorkOrderReply implements Serializable{
	private static final long serialVersionUID = 1L;
	/**答复编号*/	
	private java.lang.String replyId;
	/**主题编号*/	
	private java.lang.String subjectId;
	/**答复内容*/	
	private java.lang.String content;
	/**图片编号,存储图片文件数据,表(g_image_info)的img_id;多张图片使用半角英文分号隔开(;)，最多3张*/	
	private java.lang.String replyImgId;
	/**答复角色0-客服;1-用户(提工单者);*/	
	private java.lang.Integer type;
	/**答复者UID*/	
	private java.lang.String uid;
	/**答复者*/	
	private java.lang.String name;
	/**备注*/	
	private java.lang.String remark;
	/**数据表版本,默认1*/	
	private java.lang.Integer version;
	/**创建时间格式:yyyy-MM-dd HH:ss:mm*/	
	private java.sql.Timestamp createTime;
	/**更新时间格式:yyyy-MM-dd HH:ss:mm*/	
	private java.sql.Timestamp updatedTime;
	
	/**图片url*/
	private String replyImg;

	public java.lang.String getReplyId() {
		return replyId;
	}

	public void setReplyId(java.lang.String replyId) {
		this.replyId = replyId;
	}

	public java.lang.String getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(java.lang.String subjectId) {
		this.subjectId = subjectId;
	}

	public java.lang.String getContent() {
		return content;
	}

	public void setContent(java.lang.String content) {
		this.content = content;
	}

	public java.lang.String getReplyImgId() {
		return replyImgId;
	}

	public void setReplyImgId(java.lang.String replyImgId) {
		this.replyImgId = replyImgId;
	}

	public java.lang.Integer getType() {
		return type;
	}

	public void setType(java.lang.Integer type) {
		this.type = type;
	}

	public java.lang.String getUid() {
		return uid;
	}

	public void setUid(java.lang.String uid) {
		this.uid = uid;
	}

	public java.lang.String getName() {
		return name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}

	public java.lang.String getRemark() {
		return remark;
	}

	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}

	public java.lang.Integer getVersion() {
		return version;
	}

	public void setVersion(java.lang.Integer version) {
		this.version = version;
	}

	public java.sql.Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(java.sql.Timestamp createTime) {
		this.createTime = createTime;
	}

	public java.sql.Timestamp getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(java.sql.Timestamp updatedTime) {
		this.updatedTime = updatedTime;
	}

	public String getReplyImg() {
		return replyImg;
	}

	public void setReplyImg(String replyImg) {
		this.replyImg = replyImg;
	}
	
}
