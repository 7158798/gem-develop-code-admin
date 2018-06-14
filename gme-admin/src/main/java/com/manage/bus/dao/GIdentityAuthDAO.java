package com.manage.bus.dao;

import java.util.List;
import java.util.Map;
import com.manage.base.annotation.MyBatisDao;
import org.springframework.stereotype.Component;
import com.manage.bus.entity.GIdentityAuth;
/**
 * 身份认证表（g_identity_auth）
功能描述：存储用户身份认证信息。 DAO
 */
@MyBatisDao
@Component("GIdentityAuthDAO")
public interface GIdentityAuthDAO{
	/**
	 * 获取分页数据
	 */
	public List<GIdentityAuth> selectPage(Map<String,Object> map) throws Exception;
	/**
	 * 获取分页数据数量
	 */
	public Integer selectPageCount(Map<String,Object> map) throws Exception;
	/**
	 * 获取一条信息
	 */
	public GIdentityAuth getById(java.lang.String auth_id) throws Exception;
	/**
	 * 修改一条信息
	 */
	public Integer update(GIdentityAuth g_identity_auth) throws Exception;
	/**
	 * 新增一条信息
	 */
	public Integer add(GIdentityAuth g_identity_auth)throws Exception;
	/**
	 * 删除一条信息
	 */
	public Integer deleteById(java.lang.String auth_id) throws Exception;
	/**
	 * 获取所有数据
	 */
	public List<GIdentityAuth> selectAll(Map<String,Object> map) throws Exception;
}