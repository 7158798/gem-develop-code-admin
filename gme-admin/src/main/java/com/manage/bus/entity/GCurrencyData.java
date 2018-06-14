package com.manage.bus.entity;
import java.io.Serializable;
/**
 *	表名：g_currency_data
 *  注释:币种资料表（g_currency_data）
 */
public class GCurrencyData implements Serializable{
	
	private static final long serialVersionUID = 1L;
	/**币种编号*/	
	private java.lang.String data_id;
	/**文本编号*/	
	private java.lang.String data_text_id;
	/**币种简介*/	
	private java.lang.String data_brief;
	/**备注*/	
	private java.lang.String remark;
	/**数据表版本,默认1*/	
	private java.lang.Integer version;
	/**创建时间格式:yyyy-MM-dd HH:ss:mm*/	
	private java.sql.Timestamp create_time;
	/**更新时间格式:yyyy-MM-dd HH:ss:mm*/	
	private java.sql.Timestamp updated_time;
	
	public void setData_id(java.lang.String data_id){
		this.data_id=data_id;
	}
	public java.lang.String getData_id(){
		return this.data_id;
	}
	public void setData_text_id(java.lang.String data_text_id){
		this.data_text_id=data_text_id;
	}
	public java.lang.String getData_text_id(){
		return this.data_text_id;
	}
	public void setData_brief(java.lang.String data_brief){
		this.data_brief=data_brief;
	}
	public java.lang.String getData_brief(){
		return this.data_brief;
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
