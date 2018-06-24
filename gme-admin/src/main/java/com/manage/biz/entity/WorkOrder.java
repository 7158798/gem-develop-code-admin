package com.manage.biz.entity;
import java.io.Serializable;
/**
 *	表名：g_work_order
 *  注释:工单表（g_work_order）
功能描述：存储工单信息。

 */
 
public class WorkOrder implements Serializable{
	private static final long serialVersionUID = 1L;
	/**工单编号*/	
	private java.lang.String subjectId;
	/**工单ID*/	
	private java.lang.String workId;
	/**工单主题*/	
	private java.lang.String subject;
	/**工单类型1充值;2提现;3申诉;4仲裁;5其他*/	
	private java.lang.Integer workType;
	/**币种类型*/	
	private java.lang.String currencyId;
	/**业务编号如充值,提现和交易的编号*/	
	private java.lang.String bizId;
	/**内容编号存储大文本数据表(g_text)的编号 txt_id*/	
	private java.lang.String workContent;
	/**图片编号存储图片文件数据表(g_image_info)的img_id;多张图片使用半角英文分号隔开(;)，最多3张*/	
	private java.lang.String workImgId;
	/**提交用户*/	
	private java.lang.String uid;
	/**账户ID*/	
	private java.lang.String accountId;
	/**手机号*/	
	private java.lang.String phoneCode;
	/**用户名称*/	
	private java.lang.String name;
	/**提交时间*/	
	private java.sql.Timestamp submitTime;
	/**处理客服*/	
	private java.lang.String sysUid;
	/**客服名称*/	
	private java.lang.String sysName;
	/**处理时间*/	
	private java.sql.Timestamp finishedTime;
	/**工单状态1-未处理;2-处理中;3-已处理;*/	
	private java.lang.Integer workStatus;
	/**答复限制往来次数限制*/	
	private java.lang.Integer replyLimit;
	/**备注*/	
	private java.lang.String remark;
	/**数据表版本,默认1*/	
	private java.lang.Integer version;
	/**创建时间格式:yyyy-MM-dd HH:ss:mm*/	
	private java.sql.Timestamp createTime;
	/**更新时间格式:yyyy-MM-dd HH:ss:mm*/	
	private java.sql.Timestamp updatedTime;
	
	/**图片url,可能有多个url用;隔开*/
	private String workImg;

	public java.lang.String getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(java.lang.String subjectId) {
		this.subjectId = subjectId;
	}

	public java.lang.String getWorkId() {
		return workId;
	}

	public void setWorkId(java.lang.String workId) {
		this.workId = workId;
	}

	public java.lang.String getSubject() {
		return subject;
	}

	public void setSubject(java.lang.String subject) {
		this.subject = subject;
	}

	public java.lang.Integer getWorkType() {
		return workType;
	}

	public void setWorkType(java.lang.Integer workType) {
		this.workType = workType;
	}

	public java.lang.String getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(java.lang.String currencyId) {
		this.currencyId = currencyId;
	}

	public java.lang.String getBizId() {
		return bizId;
	}

	public void setBizId(java.lang.String bizId) {
		this.bizId = bizId;
	}

	public java.lang.String getWorkContent() {
		return workContent;
	}

	public void setWorkContent(java.lang.String workContent) {
		this.workContent = workContent;
	}

	public java.lang.String getWorkImgId() {
		return workImgId;
	}

	public void setWorkImgId(java.lang.String workImgId) {
		this.workImgId = workImgId;
	}

	public java.lang.String getUid() {
		return uid;
	}

	public void setUid(java.lang.String uid) {
		this.uid = uid;
	}

	public java.lang.String getAccountId() {
		return accountId;
	}

	public void setAccountId(java.lang.String accountId) {
		this.accountId = accountId;
	}

	public java.lang.String getPhoneCode() {
		return phoneCode;
	}

	public void setPhoneCode(java.lang.String phoneCode) {
		this.phoneCode = phoneCode;
	}

	public java.lang.String getName() {
		return name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}

	public java.sql.Timestamp getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(java.sql.Timestamp submitTime) {
		this.submitTime = submitTime;
	}

	public java.lang.String getSysUid() {
		return sysUid;
	}

	public void setSysUid(java.lang.String sysUid) {
		this.sysUid = sysUid;
	}

	public java.lang.String getSysName() {
		return sysName;
	}

	public void setSysName(java.lang.String sysName) {
		this.sysName = sysName;
	}

	public java.sql.Timestamp getFinishedTime() {
		return finishedTime;
	}

	public void setFinishedTime(java.sql.Timestamp finishedTime) {
		this.finishedTime = finishedTime;
	}

	public java.lang.Integer getWorkStatus() {
		return workStatus;
	}

	public void setWorkStatus(java.lang.Integer workStatus) {
		this.workStatus = workStatus;
	}

	public java.lang.Integer getReplyLimit() {
		return replyLimit;
	}

	public void setReplyLimit(java.lang.Integer replyLimit) {
		this.replyLimit = replyLimit;
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

	public String getWorkImg() {
		return workImg;
	}

	public void setWorkImg(String workImg) {
		this.workImg = workImg;
	}
}
