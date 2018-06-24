package com.manage.sys.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.manage.base.annotation.MyBatisDao;
import com.manage.sys.entity.SysRpersion;
/**
 * 角色菜单功能 DAO
 */
@MyBatisDao
@Component("sysRpersionDao")
public interface SysRpersionDAO{
	/**
	 * 获取分页数据
	 */
	public List<SysRpersion> selectPage(Map<String,Object> map) throws Exception;
	/**
	 * 获取分页数据数量
	 */
	public Integer selectPageCount(Map<String,Object> map) throws Exception;
	/**
	 * 获取一条信息
	 */
	public SysRpersion getById(Long id) throws Exception;
	/**
	 * 修改一条信息
	 */
	public Integer update(SysRpersion llSysRpersion) throws Exception;
	/**
	 * 新增一条信息
	 */
	public Integer add(SysRpersion llSysRpersion)throws Exception;
	/**
	 * 删除信息
	 */
	public Integer deleteData(Map<String,Object> map) throws Exception;
	/**
	 * 获取所有数据
	 */
	public List<SysRpersion> selectAll(Map<String,Object> map) throws Exception;
}