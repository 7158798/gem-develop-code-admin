package com.manage.biz.entity;
import java.io.Serializable;
/**
 *	表名：g_supplier_info
 *  注释:商家信息表（g_supplier_info）
功能描述：存储商家统计数据信息。
 */
 
public class GSupplierInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	/***/	
	private java.lang.String uid;
	/**商家名称*/	
	private java.lang.String supplier_name;
	/**是否认证；1-是;2-否*/	
	private java.lang.Integer is_auth;
	/**币种类型*/	
	private java.lang.String currency_id;
	/**币种符号*/	
	private java.lang.String currency_symbol;
	/**订单总数*/	
	private java.lang.Integer total_number;
	/**总成交数*/	
	private java.lang.Integer total_deal_number;
	/**取消次数；每天最多取消三次，超过次数禁止OTC交易（系统撤销订单除外）*/	
	private java.lang.Integer cancel_time;
	/**被投诉次数；投诉5次或以上，禁止OTC交易*/	
	private java.lang.Integer complained_number;
	/**保证金*/	
	private java.math.BigDecimal deposit;
	/**被冻结的保证金*/	
	private java.math.BigDecimal frozen_deposit;
	/**商家状态；1-正常;2-冻结;*/	
	private java.lang.Integer supplier_status;
	/**token生成规则：MD5(key+uid+is_auth+total_number+total_deal_number+cancel_time+complained_number+deposit+frozen_deposit); 程序操作记录行均需要生成token与该字段进行验证*/	
	private java.lang.String token;
	/**备注*/	
	private java.lang.String remark;
	/**数据表版本,默认1*/	
	private java.lang.Integer version;
	/**创建时间格式:yyyy-MM-dd HH:ss:mm*/	
	private java.sql.Timestamp create_time;
	/**更新时间格式:yyyy-MM-dd HH:ss:mm*/	
	private java.sql.Timestamp updated_time;
	
	/**
	 * 是否是媒介币 0不是 1是
	 */
	private Integer is_token;
	
	public Integer getIs_token() {
		return is_token;
	}
	public void setIs_token(Integer is_token) {
		this.is_token = is_token;
	}
	public void setUid(java.lang.String uid){
		this.uid=uid;
	}
	public java.lang.String getUid(){
		return this.uid;
	}
	public void setSupplier_name(java.lang.String supplier_name){
		this.supplier_name=supplier_name;
	}
	public java.lang.String getSupplier_name(){
		return this.supplier_name;
	}
	public void setIs_auth(java.lang.Integer is_auth){
		this.is_auth=is_auth;
	}
	public java.lang.Integer getIs_auth(){
		return this.is_auth;
	}
	public void setCurrency_id(java.lang.String currency_id){
		this.currency_id=currency_id;
	}
	public java.lang.String getCurrency_id(){
		return this.currency_id;
	}
	public void setCurrency_symbol(java.lang.String currency_symbol){
		this.currency_symbol=currency_symbol;
	}
	public java.lang.String getCurrency_symbol(){
		return this.currency_symbol;
	}
	public void setTotal_number(java.lang.Integer total_number){
		this.total_number=total_number;
	}
	public java.lang.Integer getTotal_number(){
		return this.total_number;
	}
	public void setTotal_deal_number(java.lang.Integer total_deal_number){
		this.total_deal_number=total_deal_number;
	}
	public java.lang.Integer getTotal_deal_number(){
		return this.total_deal_number;
	}
	public void setCancel_time(java.lang.Integer cancel_time){
		this.cancel_time=cancel_time;
	}
	public java.lang.Integer getCancel_time(){
		return this.cancel_time;
	}
	public void setComplained_number(java.lang.Integer complained_number){
		this.complained_number=complained_number;
	}
	public java.lang.Integer getComplained_number(){
		return this.complained_number;
	}
	public void setDeposit(java.math.BigDecimal deposit){
		this.deposit=deposit;
	}
	public java.math.BigDecimal getDeposit(){
		return this.deposit;
	}
	public void setFrozen_deposit(java.math.BigDecimal frozen_deposit){
		this.frozen_deposit=frozen_deposit;
	}
	public java.math.BigDecimal getFrozen_deposit(){
		return this.frozen_deposit;
	}
	public void setSupplier_status(java.lang.Integer supplier_status){
		this.supplier_status=supplier_status;
	}
	public java.lang.Integer getSupplier_status(){
		return this.supplier_status;
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
}
