package com.manage.sys.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.manage.base.annotation.MyBatisDao;
import com.manage.sys.entity.SysPersion;
/**
 * 菜单功能表 DAO
 */
@MyBatisDao
@Component("sysPersionDAO")
public interface SysPersionDAO{
	/**
	 * 获取分页数据
	 */
	public List<SysPersion> selectPage(Map<String,Object> map) throws Exception;
	/**
	 * 获取分页数据数量
	 */
	public Integer selectPageCount(Map<String,Object> map) throws Exception;
	/**
	 * 获取一条信息
	 */
	public SysPersion getById(Long id) throws Exception;
	/**
	 * 修改一条信息
	 */
	public Integer update(SysPersion llSysPersion) throws Exception;
	/**
	 * 新增一条信息
	 */
	public Integer add(SysPersion llSysPersion)throws Exception;
	/**
	 * 删除信息
	 */
	public Integer deleteData(Map<String,Object> map) throws Exception;
	/**
	 * 获取所有数据
	 */
	public List<SysPersion> selectAll(Map<String,Object> map) throws Exception;
}