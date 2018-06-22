package com.manage.biz.vo;


import com.manage.base.entity.BaseVO;

/**
* 商家信息表（g_supplier_info）
功能描述：存储商家统计数据信息。查询bean
*/
public class GSupplierInfoVO extends BaseVO{
	private static final long serialVersionUID = 1L;

	/**
	 * 商家名称
	 */
	private String supplier_name;
	/**
	 * 是否认证；1-是;2-否
	 */
	private Integer is_auth;
	/**
	 * 是否是媒介币 0不是 1是
	 */
	private Integer is_token;
	/**
	 * 商家状态；1-正常;2-冻结;
	 */
	private Integer supplier_status;
	public String getSupplier_name() {
		return supplier_name;
	}
	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}
	public Integer getIs_auth() {
		return is_auth;
	}
	public void setIs_auth(Integer is_auth) {
		this.is_auth = is_auth;
	}
	public Integer getIs_token() {
		return is_token;
	}
	public void setIs_token(Integer is_token) {
		this.is_token = is_token;
	}
	public Integer getSupplier_status() {
		return supplier_status;
	}
	public void setSupplier_status(Integer supplier_status) {
		this.supplier_status = supplier_status;
	}
}
