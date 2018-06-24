package com.manage.biz.vo;


import com.manage.base.entity.BaseVO;

/**
* 通知公告表（g_notice）
功能描述：存储通知公告信息。
查询bean
*/
public class NoticeVO extends BaseVO{

	private static final long serialVersionUID = 1L;
	/**
	 * 操作人名称
	 */
	private String sysName;
	/**
	 * 公告类型
	 */
	private String type;
	
	public String getSysName() {
		return sysName;
	}
	public void setSysName(String sysName) {
		this.sysName = sysName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}