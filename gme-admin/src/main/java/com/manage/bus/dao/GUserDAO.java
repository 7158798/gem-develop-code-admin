package com.manage.bus.dao;

import java.util.List;
import java.util.Map;
import com.manage.base.annotation.MyBatisDao;
import org.springframework.stereotype.Component;
import com.manage.bus.entity.GUser;
/**
 * 用户表
功能描述：存储用户注册等相关信息 DAO
 */
@MyBatisDao
@Component("GUserDAO")
public interface GUserDAO{
	/**
	 * 获取分页数据
	 */
	public List<GUser> selectPage(Map<String,Object> map) throws Exception;
	/**
	 * 获取分页数据数量
	 */
	public Integer selectPageCount(Map<String,Object> map) throws Exception;
	/**
	 * 获取一条信息
	 */
	public GUser getById(java.lang.String uid) throws Exception;
	/**
	 * 修改一条信息
	 */
	public Integer update(GUser g_user) throws Exception;
	/**
	 * 新增一条信息
	 */
	public Integer add(GUser g_user)throws Exception;
	/**
	 * 删除一条信息
	 */
	public Integer deleteById(java.lang.String uid) throws Exception;
	/**
	 * 获取所有数据
	 */
	public List<GUser> selectAll(Map<String,Object> map) throws Exception;
}