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
import com.manage.base.entity.PageBean;
import com.manage.biz.entity.CurrencyTradePair;
import com.manage.biz.vo.CurrencyTradePairVO;



/**
 * 
 * @Project：gme-admin   
 * @Class：GCurrencyTradePairService   
 * @Description 类描述：币种交易对管理
 * @Author：zhou   
 * @Date：2018年6月12日 下午6:03:12   
 * @version V1.0
 */
@Service("CurrencyTradePairService")
public class CurrencyTradePairService{

	
	private Logger logger = Logger.getLogger(CurrencyTradePairService.class);
	
	
    
	

 // 测试分页查询
    public static String testPage() {
		List<CurrencyTradePair> list = new ArrayList<CurrencyTradePair>();
		CurrencyTradePair g = new CurrencyTradePair();
		g.setCurrencyId("1");
		g.setIsElite(1);
		g.setPairSn(2);
		g.setIsEnable(1);
		list.add(g);
		PageBean pageInfo = new PageBean(1, 1,1, list);
		return JSON.toJSONString(pageInfo);
	}

    // 测试查询一条记录
    public static String testOne() {
    	CurrencyTradePair g = new CurrencyTradePair();
		g.setCurrencyId("1");
		g.setIsElite(1);
		g.setPairSn(2);
		g.setIsEnable(1);
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
     * @param @param currencyTradePairVO
     * @param @return
     * @param @throws Exception
     * @return PageInfo
     * @throws
     */
    public PageBean selectPage(HttpServletRequest request,CurrencyTradePairVO currencyTradePairVO) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("PSIZE", currencyTradePairVO.getRows());
        map.put("BEGIN", (currencyTradePairVO.getPage() - 1) * currencyTradePairVO.getRows());
        
        if (null != currencyTradePairVO.getIsEnable()) {
        	map.put("isEnable", currencyTradePairVO.getIsEnable());
        }
        if (null != currencyTradePairVO.getIsElite()) {
        	map.put("isElite", currencyTradePairVO.getIsElite());
        }
        
        
        Integer count = 0;
        // 查询总记录数
        try {
           /* String method = "currencyTradePair_getPageCount";
            String json = SendRequestUtil.sendMapRequest(request, map, method);*/
        	String json = this.testPage();
        	if (null != json) {
        		PageBean pageInfo = JSON.parseObject(json, PageBean.class);
                count = pageInfo.getTotalCount();
                if (count == 0) {
                	return new PageBean(currencyTradePairVO.getRows(), currencyTradePairVO.getPage(), count, new ArrayList<CurrencyTradePair>());
                }
        	}else {
            	return new PageBean(currencyTradePairVO.getRows(), currencyTradePairVO.getPage(), count, new ArrayList<CurrencyTradePair>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[币种管理-币种交易对-查询总记录条数]请求后台出错",e);
			return new PageBean(currencyTradePairVO.getRows(), currencyTradePairVO.getPage(), count, new ArrayList<CurrencyTradePair>());
		}
        
        
        // 查询列表
        try {
			/*String method = "currencyTradePair_getList";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
        	String json = this.testPage();
        	if (null != json) {
        		PageBean pageInfo = JSON.parseObject(json, PageBean.class);
                return pageInfo;
            }else {
            	return new PageBean(currencyTradePairVO.getRows(), currencyTradePairVO.getPage(), 0, new ArrayList<CurrencyTradePair>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[币种管理-币种交易对-查询所有记录]请求后台出错",e);
			return new PageBean(currencyTradePairVO.getRows(), currencyTradePairVO.getPage(), 0, new ArrayList<CurrencyTradePair>());
		}
        
    }

    
    /**
     * 
     * @Title: get
     * @Description: 查询一条记录
     * @param @param pairId
     * @param @return
     * @param @throws Exception
     * @return GCurrencyTradePair
     * @throws
     */
    public CurrencyTradePair get(HttpServletRequest request,String pairId) throws Exception {
    	try {
    		Map<String,Object> map = new HashMap<String, Object>();
    		map.put("pairId", pairId);
			/*String method = "currencyTradePair_getOne";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
    		String json = CurrencyTradePairService.testOne();
			if (null != json) {
				CurrencyTradePair gCurrencyTradePair = JSON.parseObject(json, CurrencyTradePair.class);
				return gCurrencyTradePair;
			}else {
				return new CurrencyTradePair();
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[币种管理-币种交易对-查询一条记录]请求后台出错",e);
			return new CurrencyTradePair();
		}
    }

    
    /**
     * 
     * @Title: add
     * @Description: 新增一条记录
     * @param @param request
     * @param @param currencyTradePair
     * @param @return
     * @param @throws Exception
     * @return boolean
     * @throws
     */
    public boolean add(HttpServletRequest request,CurrencyTradePair currencyTradePair) throws Exception {
    	try {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("GCurrencyTradePair", currencyTradePair);
			/*String method = "currencyTradePair_add";
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
			logger.error("[币种管理-币种交易对-新增一条记录]请求后台出错",e);
			return false;
		}
    }

    
    /**
     * 
     * @Title: update
     * @Description: 修改一条数据
     * @param @param request
     * @param @param currencyTradePair
     * @param @return
     * @param @throws Exception
     * @return boolean
     * @throws
     */
    public boolean update(HttpServletRequest request,CurrencyTradePair currencyTradePair) throws Exception {
    	try {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("GCurrencyTradePair", currencyTradePair);
			/*String method = "currencyTradePair_update";
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
			logger.error("[币种管理-币种交易对-修改一条记录]请求后台出错",e);
			return false;
		}
    }
    
    
    
    /**
     * 
     * @Title: delete
     * @Description: 删除一条记录
     * @param @param request
     * @param @param pairId
     * @param @return
     * @param @throws Exception
     * @return boolean
     * @throws
     */
    public boolean delete(HttpServletRequest request,String pairId) throws Exception {
    	try {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("pairId", pairId);
			/*String method = "currencyTradePair_delete";
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
			logger.error("[币种管理-币种交易对-删除一条记录]请求后台出错",e);
			return false;
		}
    }
    /**
	 * 获取所有数据
	 */
	/*public List<GCurrencyTradePair> selectAll(GCurrencyTradePairVO currencyTradePairVO) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		return currencyTradePair_dao.selectAll(map);
	} */


}
