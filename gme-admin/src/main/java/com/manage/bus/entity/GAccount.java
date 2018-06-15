package com.manage.bus.entity;
import java.io.Serializable;
/**
 *	表名：g_account
 *  注释:账户表（g_account）
功能描述：存储用户账户信息。
 */
 
public class GAccount implements Serializable{
	private static final long serialVersionUID = 1L;
	/**用户编号*/	
	private java.lang.String uid;
	/**账号ID；用户账号ID，全局唯一*/	
	private java.lang.Integer account_id;
	/**真实姓名*/	
	private java.lang.String real_name;
	/**银行卡类型；1-借记卡;2-信用卡;*/	
	private java.lang.Integer card_type;
	/**银行卡号*/	
	private java.lang.String card_number;
	/**开户银行*/	
	private java.lang.String bank_name;
	/**开户支行*/	
	private java.lang.String bank_branch_name;
	/**支付宝二维码图片编号*/	
	private java.lang.String alipay_qrcode_id;
	/**支付宝账号*/	
	private java.lang.String alipay_account;
	/**支付宝绑定描述*/	
	private java.lang.String alipay_desc;
	/**微信钱包二维码图片编号*/	
	private java.lang.String wx_qrcode_id;
	/**微信账号*/	
	private java.lang.String wx_account;
	/**微信绑定描述*/	
	private java.lang.String wx_desc;
	/**转账账号1-未审核;2-通过审核;*/	
	private java.lang.Integer audit_status;
	/**账户状态1-正常;2-冻结;*/	
	private java.lang.Integer account_status;
	/**token生成规则：MD5(key+uid+account_id+card_number+alipay_qrcode_id+alipay_account+wx_qrcode_id+wx_account+audit_status); 程序操作记录行均需要生成token与该字段进行验证*/	
	private java.lang.String token;
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
	public void setAccount_id(java.lang.Integer account_id){
		this.account_id=account_id;
	}
	public java.lang.Integer getAccount_id(){
		return this.account_id;
	}
	public void setReal_name(java.lang.String real_name){
		this.real_name=real_name;
	}
	public java.lang.String getReal_name(){
		return this.real_name;
	}
	public void setCard_number(java.lang.String card_number){
		this.card_number=card_number;
	}
	public java.lang.String getCard_number(){
		return this.card_number;
	}
	public void setBank_name(java.lang.String bank_name){
		this.bank_name=bank_name;
	}
	public java.lang.String getBank_name(){
		return this.bank_name;
	}
	public void setBank_branch_name(java.lang.String bank_branch_name){
		this.bank_branch_name=bank_branch_name;
	}
	public java.lang.String getBank_branch_name(){
		return this.bank_branch_name;
	}
	public void setAlipay_qrcode_id(java.lang.String alipay_qrcode_id){
		this.alipay_qrcode_id=alipay_qrcode_id;
	}
	public java.lang.String getAlipay_qrcode_id(){
		return this.alipay_qrcode_id;
	}
	public void setAlipay_account(java.lang.String alipay_account){
		this.alipay_account=alipay_account;
	}
	public java.lang.String getAlipay_account(){
		return this.alipay_account;
	}
	public void setAlipay_desc(java.lang.String alipay_desc){
		this.alipay_desc=alipay_desc;
	}
	public java.lang.String getAlipay_desc(){
		return this.alipay_desc;
	}
	public void setWx_qrcode_id(java.lang.String wx_qrcode_id){
		this.wx_qrcode_id=wx_qrcode_id;
	}
	public java.lang.String getWx_qrcode_id(){
		return this.wx_qrcode_id;
	}
	public void setWx_account(java.lang.String wx_account){
		this.wx_account=wx_account;
	}
	public java.lang.String getWx_account(){
		return this.wx_account;
	}
	public void setWx_desc(java.lang.String wx_desc){
		this.wx_desc=wx_desc;
	}
	public java.lang.String getWx_desc(){
		return this.wx_desc;
	}
	public void setToken(java.lang.String token){
		this.token=token;
	}
	public java.lang.String getToken(){
		return this.token;
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
	public java.lang.Integer getCard_type() {
		return card_type;
	}
	public void setCard_type(java.lang.Integer card_type) {
		this.card_type = card_type;
	}
	public java.lang.Integer getAudit_status() {
		return audit_status;
	}
	public void setAudit_status(java.lang.Integer audit_status) {
		this.audit_status = audit_status;
	}
	public java.lang.Integer getAccount_status() {
		return account_status;
	}
	public void setAccount_status(java.lang.Integer account_status) {
		this.account_status = account_status;
	}
	
}
