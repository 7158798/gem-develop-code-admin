package com.manage.sys.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.manage.base.annotation.MyBatisDao;
import com.manage.sys.entity.SysRmenu;
/**
 * 角色权限 DAO
 */
@MyBatisDao
@Component("sysRmenuDao")
public interface SysRmenuDAO{
	/**
	 * 获取分页数据
	 */
	public List<SysRmenu> selectPage(Map<String,Object> map) throws Exception;
	/**
	 * 获取分页数据数量
	 */
	public Integer selectPageCount(Map<String,Object> map) throws Exception;
	/**
	 * 获取一条信息
	 */
	public SysRmenu getById(Long id) throws Exception;
	/**
	 * 修改一条信息
	 */
	public Integer update(SysRmenu llSysRmenu) throws Exception;
	/**
	 * 新增一条信息
	 */
	public Integer add(SysRmenu llSysRmenu)throws Exception;
	/**
	 * 删除信息
	 */
	public Integer deleteData(Map<String,Object> map) throws Exception;
	/**
	 * 获取所有数据
	 */
	public List<SysRmenu> selectAll(Map<String,Object> map) throws Exception;
}