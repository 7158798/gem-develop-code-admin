package com.manage.biz.entity;
import java.io.Serializable;
/**
 *	表名：g_login_log
 *  注释:登录日志表（g_login_log）
功能描述：存储用户登录日志信息。

 */
 
public class GLoginLog implements Serializable{
	private static final long serialVersionUID = 1L;
	/**编号*/	
	private java.lang.String log_id;
	/**用户编号*/	
	private java.lang.String uid;
	/**登录账号*/	
	private java.lang.String account;
	/**IP*/	
	private java.lang.String login_ip;
	/**IP归属地址*/	
	private java.lang.String home_address;
	/**登录客户端pc / ios / ard*/	
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
	
	public void setLog_id(java.lang.String log_id){
		this.log_id=log_id;
	}
	public java.lang.String getLog_id(){
		return this.log_id;
	}
	public void setUid(java.lang.String uid){
		this.uid=uid;
	}
	public java.lang.String getUid(){
		return this.uid;
	}
	public void setAccount(java.lang.String account){
		this.account=account;
	}
	public java.lang.String getAccount(){
		return this.account;
	}
	public void setLogin_ip(java.lang.String login_ip){
		this.login_ip=login_ip;
	}
	public java.lang.String getLogin_ip(){
		return this.login_ip;
	}
	public void setHome_address(java.lang.String home_address){
		this.home_address=home_address;
	}
	public java.lang.String getHome_address(){
		return this.home_address;
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
