package com.manage.bus.dao;

import java.util.List;
import java.util.Map;
import com.manage.base.annotation.MyBatisDao;
import org.springframework.stereotype.Component;
import com.manage.bus.entity.GAsset;
/**
 * 资产表（g_asset）
功能描述：存储用户币种资产信息。 DAO
 */
@MyBatisDao
@Component("GAssetDAO")
public interface GAssetDAO{
	/**
	 * 获取分页数据
	 */
	public List<GAsset> selectPage(Map<String,Object> map) throws Exception;
	/**
	 * 获取分页数据数量
	 */
	public Integer selectPageCount(Map<String,Object> map) throws Exception;
	/**
	 * 获取一条信息
	 */
	public GAsset getById(java.lang.String asset_id) throws Exception;
	/**
	 * 修改一条信息
	 */
	public Integer update(GAsset g_asset) throws Exception;
	/**
	 * 新增一条信息
	 */
	public Integer add(GAsset g_asset)throws Exception;
	/**
	 * 删除一条信息
	 */
	public Integer deleteById(java.lang.String asset_id) throws Exception;
	/**
	 * 获取所有数据
	 */
	public List<GAsset> selectAll(Map<String,Object> map) throws Exception;
}