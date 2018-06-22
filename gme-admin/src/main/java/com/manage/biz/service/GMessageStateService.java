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
import com.manage.biz.entity.GMessageState;
import com.manage.biz.vo.GMessageStateVO;
import com.manage.util.StringUtil;



/**
 * 
 * @Project：gme-admin   
 * @Class：GMessageStateService   
 * @Description 类描述：短信邮件发送状态   
 * @Author：zhou   
 * @Date：2018年6月20日 下午3:32:23   
 * @version V1.0
 */
@Service("GMessageStateService")
public class GMessageStateService{
	
	private Logger logger = Logger.getLogger(GMessageStateService.class);
	
   	@Value("${SERVICE_BASE_PARAM}")
    private String SERVICE_BASE_PARAM;

 // 测试分页查询
    public static String testPage() {
		List<GMessageState> list = new ArrayList<GMessageState>();
		GMessageState g = new GMessageState();
		g.setUid("1");
		g.setBiz_content("业务内容啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊");
		g.setType(1);
		g.setBiz_desc("业务描述");
		g.setBiz_id("1");
		g.setClient_ip("11.32.54.54");
		g.setCountry_code("86");
		g.setError_reason("异常异常异常异常异常");
		g.setStatus("success");
		
		
		GMessageState g1 = new GMessageState();
		g1.setUid("2");
		g1.setType(2);
		g1.setBiz_content("业务内容不不不不不不不不不不");
		g1.setBiz_desc("业务描述111111");
		g1.setBiz_id("2");
		g1.setClient_ip("64.32.11.54");
		g1.setCountry_code("1");
		g1.setError_reason("异常异常异常异常异常");
		g1.setStatus("failed");
		list.add(g);
		list.add(g1);

		PageInfo pageInfo = new PageInfo(1, 1,1, list);
		return JSON.toJSONString(pageInfo);
	}

    // 测试查询一条记录
    public static String testOne() {
    	GMessageState g = new GMessageState();
		g.setUid("1");
		g.setType(2);
		g.setBiz_content("业务内容啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊");
		g.setBiz_desc("业务描述");
		g.setBiz_id("1");
		g.setClient_ip("11.32.54.54");
		g.setCountry_code("86");
		g.setError_reason("异常异常异常异常异常");
		g.setStatus("success");
		return JSON.toJSONString(g);
    }

    
    /**
     * 
     * @Title: selectPage
     * @Description: 分页查询
     * @param @param request
     * @param @param g_message_state_vo
     * @param @return
     * @param @throws Exception
     * @return PageInfo
     * @throws
     */
    public PageInfo selectPage(HttpServletRequest request,GMessageStateVO g_message_state_vo) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("PSIZE", g_message_state_vo.getRows());
        map.put("BEGIN", (g_message_state_vo.getPage() - 1) * g_message_state_vo.getRows());
        
        if (null != g_message_state_vo.getBiz_id() && !StringUtils.isBlank(g_message_state_vo.getBiz_id())) {
        	if (StringUtil.isNumeric(g_message_state_vo.getBiz_id())) {
        		map.put("bizId", g_message_state_vo.getBiz_id());
        	}
        }
        if (null != g_message_state_vo.getUid() && !StringUtils.isBlank(g_message_state_vo.getUid())) {
        	if (StringUtil.isNumeric(g_message_state_vo.getUid())) {
        		map.put("uid", g_message_state_vo.getUid());
        	}
        }
        if (null != g_message_state_vo.getType()) {
        	map.put("type", g_message_state_vo.getType());
        }

        
        Integer count = 0;
        // 查询总记录数
        try {
           /* String method = SERVICE_BASE_PARAM + "g_message_state_getPageCount";
            String json = SendRequestUtil.sendMapRequest(request, map, method);*/
        	String json = this.testPage();
        	if (null != json) {
        		PageInfo pageInfo = JSON.parseObject(json, PageInfo.class);
                count = pageInfo.getTotalCount();
                if (count == 0) {
                	return new PageInfo(g_message_state_vo.getRows(), g_message_state_vo.getPage(), count, new ArrayList<GMessageState>());
                }
        	}else {
            	return new PageInfo(g_message_state_vo.getRows(), g_message_state_vo.getPage(), count, new ArrayList<GMessageState>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[日志管理-短信邮件日志管理-查询总记录条数]请求后台出错",e);
			return new PageInfo(g_message_state_vo.getRows(), g_message_state_vo.getPage(), count, new ArrayList<GMessageState>());
		}
        
        
        // 查询列表
        try {
			/*String method = SERVICE_BASE_PARAM + "g_message_state_getList";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
        	String json = this.testPage();
        	if (null != json) {
        		PageInfo pageInfo = JSON.parseObject(json, PageInfo.class);
                return pageInfo;
            }else {
            	return new PageInfo(g_message_state_vo.getRows(), g_message_state_vo.getPage(), 0, new ArrayList<GMessageState>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[日志管理-短信邮件日志管理-查询所有记录]请求后台出错",e);
			return new PageInfo(g_message_state_vo.getRows(), g_message_state_vo.getPage(), 0, new ArrayList<GMessageState>());
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
     * @return GMessageState
     * @throws
     */
    public GMessageState get(HttpServletRequest request,String id) throws Exception {
    	try {
    		Map<String,Object> map = new HashMap<String, Object>();
    		map.put("id", id);
			/*String method = SERVICE_BASE_PARAM + "g_message_state_getOne";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
    		String json = this.testOne();
			if (null != json) {
				GMessageState gMessageState = JSON.parseObject(json, GMessageState.class);
				return gMessageState;
			}else {
				return new GMessageState();
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[日志管理-短信邮件日志管理-查询一条记录]请求后台出错",e);
			return new GMessageState();
		}
    }

    /**
     * 新增
     */
    /*public boolean add(GMessageState g_message_state) throws Exception {
        Integer result = g_message_state_dao.add(g_message_state);
        return result > 0 ? true : false;
    }*/

    /**
     * 修改
     */
    /*public boolean update(GMessageState g_message_state) throws Exception {
        Integer result = g_message_state_dao.update(g_message_state);
        return result > 0 ? true : false;
    }*/
    
	 /**
     * 删除
     */
    /*public boolean delete(java.lang.String id) throws Exception {
        Integer result = g_message_state_dao.deleteById(id);
        return result > 0 ? true : false;
    }*/
    
    /**
	 * 获取所有数据
	 */
	/*public List<GMessageState> selectAll(GMessageStateVO g_message_state_vo) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		return g_message_state_dao.selectAll(map);
	} */


}
