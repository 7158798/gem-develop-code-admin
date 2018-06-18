package com.manage.bus.dao;

import java.util.List;
import java.util.Map;
import com.manage.base.annotation.MyBatisDao;
import org.springframework.stereotype.Component;
import com.manage.bus.entity.GOtcOrder;
/**
 * OTC订单表（g_otc_order）
功能描述：存储OTC订单信息。
 DAO
 */
@MyBatisDao
@Component("GOtcOrderDAO")
public interface GOtcOrderDAO{
	/**
	 * 获取分页数据
	 */
	public List<GOtcOrder> selectPage(Map<String,Object> map) throws Exception;
	/**
	 * 获取分页数据数量
	 */
	public Integer selectPageCount(Map<String,Object> map) throws Exception;
	/**
	 * 获取一条信息
	 */
	public GOtcOrder getById(java.lang.String entry_order_id) throws Exception;
	/**
	 * 修改一条信息
	 */
	public Integer update(GOtcOrder g_otc_order) throws Exception;
	/**
	 * 新增一条信息
	 */
	public Integer add(GOtcOrder g_otc_order)throws Exception;
	/**
	 * 删除一条信息
	 */
	public Integer deleteById(java.lang.String entry_order_id) throws Exception;
	/**
	 * 获取所有数据
	 */
	public List<GOtcOrder> selectAll(Map<String,Object> map) throws Exception;
}