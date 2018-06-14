package com.manage.bus.dao;

import java.util.List;
import java.util.Map;
import com.manage.base.annotation.MyBatisDao;
import org.springframework.stereotype.Component;
import com.manage.bus.entity.GCurrencyTradePair;
/**
 * 币种交易对表 DAO
 */
@MyBatisDao
@Component("GCurrencyTradePairDAO")
public interface GCurrencyTradePairDAO{
	/**
	 * 获取分页数据
	 */
	public List<GCurrencyTradePair> selectPage(Map<String,Object> map) throws Exception;
	/**
	 * 获取分页数据数量
	 */
	public Integer selectPageCount(Map<String,Object> map) throws Exception;
	/**
	 * 获取一条信息
	 */
	public GCurrencyTradePair getById(java.lang.String pair_id) throws Exception;
	/**
	 * 修改一条信息
	 */
	public Integer update(GCurrencyTradePair g_currency_trade_pair) throws Exception;
	/**
	 * 新增一条信息
	 */
	public Integer add(GCurrencyTradePair g_currency_trade_pair)throws Exception;
	/**
	 * 删除一条信息
	 */
	public Integer deleteById(java.lang.String pair_id) throws Exception;
	/**
	 * 获取所有数据
	 */
	public List<GCurrencyTradePair> selectAll(Map<String,Object> map) throws Exception;
}