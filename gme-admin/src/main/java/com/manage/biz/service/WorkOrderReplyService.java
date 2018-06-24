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
import com.manage.biz.entity.WorkOrderReply;
import com.manage.biz.entity.WorkOrderReplyImage;
import com.manage.biz.vo.WorkOrderReplyVO;
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
@Service("WorkOrderReplyService")
public class WorkOrderReplyService{
	
	private Logger logger = Logger.getLogger(WorkOrderReplyService.class);
	
	@Value("${SERVICE_BASE_PARAM}")
    private String SERVICE_BASE_PARAM;
	
	
	// 测试分页查询
    public static String testPage() {
		List<WorkOrderReply> list = new ArrayList<WorkOrderReply>();
		WorkOrderReply g = new WorkOrderReply();
		g.setUid("1");
		g.setContent("测试内容24の2324234");
		g.setCreateTime(new Timestamp(new Date().getTime()));
		g.setName("张三");
		g.setReplyId("1");
		g.setReplyImgId("1");
		g.setType(1);
		g.setSubjectId("1");
		
		
		WorkOrderReply g1 = new WorkOrderReply();
		g1.setUid("2");
		g1.setContent("测试内容asffafas");
		g1.setCreateTime(new Timestamp(new Date().getTime()));
		g1.setName("李四");
		g1.setReplyId("2");
		g1.setReplyImgId("2");
		g1.setType(0);
		g1.setSubjectId("2");
		
		list.add(g);
		list.add(g1);

		PageInfo pageInfo = new PageInfo(1, 1,1, list);
		return JSON.toJSONString(pageInfo);
	}

    // 测试查询一条记录
    public static String testOne() {
    	WorkOrderReply g = new WorkOrderReply();
		g.setUid("1");
		g.setContent("测试内容24の2324234");
		g.setCreateTime(new Timestamp(new Date().getTime()));
		g.setName("张三");
		g.setReplyId("1");
		g.setReplyImgId("1");
		g.setType(1);
		g.setSubjectId("1");
		g.setReplyImg("http://img.zcool.cn/community/010a1b554c01d1000001bf72a68b37.jpg@1280w_1l_2o_100sh.png;https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1528956814406&di=811d73ef65bc0b7462765d7b079243de&imgtype=0&src=http%3A%2F%2Fuploads.5068.com%2Fallimg%2F151028%2F57-15102Q33H7.jpg;http://img.zcool.cn/community/010f87596f13e6a8012193a363df45.jpg@1280w_1l_2o_100sh.jpg");
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
	 * @param @param workOrderReplyVO
	 * @param @return
	 * @param @throws Exception
	 * @return PageInfo
	 * @throws
	 */
    public PageInfo selectPage(HttpServletRequest request,WorkOrderReplyVO workOrderReplyVO) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("PSIZE", workOrderReplyVO.getRows());
        map.put("BEGIN", (workOrderReplyVO.getPage() - 1) * workOrderReplyVO.getRows());
        
        if (null != workOrderReplyVO.getSubjectId() && !StringUtils.isBlank(workOrderReplyVO.getSubjectId())) {
        	if (StringUtil.isNumeric(workOrderReplyVO.getSubjectId())) {
        		map.put("subjectId", workOrderReplyVO.getSubjectId());
        	}
        }
        if (null != workOrderReplyVO.getUid() && !StringUtils.isBlank(workOrderReplyVO.getUid())) {
        	if (StringUtil.isNumeric(workOrderReplyVO.getUid())) {
        		map.put("uid", workOrderReplyVO.getUid());
        	}
        }
        if (null != workOrderReplyVO.getType()) {
        	map.put("type", workOrderReplyVO.getType());
        }
        
        Integer count = 0;
        // 查询总记录数
        try {
           /* String method = SERVICE_BASE_PARAM + "workOrderReply_getPageCount";
            String json = SendRequestUtil.sendMapRequest(request, map, method);*/
        	String json = this.testPage();
        	if (null != json) {
        		PageInfo pageInfo = JSON.parseObject(json, PageInfo.class);
                count = pageInfo.getTotalCount();
                if (count == 0) {
                	return new PageInfo(workOrderReplyVO.getRows(), workOrderReplyVO.getPage(), count, new ArrayList<WorkOrderReply>());
                }
        	}else {
            	return new PageInfo(workOrderReplyVO.getRows(), workOrderReplyVO.getPage(), count, new ArrayList<WorkOrderReply>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[运营管理-工单答复管理-查询总记录条数]请求后台出错",e);
			return new PageInfo(workOrderReplyVO.getRows(), workOrderReplyVO.getPage(), count, new ArrayList<WorkOrderReply>());
		}
        
        
        // 查询列表
        try {
			/*String method = SERVICE_BASE_PARAM + "workOrderReply_getList";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
        	String json = this.testPage();
        	if (null != json) {
        		PageInfo pageInfo = JSON.parseObject(json, PageInfo.class);
                return pageInfo;
            }else {
            	return new PageInfo(workOrderReplyVO.getRows(), workOrderReplyVO.getPage(), 0, new ArrayList<WorkOrderReply>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[运营管理-工单答复管理-查询所有记录]请求后台出错",e);
			return new PageInfo(workOrderReplyVO.getRows(), workOrderReplyVO.getPage(), 0, new ArrayList<WorkOrderReply>());
		}
    }

    
    
    /**
     * 
     * @Title: get
     * @Description: 查询一条记录
     * @param @param request
     * @param @param replyId
     * @param @return
     * @param @throws Exception
     * @return GWorkOrderReply
     * @throws
     */
    public WorkOrderReply get(HttpServletRequest request,String replyId) throws Exception {
    	try {
    		Map<String,Object> map = new HashMap<String, Object>();
    		map.put("replyId",replyId);
			/*String method = SERVICE_BASE_PARAM + "workOrderReply_getOne";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
    		String json = this.testOne();
			if (null != json) {
				WorkOrderReplyImage gWorkOrderReplyImage = JSON.parseObject(json, WorkOrderReplyImage.class);
				return gWorkOrderReplyImage;
			}else {
				return new WorkOrderReplyImage();
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[运营管理-工单答复管理-查询一条记录]请求后台出错",e);
			return new WorkOrderReplyImage();
		}
    }

    
    /**
     * 
     * @Title: add
     * @Description: 添加一条数据
     * @param @param request
     * @param @param workOrderReply
     * @param @return
     * @param @throws Exception
     * @return boolean
     * @throws
     */
    public boolean add(HttpServletRequest request,WorkOrderReply workOrderReply) throws Exception {
    	try {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("GWorkOrderReply", workOrderReply);
			/*String method = SERVICE_BASE_PARAM + "workOrderReply_add";
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
    /*public boolean update(GWorkOrderReply workOrderReply) throws Exception {
        Integer result = workOrderReply_dao.update(workOrderReply);
        return result > 0 ? true : false;
    }*/
    
	 /**
     * 删除
     */
    /*public boolean delete(java.lang.String replyId) throws Exception {
        Integer result = workOrderReply_dao.deleteById(replyId);
        return result > 0 ? true : false;
    }*/
    
    /**
	 * 获取所有数据
	 */
	/*public List<GWorkOrderReply> selectAll(GWorkOrderReplyVO workOrderReplyVO) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		return workOrderReply_dao.selectAll(map);
	}*/ 


}
