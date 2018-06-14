package com.manage.bus.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.manage.base.entity.PageInfo;
import com.manage.bus.entity.GCurrencyTradePair;
import com.manage.bus.vo.GCurrencyTradePairVO;



/**
 * 
 * @Project：gme-admin   
 * @Class：GCurrencyTradePairService   
 * @Description 类描述：币种交易对管理
 * @Author：zhou   
 * @Date：2018年6月12日 下午6:03:12   
 * @version V1.0
 */
@Transactional(readOnly = true)
@Service("GCurrencyTradePairService")
public class GCurrencyTradePairService{

	
	private Logger logger = Logger.getLogger(GCurrencyTradePairService.class);
	
	@Value("${SERVICE_BASE_PARAM}")
    private String SERVICE_BASE_PARAM;
	

 // 测试分页查询
    public static String testPage() {
		List<GCurrencyTradePair> list = new ArrayList<GCurrencyTradePair>();
		GCurrencyTradePair g = new GCurrencyTradePair();
		g.setCurrency_id("1");
		g.setIs_elite(1);
		g.setPair_sn(2);
		g.setIs_enable(1);
		list.add(g);
		PageInfo pageInfo = new PageInfo(1, 1,1, list);
		return JSON.toJSONString(pageInfo);
	}

    // 测试查询一条记录
    public static String testOne() {
    	GCurrencyTradePair g = new GCurrencyTradePair();
    	g.setCurrency_id("1");
		g.setIs_elite(1);
		g.setPair_sn(2);
		g.setIs_enable(1);
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
     * @param @param g_currency_trade_pair_vo
     * @param @return
     * @param @throws Exception
     * @return PageInfo
     * @throws
     */
    public PageInfo selectPage(HttpServletRequest request,GCurrencyTradePairVO g_currency_trade_pair_vo) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("PSIZE", g_currency_trade_pair_vo.getRows());
        map.put("BEGIN", (g_currency_trade_pair_vo.getPage() - 1) * g_currency_trade_pair_vo.getRows());
        
        if (null != g_currency_trade_pair_vo.getIs_enable()) {
        	map.put("isEnable", g_currency_trade_pair_vo.getIs_enable());
        }
        if (null != g_currency_trade_pair_vo.getIs_elite()) {
        	map.put("isElite", g_currency_trade_pair_vo.getIs_elite());
        }
        
        
        Integer count = 0;
        // 查询总记录数
        try {
           /* String method = SERVICE_BASE_PARAM + "g_currency_trade_pair_getPageCount";
            String json = SendRequestUtil.sendMapRequest(request, map, method);*/
        	String json = GCurrencyTradePairService.testPage();
        	if (null != json) {
        		PageInfo pageInfo = JSON.parseObject(json, PageInfo.class);
                count = pageInfo.getTotalCount();
                if (count == 0) {
                	return new PageInfo(g_currency_trade_pair_vo.getRows(), g_currency_trade_pair_vo.getPage(), count, new ArrayList<GCurrencyTradePair>());
                }
        	}else {
            	return new PageInfo(g_currency_trade_pair_vo.getRows(), g_currency_trade_pair_vo.getPage(), count, new ArrayList<GCurrencyTradePair>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[币种管理-币种交易对-查询总记录条数]请求后台出错",e);
			return new PageInfo(g_currency_trade_pair_vo.getRows(), g_currency_trade_pair_vo.getPage(), count, new ArrayList<GCurrencyTradePair>());
		}
        
        
        // 查询列表
        try {
			/*String method = SERVICE_BASE_PARAM + "g_currency_trade_pair_getList";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
        	String json = GCurrencyTradePairService.testPage();
        	if (null != json) {
        		PageInfo pageInfo = JSON.parseObject(json, PageInfo.class);
                return pageInfo;
            }else {
            	return new PageInfo(g_currency_trade_pair_vo.getRows(), g_currency_trade_pair_vo.getPage(), 0, new ArrayList<GCurrencyTradePair>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[币种管理-币种交易对-查询所有记录]请求后台出错",e);
			return new PageInfo(g_currency_trade_pair_vo.getRows(), g_currency_trade_pair_vo.getPage(), 0, new ArrayList<GCurrencyTradePair>());
		}
        
    }

    
    /**
     * 
     * @Title: get
     * @Description: 查询一条记录
     * @param @param pair_id
     * @param @return
     * @param @throws Exception
     * @return GCurrencyTradePair
     * @throws
     */
    public GCurrencyTradePair get(HttpServletRequest request,String pair_id) throws Exception {
    	try {
    		Map<String,Object> map = new HashMap<String, Object>();
    		map.put("pairId", pair_id);
			/*String method = SERVICE_BASE_PARAM + "g_currency_trade_pair_getOne";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
    		String json = GCurrencyTradePairService.testOne();
			if (null != json) {
				GCurrencyTradePair gCurrencyTradePair = JSON.parseObject(json, GCurrencyTradePair.class);
				return gCurrencyTradePair;
			}else {
				return new GCurrencyTradePair();
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[币种管理-币种交易对-查询一条记录]请求后台出错",e);
			return new GCurrencyTradePair();
		}
    }

    
    /**
     * 
     * @Title: add
     * @Description: 新增一条记录
     * @param @param request
     * @param @param g_currency_trade_pair
     * @param @return
     * @param @throws Exception
     * @return boolean
     * @throws
     */
    public boolean add(HttpServletRequest request,GCurrencyTradePair g_currency_trade_pair) throws Exception {
    	try {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("GCurrencyTradePair", g_currency_trade_pair);
			/*String method = SERVICE_BASE_PARAM + "g_currency_trade_pair_add";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
			String json = GCurrencyTradePairService.testAdd();
			if (null != json) {
				Boolean flag = JSON.parseObject(json,Boolean.class);
				return flag;
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[币种管理-币种交易对-新增一条记录]请求后台出错",e);
			return false;
		}
    }

    
    /**
     * 
     * @Title: update
     * @Description: 修改一条数据
     * @param @param request
     * @param @param g_currency_trade_pair
     * @param @return
     * @param @throws Exception
     * @return boolean
     * @throws
     */
    public boolean update(HttpServletRequest request,GCurrencyTradePair g_currency_trade_pair) throws Exception {
    	try {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("GCurrencyTradePair", g_currency_trade_pair);
			/*String method = SERVICE_BASE_PARAM + "g_currency_trade_pair_update";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
			String json = GCurrencyTradePairService.testUpdate();
			if (null != json) {
				Boolean flag = JSON.parseObject(json,Boolean.class);
				return flag;
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[币种管理-币种交易对-修改一条记录]请求后台出错",e);
			return false;
		}
    }
    
    
    
    /**
     * 
     * @Title: delete
     * @Description: 删除一条记录
     * @param @param request
     * @param @param pair_id
     * @param @return
     * @param @throws Exception
     * @return boolean
     * @throws
     */
    public boolean delete(HttpServletRequest request,String pair_id) throws Exception {
    	try {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("pairId", pair_id);
			/*String method = SERVICE_BASE_PARAM + "g_currency_trade_pair_delete";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
			String json = GCurrencyTradePairService.testDelete();
			if (null != json) {
				Boolean flag = JSON.parseObject(json,Boolean.class);
				return flag;
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[币种管理-币种交易对-删除一条记录]请求后台出错",e);
			return false;
		}
    }
    /**
	 * 获取所有数据
	 */
	/*public List<GCurrencyTradePair> selectAll(GCurrencyTradePairVO g_currency_trade_pair_vo) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		return g_currency_trade_pair_dao.selectAll(map);
	} */


}
