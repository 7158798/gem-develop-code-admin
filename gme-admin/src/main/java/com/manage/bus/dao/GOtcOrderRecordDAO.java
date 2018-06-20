package com.manage.bus.dao;

import java.util.List;
import java.util.Map;
import com.manage.base.annotation.MyBatisDao;
import org.springframework.stereotype.Component;
import com.manage.bus.entity.GOtcOrderRecord;
/**
 * OTC历史订单表（g_otc_order_record） DAO
 */
@MyBatisDao
@Component("GOtcOrderRecordDAO")
public interface GOtcOrderRecordDAO{
	/**
	 * 获取分页数据
	 */
	public List<GOtcOrderRecord> selectPage(Map<String,Object> map) throws Exception;
	/**
	 * 获取分页数据数量
	 */
	public Integer selectPageCount(Map<String,Object> map) throws Exception;
	/**
	 * 获取一条信息
	 */
	public GOtcOrderRecord getById(java.lang.String entry_order_id) throws Exception;
	/**
	 * 修改一条信息
	 */
	public Integer update(GOtcOrderRecord g_otc_order_record) throws Exception;
	/**
	 * 新增一条信息
	 */
	public Integer add(GOtcOrderRecord g_otc_order_record)throws Exception;
	/**
	 * 删除一条信息
	 */
	public Integer deleteById(java.lang.String entry_order_id) throws Exception;
	/**
	 * 获取所有数据
	 */
	public List<GOtcOrderRecord> selectAll(Map<String,Object> map) throws Exception;
}