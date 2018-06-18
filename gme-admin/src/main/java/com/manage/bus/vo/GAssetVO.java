package com.manage.bus.vo;


import com.manage.base.entity.BaseVO;

/**
* 资产表（g_asset）
功能描述：存储用户币种资产信息。查询bean
*/
public class GAssetVO extends BaseVO{
	private static final long serialVersionUID = 1L;

	/**
	 * 资产状态  0-正常;1-冻结;
	 */
	private Integer status;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}