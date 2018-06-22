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
import com.manage.base.entity.PageInfo;
import com.manage.biz.entity.GLoginLog;
import com.manage.biz.vo.GLoginLogVO;
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
@Service("GLoginLogService")
public class GLoginLogService{

	private Logger logger = Logger.getLogger(GLoginLogService.class);
	
   	@Value("${SERVICE_BASE_PARAM}")
    private String SERVICE_BASE_PARAM;
   	
 // 测试分页查询
    public static String testPage() {
		List<GLoginLog> list = new ArrayList<GLoginLog>();
		GLoginLog g = new GLoginLog();
		g.setUid("1");
		g.setAccount("aaa");
		g.setClient_type("pc");
		g.setError_reason("输入登录密码错误5次");
		g.setHome_address("深圳");
		g.setLog_id("1");
		g.setLogin_ip("143.23.42.54");
		g.setStatus("failed");
		
		GLoginLog g1 = new GLoginLog();
		g1.setUid("2");
		g1.setAccount("bbb");
		g1.setClient_type("android");
		g1.setError_reason("登录成功");
		g1.setHome_address("广东");
		g1.setLog_id("2");
		g1.setLogin_ip("43.23.42.54");
		g1.setStatus("success");
		list.add(g);
		list.add(g1);

		PageInfo pageInfo = new PageInfo(1, 1,1, list);
		return JSON.toJSONString(pageInfo);
	}

    // 测试查询一条记录
    public static String testOne() {
    	GLoginLog g = new GLoginLog();
		g.setUid("1");
		g.setAccount("aaa");
		g.setClient_type("pc");
		g.setError_reason("输入登录密码错误5次");
		g.setHome_address("深圳");
		g.setLog_id("1");
		g.setLogin_ip("143.23.42.54");
		g.setStatus("failed");
		return JSON.toJSONString(g);
    }

    
    /**
     * 
     * @Title: selectPage
     * @Description: 分页查询
     * @param @param request
     * @param @param g_login_log_vo
     * @param @return
     * @param @throws Exception
     * @return PageInfo
     * @throws
     */
    public PageInfo selectPage(HttpServletRequest request,GLoginLogVO g_login_log_vo) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("PSIZE", g_login_log_vo.getRows());
        map.put("BEGIN", (g_login_log_vo.getPage() - 1) * g_login_log_vo.getRows());
        
        if (null != g_login_log_vo.getAccount() && !StringUtils.isBlank(g_login_log_vo.getAccount())) {
        	map.put("account", g_login_log_vo.getAccount());
        }
        if (null != g_login_log_vo.getUid() && !StringUtils.isBlank(g_login_log_vo.getUid())) {
        	if (StringUtil.isNumeric(g_login_log_vo.getUid())) {
        		map.put("uid", g_login_log_vo.getUid());
        	}
        }
        if (null != g_login_log_vo.getLogin_ip() && !StringUtils.isBlank(g_login_log_vo.getLogin_ip())) {
        	map.put("loginIp", g_login_log_vo.getLogin_ip());
        }
        if (null != g_login_log_vo.getStatus() && !StringUtils.isBlank(g_login_log_vo.getStatus())) {
        	map.put("status", g_login_log_vo.getStatus());
        }
        
        
        Integer count = 0;
        // 查询总记录数
        try {
           /* String method = SERVICE_BASE_PARAM + "g_login_log_getPageCount";
            String json = SendRequestUtil.sendMapRequest(request, map, method);*/
        	String json = this.testPage();
        	if (null != json) {
        		PageInfo pageInfo = JSON.parseObject(json, PageInfo.class);
                count = pageInfo.getTotalCount();
                if (count == 0) {
                	return new PageInfo(g_login_log_vo.getRows(), g_login_log_vo.getPage(), count, new ArrayList<GLoginLog>());
                }
        	}else {
            	return new PageInfo(g_login_log_vo.getRows(), g_login_log_vo.getPage(), count, new ArrayList<GLoginLog>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[日志管理-登录日志管理-查询总记录条数]请求后台出错",e);
			return new PageInfo(g_login_log_vo.getRows(), g_login_log_vo.getPage(), count, new ArrayList<GLoginLog>());
		}
        
        
        // 查询列表
        try {
			/*String method = SERVICE_BASE_PARAM + "g_login_log_getList";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
        	String json = this.testPage();
        	if (null != json) {
        		PageInfo pageInfo = JSON.parseObject(json, PageInfo.class);
                return pageInfo;
            }else {
            	return new PageInfo(g_login_log_vo.getRows(), g_login_log_vo.getPage(), 0, new ArrayList<GLoginLog>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[日志管理-登录日志管理-查询所有记录]请求后台出错",e);
			return new PageInfo(g_login_log_vo.getRows(), g_login_log_vo.getPage(), 0, new ArrayList<GLoginLog>());
		}
    }

    
    /**
     * 
     * @Title: get
     * @Description: 查询一条记录
     * @param @param request
     * @param @param log_id
     * @param @return
     * @param @throws Exception
     * @return GLoginLog
     * @throws
     */
    public GLoginLog get(HttpServletRequest request,String log_id) throws Exception {
    	try {
    		Map<String,Object> map = new HashMap<String, Object>();
    		map.put("logId", log_id);
			/*String method = SERVICE_BASE_PARAM + "g_login_log_getOne";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
    		String json = this.testOne();
			if (null != json) {
				GLoginLog gLoginLog = JSON.parseObject(json, GLoginLog.class);
				return gLoginLog;
			}else {
				return new GLoginLog();
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[日志管理-登录日志管理-查询一条记录]请求后台出错",e);
			return new GLoginLog();
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
    /*public boolean delete(java.lang.String log_id) throws Exception {
        Integer result = g_login_log_dao.deleteById(log_id);
        return result > 0 ? true : false;
    }*/
    
    /**
	 * 获取所有数据
	 */
	/*public List<GLoginLog> selectAll(GLoginLogVO g_login_log_vo) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		return g_login_log_dao.selectAll(map);
	} */


}
