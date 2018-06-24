package com.manage.biz.entity;
import java.io.Serializable;
/**
 *	表名：g_notice
 *  注释:通知公告表（g_notice）
功能描述：存储通知公告信息。

 */
 
public class Notice implements Serializable{
	private static final long serialVersionUID = 1L;
	/**编号*/	
	private java.lang.String noticeId;
	/**类型*/	
	private java.lang.Integer type;
	/**标题*/	
	private java.lang.String titleCN;
	/**标题(英文)*/	
	private java.lang.String titleEN;
	/**内容*/	
	private java.lang.String txtIdCN;
	/**内容(英文)*/	
	private java.lang.String txtIdEN;
	/**来源*/	
	private java.lang.String source;
	/**操作人*/	
	private java.lang.String sysUid;
	/**操作人名称*/	
	private java.lang.String sysName;
	/**备注*/	
	private java.lang.String remark;
	/**数据表版本,默认1*/	
	private java.lang.Integer version;
	/**创建时间格式:yyyy-MM-dd HH:ss:mm*/	
	private java.sql.Timestamp createTime;
	/**更新时间格式:yyyy-MM-dd HH:ss:mm*/	
	private java.sql.Timestamp updatedTime;
	public java.lang.String getNoticeId() {
		return noticeId;
	}
	public void setNoticeId(java.lang.String noticeId) {
		this.noticeId = noticeId;
	}
	public java.lang.Integer getType() {
		return type;
	}
	public void setType(java.lang.Integer type) {
		this.type = type;
	}
	public java.lang.String getTitleCN() {
		return titleCN;
	}
	public void setTitleCN(java.lang.String titleCN) {
		this.titleCN = titleCN;
	}
	public java.lang.String getTitleEN() {
		return titleEN;
	}
	public void setTitleEN(java.lang.String titleEN) {
		this.titleEN = titleEN;
	}
	public java.lang.String getTxtIdCN() {
		return txtIdCN;
	}
	public void setTxtIdCN(java.lang.String txtIdCN) {
		this.txtIdCN = txtIdCN;
	}
	public java.lang.String getTxtIdEN() {
		return txtIdEN;
	}
	public void setTxtIdEN(java.lang.String txtIdEN) {
		this.txtIdEN = txtIdEN;
	}
	public java.lang.String getSource() {
		return source;
	}
	public void setSource(java.lang.String source) {
		this.source = source;
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
}
