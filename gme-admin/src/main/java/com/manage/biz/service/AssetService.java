package com.manage.biz.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.manage.base.entity.PageInfo;
import com.manage.biz.entity.Asset;
import com.manage.biz.vo.AssetVO;
import com.manage.util.StringUtil;

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
@Service("AssetService")
public class AssetService {
	

	private Logger logger = Logger.getLogger(AssetService.class);

	@Value("${SERVICE_BASE_PARAM}")
	private String SERVICE_BASE_PARAM;

	// 测试分页查询
	public static String testPage() {
		List<Asset> list = new ArrayList<Asset>();
		Asset g = new Asset();
		g.setAssetId("1");
		g.setAccountId(1);
		g.setStatus(1);
		g.setFrozenAssets(new BigDecimal(23423));
		g.setCurrencySymbol("USDT");
		Asset g1 = new Asset();
		g1.setAssetId("1");
		g1.setAccountId(2);
		g1.setCurrencySymbol("BTC");
		g1.setStatus(0);
		g1.setFrozenAssets(new BigDecimal(324));
		list.add(g);
		list.add(g1);
		PageInfo pageInfo = new PageInfo(1, 1, 1, list);
		return JSON.toJSONString(pageInfo);
	}

	// 测试查询一条记录
	public static String testOne() {
		Asset g = new Asset();
		g.setAssetId("1");
		g.setAccountId(1);
		g.setStatus(1);
		g.setFrozenAssets(new BigDecimal(23423));
		g.setCurrencySymbol("USDT");
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
	 * @param @param assetVO
	 * @param @return
	 * @param @throws Exception  
	 * @return PageInfo 
	 * @throws
	 */
	public PageInfo selectPage(HttpServletRequest request,AssetVO assetVO) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("PSIZE", assetVO.getRows());
		map.put("BEGIN", (assetVO.getPage() - 1) * assetVO.getRows());

		if (null != assetVO.getUid() && !StringUtils.isBlank(assetVO.getUid())) {
			if (StringUtil.isNumeric(assetVO.getUid())) {
				map.put("uid", assetVO.getUid());
			}
		}
		if (null != assetVO.getStatus()) {
			map.put("status", assetVO.getStatus());
		}

		Integer count = 0;
		// 查询总记录数
		try {
			/*
			 * String method = SERVICE_BASE_PARAM + "asset_getPageCount";
			 * String json = SendRequestUtil.sendMapRequest(request, map,
			 * method);
			 */
			String json = this.testPage();
			if (null != json) {
				PageInfo pageInfo = JSON.parseObject(json, PageInfo.class);
				count = pageInfo.getTotalCount();
				if (count == 0) {
					return new PageInfo(assetVO.getRows(), assetVO.getPage(), count, new ArrayList<Asset>());
				}
			} else {
				return new PageInfo(assetVO.getRows(), assetVO.getPage(), count, new ArrayList<Asset>());
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[用户管理-资产信息管理-查询总记录条数]请求后台出错", e);
			return new PageInfo(assetVO.getRows(), assetVO.getPage(), count, new ArrayList<Asset>());
		}

		// 查询列表
		try {
			/*
			 * String method = SERVICE_BASE_PARAM + "asset_getList"; String
			 * json = SendRequestUtil.sendMapRequest(request, map, method);
			 */
			String json = this.testPage();
			if (null != json) {
				PageInfo pageInfo = JSON.parseObject(json, PageInfo.class);
				return pageInfo;
			} else {
				return new PageInfo(assetVO.getRows(), assetVO.getPage(), 0, new ArrayList<Asset>());
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[用户管理-资产信息管理-查询所有记录]请求后台出错", e);
			return new PageInfo(assetVO.getRows(), assetVO.getPage(), 0, new ArrayList<Asset>());
		}
	}

	
	/**
	 * 
	 * @Title: get
	 * @Description: 查询一条记录
	 * @param @param request
	 * @param @param assetId
	 * @param @return
	 * @param @throws Exception
	 * @return GAsset
	 * @throws
	 */
	public Asset get(HttpServletRequest request,String assetId) throws Exception {
		try {
    		Map<String,Object> map = new HashMap<String, Object>();
    		map.put("assetId", assetId);
			/*String method = SERVICE_BASE_PARAM + "asset_getOfne";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
    		String json = this.testOne();
			if (null != json) {
				Asset gAsset = JSON.parseObject(json, Asset.class);
				return gAsset;
			}else {
				return new Asset();
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[用户管理-资产信息管理-查询一条记录]请求后台出错",e);
			return new Asset();
		}
	}

	/**
	 * 新增
	 */
	/*@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean add(GAsset asset) throws Exception {
		Integer result = asset_dao.add(asset);
		return result > 0 ? true : false;
	}*/

	
	/**
	 * 
	 * @Title: update
	 * @Description: 修改一条记录
	 * @param @param request
	 * @param @param asset
	 * @param @return
	 * @param @throws Exception  
	 * @return boolean 
	 * @throws
	 */
	public boolean update(HttpServletRequest request,Asset asset) throws Exception {
		try {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("GAsset", asset);
			/*String method = SERVICE_BASE_PARAM + "asset_update";
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
	public boolean delete(java.lang.String assetId) throws Exception {
		Integer result = asset_dao.deleteById(assetId);
		return result > 0 ? true : false;
	}*/

	/**
	 * 获取所有数据
	 */
	/*public List<GAsset> selectAll(GAssetVO assetVO) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		return asset_dao.selectAll(map);
	}*/

}
