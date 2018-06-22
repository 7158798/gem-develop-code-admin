package com.manage.biz.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
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
import com.manage.biz.entity.GWorkOrderReply;
import com.manage.biz.entity.GWorkOrderReplyImage;
import com.manage.biz.vo.GWorkOrderReplyVO;
import com.manage.util.StringUtil;


/**
 * 
 * @Project：gme-admin   
 * @Class：GWorkOrderReplyService   
 * @Description 类描述：工单答复   
 * @Author：zhou   
 * @Date：2018年6月20日 上午11:25:59   
 * @version V1.0
 */
@Service("GWorkOrderReplyService")
public class GWorkOrderReplyService{
	
	private Logger logger = Logger.getLogger(GWorkOrderReplyService.class);
	
	@Value("${SERVICE_BASE_PARAM}")
    private String SERVICE_BASE_PARAM;
	
	
	// 测试分页查询
    public static String testPage() {
		List<GWorkOrderReply> list = new ArrayList<GWorkOrderReply>();
		GWorkOrderReply g = new GWorkOrderReply();
		g.setUid("1");
		g.setContent("测试内容24の2324234");
		g.setCreate_time(new Timestamp(new Date().getTime()));
		g.setName("张三");
		g.setReply_id("1");
		g.setReply_img_id("1");
		g.setType(1);
		g.setSubject_id("1");
		
		
		GWorkOrderReply g1 = new GWorkOrderReply();
		g1.setUid("2");
		g1.setContent("测试内容asffafas");
		g1.setCreate_time(new Timestamp(new Date().getTime()));
		g1.setName("李四");
		g1.setReply_id("2");
		g1.setReply_img_id("2");
		g1.setType(0);
		g1.setSubject_id("2");
		
		list.add(g);
		list.add(g1);

		PageInfo pageInfo = new PageInfo(1, 1,1, list);
		return JSON.toJSONString(pageInfo);
	}

    // 测试查询一条记录
    public static String testOne() {
    	GWorkOrderReplyImage g = new GWorkOrderReplyImage();
		g.setUid("1");
		g.setContent("测试内容24の2324234");
		g.setCreate_time(new Timestamp(new Date().getTime()));
		g.setName("张三");
		g.setReply_id("1");
		g.setReply_img_id("1");
		g.setType(1);
		g.setSubject_id("1");
		g.setReply_img("http://img.zcool.cn/community/010a1b554c01d1000001bf72a68b37.jpg@1280w_1l_2o_100sh.png;https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1528956814406&di=811d73ef65bc0b7462765d7b079243de&imgtype=0&src=http%3A%2F%2Fuploads.5068.com%2Fallimg%2F151028%2F57-15102Q33H7.jpg;http://img.zcool.cn/community/010f87596f13e6a8012193a363df45.jpg@1280w_1l_2o_100sh.jpg");
		return JSON.toJSONString(g);
    }
    
    // 测试添加一条数据
    public static String testAdd() {
    	Boolean flag = false;
		return JSON.toJSONString(flag);
    }
	

	/**
	 * 
	 * @Title: selectPage
	 * @Description: 分页查询
	 * @param @param request
	 * @param @param g_work_order_reply_vo
	 * @param @return
	 * @param @throws Exception
	 * @return PageInfo
	 * @throws
	 */
    public PageInfo selectPage(HttpServletRequest request,GWorkOrderReplyVO g_work_order_reply_vo) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("PSIZE", g_work_order_reply_vo.getRows());
        map.put("BEGIN", (g_work_order_reply_vo.getPage() - 1) * g_work_order_reply_vo.getRows());
        
        if (null != g_work_order_reply_vo.getSubject_id() && !StringUtils.isBlank(g_work_order_reply_vo.getSubject_id())) {
        	if (StringUtil.isNumeric(g_work_order_reply_vo.getSubject_id())) {
        		map.put("subjectId", g_work_order_reply_vo.getSubject_id());
        	}
        }
        if (null != g_work_order_reply_vo.getUid() && !StringUtils.isBlank(g_work_order_reply_vo.getUid())) {
        	if (StringUtil.isNumeric(g_work_order_reply_vo.getUid())) {
        		map.put("uid", g_work_order_reply_vo.getUid());
        	}
        }
        if (null != g_work_order_reply_vo.getType()) {
        	map.put("type", g_work_order_reply_vo.getType());
        }
        
        Integer count = 0;
        // 查询总记录数
        try {
           /* String method = SERVICE_BASE_PARAM + "g_work_order_reply_getPageCount";
            String json = SendRequestUtil.sendMapRequest(request, map, method);*/
        	String json = this.testPage();
        	if (null != json) {
        		PageInfo pageInfo = JSON.parseObject(json, PageInfo.class);
                count = pageInfo.getTotalCount();
                if (count == 0) {
                	return new PageInfo(g_work_order_reply_vo.getRows(), g_work_order_reply_vo.getPage(), count, new ArrayList<GWorkOrderReply>());
                }
        	}else {
            	return new PageInfo(g_work_order_reply_vo.getRows(), g_work_order_reply_vo.getPage(), count, new ArrayList<GWorkOrderReply>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[运营管理-工单答复管理-查询总记录条数]请求后台出错",e);
			return new PageInfo(g_work_order_reply_vo.getRows(), g_work_order_reply_vo.getPage(), count, new ArrayList<GWorkOrderReply>());
		}
        
        
        // 查询列表
        try {
			/*String method = SERVICE_BASE_PARAM + "g_work_order_reply_getList";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
        	String json = this.testPage();
        	if (null != json) {
        		PageInfo pageInfo = JSON.parseObject(json, PageInfo.class);
                return pageInfo;
            }else {
            	return new PageInfo(g_work_order_reply_vo.getRows(), g_work_order_reply_vo.getPage(), 0, new ArrayList<GWorkOrderReply>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[运营管理-工单答复管理-查询所有记录]请求后台出错",e);
			return new PageInfo(g_work_order_reply_vo.getRows(), g_work_order_reply_vo.getPage(), 0, new ArrayList<GWorkOrderReply>());
		}
    }

    
    
    /**
     * 
     * @Title: get
     * @Description: 查询一条记录
     * @param @param request
     * @param @param reply_id
     * @param @return
     * @param @throws Exception
     * @return GWorkOrderReply
     * @throws
     */
    public GWorkOrderReply get(HttpServletRequest request,String reply_id) throws Exception {
    	try {
    		Map<String,Object> map = new HashMap<String, Object>();
    		map.put("replyId",reply_id);
			/*String method = SERVICE_BASE_PARAM + "g_work_order_reply_getOne";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
    		String json = this.testOne();
			if (null != json) {
				GWorkOrderReplyImage gWorkOrderReplyImage = JSON.parseObject(json, GWorkOrderReplyImage.class);
				return gWorkOrderReplyImage;
			}else {
				return new GWorkOrderReplyImage();
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[运营管理-工单答复管理-查询一条记录]请求后台出错",e);
			return new GWorkOrderReplyImage();
		}
    }

    
    /**
     * 
     * @Title: add
     * @Description: 添加一条数据
     * @param @param request
     * @param @param g_work_order_reply
     * @param @return
     * @param @throws Exception
     * @return boolean
     * @throws
     */
    public boolean add(HttpServletRequest request,GWorkOrderReply g_work_order_reply) throws Exception {
    	try {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("GWorkOrderReply", g_work_order_reply);
			/*String method = SERVICE_BASE_PARAM + "g_work_order_reply_add";
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
			logger.error("[运营管理-工单答复管理-新增一条记录]请求后台出错",e);
			return false;
		}
    }

    /**
     * 修改
     */
    /*public boolean update(GWorkOrderReply g_work_order_reply) throws Exception {
        Integer result = g_work_order_reply_dao.update(g_work_order_reply);
        return result > 0 ? true : false;
    }*/
    
	 /**
     * 删除
     */
    /*public boolean delete(java.lang.String reply_id) throws Exception {
        Integer result = g_work_order_reply_dao.deleteById(reply_id);
        return result > 0 ? true : false;
    }*/
    
    /**
	 * 获取所有数据
	 */
	/*public List<GWorkOrderReply> selectAll(GWorkOrderReplyVO g_work_order_reply_vo) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		return g_work_order_reply_dao.selectAll(map);
	}*/ 


}
