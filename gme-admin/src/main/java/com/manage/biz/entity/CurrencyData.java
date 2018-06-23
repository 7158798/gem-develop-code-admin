package com.manage.biz.entity;
import java.io.Serializable;
/**
 *	表名：g_currency_data
 *  注释:币种资料表（g_currency_data）
 */
public class CurrencyData implements Serializable{
	
	private static final long serialVersionUID = 1L;
	/**币种编号*/	
	private java.lang.String dataId;
	/**文本编号*/	
	private java.lang.String dataTextId;
	/**币种简介*/	
	private java.lang.String dataBrief;
	/**备注*/	
	private java.lang.String remark;
	/**数据表版本,默认1*/	
	private java.lang.Integer version;
	/**创建时间格式:yyyy-MM-dd HH:ss:mm*/	
	private java.sql.Timestamp createTime;
	/**更新时间格式:yyyy-MM-dd HH:ss:mm*/	
	private java.sql.Timestamp updatedTime;
	public java.lang.String getDataId() {
		return dataId;
	}
	public void setDataId(java.lang.String dataId) {
		this.dataId = dataId;
	}
	public java.lang.String getDataTextId() {
		return dataTextId;
	}
	public void setDataTextId(java.lang.String dataTextId) {
		this.dataTextId = dataTextId;
	}
	public java.lang.String getDataBrief() {
		return dataBrief;
	}
	public void setDataBrief(java.lang.String dataBrief) {
		this.dataBrief = dataBrief;
	}
	public java.lang.String getRemark() {
		return remark;
	}
	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}
	public java.lang.Integer getVersion() {
		return version;
	}
	public void setVersion(java.lang.Integer version) {
		this.version = version;
	}
	public java.sql.Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(java.sql.Timestamp createTime) {
		this.createTime = createTime;
	}
	public java.sql.Timestamp getUpdatedTime() {
		return updatedTime;
	}
	public void setUpdatedTime(java.sql.Timestamp updatedTime) {
		this.updatedTime = updatedTime;
	}
	
}
