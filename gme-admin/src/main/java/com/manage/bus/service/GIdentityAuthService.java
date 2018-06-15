package com.manage.bus.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.manage.base.entity.PageInfo;
import com.manage.bus.dao.GIdentityAuthDAO;
import com.manage.bus.entity.GCurrencyData;
import com.manage.bus.entity.GIdentityAuth;
import com.manage.bus.entity.GIdentityAuthImage;
import com.manage.bus.vo.GIdentityAuthVO;


/**
 * 
 * @Project：gme-admin   
 * @Class：GIdentityAuthService   
 * @Description 类描述：实名认证管理   
 * @Author：zhou   
 * @Date：2018年6月13日 下午9:07:14   
 * @version V1.0
 */
@Transactional(readOnly = true)
@Service("GIdentityAuthService")
public class GIdentityAuthService{

    private  Logger logger = Logger.getLogger(GIdentityAuthService.class);
    
    @Value("${SERVICE_BASE_PARAM}")
    private String SERVICE_BASE_PARAM;
    
    // 测试分页查询
    public static String testPage() {
		List<GIdentityAuth> list = new ArrayList<GIdentityAuth>();
		GIdentityAuth g = new GIdentityAuth();
		g.setAuth_id("1");
		g.setCertificate_number("3423423434234232323");
		g.setAuth_status(2);
		g.setCertificate_type(2);
		g.setIs_auth_supplier(1);
		g.setReal_name("张三");
		g.setStatus(0);
		
		GIdentityAuth g1 = new GIdentityAuth();
		g1.setAuth_id("3");
		g1.setCertificate_number("dfasfdasffdasf");
		g1.setAuth_status(1);
		g1.setCertificate_type(1);
		g1.setIs_auth_supplier(2);
		g1.setReal_name("李四");
		g1.setStatus(1);
		list.add(g);
		list.add(g1);
		PageInfo pageInfo = new PageInfo(1, 1,1, list);
		return JSON.toJSONString(pageInfo);
	}

    // 测试查询一条记录
    public static String testOne() {
    	GIdentityAuthImage g = new GIdentityAuthImage();
    	g.setAuth_id("1");
    	g.setAuth_status(2);
    	g.setCertificate_number("3423423434234232323");
		g.setCertificate_type(2);
		g.setIs_auth_supplier(1);
		g.setReal_name("张三");
		g.setStatus(0);
		g.setIn_hand_img("http://img.zcool.cn/community/010a1b554c01d1000001bf72a68b37.jpg@1280w_1l_2o_100sh.png");
		g.setFront_img("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1528956814406&di=811d73ef65bc0b7462765d7b079243de&imgtype=0&src=http%3A%2F%2Fuploads.5068.com%2Fallimg%2F151028%2F57-15102Q33H7.jpg");
		g.setReverse_img("http://img.zcool.cn/community/010f87596f13e6a8012193a363df45.jpg@1280w_1l_2o_100sh.jpg");
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
     * @param @param g_identity_auth_vo
     * @param @return
     * @param @throws Exception
     * @return PageInfo
     * @throws
     */
    public PageInfo selectPage(HttpServletRequest request,GIdentityAuthVO g_identity_auth_vo) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("PSIZE", g_identity_auth_vo.getRows());
        map.put("BEGIN", (g_identity_auth_vo.getPage() - 1) * g_identity_auth_vo.getRows());
        
        if (null != g_identity_auth_vo.getReal_name() && !StringUtils.isBlank(g_identity_auth_vo.getReal_name())) {
        	map.put("realName", g_identity_auth_vo.getReal_name());
        }
        if (null != g_identity_auth_vo.getAuth_status()) {
        	map.put("authStatus", g_identity_auth_vo.getAuth_status());
        }
        if (null != g_identity_auth_vo.getIs_auth_supplier()) {
        	map.put("isAuthSupplier", g_identity_auth_vo.getIs_auth_supplier());
        }
        if (null != g_identity_auth_vo.getCertificate_type()) {
        	map.put("certificateType", g_identity_auth_vo.getCertificate_type());
        }
        if (null != g_identity_auth_vo.getStatus()) {
        	map.put("status", g_identity_auth_vo.getStatus());
        }
      
        
        Integer count = 0;
        // 查询总记录数
        try {
           /* String method = SERVICE_BASE_PARAM + "g_identity_auth_getPageCount";
            String json = SendRequestUtil.sendMapRequest(request, map, method);*/
        	String json = this.testPage();
        	if (null != json) {
        		PageInfo pageInfo = JSON.parseObject(json, PageInfo.class);
                count = pageInfo.getTotalCount();
                if (count == 0) {
                	return new PageInfo(g_identity_auth_vo.getRows(), g_identity_auth_vo.getPage(), count, new ArrayList<GIdentityAuth>());
                }
        	}else {
            	return new PageInfo(g_identity_auth_vo.getRows(), g_identity_auth_vo.getPage(), count, new ArrayList<GIdentityAuth>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[用户管理-实名认证-查询记录条数]请求后台出错",e);
			return new PageInfo(g_identity_auth_vo.getRows(), g_identity_auth_vo.getPage(), count, new ArrayList<GIdentityAuth>());
		}
        
        
        // 查询列表
        try {
			/*String method = SERVICE_BASE_PARAM + "g_identity_auth_getList";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
        	String json = this.testPage();
        	if (null != json) {
        		PageInfo pageInfo = JSON.parseObject(json, PageInfo.class);
                return pageInfo;
            }else {
            	return new PageInfo(g_identity_auth_vo.getRows(), g_identity_auth_vo.getPage(), 0, new ArrayList<GIdentityAuth>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[用户管理-实名认证-查询所有记录]请求后台出错",e);
			return new PageInfo(g_identity_auth_vo.getRows(), g_identity_auth_vo.getPage(), 0, new ArrayList<GIdentityAuth>());
		}
    }


    
    /**
     * 
     * @Title: get
     * @Description: 查询一条记录
     * @param @param request
     * @param @param auth_id
     * @param @return
     * @param @throws Exception
     * @return GIdentityAuth
     * @throws
     */
    public GIdentityAuth get(HttpServletRequest request,String auth_id) throws Exception {
    	try {
    		Map<String,Object> map = new HashMap<String, Object>();
    		map.put("authId", auth_id);
			/*String method = SERVICE_BASE_PARAM + "g_identity_auth_getOne";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
    		String json = this.testOne();
			if (null != json) {
				GIdentityAuthImage gIdentityAuthImage = JSON.parseObject(json, GIdentityAuthImage.class);
				return gIdentityAuthImage;
			}else {
				return new GIdentityAuthImage();
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[用户管理-实名认证-查询一条记录]请求后台出错",e);
			return new GIdentityAuthImage();
		}
    }

    
    
    /**
     * 
     * @Title: add
     * @Description: 新增一条记录
     * @param @param request
     * @param @param g_identity_auth
     * @param @return
     * @param @throws Exception
     * @return boolean
     * @throws
     */
    /*public boolean add(HttpServletRequest request,GIdentityAuth g_identity_auth) throws Exception {
    	try {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("GCurrencyData", g_currency_data);
			String method = SERVICE_BASE_PARAM + "g_currency_data_add";
			String json = SendRequestUtil.sendMapRequest(request, map, method);
			String json = GCurrencyDataService.testAdd();
			if (null != json) {
				Boolean flag = JSON.parseObject(json,Boolean.class);
				return flag;
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[币种管理-币种资料-新增一条记录]请求后台出错",e);
			return false;
		}
    }*/

    
    /**
     * 
     * @Title: update
     * @Description: 修改记录
     * @param @param request
     * @param @param g_identity_auth
     * @param @return
     * @param @throws Exception
     * @return boolean
     * @throws
     */
    public boolean update(HttpServletRequest request,GIdentityAuth g_identity_auth) throws Exception {
    	try {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("GIdentityAuth", g_identity_auth);
			/*String method = SERVICE_BASE_PARAM + "g_identity_auth_update";
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
			logger.error("[用户管理-实名认证-修改一条记录]请求后台出错",e);
			return false;
		}
    }
	 /**
     * 删除
     */
    /*public boolean delete(java.lang.String auth_id) throws Exception {
        Integer result = g_identity_auth_dao.deleteById(auth_id);
        return result > 0 ? true : false;
    }*/
    /**
	 * 获取所有数据
	 */
	/*public List<GIdentityAuth> selectAll(GIdentityAuthVO g_identity_auth_vo) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		return g_identity_auth_dao.selectAll(map);
	}*/ 


}
