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
import com.manage.biz.entity.Account;
import com.manage.biz.vo.AccountVO;


/**
 * 
 * @Project：gme-admin   
 * @Class：GAccountService   
 * @Description 类描述：用户账户支付信息管理   
 * @Author：zhou   
 * @Date：2018年6月15日 下午5:17:23   
 * @version V1.0
 */
@Service("AccountService")
public class AccountService{

    private Logger logger = Logger.getLogger(AccountService.class);
	
	
    

	
	
	
	// 测试分页查询
    public static String testPage() {
		List<Account> list = new ArrayList<Account>();
		Account g = new Account();
		g.setUid("1");
		g.setAccountId(1);
		g.setAccountStatus(1);
		g.setAuditStatus(2);
		g.setCardType(2);
		g.setBankBranchName("宝安");
		
		Account g1 = new Account();
		g.setUid("1");
		g1.setAccountId(2);
		g1.setAccountStatus(2);
		g1.setAuditStatus(1);
		g1.setCardType(1);
		g1.setBankBranchName("西乡");
		list.add(g);
		list.add(g1);
		PageBean pageInfo = new PageBean(1, 1,1, list);
		return JSON.toJSONString(pageInfo);
	}

    // 测试查询一条记录
    public static String testOne() {
    	Account g = new Account();
		g.setAccountId(1);
		g.setAccountStatus(1);
		g.setAuditStatus(2);
		g.setCardType(2);
		g.setBankBranchName("宝安");
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
     * @param @param accountVO
     * @param @return
     * @param @throws Exception
     * @return PageInfo
     * @throws
     */
    public PageBean selectPage(HttpServletRequest request,AccountVO accountVO) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("PSIZE", accountVO.getRows());
        map.put("BEGIN", (accountVO.getPage() - 1) * accountVO.getRows());
        
        if (null != accountVO.getRealName() && !StringUtils.isBlank(accountVO.getRealName())) {
        	map.put("realName", accountVO.getRealName());
        }
        if (null != accountVO.getAccountStatus()) {
        	map.put("accountStatus", accountVO.getAccountStatus());
        }
        if (null != accountVO.getAuditStatus()) {
        	map.put("auditStatus", accountVO.getAuditStatus());
        }
        if (null != accountVO.getCardType()) {
        	map.put("cardType", accountVO.getCardType());
        }
        
        
        Integer count = 0;
        // 查询总记录数
        try {
           /* String method = "g_account_getPageCount";
            String json = SendRequestUtil.sendMapRequest(request, map, method);*/
        	String json = this.testPage();
        	if (null != json) {
        		PageBean pageInfo = JSON.parseObject(json, PageBean.class);
                count = pageInfo.getTotalCount();
                if (count == 0) {
                	return new PageBean(accountVO.getRows(), accountVO.getPage(), count, new ArrayList<Account>());
                }
        	}else {
            	return new PageBean(accountVO.getRows(), accountVO.getPage(), count, new ArrayList<Account>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[用户管理-用户账户支付管理-查询总记录条数]请求后台出错",e);
			return new PageBean(accountVO.getRows(), accountVO.getPage(), count, new ArrayList<Account>());
		}
        
        
        // 查询列表
        try {
			/*String method = "g_account_getList";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
        	String json = this.testPage();
        	if (null != json) {
        		PageBean pageInfo = JSON.parseObject(json, PageBean.class);
                return pageInfo;
            }else {
            	return new PageBean(accountVO.getRows(), accountVO.getPage(), 0, new ArrayList<Account>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[用户管理-用户账户支付管理-查询所有记录]请求后台出错",e);
			return new PageBean(accountVO.getRows(), accountVO.getPage(), 0, new ArrayList<Account>());
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
    public Account get(HttpServletRequest request,String uid) throws Exception {
    	try {
    		Map<String,Object> map = new HashMap<String, Object>();
    		map.put("uid", uid);
			/*String method = "g_account_getOfne";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
    		String json = this.testOne();
			if (null != json) {
				Account gAccount = JSON.parseObject(json, Account.class);
				return gAccount;
			}else {
				return new Account();
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[用户管理-用户账户支付管理-查询一条记录]请求后台出错",e);
			return new Account();
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
    public boolean update(HttpServletRequest request,Account g_account) throws Exception {
    	try {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("GAccount", g_account);
			/*String method = "g_account_update";
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
	/*public List<GAccount> selectAll(AccountVO accountVO) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		return g_account_dao.selectAll(map);
	} */


}
