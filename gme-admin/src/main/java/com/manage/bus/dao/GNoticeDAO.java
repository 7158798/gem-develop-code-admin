package com.manage.bus.dao;

import java.util.List;
import java.util.Map;
import com.manage.base.annotation.MyBatisDao;
import org.springframework.stereotype.Component;
import com.manage.bus.entity.GNotice;
/**
 * 通知公告表（g_notice）
功能描述：存储通知公告信息。
 DAO
 */
@MyBatisDao
@Component("GNoticeDAO")
public interface GNoticeDAO{
	/**
	 * 获取分页数据
	 */
	public List<GNotice> selectPage(Map<String,Object> map) throws Exception;
	/**
	 * 获取分页数据数量
	 */
	public Integer selectPageCount(Map<String,Object> map) throws Exception;
	/**
	 * 获取一条信息
	 */
	public GNotice getById(java.lang.String notice_id) throws Exception;
	/**
	 * 修改一条信息
	 */
	public Integer update(GNotice g_notice) throws Exception;
	/**
	 * 新增一条信息
	 */
	public Integer add(GNotice g_notice)throws Exception;
	/**
	 * 删除一条信息
	 */
	public Integer deleteById(java.lang.String notice_id) throws Exception;
	/**
	 * 获取所有数据
	 */
	public List<GNotice> selectAll(Map<String,Object> map) throws Exception;
}