package com.manage.biz.vo;


import com.manage.base.entity.BaseVO;

/**
* 商家信息表（g_supplier_info）
功能描述：存储商家统计数据信息。查询bean
*/
public class SupplierInfoVO extends BaseVO{
	private static final long serialVersionUID = 1L;

	/**
	 * 商家名称
	 */
	private String supplierName;
	/**
	 * 是否认证；1-是;2-否
	 */
	private Integer isAuth;
	/**
	 * 是否是媒介币 0不是 1是
	 */
	private Integer isToken;
	/**
	 * 商家状态；1-正常;2-冻结;
	 */
	private Integer supplierStatus;
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public Integer getIsAuth() {
		return isAuth;
	}
	public void setIsAuth(Integer isAuth) {
		this.isAuth = isAuth;
	}
	public Integer getIsToken() {
		return isToken;
	}
	public void setIsToken(Integer isToken) {
		this.isToken = isToken;
	}
	public Integer getSupplierStatus() {
		return supplierStatus;
	}
	public void setSupplierStatus(Integer supplierStatus) {
		this.supplierStatus = supplierStatus;
	}
	
}

