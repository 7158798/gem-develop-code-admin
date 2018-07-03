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
import com.manage.biz.entity.User;
import com.manage.biz.vo.UserVO;


/**
 * 
 * @Project：gme-admin   
 * @Class：GUserService   
 * @Description 类描述：用户信息service   
 * @Author：zhou   
 * @Date：2018年6月13日 上午10:52:47   
 * @version V1.0
 */
@Service("UserService")
public class UserService{

	private  Logger logger = Logger.getLogger(UserService.class);
	
	
    
	

    
 // 测试分页查询
    public static String testPage() {
		List<User> list = new ArrayList<User>();
		User g = new User();
		g.setName("张三");
		g.setIsSupplier(1);
		g.setCountryCode("86");
		g.setStatus(1);
		g.setIsSecondVerify(2);
		list.add(g);
		PageBean pageInfo = new PageBean(1, 1,1, list);
		return JSON.toJSONString(pageInfo);
	}

 // 测试查询一条记录
    public static String testOne() {
    	User g = new User();
		g.setName("张三");
		g.setIsSupplier(1);
		g.setCountryCode("86");
		g.setStatus(1);
		g.setIsSecondVerify(2);
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
     * @param @param userVO
     * @param @return
     * @param @throws Exception
     * @return PageInfo
     * @throws
     */
    public PageBean selectPage(HttpServletRequest request,UserVO userVO) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("PSIZE", userVO.getRows());
        map.put("BEGIN", (userVO.getPage() - 1) * userVO.getRows());
        
        if (null != userVO.getName() && !StringUtils.isBlank(userVO.getName())) {
        	map.put("name", userVO.getName());
        }
        if (null != userVO.getStatus()) {
        	map.put("status", userVO.getStatus());
        }
        if (null != userVO.getIsSecondVerify()) {
        	map.put("isSecondVerify", userVO.getIsSecondVerify());
        }
        if (null != userVO.getIsSupplier()) {
        	map.put("isSupplier", userVO.getIsSupplier());
        }
        
        
        Integer count = 0;
        // 查询总记录数
        try {
           /* String method = "user_getPageCount";
            String json = SendRequestUtil.sendMapRequest(request, map, method);*/
        	String json = UserService.testPage();
        	if (null != json) {
        		PageBean pageInfo = JSON.parseObject(json, PageBean.class);
                count = pageInfo.getTotalCount();
                if (count == 0) {
                	return new PageBean(userVO.getRows(), userVO.getPage(), count, new ArrayList<User>());
                }
        	}else {
            	return new PageBean(userVO.getRows(), userVO.getPage(), count, new ArrayList<User>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[用户管理-用户信息-查询总记录条数]请求后台出错",e);
			return new PageBean(userVO.getRows(), userVO.getPage(), count, new ArrayList<User>());
		}
        
        
        // 查询列表
        try {
			/*String method = "user_getList";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
        	String json = UserService.testPage();
        	if (null != json) {
        		PageBean pageInfo = JSON.parseObject(json, PageBean.class);
                return pageInfo;
            }else {
            	return new PageBean(userVO.getRows(), userVO.getPage(), 0, new ArrayList<User>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[用户管理-用户信息-查询所有记录]请求后台出错",e);
			return new PageBean(userVO.getRows(), userVO.getPage(), 0, new ArrayList<User>());
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
    public User get(HttpServletRequest request,String uid) throws Exception {
        try {
    		Map<String,Object> map = new HashMap<String, Object>();
    		map.put("uid", uid);
			/*String method = "user_getOne";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
    		String json = UserService.testOne();
			if (null != json) {
				User gUser = JSON.parseObject(json, User.class);
				return gUser;
			}else {
				return new User();
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[用户管理-用户信息-查询一条记录]请求后台出错",e);
			return new User();
		}
    }

    
    /**
     * 
     * @Title: add
     * @Description: 新增一条数据
     * @param @param request
     * @param @param user
     * @param @return
     * @param @throws Exception
     * @return boolean
     * @throws
     */
    /*public boolean add(HttpServletRequest request,GUser user) throws Exception {
    	try {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("GUser", user);
			String method = "user_add";
			String json = SendRequestUtil.sendMapRequest(request, map, method);
			String json = this.testAdd();
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
    }*/

    
    /**
     * 
     * @Title: update
     * @Description: 修改一条数据
     * @param @param request
     * @param @param user
     * @param @return
     * @param @throws Exception
     * @return boolean
     * @throws
     */
    public boolean update(HttpServletRequest request,User user) throws Exception {
    	try {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("GUser", user);
			/*String method = "user_update";
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
    /*public boolean delete(HttpServletRequest request,String uid) throws Exception {
    	try {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("uid", uid);
			String method = "user_delete";
			String json = SendRequestUtil.sendMapRequest(request, map, method);
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
    }*/
    /**
	 * 获取所有数据
	 */
	/*public List<GUser> selectAll(GUserVO userVO) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		return user_dao.selectAll(map);
	} */


}
