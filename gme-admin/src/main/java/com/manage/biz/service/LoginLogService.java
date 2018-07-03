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

import com.alibaba.fastjson.JSON;
import com.manage.base.entity.PageBean;
import com.manage.biz.entity.LoginLog;
import com.manage.biz.vo.LoginLogVO;
import com.manage.util.StringUtil;


/**
 * 
 * @Project：gme-admin   
 * @Class：GLoginLogService   
 * @Description 类描述：用户登录日记管理   
 * @Author：zhou   
 * @Date：2018年6月20日 下午2:30:39   
 * @version V1.0
 */
@Service("LoginLogService")
public class LoginLogService{

	private Logger logger = Logger.getLogger(LoginLogService.class);
	
   	
    
   	
 // 测试分页查询
    public static String testPage() {
		List<LoginLog> list = new ArrayList<LoginLog>();
		LoginLog g = new LoginLog();
		g.setUid("1");
		g.setAccount("aaa");
		g.setClientType("pc");
		g.setErrorReason("输入登录密码错误5次");
		g.setHomeAddress("深圳");
		g.setLogId("1");
		g.setLoginIp("143.23.42.54");
		g.setStatus("failed");
		
		LoginLog g1 = new LoginLog();
		g1.setUid("2");
		g1.setAccount("bbb");
		g1.setClientType("登录成功");
		g.setErrorReason("输入登录密码错误5次");
		g1.setHomeAddress("广东");
		g1.setLogId("2");
		g1.setLoginIp("43.23.42.54");
		g1.setStatus("success");
		list.add(g);
		list.add(g1);

		PageBean pageInfo = new PageBean(1, 1,1, list);
		return JSON.toJSONString(pageInfo);
	}

    // 测试查询一条记录
    public static String testOne() {
    	LoginLog g = new LoginLog();
		g.setUid("1");
		g.setAccount("aaa");
		g.setClientType("pc");
		g.setErrorReason("输入登录密码错误5次");
		g.setHomeAddress("深圳");
		g.setLogId("1");
		g.setLoginIp("143.23.42.54");
		g.setStatus("failed");
		return JSON.toJSONString(g);
    }

    
    /**
     * 
     * @Title: selectPage
     * @Description: 分页查询
     * @param @param request
     * @param @param loginLogVO
     * @param @return
     * @param @throws Exception
     * @return PageInfo
     * @throws
     */
    public PageBean selectPage(HttpServletRequest request,LoginLogVO loginLogVO) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("PSIZE", loginLogVO.getRows());
        map.put("BEGIN", (loginLogVO.getPage() - 1) * loginLogVO.getRows());
        
        if (null != loginLogVO.getAccount() && !StringUtils.isBlank(loginLogVO.getAccount())) {
        	map.put("account", loginLogVO.getAccount());
        }
        if (null != loginLogVO.getUid() && !StringUtils.isBlank(loginLogVO.getUid())) {
        	if (StringUtil.isNumeric(loginLogVO.getUid())) {
        		map.put("uid", loginLogVO.getUid());
        	}
        }
        if (null != loginLogVO.getLoginIp() && !StringUtils.isBlank(loginLogVO.getLoginIp())) {
        	map.put("loginIp", loginLogVO.getLoginIp());
        }
        if (null != loginLogVO.getStatus() && !StringUtils.isBlank(loginLogVO.getStatus())) {
        	map.put("status", loginLogVO.getStatus());
        }
        
        
        Integer count = 0;
        // 查询总记录数
        try {
           /* String method = "g_login_log_getPageCount";
            String json = SendRequestUtil.sendMapRequest(request, map, method);*/
        	String json = this.testPage();
        	if (null != json) {
        		PageBean pageInfo = JSON.parseObject(json, PageBean.class);
                count = pageInfo.getTotalCount();
                if (count == 0) {
                	return new PageBean(loginLogVO.getRows(), loginLogVO.getPage(), count, new ArrayList<LoginLog>());
                }
        	}else {
            	return new PageBean(loginLogVO.getRows(), loginLogVO.getPage(), count, new ArrayList<LoginLog>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[日志管理-登录日志管理-查询总记录条数]请求后台出错",e);
			return new PageBean(loginLogVO.getRows(), loginLogVO.getPage(), count, new ArrayList<LoginLog>());
		}
        
        
        // 查询列表
        try {
			/*String method = "g_login_log_getList";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
        	String json = this.testPage();
        	if (null != json) {
        		PageBean pageInfo = JSON.parseObject(json, PageBean.class);
                return pageInfo;
            }else {
            	return new PageBean(loginLogVO.getRows(), loginLogVO.getPage(), 0, new ArrayList<LoginLog>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[日志管理-登录日志管理-查询所有记录]请求后台出错",e);
			return new PageBean(loginLogVO.getRows(), loginLogVO.getPage(), 0, new ArrayList<LoginLog>());
		}
    }

    
    /**
     * 
     * @Title: get
     * @Description: 查询一条记录
     * @param @param request
     * @param @param logId
     * @param @return
     * @param @throws Exception
     * @return GLoginLog
     * @throws
     */
    public LoginLog get(HttpServletRequest request,String logId) throws Exception {
    	try {
    		Map<String,Object> map = new HashMap<String, Object>();
    		map.put("logId", logId);
			/*String method = "g_login_log_getOne";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
    		String json = this.testOne();
			if (null != json) {
				LoginLog gLoginLog = JSON.parseObject(json, LoginLog.class);
				return gLoginLog;
			}else {
				return new LoginLog();
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[日志管理-登录日志管理-查询一条记录]请求后台出错",e);
			return new LoginLog();
		}
    }

    /**
     * 新增
     */
    /*public boolean add(GLoginLog g_login_log) throws Exception {
        Integer result = g_login_log_dao.add(g_login_log);
        return result > 0 ? true : false;
    }*/

    /**
     * 修改
     */
    /*public boolean update(GLoginLog g_login_log) throws Exception {
        Integer result = g_login_log_dao.update(g_login_log);
        return result > 0 ? true : false;
    }*/
    
	 /**
     * 删除
     */
    /*public boolean delete(java.lang.String logId) throws Exception {
        Integer result = g_login_log_dao.deleteById(logId);
        return result > 0 ? true : false;
    }*/
    
    /**
	 * 获取所有数据
	 */
	/*public List<GLoginLog> selectAll(GLoginLogVO loginLogVO) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		return g_login_log_dao.selectAll(map);
	} */


}
