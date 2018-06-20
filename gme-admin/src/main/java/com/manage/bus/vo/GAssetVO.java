package com.manage.bus.vo;


import com.manage.base.entity.BaseVO;

/**
* 资产表（g_asset）
功能描述：存储用户币种资产信息。查询bean
*/
public class GAssetVO extends BaseVO{
	private static final long serialVersionUID = 1L;

	/**
	 * 用户编号
	 */
	private String uid;
	/**
	 * 资产状态  0-正常;1-冻结;
	 */
	private Integer status;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
