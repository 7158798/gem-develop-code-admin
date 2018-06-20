package com.manage.bus.dao;

import java.util.List;
import java.util.Map;
import com.manage.base.annotation.MyBatisDao;
import org.springframework.stereotype.Component;
import com.manage.bus.entity.GWorkOrderReply;
/**
 * 工单答复表（g_work_order_reply）
功能描述：存储工单答复信息。		
 DAO
 */
@MyBatisDao
@Component("GWorkOrderReplyDAO")
public interface GWorkOrderReplyDAO{
	/**
	 * 获取分页数据
	 */
	public List<GWorkOrderReply> selectPage(Map<String,Object> map) throws Exception;
	/**
	 * 获取分页数据数量
	 */
	public Integer selectPageCount(Map<String,Object> map) throws Exception;
	/**
	 * 获取一条信息
	 */
	public GWorkOrderReply getById(java.lang.String reply_id) throws Exception;
	/**
	 * 修改一条信息
	 */
	public Integer update(GWorkOrderReply g_work_order_reply) throws Exception;
	/**
	 * 新增一条信息
	 */
	public Integer add(GWorkOrderReply g_work_order_reply)throws Exception;
	/**
	 * 删除一条信息
	 */
	public Integer deleteById(java.lang.String reply_id) throws Exception;
	/**
	 * 获取所有数据
	 */
	public List<GWorkOrderReply> selectAll(Map<String,Object> map) throws Exception;
}