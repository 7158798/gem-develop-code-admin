package com.manage.bus.dao;

import java.util.List;
import java.util.Map;
import com.manage.base.annotation.MyBatisDao;
import org.springframework.stereotype.Component;
import com.manage.bus.entity.GMessageState;
/**
 * 短信邮件发送状态表（g_message_state）
功能描述：存储短信邮件发送状态信息。
 DAO
 */
@MyBatisDao
@Component("GMessageStateDAO")
public interface GMessageStateDAO{
	/**
	 * 获取分页数据
	 */
	public List<GMessageState> selectPage(Map<String,Object> map) throws Exception;
	/**
	 * 获取分页数据数量
	 */
	public Integer selectPageCount(Map<String,Object> map) throws Exception;
	/**
	 * 获取一条信息
	 */
	public GMessageState getById(java.lang.String id) throws Exception;
	/**
	 * 修改一条信息
	 */
	public Integer update(GMessageState g_message_state) throws Exception;
	/**
	 * 新增一条信息
	 */
	public Integer add(GMessageState g_message_state)throws Exception;
	/**
	 * 删除一条信息
	 */
	public Integer deleteById(java.lang.String id) throws Exception;
	/**
	 * 获取所有数据
	 */
	public List<GMessageState> selectAll(Map<String,Object> map) throws Exception;
}