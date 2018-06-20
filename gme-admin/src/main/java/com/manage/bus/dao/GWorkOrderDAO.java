package com.manage.bus.dao;

import java.util.List;
import java.util.Map;
import com.manage.base.annotation.MyBatisDao;
import org.springframework.stereotype.Component;
import com.manage.bus.entity.GWorkOrder;
/**
 * 工单表（g_work_order）
功能描述：存储工单信息。
 DAO
 */
@MyBatisDao
@Component("GWorkOrderDAO")
public interface GWorkOrderDAO{
	/**
	 * 获取分页数据
	 */
	public List<GWorkOrder> selectPage(Map<String,Object> map) throws Exception;
	/**
	 * 获取分页数据数量
	 */
	public Integer selectPageCount(Map<String,Object> map) throws Exception;
	/**
	 * 获取一条信息
	 */
	public GWorkOrder getById(java.lang.String subject_id) throws Exception;
	/**
	 * 修改一条信息
	 */
	public Integer update(GWorkOrder g_work_order) throws Exception;
	/**
	 * 新增一条信息
	 */
	public Integer add(GWorkOrder g_work_order)throws Exception;
	/**
	 * 删除一条信息
	 */
	public Integer deleteById(java.lang.String subject_id) throws Exception;
	/**
	 * 获取所有数据
	 */
	public List<GWorkOrder> selectAll(Map<String,Object> map) throws Exception;
}