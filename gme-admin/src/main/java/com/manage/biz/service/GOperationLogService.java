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
import com.manage.biz.entity.GOperationLog;
import com.manage.biz.vo.GOperationLogVO;
import com.manage.util.StringUtil;


/**
 * 
 * @Project：gme-admin   
 * @Class：GOperationLogService   
 * @Description 类描述：操作日志表   
 * @Author：zhou   
 * @Date：2018年6月21日 下午4:22:05   
 * @version V1.0
 */
@Transactional(readOnly = true)
@Service("GOperationLogService")
public class GOperationLogService{

	private Logger logger = Logger.getLogger(GOperationLogService.class);
	
	@Value("${SERVICE_BASE_PARAM}")
    private String SERVICE_BASE_PARAM;
	
	// 测试分页查询
    public static String testPage() {
		List<GOperationLog> list = new ArrayList<GOperationLog>();
		GOperationLog g = new GOperationLog();
		g.setBiz_desc("业务描述业务描述业务描述");
		g.setBiz_id("1");
		g.setBiz_type(1);
		g.setClient_ip("13.42.42.45");
		g.setClient_type("pc");
		g.setHttp_user_agent("http请求http请求http请求");
		g.setId("1");
		g.setStatus("success");
		g.setUid("1");
		
		GOperationLog g1 = new GOperationLog();
		g1.setBiz_desc("业务描述业务描述业务描述不不不不不");
		g1.setBiz_id("2");
		g1.setBiz_type(2);
		g1.setClient_ip("13.442.22.45");
		g1.setClient_type("ios");
		g1.setHttp_user_agent("http请求http请求http请求bbbbbbb");
		g1.setId("2");
		g1.setStatus("failed");
		g1.setUid("2");
		list.add(g);
		list.add(g1);
		PageInfo pageInfo = new PageInfo(1, 1,1, list);
		return JSON.toJSONString(pageInfo);
	}

    // 测试查询一条记录
    public static String testOne() {
    	GOperationLog g = new GOperationLog();
		g.setBiz_desc("业务描述业务描述业务描述dasfdasffafasfffdasffsffdas");
		g.setBiz_id("1");
		g.setBiz_type(1);
		g.setClient_ip("13.42.42.45");
		g.setClient_type("pc");
		g.setHttp_user_agent("http请求http请求http请求");
		g.setId("1");
		g.setStatus("success");
		g.setUid("1");
		g.setError_reason("fafasfasdaafasdfasdddddddddddddddddddddd");
		return JSON.toJSONString(g);
    }
	
	

    /**
     * 
     * @Title: selectPage
     * @Description: 分页查询
     * @param @param request
     * @param @param g_operation_log_vo
     * @param @return
     * @param @throws Exception
     * @return PageInfo
     * @throws
     */
    public PageInfo selectPage(HttpServletRequest request,GOperationLogVO g_operation_log_vo) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("PSIZE", g_operation_log_vo.getRows());
        map.put("BEGIN", (g_operation_log_vo.getPage() - 1) * g_operation_log_vo.getRows());
        
        if (null != g_operation_log_vo.getUid() && !StringUtils.isBlank(g_operation_log_vo.getUid())) {
        	if (StringUtil.isNumeric(g_operation_log_vo.getUid())) {
        		map.put("uid", g_operation_log_vo.getUid());
        	}
        }
        if (null != g_operation_log_vo.getBiz_id() && !StringUtils.isBlank(g_operation_log_vo.getBiz_id())) {
        	if (StringUtil.isNumeric(g_operation_log_vo.getBiz_id())) {
        		map.put("bizId", g_operation_log_vo.getBiz_id());
        	}
        }
        if (null != g_operation_log_vo.getBiz_type()) {
        	map.put("bizType", g_operation_log_vo.getBiz_type());
        }
        if (null != g_operation_log_vo.getStatus() && !StringUtils.isBlank(g_operation_log_vo.getStatus())) {
        	map.put("status", g_operation_log_vo.getStatus());
        }
        
        
        
        Integer count = 0;
        // 查询总记录数
        try {
           /* String method = SERVICE_BASE_PARAM + "g_operation_log_getPageCount";
            String json = SendRequestUtil.sendMapRequest(request, map, method);*/
        	String json = this.testPage();
        	if (null != json) {
        		PageInfo pageInfo = JSON.parseObject(json, PageInfo.class);
                count = pageInfo.getTotalCount();
                if (count == 0) {
                	return new PageInfo(g_operation_log_vo.getRows(), g_operation_log_vo.getPage(), count, new ArrayList<GOperationLog>());
                }
        	}else {
            	return new PageInfo(g_operation_log_vo.getRows(), g_operation_log_vo.getPage(), count, new ArrayList<GOperationLog>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[日志管理-用户操作日记管理-查询总记录条数]请求后台出错",e);
			return new PageInfo(g_operation_log_vo.getRows(), g_operation_log_vo.getPage(), count, new ArrayList<GOperationLog>());
		}
        
        
        // 查询列表
        try {
			/*String method = SERVICE_BASE_PARAM + "g_operation_log_getList";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
        	String json = this.testPage();
        	if (null != json) {
        		PageInfo pageInfo = JSON.parseObject(json, PageInfo.class);
                return pageInfo;
            }else {
            	return new PageInfo(g_operation_log_vo.getRows(), g_operation_log_vo.getPage(), 0, new ArrayList<GOperationLog>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[日志管理-用户操作日记管理-查询所有记录]请求后台出错",e);
			return new PageInfo(g_operation_log_vo.getRows(), g_operation_log_vo.getPage(), 0, new ArrayList<GOperationLog>());
		}
    }

    
    /**
     * 
     * @Title: get
     * @Description: 查询一条记录
     * @param @param request
     * @param @param id
     * @param @return
     * @param @throws Exception
     * @return GOperationLog
     * @throws
     */
    public GOperationLog get(HttpServletRequest request,String id) throws Exception {
    	try {
    		Map<String,Object> map = new HashMap<String, Object>();
    		map.put("id", id);
			/*String method = SERVICE_BASE_PARAM + "g_operation_log_getOne";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
    		String json = this.testOne();
			if (null != json) {
				GOperationLog gOperationLog = JSON.parseObject(json, GOperationLog.class);
				return gOperationLog;
			}else {
				return new GOperationLog();
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[日志管理-用户操作日记管理-查询一条记录]请求后台出错",e);
			return new GOperationLog();
		}
    }

    /**
     * 新增
     */
    /*public boolean add(GOperationLog g_operation_log) throws Exception {
        Integer result = g_operation_log_dao.add(g_operation_log);
        return result > 0 ? true : false;
    }*/

    /**
     * 修改
     */
    /*public boolean update(GOperationLog g_operation_log) throws Exception {
        Integer result = g_operation_log_dao.update(g_operation_log);
        return result > 0 ? true : false;
    }*/
    
	 /**
     * 删除
     */
    /*public boolean delete(java.lang.String id) throws Exception {
        Integer result = g_operation_log_dao.deleteById(id);
        return result > 0 ? true : false;
    }*/
    
    /**
	 * 获取所有数据
	 */
	/*public List<GOperationLog> selectAll(GOperationLogVO g_operation_log_vo) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		return g_operation_log_dao.selectAll(map);
	} */


}
