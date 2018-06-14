package com.manage.bus.dao;

import java.util.List;
import java.util.Map;
import com.manage.base.annotation.MyBatisDao;
import org.springframework.stereotype.Component;
import com.manage.bus.entity.GCurrencyData;
/**
 * 币种资料表（g_currency_data） DAO
 */
@MyBatisDao
@Component("GCurrencyDataDAO")
public interface GCurrencyDataDAO{
	/**
	 * 获取分页数据
	 */
	public List<GCurrencyData> selectPage(Map<String,Object> map) throws Exception;
	/**
	 * 获取分页数据数量
	 */
	public Integer selectPageCount(Map<String,Object> map) throws Exception;
	/**
	 * 获取一条信息
	 */
	public GCurrencyData getById(java.lang.String data_id) throws Exception;
	/**
	 * 修改一条信息
	 */
	public Integer update(GCurrencyData g_currency_data) throws Exception;
	/**
	 * 新增一条信息
	 */
	public Integer add(GCurrencyData g_currency_data)throws Exception;
	/**
	 * 删除一条信息
	 */
	public Integer deleteById(java.lang.String data_id) throws Exception;
	/**
	 * 获取所有数据
	 */
	public List<GCurrencyData> selectAll(Map<String,Object> map) throws Exception;
}