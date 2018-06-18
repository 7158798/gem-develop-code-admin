package com.manage.bus.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.manage.base.entity.PageInfo;
import com.manage.bus.dao.GAssetDAO;
import com.manage.bus.entity.GAccount;
import com.manage.bus.entity.GAsset;
import com.manage.bus.vo.GAssetVO;

/**
 * 
 * @Project：gme-admin
 * @Class：GAssetService
 * @Description 类描述： 用户资产管理service
 * @Author：zhou
 * @Date：2018年6月16日 下午4:07:19
 * @version
 */
@Transactional(readOnly = true)
@Service("GAssetService")
public class GAssetService {

	@Resource(name = "GAssetDAO")
	private GAssetDAO g_asset_dao;

	private Logger logger = Logger.getLogger(GAssetService.class);

	@Value("${SERVICE_BASE_PARAM}")
	private String SERVICE_BASE_PARAM;

	// 测试分页查询
	public static String testPage() {
		List<GAsset> list = new ArrayList<GAsset>();
		GAsset g = new GAsset();
		g.setAccount_id(1);
		g.setStatus(1);
		g.setFrozen_assets(new BigDecimal(23423));
		GAsset g1 = new GAsset();
		g1.setAccount_id(2);
		g1.setStatus(0);
		g1.setFrozen_assets(new BigDecimal(324));
		list.add(g);
		list.add(g1);
		PageInfo pageInfo = new PageInfo(1, 1, 1, list);
		return JSON.toJSONString(pageInfo);
	}

	// 测试查询一条记录
	public static String testOne() {
		GAsset g = new GAsset();
		g.setAccount_id(1);
		g.setStatus(1);
		g.setFrozen_assets(new BigDecimal(23423));
		return JSON.toJSONString(g);
	}

	// 测试修改一条数据
	public static String testUpdate() {
		Boolean flag = true;
		return JSON.toJSONString(flag);
	}

	
	/**
	 * 
	 * @Title: selectPage
	 * @Description: 分页查询
	 * @param @param request
	 * @param @param g_asset_vo
	 * @param @return
	 * @param @throws Exception  
	 * @return PageInfo 
	 * @throws
	 */
	public PageInfo selectPage(HttpServletRequest request,GAssetVO g_asset_vo) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("PSIZE", g_asset_vo.getRows());
		map.put("BEGIN", (g_asset_vo.getPage() - 1) * g_asset_vo.getRows());

		if (null != g_asset_vo.getStatus()) {
			map.put("status", g_asset_vo.getStatus());
		}

		Integer count = 0;
		// 查询总记录数
		try {
			/*
			 * String method = SERVICE_BASE_PARAM + "g_asset_getPageCount";
			 * String json = SendRequestUtil.sendMapRequest(request, map,
			 * method);
			 */
			String json = this.testPage();
			if (null != json) {
				PageInfo pageInfo = JSON.parseObject(json, PageInfo.class);
				count = pageInfo.getTotalCount();
				if (count == 0) {
					return new PageInfo(g_asset_vo.getRows(), g_asset_vo.getPage(), count, new ArrayList<GAsset>());
				}
			} else {
				return new PageInfo(g_asset_vo.getRows(), g_asset_vo.getPage(), count, new ArrayList<GAsset>());
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[用户管理-资产信息管理-查询总记录条数]请求后台出错", e);
			return new PageInfo(g_asset_vo.getRows(), g_asset_vo.getPage(), count, new ArrayList<GAsset>());
		}

		// 查询列表
		try {
			/*
			 * String method = SERVICE_BASE_PARAM + "g_asset_getList"; String
			 * json = SendRequestUtil.sendMapRequest(request, map, method);
			 */
			String json = this.testPage();
			if (null != json) {
				PageInfo pageInfo = JSON.parseObject(json, PageInfo.class);
				return pageInfo;
			} else {
				return new PageInfo(g_asset_vo.getRows(), g_asset_vo.getPage(), 0, new ArrayList<GAsset>());
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[用户管理-资产信息管理-查询所有记录]请求后台出错", e);
			return new PageInfo(g_asset_vo.getRows(), g_asset_vo.getPage(), 0, new ArrayList<GAsset>());
		}
	}

	
	public GAsset get(HttpServletRequest request,String asset_id) throws Exception {
		try {
    		Map<String,Object> map = new HashMap<String, Object>();
    		map.put("assetId", asset_id);
			/*String method = SERVICE_BASE_PARAM + "g_asset_getOfne";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
    		String json = this.testOne();
			if (null != json) {
				GAsset gAsset = JSON.parseObject(json, GAsset.class);
				return gAsset;
			}else {
				return new GAsset();
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[用户管理-资产信息管理-查询一条记录]请求后台出错",e);
			return new GAsset();
		}
	}

	/**
	 * 新增
	 */
	/*@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean add(GAsset g_asset) throws Exception {
		Integer result = g_asset_dao.add(g_asset);
		return result > 0 ? true : false;
	}*/

	
	/**
	 * 
	 * @Title: update
	 * @Description: 修改一条记录
	 * @param @param request
	 * @param @param g_asset
	 * @param @return
	 * @param @throws Exception  
	 * @return boolean 
	 * @throws
	 */
	public boolean update(HttpServletRequest request,GAsset g_asset) throws Exception {
		try {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("GAsset", g_asset);
			/*String method = SERVICE_BASE_PARAM + "g_asset_update";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
			String json = this.testUpdate();
			if (null != json) {
				Boolean flag = JSON.parseObject(json,Boolean.class);
				return flag;
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[用户管理-资产信息管理-修改一条记录]请求后台出错",e);
			return false;
		}
	}

	/**
	 * 删除
	 */
	/*@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean delete(java.lang.String asset_id) throws Exception {
		Integer result = g_asset_dao.deleteById(asset_id);
		return result > 0 ? true : false;
	}*/

	/**
	 * 获取所有数据
	 */
	/*public List<GAsset> selectAll(GAssetVO g_asset_vo) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		return g_asset_dao.selectAll(map);
	}*/

}
