package com.manage.bus.dao;

import java.util.List;
import java.util.Map;
import com.manage.base.annotation.MyBatisDao;
import org.springframework.stereotype.Component;
import com.manage.bus.entity.GAccount;
/**
 * 账户表（g_account）
功能描述：存储用户账户信息。 DAO
 */
@MyBatisDao
@Component("GAccountDAO")
public interface GAccountDAO{
	/**
	 * 获取分页数据
	 */
	public List<GAccount> selectPage(Map<String,Object> map) throws Exception;
	/**
	 * 获取分页数据数量
	 */
	public Integer selectPageCount(Map<String,Object> map) throws Exception;
	/**
	 * 获取一条信息
	 */
	public GAccount getById(java.lang.String uid) throws Exception;
	/**
	 * 修改一条信息
	 */
	public Integer update(GAccount g_account) throws Exception;
	/**
	 * 新增一条信息
	 */
	public Integer add(GAccount g_account)throws Exception;
	/**
	 * 删除一条信息
	 */
	public Integer deleteById(java.lang.String uid) throws Exception;
	/**
	 * 获取所有数据
	 */
	public List<GAccount> selectAll(Map<String,Object> map) throws Exception;
}