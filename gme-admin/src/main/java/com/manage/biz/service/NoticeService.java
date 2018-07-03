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
import com.manage.biz.entity.Notice;
import com.manage.biz.vo.NoticeVO;



/**
 * 
 * @Project：gme-admin   
 * @Class：GNoticeService   
 * @Description 类描述：公告管理   
 * @Author：zhou   
 * @Date：2018年6月19日 下午8:42:18   
 * @version V1.0
 */
@Service("NoticeService")
public class NoticeService{


	private  Logger logger = Logger.getLogger(NoticeService.class);
    
    
    
    
    
 // 测试分页查询
    public static String testPage() {
		List<Notice> list = new ArrayList<Notice>();
		Notice g = new Notice();
		g.setNoticeId("1");
		g.setTitleCN("China");
		g.setTitleEN("US");
		g.setSysName("a");
		g.setSysUid("1");
		g.setTxtIdCN("这是一条测试数据");
		g.setTxtIdEN("this is test data");
		g.setType(1);
		
		Notice g1 = new Notice();
		g1.setNoticeId("2");
		g1.setTitleCN("China1");
		g1.setTitleEN("US1");
		g1.setSysName("b");
		g1.setSysUid("2");
		g1.setTxtIdCN("这是一条测试数据1111");
		g1.setTxtIdEN("this is test data111");
		g1.setType(2);
		list.add(g);
		list.add(g1);
		PageBean pageInfo = new PageBean(1, 1,1, list);
		return JSON.toJSONString(pageInfo);
	}

    // 测试查询一条记录
    public static String testOne() {
    	Notice g = new Notice();
		g.setNoticeId("1");
		g.setTitleCN("China");
		g.setTitleEN("US");
		g.setSysName("a");
		g.setSysUid("1");
		g.setTxtIdCN("这是一条测试数据");
		g.setTxtIdEN("this is test data");
		g.setType(1);
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
     * @param @param noticeVO
     * @param @return
     * @param @throws Exception
     * @return PageInfo
     * @throws
     */
    public PageBean selectPage(HttpServletRequest request,NoticeVO noticeVO) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("PSIZE", noticeVO.getRows());
        map.put("BEGIN", (noticeVO.getPage() - 1) * noticeVO.getRows());
        
        if (null != noticeVO.getSysName() && !StringUtils.isBlank(noticeVO.getSysName())) {
        	map.put("sysName", noticeVO.getSysName());
        }
        if (null != noticeVO.getType()) {
        	map.put("type", noticeVO.getType());
        }
        
        
        Integer count = 0;
        // 查询总记录数
        try {
           /* String method = "notice_getPageCount";
            String json = SendRequestUtil.sendMapRequest(request, map, method);*/
        	String json = this.testPage();
        	if (null != json) {
        		PageBean pageInfo = JSON.parseObject(json, PageBean.class);
                count = pageInfo.getTotalCount();
                if (count == 0) {
                	return new PageBean(noticeVO.getRows(), noticeVO.getPage(), count, new ArrayList<Notice>());
                }
        	}else {
            	return new PageBean(noticeVO.getRows(), noticeVO.getPage(), count, new ArrayList<Notice>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[运营管理-公告管理-查询记录条数]请求后台出错",e);
			return new PageBean(noticeVO.getRows(), noticeVO.getPage(), count, new ArrayList<Notice>());
		}
        
        
        // 查询列表
        try {
			/*String method = "notice_getList";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
        	String json = this.testPage();
        	if (null != json) {
        		PageBean pageInfo = JSON.parseObject(json, PageBean.class);
                return pageInfo;
            }else {
            	return new PageBean(noticeVO.getRows(), noticeVO.getPage(), 0, new ArrayList<Notice>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[运营管理-公告管理-查询所有记录]请求后台出错",e);
			return new PageBean(noticeVO.getRows(), noticeVO.getPage(), 0, new ArrayList<Notice>());
		}
    }

    
    /**
     * 
     * @Title: get
     * @Description: 查询一条记录
     * @param @param noticeId
     * @param @return
     * @param @throws Exception
     * @return GNotice
     * @throws
     */
    public Notice get(HttpServletRequest request,String noticeId) throws Exception {
    	try {
    		Map<String,Object> map = new HashMap<String, Object>();
    		map.put("noticeId", noticeId);
			/*String method = "notice_getOne";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
    		String json = this.testOne();
			if (null != json) {
				Notice gNotice = JSON.parseObject(json, Notice.class);
				return gNotice;
			}else {
				return new Notice();
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[运营管理-公告管理-查询一条记录]请求后台出错",e);
			return new Notice();
		}
    }

    
    /**
     * 
     * @Title: add
     * @Description: 添加一条数据
     * @param @param notice
     * @param @return
     * @param @throws Exception
     * @return boolean
     * @throws
     */
    public boolean add(HttpServletRequest request,Notice notice) throws Exception {
    	try {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("GNotice", notice);
//			String method = "notice_add";
//			String json = SendRequestUtil.sendMapRequest(request, map, method);
			String json = this.testAdd();
			if (null != json) {
				Boolean flag = JSON.parseObject(json,Boolean.class);
				return flag;
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[运营管理-公告管理-新增一条记录]请求后台出错",e);
			return false;
		}
    }

    
    /**
     * 
     * @Title: update
     * @Description: 修改一条数据
     * @param @param notice
     * @param @return
     * @param @throws Exception
     * @return boolean
     * @throws
     */
    public boolean update(HttpServletRequest request,Notice notice) throws Exception {
    	try {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("GNotice", notice);
			/*String method = "notice_update";
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
			logger.error("[运营管理-公告管理-修改一条记录]请求后台出错",e);
			return false;
		}
    }
    
    
    /**
     * 
     * @Title: delete
     * @Description: 删除一条数据
     * @param @param noticeId
     * @param @return
     * @param @throws Exception
     * @return boolean
     * @throws
     */
    public boolean delete(HttpServletRequest request,String noticeId) throws Exception {
    	try {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("noticeId", noticeId);
			/*String method = "notice_delete";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
			String json = this.testDelete();
			if (null != json) {
				Boolean flag = JSON.parseObject(json,Boolean.class);
				return flag;
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[运营管理-公告管理-删除一条记录]请求后台出错",e);
			return false;
		}
    }
    /**
	 * 获取所有数据
	 */
	/*public List<GNotice> selectAll(GNoticeVO noticeVO) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		return notice_dao.selectAll(map);
	} */


}
