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
import com.manage.biz.entity.MessageState;
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
@Service("MessageStateService")
public class MessageStateService{
	
	private Logger logger = Logger.getLogger(MessageStateService.class);
	
   	@Value("${SERVICE_BASE_PARAM}")
    private String SERVICE_BASE_PARAM;

 // 测试分页查询
    public static String testPage() {
		List<MessageState> list = new ArrayList<MessageState>();
		MessageState g = new MessageState();
		g.setUid("1");
		g.setBizContent("业务内容啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊");
		g.setType(1);
		g.setBizDesc("业务描述");
		g.setBizId("1");
		g.setClientIp("11.32.54.54");
		g.setCountryCode("86");
		g.setErrorReason("异常异常异常异常异常");
		g.setStatus("success");
		
		
		MessageState g1 = new MessageState();
		g1.setUid("2");
		g1.setType(2);
		g1.setBizContent("业务内容不不不不不不不不不不");
		g1.setBizDesc("业务描述111111");
		g1.setBizId("2");
		g1.setClientIp("64.32.11.54");
		g1.setCountryCode("1");
		g1.setErrorReason("异常异常异常异常异常");
		g1.setStatus("failed");
		list.add(g);
		list.add(g1);

		PageInfo pageInfo = new PageInfo(1, 1,1, list);
		return JSON.toJSONString(pageInfo);
	}

    // 测试查询一条记录
    public static String testOne() {
    	MessageState g = new MessageState();
		g.setUid("1");
		g.setBizContent("业务内容啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊");
		g.setType(1);
		g.setBizDesc("业务描述");
		g.setBizId("1");
		g.setClientIp("11.32.54.54");
		g.setCountryCode("86");
		g.setErrorReason("异常异常异常异常异常");
		g.setStatus("success");
		return JSON.toJSONString(g);
    }

    
    /**
     * 
     * @Title: selectPage
     * @Description: 分页查询
     * @param @param request
     * @param @param messageStateVO
     * @param @return
     * @param @throws Exception
     * @return PageInfo
     * @throws
     */
    public PageInfo selectPage(HttpServletRequest request,GMessageStateVO messageStateVO) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("PSIZE", messageStateVO.getRows());
        map.put("BEGIN", (messageStateVO.getPage() - 1) * messageStateVO.getRows());
        
        if (null != messageStateVO.getBizId() && !StringUtils.isBlank(messageStateVO.getBizId())) {
        	if (StringUtil.isNumeric(messageStateVO.getBizId())) {
        		map.put("bizId", messageStateVO.getBizId());
        	}
        }
        if (null != messageStateVO.getUid() && !StringUtils.isBlank(messageStateVO.getUid())) {
        	if (StringUtil.isNumeric(messageStateVO.getUid())) {
        		map.put("uid", messageStateVO.getUid());
        	}
        }
        if (null != messageStateVO.getType()) {
        	map.put("type", messageStateVO.getType());
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
                	return new PageInfo(messageStateVO.getRows(), messageStateVO.getPage(), count, new ArrayList<MessageState>());
                }
        	}else {
            	return new PageInfo(messageStateVO.getRows(), messageStateVO.getPage(), count, new ArrayList<MessageState>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[日志管理-短信邮件日志管理-查询总记录条数]请求后台出错",e);
			return new PageInfo(messageStateVO.getRows(), messageStateVO.getPage(), count, new ArrayList<MessageState>());
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
            	return new PageInfo(messageStateVO.getRows(), messageStateVO.getPage(), 0, new ArrayList<MessageState>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[日志管理-短信邮件日志管理-查询所有记录]请求后台出错",e);
			return new PageInfo(messageStateVO.getRows(), messageStateVO.getPage(), 0, new ArrayList<MessageState>());
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
    public MessageState get(HttpServletRequest request,String id) throws Exception {
    	try {
    		Map<String,Object> map = new HashMap<String, Object>();
    		map.put("id", id);
			/*String method = SERVICE_BASE_PARAM + "g_message_state_getOne";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
    		String json = this.testOne();
			if (null != json) {
				MessageState gMessageState = JSON.parseObject(json, MessageState.class);
				return gMessageState;
			}else {
				return new MessageState();
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[日志管理-短信邮件日志管理-查询一条记录]请求后台出错",e);
			return new MessageState();
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
	/*public List<GMessageState> selectAll(GMessageStateVO messageStateVO) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		return g_message_state_dao.selectAll(map);
	} */


}
