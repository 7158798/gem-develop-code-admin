package com.manage.biz.service;

import java.math.BigDecimal;
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
import com.manage.base.entity.PageBean;
import com.manage.biz.entity.EntrustOrderUsdt;
import com.manage.biz.vo.EntrustOrderUsdtVO;
import com.manage.util.StringUtil;


/**
 * 
 * @Project：gme-admin   
 * @Class：GEntrustOrderUsdtService   
 * @Description 类描述：委托订单记录   
 * @Author：zhou   
 * @Date：2018年6月19日 下午4:01:57   
 * @version V1.0
 */
@Service("EntrustOrderUsdtService")
public class EntrustOrderUsdtService{

	private Logger logger = Logger.getLogger(EntrustOrderUsdtService.class);
	
   	
    

   	
 // 测试分页查询
    public static String testPage() {
		List<EntrustOrderUsdt> list = new ArrayList<EntrustOrderUsdt>();
		EntrustOrderUsdt g = new EntrustOrderUsdt();
		g.setUid("1");
		g.setOrderId("1");
		g.setEntrustAmount(new BigDecimal(2323));
		g.setEntrustType(1);
		g.setOrderStatus(3);
		g.setOrderFinishedTime(new Timestamp(new Date().getTime()));
		g.setFinishedAmount(new BigDecimal(2000));
		
		EntrustOrderUsdt g1 = new EntrustOrderUsdt();
		g1.setUid("2");
		g1.setOrderId("2");
		g1.setEntrustAmount(new BigDecimal(224223));
		g1.setEntrustType(2);
		g1.setOrderStatus(4);
		g1.setOrderFinishedTime(new Timestamp(new Date().getTime()));
		g1.setFinishedAmount(new BigDecimal(340));
		list.add(g);
		list.add(g1);

		PageBean pageInfo = new PageBean(1, 1,1, list);
		return JSON.toJSONString(pageInfo);
	}

    // 测试查询一条记录
    public static String testOne() {
    	EntrustOrderUsdt g = new EntrustOrderUsdt();
		g.setUid("1");
		g.setOrderId("1");
		g.setEntrustAmount(new BigDecimal(2323));
		g.setEntrustType(1);
		g.setOrderStatus(3);
		g.setOrderFinishedTime(new Timestamp(new Date().getTime()));
		g.setFinishedAmount(new BigDecimal(2000));
		return JSON.toJSONString(g);
    }
   	
   	
   	/**
   	 * 
   	 * @Title: selectPage
   	 * @Description: 分页查询
   	 * @param @param request
   	 * @param @param entrustOrderUsdtVO
   	 * @param @return
   	 * @param @throws Exception
   	 * @return PageInfo
   	 * @throws
   	 */
    public PageBean selectPage(HttpServletRequest request,EntrustOrderUsdtVO entrustOrderUsdtVO) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("PSIZE", entrustOrderUsdtVO.getRows());
        map.put("BEGIN", (entrustOrderUsdtVO.getPage() - 1) * entrustOrderUsdtVO.getRows());
        
        if (null != entrustOrderUsdtVO.getOrderId() && !StringUtils.isBlank(entrustOrderUsdtVO.getOrderId())) {
        	if (StringUtil.isNumeric(entrustOrderUsdtVO.getOrderId())) {
        		map.put("orderId", entrustOrderUsdtVO.getOrderId());
        	}
        }
        if (null != entrustOrderUsdtVO.getUid() && !StringUtils.isBlank(entrustOrderUsdtVO.getUid())) {
        	if (StringUtil.isNumeric(entrustOrderUsdtVO.getUid())) {
        		map.put("uid", entrustOrderUsdtVO.getUid());
        	}
        }
        if (null != entrustOrderUsdtVO.getEntrustType()) {
        	map.put("objectUid", entrustOrderUsdtVO.getEntrustType());
        }
        if (null != entrustOrderUsdtVO.getOrderStatus()) {
        	map.put("orderStatus", entrustOrderUsdtVO.getOrderStatus());
        }
        
        Integer count = 0;
        // 查询总记录数
        try {
           /* String method = "g_entrust_order_usdt_getPageCount";
            String json = SendRequestUtil.sendMapRequest(request, map, method);*/
        	String json = this.testPage();
        	if (null != json) {
        		PageBean pageInfo = JSON.parseObject(json, PageBean.class);
                count = pageInfo.getTotalCount();
                if (count == 0) {
                	return new PageBean(entrustOrderUsdtVO.getRows(), entrustOrderUsdtVO.getPage(), count, new ArrayList<EntrustOrderUsdt>());
                }
        	}else {
            	return new PageBean(entrustOrderUsdtVO.getRows(), entrustOrderUsdtVO.getPage(), count, new ArrayList<EntrustOrderUsdt>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[交易中心-委托订单记录-查询总记录条数]请求后台出错",e);
			return new PageBean(entrustOrderUsdtVO.getRows(), entrustOrderUsdtVO.getPage(), count, new ArrayList<EntrustOrderUsdt>());
		}
        
        
        // 查询列表
        try {
			/*String method = "g_entrust_order_usdt_getList";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
        	String json = this.testPage();
        	if (null != json) {
        		PageBean pageInfo = JSON.parseObject(json, PageBean.class);
                return pageInfo;
            }else {
            	return new PageBean(entrustOrderUsdtVO.getRows(), entrustOrderUsdtVO.getPage(), 0, new ArrayList<EntrustOrderUsdt>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[交易中心-委托订单记录-查询所有记录]请求后台出错",e);
			return new PageBean(entrustOrderUsdtVO.getRows(), entrustOrderUsdtVO.getPage(), 0, new ArrayList<EntrustOrderUsdt>());
		}
    }
    
    
    /**
     * 
     * @Title: get
     * @Description: 查询一条记录
     * @param @param request
     * @param @param entrustOrderId
     * @param @return
     * @param @throws Exception
     * @return GEntrustOrderUsdt
     * @throws
     */
    public EntrustOrderUsdt get(HttpServletRequest request,String entrustOrderId) throws Exception {
    	try {
    		Map<String,Object> map = new HashMap<String, Object>();
    		map.put("entrustOrderId", entrustOrderId);
			/*String method = "g_entrust_order_usdt_getOne";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
    		String json = this.testOne();
			if (null != json) {
				EntrustOrderUsdt gEntrustOrderUsdt = JSON.parseObject(json, EntrustOrderUsdt.class);
				return gEntrustOrderUsdt;
			}else {
				return new EntrustOrderUsdt();
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[交易中心-委托订单记录-查询一条记录]请求后台出错",e);
			return new EntrustOrderUsdt();
		}
    }

    /**
     * 新增
     */
    /*public boolean add(GEntrustOrderUsdt g_entrust_order_usdt) throws Exception {
        Integer result = g_entrust_order_usdt_dao.add(g_entrust_order_usdt);
        return result > 0 ? true : false;
    }*/

    /**
     * 修改
     */
/*    public boolean update(GEntrustOrderUsdt g_entrust_order_usdt) throws Exception {
        Integer result = g_entrust_order_usdt_dao.update(g_entrust_order_usdt);
        return result > 0 ? true : false;
    }*/
    
	 /**
     * 删除
     */
/*    public boolean delete(java.lang.String entrustOrderId) throws Exception {
        Integer result = g_entrust_order_usdt_dao.deleteById(entrustOrderId);
        return result > 0 ? true : false;
    }*/
    
    /**
	 * 获取所有数据
	 */
	/*public List<GEntrustOrderUsdt> selectAll(GEntrustOrderUsdtVO entrustOrderUsdtVO) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		return g_entrust_order_usdt_dao.selectAll(map);
	}*/ 


}
