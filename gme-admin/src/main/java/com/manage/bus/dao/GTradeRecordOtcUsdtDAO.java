package com.manage.bus.dao;

import java.util.List;
import java.util.Map;
import com.manage.base.annotation.MyBatisDao;
import org.springframework.stereotype.Component;
import com.manage.bus.entity.GTradeRecordOtcUsdt;
/**
 * OTC交易记录表（g_trade_record_otc_usdt） DAO
 */
@MyBatisDao
@Component("GTradeRecordOtcUsdtDAO")
public interface GTradeRecordOtcUsdtDAO{
	/**
	 * 获取分页数据
	 */
	public List<GTradeRecordOtcUsdt> selectPage(Map<String,Object> map) throws Exception;
	/**
	 * 获取分页数据数量
	 */
	public Integer selectPageCount(Map<String,Object> map) throws Exception;
	/**
	 * 获取一条信息
	 */
	public GTradeRecordOtcUsdt getById(java.lang.String id) throws Exception;
	/**
	 * 修改一条信息
	 */
	public Integer update(GTradeRecordOtcUsdt g_trade_record_otc_usdt) throws Exception;
	/**
	 * 新增一条信息
	 */
	public Integer add(GTradeRecordOtcUsdt g_trade_record_otc_usdt)throws Exception;
	/**
	 * 删除一条信息
	 */
	public Integer deleteById(java.lang.String id) throws Exception;
	/**
	 * 获取所有数据
	 */
	public List<GTradeRecordOtcUsdt> selectAll(Map<String,Object> map) throws Exception;
}