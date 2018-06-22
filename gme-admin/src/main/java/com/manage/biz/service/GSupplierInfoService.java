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
import com.manage.biz.entity.GSupplierInfo;
import com.manage.biz.vo.GSupplierInfoVO;



/**
 * 
 * @Project：gme-admin   
 * @Class：GSupplierInfoService   
 * @Description 类描述：商家信息表   
 * @Author：zhou   
 * @Date：2018年6月21日 下午3:33:46   
 * @version V1.0
 */
@Service("GSupplierInfoService")
public class GSupplierInfoService{

	private Logger logger = Logger.getLogger(GSupplierInfoService.class);
	
   	@Value("${SERVICE_BASE_PARAM}")
    private String SERVICE_BASE_PARAM;

 // 测试分页查询
    public static String testPage() {
		List<GSupplierInfo> list = new ArrayList<GSupplierInfo>();
		GSupplierInfo g = new GSupplierInfo();
		g.setUid("1");
		g.setComplained_number(6);
		g.setIs_token(0);
		g.setIs_auth(1);
		g.setSupplier_status(1);
		g.setUid("1");
		g.setTotal_deal_number(100);
		g.setSupplier_name("zs");
		
		
		GSupplierInfo g1 = new GSupplierInfo();
		g1.setUid("2");
		g1.setComplained_number(3);
		g1.setIs_token(1);
		g1.setIs_auth(2);
		g1.setSupplier_status(2);
		g1.setUid("2");
		g1.setTotal_deal_number(300);
		g1.setSupplier_name("ls");
		list.add(g);
		list.add(g1);

		PageInfo pageInfo = new PageInfo(1, 1,1, list);
		return JSON.toJSONString(pageInfo);
	}

    // 测试查询一条记录
    public static String testOne() {
    	GSupplierInfo g = new GSupplierInfo();
		g.setUid("1");
		g.setComplained_number(6);
		g.setIs_token(0);
		g.setIs_auth(1);
		g.setSupplier_status(1);
		g.setUid("1");
		g.setTotal_deal_number(100);
		g.setSupplier_name("zs");
		return JSON.toJSONString(g);
    }
    
 // 测试修改一条数据
    public static String testUpdate() {
    	Boolean flag = true;
		return JSON.toJSONString(flag);
    }
   	

    /**
     * 
     * @Title: selectPage
     * @Description: 分页查询
     * @param @param request
     * @param @param g_supplier_info_vo
     * @param @return
     * @param @throws Exception
     * @return PageInfo
     * @throws
     */
    public PageInfo selectPage(HttpServletRequest request,GSupplierInfoVO g_supplier_info_vo) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("PSIZE", g_supplier_info_vo.getRows());
        map.put("BEGIN", (g_supplier_info_vo.getPage() - 1) * g_supplier_info_vo.getRows());
        
        if (null != g_supplier_info_vo.getSupplier_name() && !StringUtils.isBlank(g_supplier_info_vo.getSupplier_name())) {
        	map.put("supplierName", g_supplier_info_vo.getSupplier_name());
        }
        if (null != g_supplier_info_vo.getIs_auth()) {
        	map.put("isAuth", g_supplier_info_vo.getIs_auth());
        }
        if (null != g_supplier_info_vo.getIs_token()) {
        	map.put("isToken", g_supplier_info_vo.getIs_token());
        }
        if (null != g_supplier_info_vo.getSupplier_status()) {
        	map.put("supplierStatus", g_supplier_info_vo.getSupplier_status());
        }
        
        Integer count = 0;
        // 查询总记录数
        try {
           /* String method = SERVICE_BASE_PARAM + "g_supplier_info_getPageCount";
            String json = SendRequestUtil.sendMapRequest(request, map, method);*/
        	String json = this.testPage();
        	if (null != json) {
        		PageInfo pageInfo = JSON.parseObject(json, PageInfo.class);
                count = pageInfo.getTotalCount();
                if (count == 0) {
                	return new PageInfo(g_supplier_info_vo.getRows(), g_supplier_info_vo.getPage(), count, new ArrayList<GSupplierInfo>());
                }
        	}else {
            	return new PageInfo(g_supplier_info_vo.getRows(), g_supplier_info_vo.getPage(), count, new ArrayList<GSupplierInfo>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[用户管理-商家信息管理-查询总记录条数]请求后台出错",e);
			return new PageInfo(g_supplier_info_vo.getRows(), g_supplier_info_vo.getPage(), count, new ArrayList<GSupplierInfo>());
		}
        
        
        // 查询列表
        try {
			/*String method = SERVICE_BASE_PARAM + "g_supplier_info_getList";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
        	String json = this.testPage();
        	if (null != json) {
        		PageInfo pageInfo = JSON.parseObject(json, PageInfo.class);
                return pageInfo;
            }else {
            	return new PageInfo(g_supplier_info_vo.getRows(), g_supplier_info_vo.getPage(), 0, new ArrayList<GSupplierInfo>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[用户管理-商家信息管理-查询所有记录]请求后台出错",e);
			return new PageInfo(g_supplier_info_vo.getRows(), g_supplier_info_vo.getPage(), 0, new ArrayList<GSupplierInfo>());
		}
    }

    
    /**
     * 
     * @Title: get
     * @Description: 查询一条记录
     * @param @param request
     * @param @param uid
     * @param @return
     * @param @throws Exception
     * @return GSupplierInfo
     * @throws
     */
    public GSupplierInfo get(HttpServletRequest request,String uid) throws Exception {
    	try {
    		Map<String,Object> map = new HashMap<String, Object>();
    		map.put("uid", uid);
			/*String method = SERVICE_BASE_PARAM + "g_supplier_info_getOne";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
    		String json = this.testOne();
			if (null != json) {
				GSupplierInfo gSupplierInfo = JSON.parseObject(json, GSupplierInfo.class);
				return gSupplierInfo;
			}else {
				return new GSupplierInfo();
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[用户管理-商家信息管理-查询一条记录]请求后台出错",e);
			return new GSupplierInfo();
		}
    }

    /**
     * 新增
     */
    /*public boolean add(GSupplierInfo g_supplier_info) throws Exception {
        Integer result = g_supplier_info_dao.add(g_supplier_info);
        return result > 0 ? true : false;
    }*/

    
    /**
     * 
     * @Title: update
     * @Description: 修改一条数据
     * @param @param request
     * @param @param g_supplier_info
     * @param @return
     * @param @throws Exception
     * @return boolean
     * @throws
     */
    public boolean update(HttpServletRequest request,GSupplierInfo g_supplier_info) throws Exception {
    	try {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("GSupplierInfo", g_supplier_info);
			/*String method = SERVICE_BASE_PARAM + "g_supplier_info_update";
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
			logger.error("[用户管理-商家信息管理-修改一条记录]请求后台出错",e);
			return false;
		}
    }
    
	 /**
     * 删除
     */
    /*public boolean delete(java.lang.String uid) throws Exception {
        Integer result = g_supplier_info_dao.deleteById(uid);
        return result > 0 ? true : false;
    }*/
    
    /**
	 * 获取所有数据
	 */
	/*public List<GSupplierInfo> selectAll(GSupplierInfoVO g_supplier_info_vo) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		return g_supplier_info_dao.selectAll(map);
	}*/ 


}
