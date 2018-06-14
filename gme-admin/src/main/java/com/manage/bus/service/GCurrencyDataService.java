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
import com.manage.bus.entity.GCurrency;
import com.manage.bus.entity.GCurrencyData;
import com.manage.bus.vo.GCurrencyDataVO;


/**
 * 
 * @Project：gme-admin   
 * @Class：GCurrencyDataService   
 * @Description 类描述：币种资料管理
 * @Author：zhou   
 * @Date：2018年6月12日 上午11:58:55   
 * @version V1.0
 */
@Transactional(readOnly = true)
@Service("GCurrencyDataService")
public class GCurrencyDataService{

	
	private  Logger logger = Logger.getLogger(GCurrencyDataService.class);
	
	@Value("${SERVICE_BASE_PARAM}")
    private String SERVICE_BASE_PARAM;
    
    // 测试分页查询
    public static String testPage() {
		List<GCurrencyData> list = new ArrayList<GCurrencyData>();
		GCurrencyData g = new GCurrencyData();
		g.setData_id("1");
		g.setData_text_id("2");
		g.setRemark("备注");
		g.setData_brief("aaaadafdfdasfd");
		list.add(g);
		PageInfo pageInfo = new PageInfo(1, 1,1, list);
		return JSON.toJSONString(pageInfo);
	}

 // 测试查询一条记录
    public static String testOne() {
    	GCurrencyData g = new GCurrencyData();
    	g.setData_id("1");
		g.setData_text_id("2");
		g.setRemark("备注");
		g.setData_brief("aaaadafdfdasfd");
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
     * @param @param g_currency_data_vo
     * @param @return
     * @param @throws Exception
     * @return PageInfo
     * @throws
     */
    public PageInfo selectPage(HttpServletRequest request,GCurrencyDataVO g_currency_data_vo) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("PSIZE", g_currency_data_vo.getRows());
        map.put("BEGIN", (g_currency_data_vo.getPage() - 1) * g_currency_data_vo.getRows());
        
        Integer count = 0;
        // 查询总记录数
        try {
           /* String method = SERVICE_BASE_PARAM + "g_currency_data_getPageCount";
            String json = SendRequestUtil.sendMapRequest(request, map, method);*/
        	String json = GCurrencyDataService.testPage();
        	if (null != json) {
        		PageInfo pageInfo = JSON.parseObject(json, PageInfo.class);
                count = pageInfo.getTotalCount();
                if (count == 0) {
                	return new PageInfo(g_currency_data_vo.getRows(), g_currency_data_vo.getPage(), count, new ArrayList<GCurrencyData>());
                }
        	}else {
            	return new PageInfo(g_currency_data_vo.getRows(), g_currency_data_vo.getPage(), count, new ArrayList<GCurrencyData>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[币种管理-币种资料-查询记录条数]请求后台出错",e);
			return new PageInfo(g_currency_data_vo.getRows(), g_currency_data_vo.getPage(), count, new ArrayList<GCurrencyData>());
		}
        
        
        // 查询列表
        try {
			/*String method = SERVICE_BASE_PARAM + "g_currency_data_getList";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
        	String json = GCurrencyDataService.testPage();
        	if (null != json) {
        		PageInfo pageInfo = JSON.parseObject(json, PageInfo.class);
                return pageInfo;
            }else {
            	return new PageInfo(g_currency_data_vo.getRows(), g_currency_data_vo.getPage(), 0, new ArrayList<GCurrencyData>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[币种管理-币种资料-查询所有记录]请求后台出错",e);
			return new PageInfo(g_currency_data_vo.getRows(), g_currency_data_vo.getPage(), 0, new ArrayList<GCurrencyData>());
		}
    }

    
    /**
     * 
     * @Title: get
     * @Description: 查询一条记录
     * @param @param data_id
     * @param @return
     * @param @throws Exception
     * @return GCurrencyData
     * @throws
     */
    public GCurrencyData get(HttpServletRequest request,String data_id) throws Exception {
    	try {
    		Map<String,Object> map = new HashMap<String, Object>();
    		map.put("dataId", data_id);
			/*String method = SERVICE_BASE_PARAM + "g_currency_data_getOne";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
    		String json = GCurrencyDataService.testOne();
			if (null != json) {
				GCurrencyData gCurrencyData = JSON.parseObject(json, GCurrencyData.class);
				return gCurrencyData;
			}else {
				return new GCurrencyData();
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[币种管理-币种资料-查询一条记录]请求后台出错",e);
			return new GCurrencyData();
		}
    }

    
    /**
     * 
     * @Title: add
     * @Description: 新增一条记录
     * @param @param g_currency_data
     * @param @return
     * @param @throws Exception
     * @return boolean
     * @throws
     */
    public boolean add(HttpServletRequest request,GCurrencyData g_currency_data) throws Exception {
    	try {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("GCurrencyData", g_currency_data);
			/*String method = SERVICE_BASE_PARAM + "g_currency_data_add";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
			String json = GCurrencyDataService.testAdd();
			if (null != json) {
				Boolean flag = JSON.parseObject(json,Boolean.class);
				return flag;
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[币种管理-币种资料-新增一条记录]请求后台出错",e);
			return false;
		}
    }

    
    /**
     * 
     * @Title: update
     * @Description: 修改一条数据
     * @param @param g_currency_data
     * @param @return
     * @param @throws Exception
     * @return boolean
     * @throws
     */
    public boolean update(HttpServletRequest request,GCurrencyData g_currency_data) throws Exception {
    	try {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("GCurrencyData", g_currency_data);
			/*String method = SERVICE_BASE_PARAM + "g_currency_data_update";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
			String json = GCurrencyDataService.testUpdate();
			if (null != json) {
				Boolean flag = JSON.parseObject(json,Boolean.class);
				return flag;
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[币种管理-币种资料-修改一条记录]请求后台出错",e);
			return false;
		}
    }
    
    
    /**
     * 
     * @Title: delete
     * @Description: 删除一条数据
     * @param @param data_id
     * @param @return
     * @param @throws Exception
     * @return boolean
     * @throws
     */
    public boolean delete(HttpServletRequest request,String data_id) throws Exception {
    	try {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("dataId", data_id);
			/*String method = SERVICE_BASE_PARAM + "g_currency_data_delete";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
			String json = GCurrencyDataService.testDelete();
			if (null != json) {
				Boolean flag = JSON.parseObject(json,Boolean.class);
				return flag;
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[币种管理-币种资料-删除一条记录]请求后台出错",e);
			return false;
		}
    }
    /**
	 * 获取所有数据
	 */
/*	public List<GCurrencyData> selectAll(GCurrencyDataVO g_currency_data_vo) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		return g_currency_data_dao.selectAll(map);
	} */


}
