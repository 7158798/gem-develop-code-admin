package com.manage.bus.vo;


import com.manage.base.entity.BaseVO;

/**
* 用户表
功能描述：存储用户注册等相关信息查询bean
*/
public class GUserVO extends BaseVO{

	private static final long serialVersionUID = 1L;

	private String name;
	private Integer is_supplier;
	private Integer status;
	private Integer is_second_verify;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getIs_supplier() {
		return is_supplier;
	}
	public void setIs_supplier(Integer is_supplier) {
		this.is_supplier = is_supplier;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getIs_second_verify() {
		return is_second_verify;
	}
	public void setIs_second_verify(Integer is_second_verify) {
		this.is_second_verify = is_second_verify;
	}

}
