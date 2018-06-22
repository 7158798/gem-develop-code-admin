package com.manage.biz.entity;
import java.io.Serializable;
/**
 *	表名：g_work_order
 *  注释:工单表（g_work_order）
功能描述：存储工单信息。

 */
 
public class GWorkOrder implements Serializable{
	private static final long serialVersionUID = 1L;
	/**工单编号*/	
	private java.lang.String subject_id;
	/**工单ID*/	
	private java.lang.String work_id;
	/**工单主题*/	
	private java.lang.String subject;
	/**工单类型1充值;2提现;3申诉;4仲裁;5其他*/	
	private java.lang.Integer work_type;
	/**币种类型*/	
	private java.lang.String currency_id;
	/**业务编号如充值,提现和交易的编号*/	
	private java.lang.String biz_id;
	/**内容编号存储大文本数据表(g_text)的编号 txt_id*/	
	private java.lang.String work_content;
	/**图片编号存储图片文件数据表(g_image_info)的img_id;多张图片使用半角英文分号隔开(;)，最多3张*/	
	private java.lang.String work_img_id;
	/**提交用户*/	
	private java.lang.String uid;
	/**账户ID*/	
	private java.lang.String account_id;
	/**手机号*/	
	private java.lang.String phone_code;
	/**用户名称*/	
	private java.lang.String name;
	/**提交时间*/	
	private java.sql.Timestamp submit_time;
	/**处理客服*/	
	private java.lang.String sys_uid;
	/**客服名称*/	
	private java.lang.String sys_name;
	/**处理时间*/	
	private java.sql.Timestamp finished_time;
	/**工单状态1-未处理;2-处理中;3-已处理;*/	
	private java.lang.Integer work_status;
	/**答复限制往来次数限制*/	
	private java.lang.Integer reply_limit;
	/**备注*/	
	private java.lang.String remark;
	/**数据表版本,默认1*/	
	private java.lang.Integer version;
	/**创建时间格式:yyyy-MM-dd HH:ss:mm*/	
	private java.sql.Timestamp create_time;
	/**更新时间格式:yyyy-MM-dd HH:ss:mm*/	
	private java.sql.Timestamp updated_time;
	
	/**图片url,可能有多个url用;隔开*/
	private String work_img;
	
	public void setSubject_id(java.lang.String subject_id){
		this.subject_id=subject_id;
	}
	public java.lang.String getSubject_id(){
		return this.subject_id;
	}
	public void setWork_id(java.lang.String work_id){
		this.work_id=work_id;
	}
	public java.lang.String getWork_id(){
		return this.work_id;
	}
	public void setSubject(java.lang.String subject){
		this.subject=subject;
	}
	public java.lang.String getSubject(){
		return this.subject;
	}
	public void setWork_type(java.lang.Integer work_type){
		this.work_type=work_type;
	}
	public java.lang.Integer getWork_type(){
		return this.work_type;
	}
	public void setCurrency_id(java.lang.String currency_id){
		this.currency_id=currency_id;
	}
	public java.lang.String getCurrency_id(){
		return this.currency_id;
	}
	public void setBiz_id(java.lang.String biz_id){
		this.biz_id=biz_id;
	}
	public java.lang.String getBiz_id(){
		return this.biz_id;
	}
	public void setWork_content(java.lang.String work_content){
		this.work_content=work_content;
	}
	public java.lang.String getWork_content(){
		return this.work_content;
	}
	public void setWork_img_id(java.lang.String work_img_id){
		this.work_img_id=work_img_id;
	}
	public java.lang.String getWork_img_id(){
		return this.work_img_id;
	}
	public void setUid(java.lang.String uid){
		this.uid=uid;
	}
	public java.lang.String getUid(){
		return this.uid;
	}
	public void setAccount_id(java.lang.String account_id){
		this.account_id=account_id;
	}
	public java.lang.String getAccount_id(){
		return this.account_id;
	}
	public void setPhone_code(java.lang.String phone_code){
		this.phone_code=phone_code;
	}
	public java.lang.String getPhone_code(){
		return this.phone_code;
	}
	public void setName(java.lang.String name){
		this.name=name;
	}
	public java.lang.String getName(){
		return this.name;
	}
	public void setSubmit_time(java.sql.Timestamp submit_time){
		this.submit_time=submit_time;
	}
	public java.sql.Timestamp getSubmit_time(){
		return this.submit_time;
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
	public void setFinished_time(java.sql.Timestamp finished_time){
		this.finished_time=finished_time;
	}
	public java.sql.Timestamp getFinished_time(){
		return this.finished_time;
	}
	public void setWork_status(java.lang.Integer work_status){
		this.work_status=work_status;
	}
	public java.lang.Integer getWork_status(){
		return this.work_status;
	}
	public void setReply_limit(java.lang.Integer reply_limit){
		this.reply_limit=reply_limit;
	}
	public java.lang.Integer getReply_limit(){
		return this.reply_limit;
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
	public String getWork_img() {
		return work_img;
	}
	public void setWork_img(String work_img) {
		this.work_img = work_img;
	}
	
}
