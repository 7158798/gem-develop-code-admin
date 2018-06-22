package com.manage.biz.entity;
import java.io.Serializable;
/**
 *	表名：g_operation_log
 *  注释:操作日志表（g_operation_log）
功能描述：存储用户业务操作日志信息。

 */
 
public class GOperationLog implements Serializable{
	private static final long serialVersionUID = 1L;
	/**编号*/	
	private java.lang.String id;
	/**业务类型*/	
	private java.lang.Integer biz_type;
	/**业务编号*/	
	private java.lang.String biz_id;
	/**业务描述*/	
	private java.lang.String biz_desc;
	/**客户端IP*/	
	private java.lang.String client_ip;
	/**用户编号*/	
	private java.lang.String uid;
	/**客户端类型 pc / ios / ard*/	
	private java.lang.String client_type;
	/**HTTP信息	*/	
	private java.lang.String http_user_agent;
	/**状态success  / failed.*/	
	private java.lang.String status;
	/**异常信息*/	
	private java.lang.String error_reason;
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
	public void setBiz_type(java.lang.Integer biz_type){
		this.biz_type=biz_type;
	}
	public java.lang.Integer getBiz_type(){
		return this.biz_type;
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
	public void setClient_ip(java.lang.String client_ip){
		this.client_ip=client_ip;
	}
	public java.lang.String getClient_ip(){
		return this.client_ip;
	}
	public void setUid(java.lang.String uid){
		this.uid=uid;
	}
	public java.lang.String getUid(){
		return this.uid;
	}
	public void setClient_type(java.lang.String client_type){
		this.client_type=client_type;
	}
	public java.lang.String getClient_type(){
		return this.client_type;
	}
	public void setHttp_user_agent(java.lang.String http_user_agent){
		this.http_user_agent=http_user_agent;
	}
	public java.lang.String getHttp_user_agent(){
		return this.http_user_agent;
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
