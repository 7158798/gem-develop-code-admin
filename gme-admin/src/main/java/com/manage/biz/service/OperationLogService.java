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
import com.manage.biz.entity.OperationLog;
import com.manage.biz.vo.OperationLogVO;
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
@Service("OperationLogService")
public class OperationLogService{

	private Logger logger = Logger.getLogger(OperationLogService.class);
	
	@Value("${SERVICE_BASE_PARAM}")
    private String SERVICE_BASE_PARAM;
	
	// 测试分页查询
    public static String testPage() {
		List<OperationLog> list = new ArrayList<OperationLog>();
		OperationLog g = new OperationLog();
		g.setBizDesc("业务描述业务描述业务描述");
		g.setBizId("1");
		g.setBizType(1);
		g.setClientIp("13.42.42.45");
		g.setClientType("pc");
		g.setHttpUserAgent("http请求http请求http请求");
		g.setId("1");
		g.setStatus("success");
		g.setUid("1");
		
		OperationLog g1 = new OperationLog();
		g1.setBizDesc("业务描述业务描述业务描述不不不不不");
		g1.setBizId("2");
		g1.setBizType(2);
		g1.setClientIp("13.442.22.45");
		g1.setClientType("ios");
		g1.setHttpUserAgent("http请求http请求http请求bbbbbbb");
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
    	OperationLog g = new OperationLog();
		g.setBizDesc("业务描述业务描述业务描述");
		g.setBizId("1");
		g.setBizType(1);
		g.setClientIp("13.42.42.45");
		g.setClientType("pc");
		g.setHttpUserAgent("http请求http请求http请求");
		g.setId("1");
		g.setStatus("success");
		g.setUid("1");
		return JSON.toJSONString(g);
    }
	
	

    /**
     * 
     * @Title: selectPage
     * @Description: 分页查询
     * @param @param request
     * @param @param operationLogVO
     * @param @return
     * @param @throws Exception
     * @return PageInfo
     * @throws
     */
    public PageInfo selectPage(HttpServletRequest request,OperationLogVO operationLogVO) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("PSIZE", operationLogVO.getRows());
        map.put("BEGIN", (operationLogVO.getPage() - 1) * operationLogVO.getRows());
        
        if (null != operationLogVO.getUid() && !StringUtils.isBlank(operationLogVO.getUid())) {
        	if (StringUtil.isNumeric(operationLogVO.getUid())) {
        		map.put("uid", operationLogVO.getUid());
        	}
        }
        if (null != operationLogVO.getBizId() && !StringUtils.isBlank(operationLogVO.getBizId())) {
        	if (StringUtil.isNumeric(operationLogVO.getBizId())) {
        		map.put("bizId", operationLogVO.getBizId());
        	}
        }
        if (null != operationLogVO.getBizType()) {
        	map.put("bizType", operationLogVO.getBizType());
        }
        if (null != operationLogVO.getStatus() && !StringUtils.isBlank(operationLogVO.getStatus())) {
        	map.put("status", operationLogVO.getStatus());
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
                	return new PageInfo(operationLogVO.getRows(), operationLogVO.getPage(), count, new ArrayList<OperationLog>());
                }
        	}else {
            	return new PageInfo(operationLogVO.getRows(), operationLogVO.getPage(), count, new ArrayList<OperationLog>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[日志管理-用户操作日记管理-查询总记录条数]请求后台出错",e);
			return new PageInfo(operationLogVO.getRows(), operationLogVO.getPage(), count, new ArrayList<OperationLog>());
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
            	return new PageInfo(operationLogVO.getRows(), operationLogVO.getPage(), 0, new ArrayList<OperationLog>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[日志管理-用户操作日记管理-查询所有记录]请求后台出错",e);
			return new PageInfo(operationLogVO.getRows(), operationLogVO.getPage(), 0, new ArrayList<OperationLog>());
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
    public OperationLog get(HttpServletRequest request,String id) throws Exception {
    	try {
    		Map<String,Object> map = new HashMap<String, Object>();
    		map.put("id", id);
			/*String method = SERVICE_BASE_PARAM + "g_operation_log_getOne";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
    		String json = this.testOne();
			if (null != json) {
				OperationLog gOperationLog = JSON.parseObject(json, OperationLog.class);
				return gOperationLog;
			}else {
				return new OperationLog();
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[日志管理-用户操作日记管理-查询一条记录]请求后台出错",e);
			return new OperationLog();
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
	/*public List<GOperationLog> selectAll(GOperationLogVO operationLogVO) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		return g_operation_log_dao.selectAll(map);
	} */


}
