package com.manage.bus.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.manage.base.entity.PageInfo;
import com.manage.bus.dao.GUserDAO;
import com.manage.bus.entity.GCurrency;
import com.manage.bus.entity.GCurrencyData;
import com.manage.bus.entity.GUser;
import com.manage.bus.vo.GUserVO;


/**
 * 
 * @Project：gme-admin   
 * @Class：GUserService   
 * @Description 类描述：用户信息service   
 * @Author：zhou   
 * @Date：2018年6月13日 上午10:52:47   
 * @version V1.0
 */
@Transactional(readOnly = true)
@Service("GUserService")
public class GUserService{

	private  Logger logger = Logger.getLogger(GUserService.class);
	
	@Value("${SERVICE_BASE_PARAM}")
    private String SERVICE_BASE_PARAM;
	

    
 // 测试分页查询
    public static String testPage() {
		List<GUser> list = new ArrayList<GUser>();
		GUser g = new GUser();
		g.setName("张三");
		g.setIs_supplier(1);
		g.setCountry_code("86");
		g.setStatus(1);
		g.setIs_second_verify(2);
		list.add(g);
		PageInfo pageInfo = new PageInfo(1, 1,1, list);
		return JSON.toJSONString(pageInfo);
	}

 // 测试查询一条记录
    public static String testOne() {
    	GUser g = new GUser();
    	g.setName("张三");
		g.setIs_supplier(1);
		g.setCountry_code("86");
		g.setStatus(1);
		g.setIs_second_verify(2);
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
     * @param @param g_user_vo
     * @param @return
     * @param @throws Exception
     * @return PageInfo
     * @throws
     */
    public PageInfo selectPage(HttpServletRequest request,GUserVO g_user_vo) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("PSIZE", g_user_vo.getRows());
        map.put("BEGIN", (g_user_vo.getPage() - 1) * g_user_vo.getRows());
        
        if (null != g_user_vo.getName() && !StringUtils.isBlank(g_user_vo.getName())) {
        	map.put("name", g_user_vo.getName());
        }
        if (null != g_user_vo.getStatus()) {
        	map.put("status", g_user_vo.getStatus());
        }
        if (null != g_user_vo.getIs_second_verify()) {
        	map.put("isSecondVerify", g_user_vo.getIs_second_verify());
        }
        if (null != g_user_vo.getIs_supplier()) {
        	map.put("isSupplier", g_user_vo.getIs_supplier());
        }
        
        
        Integer count = 0;
        // 查询总记录数
        try {
           /* String method = SERVICE_BASE_PARAM + "g_user_getPageCount";
            String json = SendRequestUtil.sendMapRequest(request, map, method);*/
        	String json = GUserService.testPage();
        	if (null != json) {
        		PageInfo pageInfo = JSON.parseObject(json, PageInfo.class);
                count = pageInfo.getTotalCount();
                if (count == 0) {
                	return new PageInfo(g_user_vo.getRows(), g_user_vo.getPage(), count, new ArrayList<GUser>());
                }
        	}else {
            	return new PageInfo(g_user_vo.getRows(), g_user_vo.getPage(), count, new ArrayList<GUser>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[用户管理-用户信息-查询总记录条数]请求后台出错",e);
			return new PageInfo(g_user_vo.getRows(), g_user_vo.getPage(), count, new ArrayList<GUser>());
		}
        
        
        // 查询列表
        try {
			/*String method = SERVICE_BASE_PARAM + "g_user_getList";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
        	String json = GUserService.testPage();
        	if (null != json) {
        		PageInfo pageInfo = JSON.parseObject(json, PageInfo.class);
                return pageInfo;
            }else {
            	return new PageInfo(g_user_vo.getRows(), g_user_vo.getPage(), 0, new ArrayList<GUser>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[用户管理-用户信息-查询所有记录]请求后台出错",e);
			return new PageInfo(g_user_vo.getRows(), g_user_vo.getPage(), 0, new ArrayList<GUser>());
		}
    }

    
    /**
     * 
     * @Title: get
     * @Description: 查询一条记录
     * @param @param request
     * @param @param uid
     * @param @return
     * @param @throws Exception
     * @return GUser
     * @throws
     */
    public GUser get(HttpServletRequest request,String uid) throws Exception {
        try {
    		Map<String,Object> map = new HashMap<String, Object>();
    		map.put("uid", uid);
			/*String method = SERVICE_BASE_PARAM + "g_user_getOne";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
    		String json = GUserService.testOne();
			if (null != json) {
				GUser gUser = JSON.parseObject(json, GUser.class);
				return gUser;
			}else {
				return new GUser();
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[用户管理-用户信息-查询一条记录]请求后台出错",e);
			return new GUser();
		}
    }

    
    /**
     * 
     * @Title: add
     * @Description: 新增一条数据
     * @param @param request
     * @param @param g_user
     * @param @return
     * @param @throws Exception
     * @return boolean
     * @throws
     */
    public boolean add(HttpServletRequest request,GUser g_user) throws Exception {
    	try {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("GUser", g_user);
			/*String method = SERVICE_BASE_PARAM + "g_user_add";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
			String json = GUserService.testAdd();
			if (null != json) {
				Boolean flag = JSON.parseObject(json,Boolean.class);
				return flag;
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[用户管理-用户信息-新增一条记录]请求后台出错",e);
			return false;
		}
    }

    
    /**
     * 
     * @Title: update
     * @Description: 修改一条数据
     * @param @param request
     * @param @param g_user
     * @param @return
     * @param @throws Exception
     * @return boolean
     * @throws
     */
    public boolean update(HttpServletRequest request,GUser g_user) throws Exception {
    	try {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("GUser", g_user);
			/*String method = SERVICE_BASE_PARAM + "g_user_update";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
			String json = GUserService.testUpdate();
			if (null != json) {
				Boolean flag = JSON.parseObject(json,Boolean.class);
				return flag;
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[用户管理-用户信息-修改一条记录]请求后台出错",e);
			return false;
		}
    }
    
    
    /**
     * 
     * @Title: delete
     * @Description: 删除一条数据
     * @param @param request
     * @param @param uid
     * @param @return
     * @param @throws Exception
     * @return boolean
     * @throws
     */
    public boolean delete(HttpServletRequest request,String uid) throws Exception {
    	try {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("uid", uid);
			/*String method = SERVICE_BASE_PARAM + "g_user_delete";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
			String json = GUserService.testDelete();
			if (null != json) {
				Boolean flag = JSON.parseObject(json,Boolean.class);
				return flag;
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[用户管理-用户信息-删除一条记录]请求后台出错",e);
			return false;
		}
    }
    /**
	 * 获取所有数据
	 */
	/*public List<GUser> selectAll(GUserVO g_user_vo) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		return g_user_dao.selectAll(map);
	} */


}
