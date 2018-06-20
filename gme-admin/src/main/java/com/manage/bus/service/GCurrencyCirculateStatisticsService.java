package com.manage.bus.service;

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
import com.manage.bus.entity.GCurrencyCirculateStatistics;
import com.manage.bus.vo.GCurrencyCirculateStatisticsVO;
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
@Transactional(readOnly = true)
@Service("GCurrencyCirculateStatisticsService")
public class GCurrencyCirculateStatisticsService{

	private Logger logger = Logger.getLogger(GCurrencyCirculateStatisticsService.class);
	
	@Value("${SERVICE_BASE_PARAM}")
    private String SERVICE_BASE_PARAM;
			
    
    // 测试分页查询
    public static String testPage() {
		List<GCurrencyCirculateStatistics> list = new ArrayList<GCurrencyCirculateStatistics>();
		GCurrencyCirculateStatistics g = new GCurrencyCirculateStatistics();
		g.setCurrency_id("1");
		g.setCurrency_symbol("ltc");
		list.add(g);
		PageInfo pageInfo = new PageInfo(1, 1,1, list);
		return JSON.toJSONString(pageInfo);
	}

    // 测试查询一条记录
    public static String testOne() {
    	GCurrencyCirculateStatistics g = new GCurrencyCirculateStatistics();
    	g.setCurrency_id("1");
    	g.setCurrency_symbol("ltc");
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
     * @param @param g_currency_circulate_statistics_vo
     * @param @return
     * @param @throws Exception
     * @return 分页结果
     * @throws
     */
    public PageInfo selectPage(HttpServletRequest request,GCurrencyCirculateStatisticsVO g_currency_circulate_statistics_vo) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("PSIZE", g_currency_circulate_statistics_vo.getRows());
        map.put("BEGIN", (g_currency_circulate_statistics_vo.getPage() - 1) * g_currency_circulate_statistics_vo.getRows());
        String currency_id = g_currency_circulate_statistics_vo.getCurrency_id();
        String currency_symbol = g_currency_circulate_statistics_vo.getCurrency_symbol();
        if (null != currency_id && !StringUtils.isBlank(currency_id)) {
        	if (StringUtil.isNumeric(currency_id)) {
        		map.put("currencyId", currency_id);
        	}
        }
        if (null != currency_symbol && !StringUtils.isBlank(currency_symbol)) {
        	map.put("currencySymbol", currency_symbol);
        }
        
        Integer count = 0;
        // 查询总记录数
        try {
           /* String method = SERVICE_BASE_PARAM + "g_currency_circulate_statistics_getPageCount";
            String json = SendRequestUtil.sendMapRequest(request, map, method);*/
        	String json = this.testPage();
        	if (null != json) {
        		PageInfo pageInfo = JSON.parseObject(json, PageInfo.class);
                count = pageInfo.getTotalCount();
                if (count == 0) {
                	return new PageInfo(g_currency_circulate_statistics_vo.getRows(), g_currency_circulate_statistics_vo.getPage(), count, new ArrayList<GCurrencyCirculateStatistics>());
                }
        	}else {
            	return new PageInfo(g_currency_circulate_statistics_vo.getRows(), g_currency_circulate_statistics_vo.getPage(), count, new ArrayList<GCurrencyCirculateStatistics>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[币种管理-币种流通统计-查询总记录条数]请求后台出错",e);
			return new PageInfo(g_currency_circulate_statistics_vo.getRows(), g_currency_circulate_statistics_vo.getPage(), count, new ArrayList<GCurrencyCirculateStatistics>());
		}
        
        
        // 查询列表
        try {
			/*String method = SERVICE_BASE_PARAM + "g_currency_circulate_statistics_getList";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
        	String json = this.testPage();
        	if (null != json) {
        		PageInfo pageInfo = JSON.parseObject(json, PageInfo.class);
                return pageInfo;
            }else {
            	return new PageInfo(g_currency_circulate_statistics_vo.getRows(), g_currency_circulate_statistics_vo.getPage(), 0, new ArrayList<GCurrencyCirculateStatistics>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[币种管理-币种流通统计-查询所有记录]请求后台出错",e);
			return new PageInfo(g_currency_circulate_statistics_vo.getRows(), g_currency_circulate_statistics_vo.getPage(), 0, new ArrayList<GCurrencyCirculateStatistics>());
		}
    }

    
    
    /**
     * 
     * @Title: get
     * @Description: 查询一条记录
     * @param @param request
     * @param @param volume_id
     * @param @return
     * @param @throws Exception
     * @return GCurrencyCirculateStatistics 一条币种流通信息
     * @throws
     */
    public GCurrencyCirculateStatistics get(HttpServletRequest request,String volume_id) throws Exception {
    	try {
    		Map<String,Object> map = new HashMap<String, Object>();
    		map.put("volumeId", volume_id);
			/*String method = SERVICE_BASE_PARAM + "g_currency_circulate_statistics_getOfne";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
    		String json = GCurrencyCirculateStatisticsService.testOne();
			if (null != json) {
				GCurrencyCirculateStatistics gCurrencyStatistics = JSON.parseObject(json, GCurrencyCirculateStatistics.class);
				return gCurrencyStatistics;
			}else {
				return new GCurrencyCirculateStatistics();
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[币种管理-币种流通统计-查询一条记录]请求后台出错",e);
			return new GCurrencyCirculateStatistics();
		}
    }

    
    /**
     * 
     * @Title: add
     * @Description: 添加一条数据
     * @param @param request
     * @param @param g_currency_circulate_statistics
     * @param @return
     * @param @throws Exception
     * @return boolean
     * @throws
     */
    public boolean add(HttpServletRequest request,GCurrencyCirculateStatistics g_currency_circulate_statistics) throws Exception {
    	try {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("GCurrencyCirculateStatistics", g_currency_circulate_statistics);
			/*String method = SERVICE_BASE_PARAM + "g_currency_circulate_statistics_add";
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
     * @param @param g_currency_circulate_statistics
     * @param @return
     * @param @throws Exception
     * @return boolean
     * @throws
     */
    public boolean update(HttpServletRequest request,GCurrencyCirculateStatistics g_currency_circulate_statistics) throws Exception {
    	try {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("GCurrencyCirculateStatistics", g_currency_circulate_statistics);
			/*String method = SERVICE_BASE_PARAM + "g_currency_circulate_statistics_update";
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
     * @param @param volume_id
     * @param @return
     * @param @throws Exception
     * @return boolean
     * @throws
     */
    public boolean delete(HttpServletRequest request,String volume_id) throws Exception {
    	try {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("volumeId", volume_id);
			/*String method = SERVICE_BASE_PARAM + "g_currency_circulate_statistics_delete";
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
	/*public List<GCurrencyCirculateStatistics> selectAll(GCurrencyCirculateStatisticsVO g_currency_circulate_statistics_vo) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		return g_currency_circulate_statistics_dao.selectAll(map);
	} */


}
