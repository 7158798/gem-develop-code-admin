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
import com.manage.biz.entity.GNotice;
import com.manage.biz.vo.GNoticeVO;



/**
 * 
 * @Project：gme-admin   
 * @Class：GNoticeService   
 * @Description 类描述：公告管理   
 * @Author：zhou   
 * @Date：2018年6月19日 下午8:42:18   
 * @version V1.0
 */
@Service("GNoticeService")
public class GNoticeService{


	private  Logger logger = Logger.getLogger(GNoticeService.class);
    
    @Value("${SERVICE_BASE_PARAM}")
    private String SERVICE_BASE_PARAM;
    
    
 // 测试分页查询
    public static String testPage() {
		List<GNotice> list = new ArrayList<GNotice>();
		GNotice g = new GNotice();
		g.setNotice_id("1");
		g.setTitle_cn("China");
		g.setTitle_en("US");
		g.setSys_name("a");
		g.setSys_uid("1");
		g.setTxt_id_cn("这是一条测试数据");
		g.setTxt_id_en("this is test data");
		g.setType(1);
		
		GNotice g1 = new GNotice();
		g1.setNotice_id("2");
		g1.setTitle_cn("China1");
		g1.setTitle_en("US1");
		g1.setSys_name("b");
		g1.setSys_uid("2");
		g1.setTxt_id_cn("这是一条测试数据1111");
		g1.setTxt_id_en("this is test data111");
		g1.setType(2);
		list.add(g);
		list.add(g1);
		PageInfo pageInfo = new PageInfo(1, 1,1, list);
		return JSON.toJSONString(pageInfo);
	}

    // 测试查询一条记录
    public static String testOne() {
    	GNotice g = new GNotice();
		g.setNotice_id("1");
		g.setTitle_cn("China");
		g.setTitle_en("US");
		g.setSys_name("a");
		g.setSys_uid("1");
		g.setTxt_id_cn("这是一条测试数据");
		g.setTxt_id_en("this is test data");
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
     * @param @param g_notice_vo
     * @param @return
     * @param @throws Exception
     * @return PageInfo
     * @throws
     */
    public PageInfo selectPage(HttpServletRequest request,GNoticeVO g_notice_vo) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("PSIZE", g_notice_vo.getRows());
        map.put("BEGIN", (g_notice_vo.getPage() - 1) * g_notice_vo.getRows());
        
        if (null != g_notice_vo.getSys_name() && !StringUtils.isBlank(g_notice_vo.getSys_name())) {
        	map.put("sysName", g_notice_vo.getSys_name());
        }
        if (null != g_notice_vo.getType()) {
        	map.put("type", g_notice_vo.getType());
        }
        
        
        Integer count = 0;
        // 查询总记录数
        try {
           /* String method = SERVICE_BASE_PARAM + "g_notice_getPageCount";
            String json = SendRequestUtil.sendMapRequest(request, map, method);*/
        	String json = this.testPage();
        	if (null != json) {
        		PageInfo pageInfo = JSON.parseObject(json, PageInfo.class);
                count = pageInfo.getTotalCount();
                if (count == 0) {
                	return new PageInfo(g_notice_vo.getRows(), g_notice_vo.getPage(), count, new ArrayList<GNotice>());
                }
        	}else {
            	return new PageInfo(g_notice_vo.getRows(), g_notice_vo.getPage(), count, new ArrayList<GNotice>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[运营管理-公告管理-查询记录条数]请求后台出错",e);
			return new PageInfo(g_notice_vo.getRows(), g_notice_vo.getPage(), count, new ArrayList<GNotice>());
		}
        
        
        // 查询列表
        try {
			/*String method = SERVICE_BASE_PARAM + "g_notice_getList";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
        	String json = this.testPage();
        	if (null != json) {
        		PageInfo pageInfo = JSON.parseObject(json, PageInfo.class);
                return pageInfo;
            }else {
            	return new PageInfo(g_notice_vo.getRows(), g_notice_vo.getPage(), 0, new ArrayList<GNotice>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[运营管理-公告管理-查询所有记录]请求后台出错",e);
			return new PageInfo(g_notice_vo.getRows(), g_notice_vo.getPage(), 0, new ArrayList<GNotice>());
		}
    }

    
    /**
     * 
     * @Title: get
     * @Description: 查询一条记录
     * @param @param notice_id
     * @param @return
     * @param @throws Exception
     * @return GNotice
     * @throws
     */
    public GNotice get(HttpServletRequest request,String notice_id) throws Exception {
    	try {
    		Map<String,Object> map = new HashMap<String, Object>();
    		map.put("noticeId", notice_id);
			/*String method = SERVICE_BASE_PARAM + "g_notice_getOne";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
    		String json = this.testOne();
			if (null != json) {
				GNotice gNotice = JSON.parseObject(json, GNotice.class);
				return gNotice;
			}else {
				return new GNotice();
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[运营管理-公告管理-查询一条记录]请求后台出错",e);
			return new GNotice();
		}
    }

    
    /**
     * 
     * @Title: add
     * @Description: 添加一条数据
     * @param @param g_notice
     * @param @return
     * @param @throws Exception
     * @return boolean
     * @throws
     */
    public boolean add(HttpServletRequest request,GNotice g_notice) throws Exception {
    	try {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("GNotice", g_notice);
//			String method = SERVICE_BASE_PARAM + "g_notice_add";
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
     * @param @param g_notice
     * @param @return
     * @param @throws Exception
     * @return boolean
     * @throws
     */
    public boolean update(HttpServletRequest request,GNotice g_notice) throws Exception {
    	try {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("GNotice", g_notice);
			/*String method = SERVICE_BASE_PARAM + "g_notice_update";
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
     * @param @param notice_id
     * @param @return
     * @param @throws Exception
     * @return boolean
     * @throws
     */
    public boolean delete(HttpServletRequest request,String notice_id) throws Exception {
    	try {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("noticeId", notice_id);
			/*String method = SERVICE_BASE_PARAM + "g_notice_delete";
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
	/*public List<GNotice> selectAll(GNoticeVO g_notice_vo) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		return g_notice_dao.selectAll(map);
	} */


}
