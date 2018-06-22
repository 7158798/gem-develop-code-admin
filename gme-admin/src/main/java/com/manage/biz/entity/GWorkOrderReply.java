package com.manage.biz.entity;
import java.io.Serializable;
/**
 *	表名：g_work_order_reply
 *  注释:工单答复表（g_work_order_reply）
功能描述：存储工单答复信息。		

 */
 
public class GWorkOrderReply implements Serializable{
	private static final long serialVersionUID = 1L;
	/**答复编号*/	
	private java.lang.String reply_id;
	/**主题编号*/	
	private java.lang.String subject_id;
	/**答复内容*/	
	private java.lang.String content;
	/**图片编号,存储图片文件数据,表(g_image_info)的img_id;多张图片使用半角英文分号隔开(;)，最多3张*/	
	private java.lang.String reply_img_id;
	/**答复角色0-客服;1-用户(提工单者);*/	
	private java.lang.Integer type;
	/**答复者UID*/	
	private java.lang.String uid;
	/**答复者*/	
	private java.lang.String name;
	/**备注*/	
	private java.lang.String remark;
	/**数据表版本,默认1*/	
	private java.lang.Integer version;
	/**创建时间格式:yyyy-MM-dd HH:ss:mm*/	
	private java.sql.Timestamp create_time;
	/**更新时间格式:yyyy-MM-dd HH:ss:mm*/	
	private java.sql.Timestamp updated_time;
	
	/**图片url*/
	private String reply_img;
	
	public void setReply_id(java.lang.String reply_id){
		this.reply_id=reply_id;
	}
	public java.lang.String getReply_id(){
		return this.reply_id;
	}
	public void setSubject_id(java.lang.String subject_id){
		this.subject_id=subject_id;
	}
	public java.lang.String getSubject_id(){
		return this.subject_id;
	}
	public void setContent(java.lang.String content){
		this.content=content;
	}
	public java.lang.String getContent(){
		return this.content;
	}
	public void setReply_img_id(java.lang.String reply_img_id){
		this.reply_img_id=reply_img_id;
	}
	public java.lang.String getReply_img_id(){
		return this.reply_img_id;
	}
	public void setType(java.lang.Integer type){
		this.type=type;
	}
	public java.lang.Integer getType(){
		return this.type;
	}
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
	public String getReply_img() {
		return reply_img;
	}
	public void setReply_img(String reply_img) {
		this.reply_img = reply_img;
	}
	
}
