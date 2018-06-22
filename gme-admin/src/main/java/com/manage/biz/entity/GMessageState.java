package com.manage.biz.entity;
import java.io.Serializable;
/**
 *	表名：g_message_state
 *  注释:短信邮件发送状态表（g_message_state）
功能描述：存储短信邮件发送状态信息。

 */
 
public class GMessageState implements Serializable{
	private static final long serialVersionUID = 1L;
	/**编号*/	
	private java.lang.String id;
	/**业务类型*/	
	private java.lang.Integer type;
	/**国家代码*/	
	private java.lang.String country_code;
	/**接收账号*/	
	private java.lang.String receiver;
	/**发送状态*/	
	private java.lang.String status;
	/**异常描述*/	
	private java.lang.String error_reason;
	/**业务编号*/	
	private java.lang.String biz_id;
	/**业务概述*/	
	private java.lang.String biz_desc;
	/**业务内容*/	
	private java.lang.String biz_content;
	/**用户编号*/	
	private java.lang.String uid;
	/**IP*/	
	private java.lang.String client_ip;
	/**备注*/	
	private java.lang.String remark;
	/**数据表版本,默认1*/	
	private java.lang.Integer version;
	/**创建时间格式:yyyy-MM-dd HH:ss:mm*/	
	private java.sql.Timestamp create_time;
	/**更新时间格式:yyyy-MM-dd HH:ss:mm*/	
	private java.sql.Timestamp updated_time;
	
	public void setId(java.lang.String id){
		this.id=id;
	}
	public java.lang.String getId(){
		return this.id;
	}
	public void setType(java.lang.Integer type){
		this.type=type;
	}
	public java.lang.Integer getType(){
		return this.type;
	}
	public void setCountry_code(java.lang.String country_code){
		this.country_code=country_code;
	}
	public java.lang.String getCountry_code(){
		return this.country_code;
	}
	public void setReceiver(java.lang.String receiver){
		this.receiver=receiver;
	}
	public java.lang.String getReceiver(){
		return this.receiver;
	}
	public void setStatus(java.lang.String status){
		this.status=status;
	}
	public java.lang.String getStatus(){
		return this.status;
	}
	public void setError_reason(java.lang.String error_reason){
		this.error_reason=error_reason;
	}
	public java.lang.String getError_reason(){
		return this.error_reason;
	}
	public void setBiz_id(java.lang.String biz_id){
		this.biz_id=biz_id;
	}
	public java.lang.String getBiz_id(){
		return this.biz_id;
	}
	public void setBiz_desc(java.lang.String biz_desc){
		this.biz_desc=biz_desc;
	}
	public java.lang.String getBiz_desc(){
		return this.biz_desc;
	}
	public void setBiz_content(java.lang.String biz_content){
		this.biz_content=biz_content;
	}
	public java.lang.String getBiz_content(){
		return this.biz_content;
	}
	public void setUid(java.lang.String uid){
		this.uid=uid;
	}
	public java.lang.String getUid(){
		return this.uid;
	}
	public void setClient_ip(java.lang.String client_ip){
		this.client_ip=client_ip;
	}
	public java.lang.String getClient_ip(){
		return this.client_ip;
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
