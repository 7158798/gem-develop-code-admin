package com.manage.bus.dao;

import java.util.List;
import java.util.Map;
import com.manage.base.annotation.MyBatisDao;
import org.springframework.stereotype.Component;
import com.manage.bus.entity.GCurrencyCirculateStatistics;
/**
 * 币种流通统计表（g_currency_circulate_statistics）
功能描述：存储币种流通统计信息。






 DAO
 */
@MyBatisDao
@Component("GCurrencyCirculateStatisticsDAO")
public interface GCurrencyCirculateStatisticsDAO{
	/**
	 * 获取分页数据
	 */
	public List<GCurrencyCirculateStatistics> selectPage(Map<String,Object> map) throws Exception;
	/**
	 * 获取分页数据数量
	 */
	public Integer selectPageCount(Map<String,Object> map) throws Exception;
	/**
	 * 获取一条信息
	 */
	public GCurrencyCirculateStatistics getById(java.lang.String volume_id) throws Exception;
	/**
	 * 修改一条信息
	 */
	public Integer update(GCurrencyCirculateStatistics g_currency_circulate_statistics) throws Exception;
	/**
	 * 新增一条信息
	 */
	public Integer add(GCurrencyCirculateStatistics g_currency_circulate_statistics)throws Exception;
	/**
	 * 删除一条信息
	 */
	public Integer deleteById(java.lang.String volume_id) throws Exception;
	/**
	 * 获取所有数据
	 */
	public List<GCurrencyCirculateStatistics> selectAll(Map<String,Object> map) throws Exception;
}