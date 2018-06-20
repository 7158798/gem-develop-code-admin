package com.manage.bus.entity;
import java.io.Serializable;
/**
 *	表名：g_notice
 *  注释:通知公告表（g_notice）
功能描述：存储通知公告信息。

 */
 
public class GNotice implements Serializable{
	private static final long serialVersionUID = 1L;
	/**编号*/	
	private java.lang.String notice_id;
	/**类型*/	
	private java.lang.Integer type;
	/**标题*/	
	private java.lang.String title_cn;
	/**标题(英文)*/	
	private java.lang.String title_en;
	/**内容*/	
	private java.lang.String txt_id_cn;
	/**内容(英文)*/	
	private java.lang.String txt_id_en;
	/**来源*/	
	private java.lang.String source;
	/**操作人*/	
	private java.lang.String sys_uid;
	/**操作人名称*/	
	private java.lang.String sys_name;
	/**备注*/	
	private java.lang.String remark;
	/**数据表版本,默认1*/	
	private java.lang.Integer version;
	/**创建时间格式:yyyy-MM-dd HH:ss:mm*/	
	private java.sql.Timestamp create_time;
	/**更新时间格式:yyyy-MM-dd HH:ss:mm*/	
	private java.sql.Timestamp updated_time;
	
	public void setNotice_id(java.lang.String notice_id){
		this.notice_id=notice_id;
	}
	public java.lang.String getNotice_id(){
		return this.notice_id;
	}
	public void setType(java.lang.Integer type){
		this.type=type;
	}
	public java.lang.Integer getType(){
		return this.type;
	}
	public void setTitle_cn(java.lang.String title_cn){
		this.title_cn=title_cn;
	}
	public java.lang.String getTitle_cn(){
		return this.title_cn;
	}
	public void setTitle_en(java.lang.String title_en){
		this.title_en=title_en;
	}
	public java.lang.String getTitle_en(){
		return this.title_en;
	}
	public void setTxt_id_cn(java.lang.String txt_id_cn){
		this.txt_id_cn=txt_id_cn;
	}
	public java.lang.String getTxt_id_cn(){
		return this.txt_id_cn;
	}
	public void setTxt_id_en(java.lang.String txt_id_en){
		this.txt_id_en=txt_id_en;
	}
	public java.lang.String getTxt_id_en(){
		return this.txt_id_en;
	}
	public void setSource(java.lang.String source){
		this.source=source;
	}
	public java.lang.String getSource(){
		return this.source;
	}
	public void setSys_uid(java.lang.String sys_uid){
		this.sys_uid=sys_uid;
	}
	public java.lang.String getSys_uid(){
		return this.sys_uid;
	}
	public void setSys_name(java.lang.String sys_name){
		this.sys_name=sys_name;
	}
	public java.lang.String getSys_name(){
		return this.sys_name;
	}
	public void setRemark(java.lang.String remark){
		this.remark=remark;
	}
	public java.lang.String getRemark(){
		return this.remark;
	}
	public void setVersion(java.lang.Integer version){
		this.version=version;
	}
	public java.lang.Integer getVersion(){
		return this.version;
	}
	public void setCreate_time(java.sql.Timestamp create_time){
		this.create_time=create_time;
	}
	public java.sql.Timestamp getCreate_time(){
		return this.create_time;
	}
	public void setUpdated_time(java.sql.Timestamp updated_time){
		this.updated_time=updated_time;
	}
	public java.sql.Timestamp getUpdated_time(){
		return this.updated_time;
	}
}
