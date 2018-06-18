package com.manage.bus.entity;
import java.io.Serializable;
/**
 *	表名：g_asset
 *  注释:资产表（g_asset）
功能描述：存储用户币种资产信息。
 */
 
public class GAsset implements Serializable{
	/**资产编号*/	
	private java.lang.String asset_id;
	/**用户编号*/	
	private java.lang.String uid;
	/**账号ID；用户账号ID，全局唯一*/	
	private java.lang.Integer account_id;
	/**币种*/	
	private java.lang.String currency_id;
	/**总资产*/	
	private java.math.BigDecimal total_assets;
	/**可用资产*/	
	private java.math.BigDecimal usable_assets;
	/**冻结资产*/	
	private java.math.BigDecimal frozen_assets;
	/**0-正常;1-冻结;*/	
	private java.lang.Integer status;
	/**token生成规则：MD5(key+uid+account_id+currency_id+total_assets+*/	
	private java.lang.String token;
	/**备注*/	
	private java.lang.String remark;
	/**数据表版本,默认1*/	
	private java.lang.Integer version;
	/**创建时间格式:yyyy-MM-dd HH:ss:mm*/	
	private java.sql.Timestamp create_time;
	/**更新时间格式:yyyy-MM-dd HH:ss:mm*/	
	private java.sql.Timestamp updated_time;
	
	public void setAsset_id(java.lang.String asset_id){
		this.asset_id=asset_id;
	}
	public java.lang.String getAsset_id(){
		return this.asset_id;
	}
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
	public void setCurrency_id(java.lang.String currency_id){
		this.currency_id=currency_id;
	}
	public java.lang.String getCurrency_id(){
		return this.currency_id;
	}
	public void setTotal_assets(java.math.BigDecimal total_assets){
		this.total_assets=total_assets;
	}
	public java.math.BigDecimal getTotal_assets(){
		return this.total_assets;
	}
	public void setUsable_assets(java.math.BigDecimal usable_assets){
		this.usable_assets=usable_assets;
	}
	public java.math.BigDecimal getUsable_assets(){
		return this.usable_assets;
	}
	public void setFrozen_assets(java.math.BigDecimal frozen_assets){
		this.frozen_assets=frozen_assets;
	}
	public java.math.BigDecimal getFrozen_assets(){
		return this.frozen_assets;
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
	public java.lang.Integer getStatus() {
		return status;
	}
	public void setStatus(java.lang.Integer status) {
		this.status = status;
	}
	
}
