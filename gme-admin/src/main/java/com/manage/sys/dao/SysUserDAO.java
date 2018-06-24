package com.manage.sys.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.manage.base.annotation.MyBatisDao;
import com.manage.sys.entity.SysUser;
/**
 * 后台管理员 DAO
 */
@MyBatisDao
@Component("sysUserDao")
public interface SysUserDAO{
	/**
	 * 获取分页数据
	 */
	public List<SysUser> selectPage(Map<String,Object> map) throws Exception;
	/**
	 * 获取分页数据数量
	 */
	public Integer selectPageCount(Map<String,Object> map) throws Exception;
	/**
	 * 获取一条信息
	 */
	public SysUser getById(Long id) throws Exception;
	/**
	 * 修改一条信息
	 */
	public Integer update(SysUser llSysUser) throws Exception;
	/**
	 * 新增一条信息
	 */
	public Integer add(SysUser llSysUser)throws Exception;
	/**
	 * 删除一条信息
	 */
	public Integer deleteById(java.lang.Long id) throws Exception;
	/**
	 * 获取所有数据
	 */
	public List<SysUser> selectAll(Map<String,Object> map) throws Exception;
}