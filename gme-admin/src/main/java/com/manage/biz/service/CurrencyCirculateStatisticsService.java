package com.manage.biz.service;

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
import com.manage.base.entity.PageBean;
import com.manage.biz.entity.CurrencyCirculateStatistics;
import com.manage.biz.vo.CurrencyCirculateStatisticsVO;
import com.manage.util.StringUtil;


/**
 * 
 * @Project：gme-admin   
 * @Class：GCurrencyCirculateStatisticsService   
 * @Description 类描述：币种管理-币种流通统计
 * @Author：zhou   
 * @Date：2018年6月11日 下午8:59:53   
 * @version V1.0
 */
@Service("CurrencyCirculateStatisticsService")
public class CurrencyCirculateStatisticsService{

	private Logger logger = Logger.getLogger(CurrencyCirculateStatisticsService.class);
	
	
    
			
    
    // 测试分页查询
    public static String testPage() {
		List<CurrencyCirculateStatistics> list = new ArrayList<CurrencyCirculateStatistics>();
		CurrencyCirculateStatistics g = new CurrencyCirculateStatistics();
		g.setCurrencyId("1");
		g.setCurrencySymbol("ltc");
		list.add(g);
		PageBean pageInfo = new PageBean(1, 1,1, list);
		return JSON.toJSONString(pageInfo);
	}

    // 测试查询一条记录
    public static String testOne() {
    	CurrencyCirculateStatistics g = new CurrencyCirculateStatistics();
		g.setCurrencyId("1");
		g.setCurrencySymbol("ltc");
		return JSON.toJSONString(g);
    }
    
    // 测试添加一条数据
    public static String testAdd() {
    	Boolean flag = false;
		return JSON.toJSONString(flag);
    }
    
    // 测试修改一条数据
    public static String testUpdate() {
    	Boolean flag = true;
		return JSON.toJSONString(flag);
    }
    
    // 测试删除一条数据
    public static String testDelete() {
    	Boolean flag = false;
		return JSON.toJSONString(flag);
    }
    
    /**
     * 
     * @Title: selectPage
     * @Description: 分页查询
     * @param @param currencyCirculateStatisticsVO
     * @param @return
     * @param @throws Exception
     * @return 分页结果
     * @throws
     */
    public PageBean selectPage(HttpServletRequest request,CurrencyCirculateStatisticsVO currencyCirculateStatisticsVO) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("PSIZE", currencyCirculateStatisticsVO.getRows());
        map.put("BEGIN", (currencyCirculateStatisticsVO.getPage() - 1) * currencyCirculateStatisticsVO.getRows());
        String currencyId = currencyCirculateStatisticsVO.getCurrencyId();
        String currencySymbol = currencyCirculateStatisticsVO.getCurrencySymbol();
        if (null != currencyId && !StringUtils.isBlank(currencyId)) {
        	if (StringUtil.isNumeric(currencyId)) {
        		map.put("currencyId", currencyId);
        	}
        }
        if (null != currencySymbol && !StringUtils.isBlank(currencySymbol)) {
        	map.put("currencySymbol", currencySymbol);
        }
        
        Integer count = 0;
        // 查询总记录数
        try {
           /* String method = "currencyCirculateStatistics_getPageCount";
            String json = SendRequestUtil.sendMapRequest(request, map, method);*/
        	String json = this.testPage();
        	if (null != json) {
        		PageBean pageInfo = JSON.parseObject(json, PageBean.class);
                count = pageInfo.getTotalCount();
                if (count == 0) {
                	return new PageBean(currencyCirculateStatisticsVO.getRows(), currencyCirculateStatisticsVO.getPage(), count, new ArrayList<CurrencyCirculateStatistics>());
                }
        	}else {
            	return new PageBean(currencyCirculateStatisticsVO.getRows(), currencyCirculateStatisticsVO.getPage(), count, new ArrayList<CurrencyCirculateStatistics>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[币种管理-币种流通统计-查询总记录条数]请求后台出错",e);
			return new PageBean(currencyCirculateStatisticsVO.getRows(), currencyCirculateStatisticsVO.getPage(), count, new ArrayList<CurrencyCirculateStatistics>());
		}
        
        
        // 查询列表
        try {
			/*String method = "currencyCirculateStatistics_getList";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
        	String json = this.testPage();
        	if (null != json) {
        		PageBean pageInfo = JSON.parseObject(json, PageBean.class);
                return pageInfo;
            }else {
            	return new PageBean(currencyCirculateStatisticsVO.getRows(), currencyCirculateStatisticsVO.getPage(), 0, new ArrayList<CurrencyCirculateStatistics>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[币种管理-币种流通统计-查询所有记录]请求后台出错",e);
			return new PageBean(currencyCirculateStatisticsVO.getRows(), currencyCirculateStatisticsVO.getPage(), 0, new ArrayList<CurrencyCirculateStatistics>());
		}
    }

    
    
    /**
     * 
     * @Title: get
     * @Description: 查询一条记录
     * @param @param request
     * @param @param volumeId
     * @param @return
     * @param @throws Exception
     * @return GCurrencyCirculateStatistics 一条币种流通信息
     * @throws
     */
    public CurrencyCirculateStatistics get(HttpServletRequest request,String volumeId) throws Exception {
    	try {
    		Map<String,Object> map = new HashMap<String, Object>();
    		map.put("volumeId", volumeId);
			/*String method = "currencyCirculateStatistics_getOfne";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
    		String json = CurrencyCirculateStatisticsService.testOne();
			if (null != json) {
				CurrencyCirculateStatistics gCurrencyStatistics = JSON.parseObject(json, CurrencyCirculateStatistics.class);
				return gCurrencyStatistics;
			}else {
				return new CurrencyCirculateStatistics();
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[币种管理-币种流通统计-查询一条记录]请求后台出错",e);
			return new CurrencyCirculateStatistics();
		}
    }

    
    /**
     * 
     * @Title: add
     * @Description: 添加一条数据
     * @param @param request
     * @param @param currencyCirculateStatistics
     * @param @return
     * @param @throws Exception
     * @return boolean
     * @throws
     */
    public boolean add(HttpServletRequest request,CurrencyCirculateStatistics currencyCirculateStatistics) throws Exception {
    	try {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("GCurrencyCirculateStatistics", currencyCirculateStatistics);
			/*String method = "currencyCirculateStatistics_add";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
			String json = this.testAdd();
			if (null != json) {
				Boolean flag = JSON.parseObject(json,Boolean.class);
				return flag;
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[币种管理-币种流通统计-新增一条记录]请求后台出错",e);
			return false;
		}
    }

    
    /**
     * 
     * @Title: update
     * @Description: 修改一条数据
     * @param @param request
     * @param @param currencyCirculateStatistics
     * @param @return
     * @param @throws Exception
     * @return boolean
     * @throws
     */
    public boolean update(HttpServletRequest request,CurrencyCirculateStatistics currencyCirculateStatistics) throws Exception {
    	try {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("GCurrencyCirculateStatistics", currencyCirculateStatistics);
			/*String method = "currencyCirculateStatistics_update";
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
			logger.error("[币种管理-币种流通统计-修改一条记录]请求后台出错",e);
			return false;
		}
    }
	 
    
    /**
     * 
     * @Title: delete
     * @Description: 删除
     * @param @param request
     * @param @param volumeId
     * @param @return
     * @param @throws Exception
     * @return boolean
     * @throws
     */
    public boolean delete(HttpServletRequest request,String volumeId) throws Exception {
    	try {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("volumeId", volumeId);
			/*String method = "currencyCirculateStatistics_delete";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
			String json = this.testDelete();
			if (null != json) {
				Boolean flag = JSON.parseObject(json,Boolean.class);
				return flag;
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[币种管理-币种流通统计-删除一条记录]请求后台出错",e);
			return false;
		}
    }
    /**
	 * 获取所有数据
	 */
	/*public List<GCurrencyCirculateStatistics> selectAll(GCurrencyCirculateStatisticsVO currencyCirculateStatisticsVO) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		return currencyCirculateStatistics_dao.selectAll(map);
	} */


}
