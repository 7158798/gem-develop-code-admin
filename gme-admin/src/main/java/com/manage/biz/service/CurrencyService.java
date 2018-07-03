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
import com.manage.biz.entity.Currency;
import com.manage.biz.entity.CurrencyData;
import com.manage.biz.entity.CurrencyExtImg;
import com.manage.biz.vo.CurrencyVO;

/**
 * 
 * @Project：gme-admin   
 * @Class：GCurrencyService   
 * @Description 类描述：   币种表（currency）功能描述：存储币种信息
 * @Author：zhou   
 * @Date：2018年6月9日 下午3:45:06   
 * @version V1.0
 */
@Service("CurrencyService")
public class CurrencyService{

	
	private  Logger logger = Logger.getLogger(CurrencyService.class);
	
    
    
    

 // 测试分页查询
    public static String testPage() {
		List<Currency> list = new ArrayList<Currency>();
		Currency g = new Currency();
		g.setCurrencyId("1");
		g.setNameCN("usdt");
		g.setNameEN("usdt");
		g.setIsOpen("0101");
		g.setIsToken(1);
		g.setOperatorName("zs");
		
		Currency g1 = new Currency();
		g1.setCurrencyId("2");
		g1.setNameCN("eos");
		g1.setNameEN("eos");
		g1.setIsOpen("0102");
		g1.setIsToken(0);
		g1.setOperatorName("cj");
		
		list.add(g);
		list.add(g1);
		PageBean pageInfo = new PageBean(1, 1,1, list);
		return JSON.toJSONString(pageInfo);
	}

 // 测试查询一条记录
    public static String testOne() {
    	Currency g = new Currency();
		g.setCurrencyId("1");
		g.setNameCN("usdt");
		g.setNameEN("usdt");
		g.setIsOpen("0101");
		g.setIsToken(1);
		g.setOperatorName("zs");
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
     * @param @param currencyVO
     * @param @return
     * @param @throws Exception
     * @return PageInfo 分页结果
     * @throws
     */
    public PageBean selectPage(HttpServletRequest request,CurrencyVO currencyVO) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("PSIZE", currencyVO.getRows());
        map.put("BEGIN", (currencyVO.getPage() - 1) * currencyVO.getRows());
        map.put("bgCreateDate", currencyVO.getBgCreateDate());
        map.put("endCreateDate", currencyVO.getEndCreateDate());
        
        if (null != currencyVO.getCurrencySymbol() && !StringUtils.isBlank(currencyVO.getCurrencySymbol())) {
        	map.put("currencySymbol",currencyVO.getCurrencySymbol());
        }
        if (null != currencyVO.getIsToken()) {
        	map.put("isToken",currencyVO.getIsToken());
        }
        if (null != currencyVO.getIsOpen()) {
        	map.put("isOpen", currencyVO.getIsOpen());
        }
        if (null != currencyVO.getIsEnable()) {
        	map.put("isEnable", currencyVO.getIsEnable());
        }
        
        Integer count = 0;
        // 查询总记录数
        try {
           /* String method = "currency_getPageCount";
            String json = SendRequestUtil.sendMapRequest(request, map, method);*/
        	String json = this.testPage();
        	if (null != json) {
        		PageBean pageInfo = JSON.parseObject(json, PageBean.class);
                count = pageInfo.getTotalCount();
                if (count == 0) {
                	return new PageBean(currencyVO.getRows(), currencyVO.getPage(), count, new ArrayList<Currency>());
                }
        	}else {
            	return new PageBean(currencyVO.getRows(), currencyVO.getPage(), count, new ArrayList<Currency>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[币种管理-币种信息-查询总记录条数]请求后台出错",e);
			return new PageBean(currencyVO.getRows(), currencyVO.getPage(), count, new ArrayList<Currency>());
		}
        
        
        // 查询列表
        try {
			/*String method = "currency_getList";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
        	String json = this.testPage();
        	if (null != json) {
        		PageBean pageInfo = JSON.parseObject(json, PageBean.class);
                return pageInfo;
            }else {
            	return new PageBean(currencyVO.getRows(), currencyVO.getPage(), 0, new ArrayList<Currency>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[币种管理-币种信息-查询所有记录]请求后台出错",e);
			return new PageBean(currencyVO.getRows(), currencyVO.getPage(), 0, new ArrayList<Currency>());
		}
    }

    /**
     * 
     * @Title: get
     * @Description: 查询一条记录
     * @param @param request
     * @param @param currencyId
     * @param @return 
     * @param @throws Exception
     * @return GCurrency 一条币种信息
     * @throws
     */
    public Currency get(HttpServletRequest request,String currencyId) throws Exception {
    	try {
    		Map<String,Object> map = new HashMap<String, Object>();
    		map.put("currencyId", currencyId);
			/*String method = "currency_getOne";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
    		String json = this.testOne();
			if (null != json) {
				CurrencyExtImg currencyExtImg = JSON.parseObject(json, CurrencyExtImg.class);
				return currencyExtImg;
			}else {
				return new CurrencyExtImg();
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[币种管理-币种信息-查询一条记录]请求后台出错",e);
			return new CurrencyExtImg();
		}
    }

    
    /**
     * 
     * @Title: add
     * @Description: 添加一条数据
     * @param @param request
     * @param @param currency
     * @param @return
     * @param @throws Exception
     * @return boolean
     * @throws
     */
    public boolean add(HttpServletRequest request,Currency currency) throws Exception {
    	try {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("GCurrency", currency);
			/*String method = "currency_add";
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
     * @param @param currency
     * @param @return
     * @param @throws Exception
     * @return boolean
     * @throws
     */
    public boolean update(HttpServletRequest request,Currency currency) throws Exception {
    	try {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("GCurrency", currency);
			/*String method = "currency_update";
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
     * @param @param currencyId
     * @param @return
     * @param @throws Exception
     * @return boolean
     * @throws
     */
    public boolean delete(HttpServletRequest request,String currencyId) throws Exception {
    	try {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("currencyId", currencyId);
			/*String method = "currency_delete";
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
	/*public List<GCurrency> selectAll(HttpServletRequest request,GCurrencyVO currencyVO) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		return currency_dao.selectAll(map);
	} 
*/

}
