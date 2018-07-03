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
import com.manage.biz.entity.EntrustOrderRecordUsdt;
import com.manage.biz.vo.EntrustOrderRecordUsdtVO;
import com.manage.util.StringUtil;

/**
 * 
 * @Project：gme-admin   
 * @Class：GEntrustOrderRecordUsdtService   
 * @Description 类描述：委托历史记录   
 * @Author：zhou   
 * @Date：2018年6月19日 下午4:36:55   
 * @version V1.0
 */
@Service("EntrustOrderRecordUsdtService")
public class EntrustOrderRecordUsdtService{

	
	private  Logger logger = Logger.getLogger(EntrustOrderRecordUsdtService.class);
	
	
    

	
	// 测试分页查询
    public static String testPage() {
		List<EntrustOrderRecordUsdt> list = new ArrayList<EntrustOrderRecordUsdt>();
		EntrustOrderRecordUsdt g = new EntrustOrderRecordUsdt();
		g.setOrderId("1");
		g.setUid("1");
		g.setDealStatus(1);
		g.setFinishedAmount(new BigDecimal(232));
		g.setCreateTime(new Timestamp(new Date().getTime()));
		g.setEntrustOrderId("1");
		g.setOrderStatus(1);
		g.setEntrustType(1);
		
		EntrustOrderRecordUsdt g1 = new EntrustOrderRecordUsdt();
		g1.setOrderId("2");
		g1.setUid("2");
		g1.setDealStatus(2);
		g1.setFinishedAmount(new BigDecimal(23432));
		g1.setCreateTime(new Timestamp(new Date().getTime()));
		g1.setEntrustOrderId("2");
		g1.setOrderStatus(3);
		g1.setEntrustType(2);
		list.add(g);
		list.add(g1);
		PageBean pageInfo = new PageBean(1, 1,1, list);
		return JSON.toJSONString(pageInfo);
	}

    // 测试查询一条记录
    public static String testOne() {
    	EntrustOrderRecordUsdt g = new EntrustOrderRecordUsdt();
		g.setOrderId("1");
		g.setUid("1");
		g.setDealStatus(1);
		g.setFinishedAmount(new BigDecimal(232));
		g.setCreateTime(new Timestamp(new Date().getTime()));
		g.setEntrustOrderId("1");
		g.setOrderStatus(1);
		g.setEntrustType(1);
		return JSON.toJSONString(g);
    }
    
    
    /**
     * 
     * @Title: selectPage
     * @Description: 分页查询
     * @param @param request
     * @param @param entrustOrderRecordUsdtVO
     * @param @return
     * @param @throws Exception
     * @return PageInfo
     * @throws
     */
    public PageBean selectPage(HttpServletRequest request,EntrustOrderRecordUsdtVO entrustOrderRecordUsdtVO) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("PSIZE", entrustOrderRecordUsdtVO.getRows());
        map.put("BEGIN", (entrustOrderRecordUsdtVO.getPage() - 1) * entrustOrderRecordUsdtVO.getRows());
        
        if (null != entrustOrderRecordUsdtVO.getOrderId() && !StringUtils.isBlank(entrustOrderRecordUsdtVO.getOrderId())) {
        	if (StringUtil.isNumeric(entrustOrderRecordUsdtVO.getOrderId())) {
        		map.put("orderId", entrustOrderRecordUsdtVO.getOrderId());
        	}
        }
        if (null != entrustOrderRecordUsdtVO.getUid() && !StringUtils.isBlank(entrustOrderRecordUsdtVO.getUid())) {
        	if (StringUtil.isNumeric(entrustOrderRecordUsdtVO.getUid())) {
        		map.put("uid", entrustOrderRecordUsdtVO.getUid());
        	}
        }
        if (null != entrustOrderRecordUsdtVO.getEntrustType()) {
        	map.put("objectUid", entrustOrderRecordUsdtVO.getEntrustType());
        }
        if (null != entrustOrderRecordUsdtVO.getOrderStatus()) {
        	map.put("orderStatus", entrustOrderRecordUsdtVO.getOrderStatus());
        }
        if (null != entrustOrderRecordUsdtVO.getDealStatus()) {
        	map.put("dealStatus", entrustOrderRecordUsdtVO.getDealStatus());
        }
        
        Integer count = 0;
        // 查询总记录数
        try {
           /* String method = "g_entrust_order_record_usdt_getPageCount";
            String json = SendRequestUtil.sendMapRequest(request, map, method);*/
        	String json = this.testPage();
        	if (null != json) {
        		PageBean pageInfo = JSON.parseObject(json, PageBean.class);
                count = pageInfo.getTotalCount();
                if (count == 0) {
                	return new PageBean(entrustOrderRecordUsdtVO.getRows(), entrustOrderRecordUsdtVO.getPage(), count, new ArrayList<EntrustOrderRecordUsdt>());
                }
        	}else {
            	return new PageBean(entrustOrderRecordUsdtVO.getRows(), entrustOrderRecordUsdtVO.getPage(), count, new ArrayList<EntrustOrderRecordUsdt>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[交易中心-委托历史订单记录-查询总记录条数]请求后台出错",e);
			return new PageBean(entrustOrderRecordUsdtVO.getRows(), entrustOrderRecordUsdtVO.getPage(), count, new ArrayList<EntrustOrderRecordUsdt>());
		}
        
        
        // 查询列表
        try {
			/*String method = "g_entrust_order_record_usdt_getList";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
        	String json = this.testPage();
        	if (null != json) {
        		PageBean pageInfo = JSON.parseObject(json, PageBean.class);
                return pageInfo;
            }else {
            	return new PageBean(entrustOrderRecordUsdtVO.getRows(), entrustOrderRecordUsdtVO.getPage(), 0, new ArrayList<EntrustOrderRecordUsdt>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[交易中心-委托历史订单记录-查询所有记录]请求后台出错",e);
			return new PageBean(entrustOrderRecordUsdtVO.getRows(), entrustOrderRecordUsdtVO.getPage(), 0, new ArrayList<EntrustOrderRecordUsdt>());
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
     * @return GEntrustOrderRecordUsdt
     * @throws
     */
    public EntrustOrderRecordUsdt get(HttpServletRequest request,String entrustOrderId) throws Exception {
    	try {
    		Map<String,Object> map = new HashMap<String, Object>();
    		map.put("entrustOrderId", entrustOrderId);
			/*String method = "g_entrust_order_record_usdt_getOne";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
    		String json = this.testOne();
			if (null != json) {
				EntrustOrderRecordUsdt gEntrustOrderRecordUsdt = JSON.parseObject(json, EntrustOrderRecordUsdt.class);
				return gEntrustOrderRecordUsdt;
			}else {
				return new EntrustOrderRecordUsdt();
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[交易中心-委托历史订单记录-查询一条记录]请求后台出错",e);
			return new EntrustOrderRecordUsdt();
		}
    }

    /**
     * 新增
     */
    /*public boolean add(GEntrustOrderRecordUsdt g_entrust_order_record_usdt) throws Exception {
        Integer result = g_entrust_order_record_usdt_dao.add(g_entrust_order_record_usdt);
        return result > 0 ? true : false;
    }*/

    /**
     * 修改
     */
    /*public boolean update(GEntrustOrderRecordUsdt g_entrust_order_record_usdt) throws Exception {
        Integer result = g_entrust_order_record_usdt_dao.update(g_entrust_order_record_usdt);
        return result > 0 ? true : false;
    }*/
    
	 /**
     * 删除
     */
    /*public boolean delete(java.lang.String entrustOrderId) throws Exception {
        Integer result = g_entrust_order_record_usdt_dao.deleteById(entrustOrderId);
        return result > 0 ? true : false;
    }*/
    
    /**
	 * 获取所有数据
	 */
	/*public List<GEntrustOrderRecordUsdt> selectAll(GEntrustOrderRecordUsdtVO entrustOrderRecordUsdtVO) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		return g_entrust_order_record_usdt_dao.selectAll(map);
	} */


}
