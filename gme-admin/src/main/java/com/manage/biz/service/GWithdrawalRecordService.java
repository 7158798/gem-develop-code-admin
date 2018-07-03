package com.manage.biz.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.manage.base.entity.PageBean;
import com.manage.base.entity.PageVO;
import com.manage.biz.entity.GWithdrawalRecord;
import com.manage.biz.vo.GWithdrawalRecordVO;
import com.manage.util.ConfigUtil;
import com.manage.util.SendRequestUtil;
import com.manage.util.StringUtil;

/**
 * 钱包提现记录表（withdrawalRecord） 功能描述：存储钱包提现记录信息。 服务
 */

@Service("GWithdrawalRecordService")
public class GWithdrawalRecordService {

	private Logger logger = Logger.getLogger(GWithdrawalRecordService.class);

	// 测试分页查询
	public static String testPage() {
		List<GWithdrawalRecord> list = new ArrayList<GWithdrawalRecord>();
		GWithdrawalRecord g = new GWithdrawalRecord();
		g.setCurrencyId("1");
		g.setStatus(1);
		g.setId("1");
		g.setCurrencyId("1");
		GWithdrawalRecord g1 = new GWithdrawalRecord();
		g1.setCurrencyId("2");
		g1.setStatus(2);
		g1.setId("2");
		g.setCurrencyId("2");
		list.add(g);
		list.add(g1);
		PageBean pageInfo = new PageBean(1, 1, 1, list);
		return JSON.toJSONString(pageInfo);
	}

	// 测试查询一条记录
	public static String testOne() {
		GWithdrawalRecord g = new GWithdrawalRecord();
		g.setCurrencyId("1");
		g.setStatus(1);
		g.setId("1");
		g.setCurrencyId("2");
		g.setCurrencyId("2");
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
	 * @param request
	 * @param withdrawalRecordVO
	 * @return
	 * @throws Exception
	 * @return PageInfo
	 */
	public PageBean selectPage(HttpServletRequest request, GWithdrawalRecordVO withdrawalRecordVO) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("numPerPage", withdrawalRecordVO.getRows());
		map.put("pageNum", withdrawalRecordVO.getPage());
//		map.put("pageNum", "0");

//		map.put("uid", "1");
		if (null != withdrawalRecordVO.getUid() && !StringUtils.isBlank(withdrawalRecordVO.getUid())) {
			if (StringUtil.isNumeric(withdrawalRecordVO.getUid())) {
				map.put("uid", withdrawalRecordVO.getUid());
			}
		}
		if (null != withdrawalRecordVO.getWithdrawalId()
				&& !StringUtils.isBlank(withdrawalRecordVO.getWithdrawalId())) {
			if (StringUtil.isNumeric(withdrawalRecordVO.getWithdrawalId())) {
				map.put("withdrawalId", withdrawalRecordVO.getWithdrawalId());
			}
		}

		if (null != withdrawalRecordVO.getCurrencyId()) {
			map.put("currencyId", withdrawalRecordVO.getCurrencyId());
		}
		if (null != withdrawalRecordVO.getStatus()) {
			map.put("status", withdrawalRecordVO.getStatus());
		}

		// 查询列表
		try {
			String method = ConfigUtil.get("WALLET_WITHDRAWPAGE");
			String json = SendRequestUtil.sendMapRequest(request, map, method);
			if (null != json) {
				PageVO pageVo = JSON.parseObject(json, PageVO.class);
				String dataJson = JSON.toJSONString(pageVo.getData());
				PageBean pageBean = JSON.parseObject(dataJson, PageBean.class);
				return pageBean;
			} else {
				return new PageBean(withdrawalRecordVO.getRows(), withdrawalRecordVO.getPage(), 0,
						new ArrayList<GWithdrawalRecord>());
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[钱包管理-提币记录管理-查询所有记录]请求后台出错", e);
			return new PageBean(withdrawalRecordVO.getRows(), withdrawalRecordVO.getPage(), 0,
					new ArrayList<GWithdrawalRecord>());
		}

	}

	/**
	 * 
	 * @Title: get
	 * @Description: 查询一条记录
	 * @param id
	 * @return
	 * @throws Exception
	 * @return GWithdrawalRecord
	 */
	public GWithdrawalRecord get(HttpServletRequest request, String id) throws Exception {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", id);

			String method = ConfigUtil.get("WALLET_GETBYID");
			String json = SendRequestUtil.sendMapRequest(request, map, method);

//			String json = this.testOne();
			if (null != json) {
				PageVO pageVo = JSON.parseObject(json, PageVO.class);
				GWithdrawalRecord gWithdrawalRecord = JSON.parseObject(JSON.toJSONString(pageVo.getData()),
						GWithdrawalRecord.class);
				return gWithdrawalRecord;
			} else {
				return new GWithdrawalRecord();
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[钱包管理-提币记录管理-查询一条记录]请求后台出错", e);
			return new GWithdrawalRecord();
		}
	}

	/**
	 * 新增
	 */
	/*
	 * public boolean add(GWithdrawalRecord withdrawalRecord) throws Exception {
	 * Integer result = withdrawalRecord_dao.add(withdrawalRecord); return result >
	 * 0 ? true : false; }
	 */

	/**
	 * 修改
	 */
	public boolean update(HttpServletRequest request,GWithdrawalRecord withdrawalRecord) throws Exception {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			if (null != withdrawalRecord && withdrawalRecord.getId() != null) {
				map.put("id", withdrawalRecord.getId());
			}
			if (null != withdrawalRecord && withdrawalRecord.getStatus() != null) {
				map.put("status", withdrawalRecord.getStatus());
			}

			String method = ConfigUtil.get("WALLET_UPDATESTATUS");
			String json = SendRequestUtil.sendMapRequest(request, map, method);

//			String json = this.testUpdate();
			if (null != json) {
				PageVO pageVo = JSON.parseObject(json, PageVO.class);
				if (null != pageVo && pageVo.getCode().equals("200")) {
					return true;
				}
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[钱包管理-提币记录管理-修改一条记录]请求后台出错", e);
			return false;
		}
	}

	/**
	 * 删除
	 */
	/*
	 * public boolean delete(java.lang.String id) throws Exception { Integer result
	 * = withdrawalRecord_dao.deleteById(id); return result > 0 ? true : false; }
	 */

	/**
	 * 获取所有数据
	 */
	/*
	 * public List<GWithdrawalRecord> selectAll(GWithdrawalRecordVO
	 * withdrawalRecordVO) throws Exception{ Map<String, Object> map = new
	 * HashMap<String, Object>(); return withdrawalRecord_dao.selectAll(map); }
	 */

}
