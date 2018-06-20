package com.manage.bus.dao;

import java.util.List;
import java.util.Map;
import com.manage.base.annotation.MyBatisDao;
import org.springframework.stereotype.Component;
import com.manage.bus.entity.GEntrustOrderUsdt;
/**
 * 委托订单表（g_entrust_order_usdt）
功能描述：存储币币交易的委托单历史记录。每个交易区生成一张委托订单表。entrust_order_id
 DAO
 */
@MyBatisDao
@Component("GEntrustOrderUsdtDAO")
public interface GEntrustOrderUsdtDAO{
	/**
	 * 获取分页数据
	 */
	public List<GEntrustOrderUsdt> selectPage(Map<String,Object> map) throws Exception;
	/**
	 * 获取分页数据数量
	 */
	public Integer selectPageCount(Map<String,Object> map) throws Exception;
	/**
	 * 获取一条信息
	 */
	public GEntrustOrderUsdt getById(java.lang.String entrust_order_id) throws Exception;
	/**
	 * 修改一条信息
	 */
	public Integer update(GEntrustOrderUsdt g_entrust_order_usdt) throws Exception;
	/**
	 * 新增一条信息
	 */
	public Integer add(GEntrustOrderUsdt g_entrust_order_usdt)throws Exception;
	/**
	 * 删除一条信息
	 */
	public Integer deleteById(java.lang.String entrust_order_id) throws Exception;
	/**
	 * 获取所有数据
	 */
	public List<GEntrustOrderUsdt> selectAll(Map<String,Object> map) throws Exception;
}