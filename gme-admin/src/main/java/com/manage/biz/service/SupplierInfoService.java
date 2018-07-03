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
import com.manage.biz.entity.SupplierInfo;
import com.manage.biz.vo.SupplierInfoVO;



/**
 * 
 * @Project：gme-admin   
 * @Class：GSupplierInfoService   
 * @Description 类描述：商家信息表   
 * @Author：zhou   
 * @Date：2018年6月21日 下午3:33:46   
 * @version V1.0
 */
@Service("SupplierInfoService")
public class SupplierInfoService{

	private Logger logger = Logger.getLogger(SupplierInfoService.class);
	
   	
    

 // 测试分页查询
    public static String testPage() {
		List<SupplierInfo> list = new ArrayList<SupplierInfo>();
		SupplierInfo g = new SupplierInfo();
		g.setUid("1");
		g.setComplainedNumber(6);
		g.setIsToken(0);
		g.setIsAuth(1);
		g.setSupplierStatus(1);
		g.setTotalDealNumber(100);
		g.setSupplierName("zs");
		
		
		SupplierInfo g1 = new SupplierInfo();
		g1.setUid("2");
		g1.setComplainedNumber(3);
		g1.setIsToken(1);
		g1.setIsAuth(2);
		g1.setSupplierStatus(2);
		g1.setTotalDealNumber(300);
		g1.setSupplierName("ls");
		list.add(g);
		list.add(g1);

		PageBean pageInfo = new PageBean(1, 1,1, list);
		return JSON.toJSONString(pageInfo);
	}

    // 测试查询一条记录
    public static String testOne() {
    	SupplierInfo g = new SupplierInfo();
		g.setUid("1");
		g.setComplainedNumber(6);
		g.setIsToken(0);
		g.setIsAuth(1);
		g.setSupplierStatus(1);
		g.setTotalDealNumber(100);
		g.setSupplierName("zs");
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
     * @param @param supplierInfoVO
     * @param @return
     * @param @throws Exception
     * @return PageInfo
     * @throws
     */
    public PageBean selectPage(HttpServletRequest request,SupplierInfoVO supplierInfoVO) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("PSIZE", supplierInfoVO.getRows());
        map.put("BEGIN", (supplierInfoVO.getPage() - 1) * supplierInfoVO.getRows());
        
        if (null != supplierInfoVO.getSupplierName() && !StringUtils.isBlank(supplierInfoVO.getSupplierName())) {
        	map.put("supplierName", supplierInfoVO.getSupplierName());
        }
        if (null != supplierInfoVO.getIsAuth()) {
        	map.put("isAuth", supplierInfoVO.getIsAuth());
        }
        if (null != supplierInfoVO.getIsToken()) {
        	map.put("isToken", supplierInfoVO.getIsToken());
        }
        if (null != supplierInfoVO.getSupplierStatus()) {
        	map.put("supplierStatus", supplierInfoVO.getSupplierStatus());
        }
        
        Integer count = 0;
        // 查询总记录数
        try {
           /* String method = "supplierInfo_getPageCount";
            String json = SendRequestUtil.sendMapRequest(request, map, method);*/
        	String json = this.testPage();
        	if (null != json) {
        		PageBean pageInfo = JSON.parseObject(json, PageBean.class);
                count = pageInfo.getTotalCount();
                if (count == 0) {
                	return new PageBean(supplierInfoVO.getRows(), supplierInfoVO.getPage(), count, new ArrayList<SupplierInfo>());
                }
        	}else {
            	return new PageBean(supplierInfoVO.getRows(), supplierInfoVO.getPage(), count, new ArrayList<SupplierInfo>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[用户管理-商家信息管理-查询总记录条数]请求后台出错",e);
			return new PageBean(supplierInfoVO.getRows(), supplierInfoVO.getPage(), count, new ArrayList<SupplierInfo>());
		}
        
        
        // 查询列表
        try {
			/*String method = "supplierInfo_getList";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
        	String json = this.testPage();
        	if (null != json) {
        		PageBean pageInfo = JSON.parseObject(json, PageBean.class);
                return pageInfo;
            }else {
            	return new PageBean(supplierInfoVO.getRows(), supplierInfoVO.getPage(), 0, new ArrayList<SupplierInfo>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[用户管理-商家信息管理-查询所有记录]请求后台出错",e);
			return new PageBean(supplierInfoVO.getRows(), supplierInfoVO.getPage(), 0, new ArrayList<SupplierInfo>());
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
    public SupplierInfo get(HttpServletRequest request,String uid) throws Exception {
    	try {
    		Map<String,Object> map = new HashMap<String, Object>();
    		map.put("uid", uid);
			/*String method = "supplierInfo_getOne";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
    		String json = this.testOne();
			if (null != json) {
				SupplierInfo gSupplierInfo = JSON.parseObject(json, SupplierInfo.class);
				return gSupplierInfo;
			}else {
				return new SupplierInfo();
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[用户管理-商家信息管理-查询一条记录]请求后台出错",e);
			return new SupplierInfo();
		}
    }

    /**
     * 新增
     */
    /*public boolean add(GSupplierInfo supplierInfo) throws Exception {
        Integer result = supplierInfo_dao.add(supplierInfo);
        return result > 0 ? true : false;
    }*/

    
    /**
     * 
     * @Title: update
     * @Description: 修改一条数据
     * @param @param request
     * @param @param supplierInfo
     * @param @return
     * @param @throws Exception
     * @return boolean
     * @throws
     */
    public boolean update(HttpServletRequest request,SupplierInfo supplierInfo) throws Exception {
    	try {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("GSupplierInfo", supplierInfo);
			/*String method = "supplierInfo_update";
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
        Integer result = supplierInfo_dao.deleteById(uid);
        return result > 0 ? true : false;
    }*/
    
    /**
	 * 获取所有数据
	 */
	/*public List<GSupplierInfo> selectAll(GSupplierInfoVO supplierInfoVO) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		return supplierInfo_dao.selectAll(map);
	}*/ 


}
