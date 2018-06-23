package com.manage.biz.service;

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
import com.manage.biz.entity.CurrencyData;
import com.manage.biz.vo.CurrencyDataVO;


/**
 * 
 * @Project：gme-admin   
 * @Class：GCurrencyDataService   
 * @Description 类描述：币种资料管理
 * @Author：zhou   
 * @Date：2018年6月12日 上午11:58:55   
 * @version V1.0
 */
@Service("CurrencyDataService")
public class CurrencyDataService{

	
	private  Logger logger = Logger.getLogger(CurrencyDataService.class);
	
	@Value("${SERVICE_BASE_PARAM}")
    private String SERVICE_BASE_PARAM;
    
    // 测试分页查询
    public static String testPage() {
		List<CurrencyData> list = new ArrayList<CurrencyData>();
		CurrencyData g = new CurrencyData();
		g.setDataId("1");
		g.setDataTextId("2");
		g.setRemark("备注");
		g.setDataBrief("aaaadafdfdasfd");
		list.add(g);
		PageInfo pageInfo = new PageInfo(1, 1,1, list);
		return JSON.toJSONString(pageInfo);
	}

 // 测试查询一条记录
    public static String testOne() {
    	CurrencyData g = new CurrencyData();
		g.setDataId("1");
		g.setDataTextId("2");
		g.setRemark("备注");
		g.setDataBrief("aaaadafdfdasfd");
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
     * @param @param currencyDataVO
     * @param @return
     * @param @throws Exception
     * @return PageInfo
     * @throws
     */
    public PageInfo selectPage(HttpServletRequest request,CurrencyDataVO currencyDataVO) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("PSIZE", currencyDataVO.getRows());
        map.put("BEGIN", (currencyDataVO.getPage() - 1) * currencyDataVO.getRows());
        
        Integer count = 0;
        // 查询总记录数
        try {
           /* String method = SERVICE_BASE_PARAM + "currencyData_getPageCount";
            String json = SendRequestUtil.sendMapRequest(request, map, method);*/
        	String json = this.testPage();
        	if (null != json) {
        		PageInfo pageInfo = JSON.parseObject(json, PageInfo.class);
                count = pageInfo.getTotalCount();
                if (count == 0) {
                	return new PageInfo(currencyDataVO.getRows(), currencyDataVO.getPage(), count, new ArrayList<CurrencyData>());
                }
        	}else {
            	return new PageInfo(currencyDataVO.getRows(), currencyDataVO.getPage(), count, new ArrayList<CurrencyData>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[币种管理-币种资料-查询记录条数]请求后台出错",e);
			return new PageInfo(currencyDataVO.getRows(), currencyDataVO.getPage(), count, new ArrayList<CurrencyData>());
		}
        
        
        // 查询列表
        try {
			/*String method = SERVICE_BASE_PARAM + "currencyData_getList";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
        	String json = this.testPage();
        	if (null != json) {
        		PageInfo pageInfo = JSON.parseObject(json, PageInfo.class);
                return pageInfo;
            }else {
            	return new PageInfo(currencyDataVO.getRows(), currencyDataVO.getPage(), 0, new ArrayList<CurrencyData>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[币种管理-币种资料-查询所有记录]请求后台出错",e);
			return new PageInfo(currencyDataVO.getRows(), currencyDataVO.getPage(), 0, new ArrayList<CurrencyData>());
		}
    }

    
    /**
     * 
     * @Title: get
     * @Description: 查询一条记录
     * @param @param dataId
     * @param @return
     * @param @throws Exception
     * @return GCurrencyData
     * @throws
     */
    public CurrencyData get(HttpServletRequest request,String dataId) throws Exception {
    	try {
    		Map<String,Object> map = new HashMap<String, Object>();
    		map.put("dataId", dataId);
			/*String method = SERVICE_BASE_PARAM + "currencyData_getOne";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
    		String json = CurrencyDataService.testOne();
			if (null != json) {
				CurrencyData gCurrencyData = JSON.parseObject(json, CurrencyData.class);
				return gCurrencyData;
			}else {
				return new CurrencyData();
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[币种管理-币种资料-查询一条记录]请求后台出错",e);
			return new CurrencyData();
		}
    }

    
    /**
     * 
     * @Title: add
     * @Description: 新增一条记录
     * @param @param currencyData
     * @param @return
     * @param @throws Exception
     * @return boolean
     * @throws
     */
    public boolean add(HttpServletRequest request,CurrencyData currencyData) throws Exception {
    	try {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("GCurrencyData", currencyData);
			/*String method = SERVICE_BASE_PARAM + "currencyData_add";
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
			logger.error("[币种管理-币种资料-新增一条记录]请求后台出错",e);
			return false;
		}
    }

    
    /**
     * 
     * @Title: update
     * @Description: 修改一条数据
     * @param @param currencyData
     * @param @return
     * @param @throws Exception
     * @return boolean
     * @throws
     */
    public boolean update(HttpServletRequest request,CurrencyData currencyData) throws Exception {
    	try {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("GCurrencyData", currencyData);
			/*String method = SERVICE_BASE_PARAM + "currencyData_update";
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
			logger.error("[币种管理-币种资料-修改一条记录]请求后台出错",e);
			return false;
		}
    }
    
    
    /**
     * 
     * @Title: delete
     * @Description: 删除一条数据
     * @param @param dataId
     * @param @return
     * @param @throws Exception
     * @return boolean
     * @throws
     */
    public boolean delete(HttpServletRequest request,String dataId) throws Exception {
    	try {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("dataId", dataId);
			/*String method = SERVICE_BASE_PARAM + "currencyData_delete";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
			String json = CurrencyDataService.testDelete();
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
/*	public List<GCurrencyData> selectAll(GCurrencyDataVO currencyDataVO) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		return currencyData_dao.selectAll(map);
	} */


}
