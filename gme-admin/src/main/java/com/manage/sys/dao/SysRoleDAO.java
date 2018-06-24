package com.manage.sys.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.manage.base.annotation.MyBatisDao;
import com.manage.sys.entity.SysRole;
/**
 * 角色说明 DAO
 */
@MyBatisDao
@Component("sysRoleDao")
public interface SysRoleDAO{
	/**
	 * 获取分页数据
	 */
	public List<SysRole> selectPage(Map<String,Object> map) throws Exception;
	/**
	 * 获取分页数据数量
	 */
	public Integer selectPageCount(Map<String,Object> map) throws Exception;
	/**
	 * 获取一条信息
	 */
	public SysRole getById(Long id) throws Exception;
	/**
	 * 修改一条信息
	 */
	public Integer update(SysRole llSysRole) throws Exception;
	/**
	 * 新增一条信息
	 */
	public Integer add(SysRole llSysRole)throws Exception;
	/**
	 * 删除一条信息
	 */
	public Integer deleteById(java.lang.Long id) throws Exception;
	/**
	 * 获取所有数据
	 */
	public List<SysRole> selectAll(Map<String,Object> map) throws Exception;
}