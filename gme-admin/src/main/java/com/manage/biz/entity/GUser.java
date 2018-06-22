package com.manage.biz.entity;
import java.io.Serializable;
/**
 *	表名：g_user
 *  注释:用户表
功能描述：存储用户注册等相关信息
 */
 
public class GUser implements Serializable{
	private static final long serialVersionUID = 1L;
	/**用户编号GUID*/	
	private java.lang.String uid;
	/**用户名称*/	
	private java.lang.String name;
	/**登录密码；采用秘钥加密控制:*/	
	private java.lang.String password;
	/**国家号码；手机号前缀国家号码*/	
	private java.lang.String country_code;
	/**用户手机；需要验证手机号格式*/	
	private java.lang.String phone_code;
	/**用户邮箱；需要验证邮件地址格式*/	
	private java.lang.String mail;
	/**是否是商户:0-不是;1-是.默认0*/	
	private java.lang.Integer is_supplier;
	/**资金密码*/	
	private java.lang.String trade_auth;
	/**最后登录时间*/	
	private java.sql.Timestamp last_login_time;
	/**是否修改过密码,true-修改过;false-未修改过;默认false*/	
	private java.lang.Integer is_change_password;
	/**连续输错密码的次数*/	
	private java.lang.Integer password_input_error_count;
	/**推广码*/	
	private java.lang.String promo_code;
	/**用户状态,用户账号状态(1/2)1-正常; 2-冻结;*/	
	private java.lang.Integer status;
	/**是否开启二次验证1-不需要;2-需要;*/	
	private java.lang.Integer is_second_verify;
	/**备注*/	
	private java.lang.String remark;
	/**数据表版本,默认1*/	
	private java.lang.Integer version;
	/**创建时间格式:yyyy-MM-dd HH:ss:mm*/	
	private java.sql.Timestamp create_time;
	/**更新时间格式:yyyy-MM-dd HH:ss:mm*/	
	private java.sql.Timestamp updated_time;
	
	public void setUid(java.lang.String uid){
		this.uid=uid;
	}
	public java.lang.String getUid(){
		return this.uid;
	}
	public void setName(java.lang.String name){
		this.name=name;
	}
	public java.lang.String getName(){
		return this.name;
	}
	public void setPassword(java.lang.String password){
		this.password=password;
	}
	public java.lang.String getPassword(){
		return this.password;
	}
	public void setCountry_code(java.lang.String country_code){
		this.country_code=country_code;
	}
	public java.lang.String getCountry_code(){
		return this.country_code;
	}
	public void setPhone_code(java.lang.String phone_code){
		this.phone_code=phone_code;
	}
	public java.lang.String getPhone_code(){
		return this.phone_code;
	}
	public void setMail(java.lang.String mail){
		this.mail=mail;
	}
	public java.lang.String getMail(){
		return this.mail;
	}
	public void setTrade_auth(java.lang.String trade_auth){
		this.trade_auth=trade_auth;
	}
	public java.lang.String getTrade_auth(){
		return this.trade_auth;
	}
	public void setLast_login_time(java.sql.Timestamp last_login_time){
		this.last_login_time=last_login_time;
	}
	public java.sql.Timestamp getLast_login_time(){
		return this.last_login_time;
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
	public java.lang.Integer getIs_supplier() {
		return is_supplier;
	}
	public void setIs_supplier(java.lang.Integer is_supplier) {
		this.is_supplier = is_supplier;
	}
	public java.lang.Integer getIs_change_password() {
		return is_change_password;
	}
	public void setIs_change_password(java.lang.Integer is_change_password) {
		this.is_change_password = is_change_password;
	}
	public java.lang.Integer getPassword_input_error_count() {
		return password_input_error_count;
	}
	public void setPassword_input_error_count(java.lang.Integer password_input_error_count) {
		this.password_input_error_count = password_input_error_count;
	}
	public java.lang.String getPromo_code() {
		return promo_code;
	}
	public void setPromo_code(java.lang.String promo_code) {
		this.promo_code = promo_code;
	}
	public java.lang.Integer getStatus() {
		return status;
	}
	public void setStatus(java.lang.Integer status) {
		this.status = status;
	}
	public java.lang.Integer getIs_second_verify() {
		return is_second_verify;
	}
	public void setIs_second_verify(java.lang.Integer is_second_verify) {
		this.is_second_verify = is_second_verify;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
