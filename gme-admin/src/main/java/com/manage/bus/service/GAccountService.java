package com.manage.bus.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.manage.base.entity.PageInfo;
import com.manage.bus.dao.GAccountDAO;
import com.manage.bus.entity.GAccount;
import com.manage.bus.entity.GCurrencyCirculateStatistics;
import com.manage.bus.vo.GAccountVO;


/**
 * 
 * @Project：gme-admin   
 * @Class：GAccountService   
 * @Description 类描述：用户账户支付信息管理   
 * @Author：zhou   
 * @Date：2018年6月15日 下午5:17:23   
 * @version V1.0
 */
@Transactional(readOnly = true)
@Service("GAccountService")
public class GAccountService{

    @Resource(name = "GAccountDAO")
    private GAccountDAO g_account_dao;

    
    private Logger logger = Logger.getLogger(GAccountService.class);
	
	@Value("${SERVICE_BASE_PARAM}")
    private String SERVICE_BASE_PARAM;

	
	
	
	// 测试分页查询
    public static String testPage() {
		List<GAccount> list = new ArrayList<GAccount>();
		GAccount g = new GAccount();
		g.setAccount_id(1);
		g.setAccount_status(1);
		g.setAudit_status(2);
		g.setCard_type(2);
		g.setBank_branch_name("宝安");
		
		GAccount g1 = new GAccount();
		g1.setAccount_id(2);
		g1.setAccount_status(2);
		g1.setAudit_status(1);
		g1.setCard_type(1);
		g1.setBank_branch_name("西乡");
		list.add(g);
		list.add(g1);
		PageInfo pageInfo = new PageInfo(1, 1,1, list);
		return JSON.toJSONString(pageInfo);
	}

    // 测试查询一条记录
    public static String testOne() {
    	GAccount g1 = new GAccount();
		g1.setAccount_id(1);
		g1.setAccount_status(1);
		g1.setAudit_status(2);
		g1.setCard_type(2);
		g1.setBank_branch_name("宝安");
		return JSON.toJSONString(g1);
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
     * @param @param g_account_vo
     * @param @return
     * @param @throws Exception
     * @return PageInfo
     * @throws
     */
    public PageInfo selectPage(HttpServletRequest request,GAccountVO g_account_vo) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("PSIZE", g_account_vo.getRows());
        map.put("BEGIN", (g_account_vo.getPage() - 1) * g_account_vo.getRows());
        
        if (null != g_account_vo.getReal_name() && !StringUtils.isBlank(g_account_vo.getReal_name())) {
        	map.put("realName", g_account_vo.getReal_name());
        }
        if (null != g_account_vo.getAccount_status()) {
        	map.put("accountStatus", g_account_vo.getAccount_status());
        }
        if (null != g_account_vo.getAudit_status()) {
        	map.put("auditStatus", g_account_vo.getAudit_status());
        }
        if (null != g_account_vo.getCard_type()) {
        	map.put("cardType", g_account_vo.getCard_type());
        }
        
        
        Integer count = 0;
        // 查询总记录数
        try {
           /* String method = SERVICE_BASE_PARAM + "g_account_getPageCount";
            String json = SendRequestUtil.sendMapRequest(request, map, method);*/
        	String json = this.testPage();
        	if (null != json) {
        		PageInfo pageInfo = JSON.parseObject(json, PageInfo.class);
                count = pageInfo.getTotalCount();
                if (count == 0) {
                	return new PageInfo(g_account_vo.getRows(), g_account_vo.getPage(), count, new ArrayList<GAccount>());
                }
        	}else {
            	return new PageInfo(g_account_vo.getRows(), g_account_vo.getPage(), count, new ArrayList<GAccount>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[用户管理-用户账户支付管理-查询总记录条数]请求后台出错",e);
			return new PageInfo(g_account_vo.getRows(), g_account_vo.getPage(), count, new ArrayList<GAccount>());
		}
        
        
        // 查询列表
        try {
			/*String method = SERVICE_BASE_PARAM + "g_account_getList";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
        	String json = this.testPage();
        	if (null != json) {
        		PageInfo pageInfo = JSON.parseObject(json, PageInfo.class);
                return pageInfo;
            }else {
            	return new PageInfo(g_account_vo.getRows(), g_account_vo.getPage(), 0, new ArrayList<GAccount>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[用户管理-用户账户支付管理-查询所有记录]请求后台出错",e);
			return new PageInfo(g_account_vo.getRows(), g_account_vo.getPage(), 0, new ArrayList<GAccount>());
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
     * @return GAccount
     * @throws
     */
    public GAccount get(HttpServletRequest request,String uid) throws Exception {
    	try {
    		Map<String,Object> map = new HashMap<String, Object>();
    		map.put("uid", uid);
			/*String method = SERVICE_BASE_PARAM + "g_account_getOfne";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
    		String json = this.testOne();
			if (null != json) {
				GAccount gAccount = JSON.parseObject(json, GAccount.class);
				return gAccount;
			}else {
				return new GAccount();
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[用户管理-用户账户支付管理-查询一条记录]请求后台出错",e);
			return new GAccount();
		}
    }

    /**
     * 新增
     */
    /*public boolean add(GAccount g_account) throws Exception {
        Integer result = g_account_dao.add(g_account);
        return result > 0 ? true : false;
    }*/

    
    /**
     * 
     * @Title: update
     * @Description: 修改一条记录
     * @param @param request
     * @param @param g_account
     * @param @return
     * @param @throws Exception
     * @return boolean
     * @throws
     */
    public boolean update(HttpServletRequest request,GAccount g_account) throws Exception {
    	try {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("GAccount", g_account);
			/*String method = SERVICE_BASE_PARAM + "g_account_update";
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
			logger.error("[用户管理-用户账户支付管理-修改一条记录]请求后台出错",e);
			return false;
		}
    }
	 /**
     * 删除
     */
  /*  public boolean delete(java.lang.String uid) throws Exception {
        Integer result = g_account_dao.deleteById(uid);
        return result > 0 ? true : false;
    }*/
    
    
    /**
	 * 获取所有数据
	 */
	/*public List<GAccount> selectAll(GAccountVO g_account_vo) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		return g_account_dao.selectAll(map);
	} */


}
