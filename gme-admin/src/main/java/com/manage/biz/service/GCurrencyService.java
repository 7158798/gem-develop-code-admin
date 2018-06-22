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
import com.manage.base.entity.PageInfo;
import com.manage.biz.entity.GCurrency;
import com.manage.biz.entity.GCurrencyData;
import com.manage.biz.vo.GCurrencyVO;

/**
 * 
 * @Project：gme-admin   
 * @Class：GCurrencyService   
 * @Description 类描述：   币种表（g_currency）功能描述：存储币种信息
 * @Author：zhou   
 * @Date：2018年6月9日 下午3:45:06   
 * @version V1.0
 */
@Transactional(readOnly = true)
@Service("GCurrencyService")
public class GCurrencyService{

	
	private  Logger logger = Logger.getLogger(GCurrencyService.class);
	
    
    @Value("${SERVICE_BASE_PARAM}")
    private String SERVICE_BASE_PARAM;

 // 测试分页查询
    public static String testPage() {
		List<GCurrency> list = new ArrayList<GCurrency>();
		GCurrency g = new GCurrency();
		g.setCurrency_id("1");
		g.setName_cn("usdt");
		g.setName_en("usdt");
		g.setIs_open("0101");
		g.setIs_token(1);
		g.setOperator_name("zs");
		
		GCurrency g1 = new GCurrency();
		g1.setCurrency_id("2");
		g1.setName_cn("eos");
		g1.setName_en("eos");
		g1.setIs_open("0102");
		g1.setIs_token(0);
		g1.setOperator_name("cj");
		
		list.add(g);
		list.add(g1);
		PageInfo pageInfo = new PageInfo(1, 1,1, list);
		return JSON.toJSONString(pageInfo);
	}

 // 测试查询一条记录
    public static String testOne() {
    	GCurrency g = new GCurrency();
		g.setCurrency_id("2");
		g.setName_cn("eos");
		g.setName_en("eos");
		g.setIs_open("0101");
		g.setIs_token(0);
		g.setOperator_name("cj");
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
     * @param @param request
     * @param @param g_currency_vo
     * @param @return
     * @param @throws Exception
     * @return PageInfo 分页结果
     * @throws
     */
    public PageInfo selectPage(HttpServletRequest request,GCurrencyVO g_currency_vo) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("PSIZE", g_currency_vo.getRows());
        map.put("BEGIN", (g_currency_vo.getPage() - 1) * g_currency_vo.getRows());
        map.put("bg_create_date", g_currency_vo.getBg_create_date());
        map.put("end_create_date", g_currency_vo.getEnd_create_date());
        
        if (null != g_currency_vo.getCurrency_symbol() && !StringUtils.isBlank(g_currency_vo.getCurrency_symbol())) {
        	map.put("currencySymbol",g_currency_vo.getCurrency_symbol());
        }
        if (null != g_currency_vo.getIs_token()) {
        	map.put("isToken",g_currency_vo.getIs_token());
        }
        if (null != g_currency_vo.getIs_open()) {
        	map.put("isOpen", g_currency_vo.getIs_open());
        }
        if (null != g_currency_vo.getIs_enable()) {
        	map.put("isEnable", g_currency_vo.getIs_enable());
        }
        
        Integer count = 0;
        // 查询总记录数
        try {
           /* String method = SERVICE_BASE_PARAM + "g_currency_getPageCount";
            String json = SendRequestUtil.sendMapRequest(request, map, method);*/
        	String json = this.testPage();
        	if (null != json) {
        		PageInfo pageInfo = JSON.parseObject(json, PageInfo.class);
                count = pageInfo.getTotalCount();
                if (count == 0) {
                	return new PageInfo(g_currency_vo.getRows(), g_currency_vo.getPage(), count, new ArrayList<GCurrency>());
                }
        	}else {
            	return new PageInfo(g_currency_vo.getRows(), g_currency_vo.getPage(), count, new ArrayList<GCurrency>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[币种管理-币种信息-查询总记录条数]请求后台出错",e);
			return new PageInfo(g_currency_vo.getRows(), g_currency_vo.getPage(), count, new ArrayList<GCurrency>());
		}
        
        
        // 查询列表
        try {
			/*String method = SERVICE_BASE_PARAM + "g_currency_getList";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
        	String json = this.testPage();
        	if (null != json) {
        		PageInfo pageInfo = JSON.parseObject(json, PageInfo.class);
                return pageInfo;
            }else {
            	return new PageInfo(g_currency_vo.getRows(), g_currency_vo.getPage(), 0, new ArrayList<GCurrency>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[币种管理-币种信息-查询所有记录]请求后台出错",e);
			return new PageInfo(g_currency_vo.getRows(), g_currency_vo.getPage(), 0, new ArrayList<GCurrency>());
		}
    }

    /**
     * 
     * @Title: get
     * @Description: 查询一条记录
     * @param @param request
     * @param @param currency_id
     * @param @return 
     * @param @throws Exception
     * @return GCurrency 一条币种信息
     * @throws
     */
    public GCurrency get(HttpServletRequest request,String currency_id) throws Exception {
    	try {
    		Map<String,Object> map = new HashMap<String, Object>();
    		map.put("currencyId", currency_id);
			/*String method = SERVICE_BASE_PARAM + "g_currency_getOne";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
    		String json = this.testOne();
			if (null != json) {
				GCurrency gCurrency = JSON.parseObject(json, GCurrency.class);
				return gCurrency;
			}else {
				return new GCurrency();
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[币种管理-币种信息-查询一条记录]请求后台出错",e);
			return new GCurrency();
		}
    }

    
    /**
     * 
     * @Title: add
     * @Description: 添加一条数据
     * @param @param request
     * @param @param g_currency
     * @param @return
     * @param @throws Exception
     * @return boolean
     * @throws
     */
    public boolean add(HttpServletRequest request,GCurrency g_currency) throws Exception {
    	try {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("GCurrency", g_currency);
			/*String method = SERVICE_BASE_PARAM + "g_currency_add";
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
			logger.error("[币种管理-币种信息-新增一条记录]请求后台出错",e);
			return false;
		}
    }

    
    /**
     * 
     * @Title: update
     * @Description: 修改一条记录
     * @param @param request
     * @param @param g_currency
     * @param @return
     * @param @throws Exception
     * @return boolean
     * @throws
     */
    public boolean update(HttpServletRequest request,GCurrency g_currency) throws Exception {
    	try {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("GCurrency", g_currency);
			/*String method = SERVICE_BASE_PARAM + "g_currency_update";
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
			logger.error("[币种管理-币种信息-修改一条记录]请求后台出错",e);
			return false;
		}
    }
	 
    
    /**
     * 
     * @Title: delete
     * @Description: 删除一条记录
     * @param @param request
     * @param @param currency_id
     * @param @return
     * @param @throws Exception
     * @return boolean
     * @throws
     */
    public boolean delete(HttpServletRequest request,String currency_id) throws Exception {
    	try {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("currencyId", currency_id);
			/*String method = SERVICE_BASE_PARAM + "g_currency_delete";
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
			logger.error("[币种管理-币种信息-删除一条记录]请求后台出错",e);
			return false;
		}
    }
    /**
	 * 获取所有数据
	 */
	/*public List<GCurrency> selectAll(HttpServletRequest request,GCurrencyVO g_currency_vo) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		return g_currency_dao.selectAll(map);
	} 
*/

}
