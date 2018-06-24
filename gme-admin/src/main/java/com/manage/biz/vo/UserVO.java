package com.manage.biz.vo;


import com.manage.base.entity.BaseVO;

/**
* 用户表
功能描述：存储用户注册等相关信息查询bean
*/
public class UserVO extends BaseVO{

	private static final long serialVersionUID = 1L;

	private String name;
	private Integer isSupplier;
	private Integer status;
	private Integer isSecondVerify;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getIsSupplier() {
		return isSupplier;
	}
	public void setIsSupplier(Integer isSupplier) {
		this.isSupplier = isSupplier;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getIsSecondVerify() {
		return isSecondVerify;
	}
	public void setIsSecondVerify(Integer isSecondVerify) {
		this.isSecondVerify = isSecondVerify;
	}
}
