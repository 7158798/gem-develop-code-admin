package com.manage.bus.dao;

import java.util.List;
import java.util.Map;
import com.manage.base.annotation.MyBatisDao;
import org.springframework.stereotype.Component;
import com.manage.bus.entity.GLoginLog;
/**
 * 登录日志表（g_login_log）
功能描述：存储用户登录日志信息。
 DAO
 */
@MyBatisDao
@Component("GLoginLogDAO")
public interface GLoginLogDAO{
	/**
	 * 获取分页数据
	 */
	public List<GLoginLog> selectPage(Map<String,Object> map) throws Exception;
	/**
	 * 获取分页数据数量
	 */
	public Integer selectPageCount(Map<String,Object> map) throws Exception;
	/**
	 * 获取一条信息
	 */
	public GLoginLog getById(java.lang.String log_id) throws Exception;
	/**
	 * 修改一条信息
	 */
	public Integer update(GLoginLog g_login_log) throws Exception;
	/**
	 * 新增一条信息
	 */
	public Integer add(GLoginLog g_login_log)throws Exception;
	/**
	 * 删除一条信息
	 */
	public Integer deleteById(java.lang.String log_id) throws Exception;
	/**
	 * 获取所有数据
	 */
	public List<GLoginLog> selectAll(Map<String,Object> map) throws Exception;
}