package com.manage.bus.vo;


import com.manage.base.entity.BaseVO;

/**
* 通知公告表（g_notice）
功能描述：存储通知公告信息。
查询bean
*/
public class GNoticeVO extends BaseVO{

	private static final long serialVersionUID = 1L;
	/**
	 * 操作人名称
	 */
	private String sys_name;
	/**
	 * 公告类型
	 */
	private String type;
	public String getSys_name() {
		return sys_name;
	}
	public void setSys_name(String sys_name) {
		this.sys_name = sys_name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}