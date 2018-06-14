package com.manage.bus.entity;
import java.io.Serializable;
/**
 *	表名：g_identity_auth
 *  注释:身份认证表（g_identity_auth）
功能描述：存储用户身份认证信息。
 */
 
public class GIdentityAuth implements Serializable{
	private static final long serialVersionUID = 1L;
	/**认证编号*/	
	private java.lang.String auth_id;
	/**用户编号*/	
	private java.lang.String uid;
	/**真实姓名*/	
	private java.lang.String real_name;
	/**证件类型:1-身份证;2-护照;3-军官证;4-台湾居民通行证;5-港澳居民通行证;*/	
	private java.lang.Integer certificate_type;
	/**证件号码*/	
	private java.lang.String certificate_number;
	/**是否是认证商家true/false*/	
	private java.lang.Integer is_auth_supplier;
	/**证件背面图片编号*/	
	private java.lang.String reverse_img_id;
	/**证件证面图片编号*/	
	private java.lang.String front_img_id;
	/**手持证件图片编号*/	
	private java.lang.String in_hand_img_id;
	/**认证状态:1-未认证;2-认证中;3-已通过认证;4-未通过认证;*/	
	private java.lang.Integer auth_status;
	/**反馈*/	
	private java.lang.String feedback;
	/**记录状态0-正常;1-异常;*/	
	private java.lang.Integer status;
	/**备注*/	
	private java.lang.String remark;
	/**数据表版本,默认1*/	
	private java.lang.Integer version;
	/**创建时间格式:yyyy-MM-dd HH:ss:mm*/	
	private java.sql.Timestamp create_time;
	/**更新时间格式:yyyy-MM-dd HH:ss:mm*/	
	private java.sql.Timestamp updated_time;
	
	public void setAuth_id(java.lang.String auth_id){
		this.auth_id=auth_id;
	}
	public java.lang.String getAuth_id(){
		return this.auth_id;
	}
	public void setUid(java.lang.String uid){
		this.uid=uid;
	}
	public java.lang.String getUid(){
		return this.uid;
	}
	public void setReal_name(java.lang.String real_name){
		this.real_name=real_name;
	}
	public java.lang.String getReal_name(){
		return this.real_name;
	}
	public void setCertificate_number(java.lang.String certificate_number){
		this.certificate_number=certificate_number;
	}
	public java.lang.String getCertificate_number(){
		return this.certificate_number;
	}
	public void setReverse_img_id(java.lang.String reverse_img_id){
		this.reverse_img_id=reverse_img_id;
	}
	public java.lang.String getReverse_img_id(){
		return this.reverse_img_id;
	}
	public void setFront_img_id(java.lang.String front_img_id){
		this.front_img_id=front_img_id;
	}
	public java.lang.String getFront_img_id(){
		return this.front_img_id;
	}
	public void setIn_hand_img_id(java.lang.String in_hand_img_id){
		this.in_hand_img_id=in_hand_img_id;
	}
	public java.lang.String getIn_hand_img_id(){
		return this.in_hand_img_id;
	}
	public void setFeedback(java.lang.String feedback){
		this.feedback=feedback;
	}
	public java.lang.String getFeedback(){
		return this.feedback;
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
	public java.lang.Integer getCertificate_type() {
		return certificate_type;
	}
	public void setCertificate_type(java.lang.Integer certificate_type) {
		this.certificate_type = certificate_type;
	}
	public java.lang.Integer getIs_auth_supplier() {
		return is_auth_supplier;
	}
	public void setIs_auth_supplier(java.lang.Integer is_auth_supplier) {
		this.is_auth_supplier = is_auth_supplier;
	}
	public java.lang.Integer getStatus() {
		return status;
	}
	public void setStatus(java.lang.Integer status) {
		this.status = status;
	}
	public java.lang.Integer getAuth_status() {
		return auth_status;
	}
	public void setAuth_status(java.lang.Integer auth_status) {
		this.auth_status = auth_status;
	}
	@Override
	public String toString() {
		return "GIdentityAuth [auth_id=" + auth_id + ", uid=" + uid + ", real_name=" + real_name + ", certificate_type="
				+ certificate_type + ", certificate_number=" + certificate_number + ", is_auth_supplier="
				+ is_auth_supplier + ", reverse_img_id=" + reverse_img_id + ", front_img_id=" + front_img_id
				+ ", in_hand_img_id=" + in_hand_img_id + ", auth_status=" + auth_status + ", feedback=" + feedback
				+ ", status=" + status + ", remark=" + remark + ", version=" + version + ", create_time=" + create_time
				+ ", updated_time=" + updated_time + "]";
	}
	
}
