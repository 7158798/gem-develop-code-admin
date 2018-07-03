package com.manage.biz.service;

import java.math.BigDecimal;
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
import com.manage.biz.entity.OtcOrder;
import com.manage.biz.vo.OtcOrderVO;
import com.manage.util.StringUtil;



/**
 * 
 * @Project：gme-admin   
 * @Class：GOtcOrderService   
 * @Description 类描述：   otc订单管理
 * @Author：zhou   
 * @Date：2018年6月19日 上午11:07:07   
 * @version V1.0
 */
@Service("OtcOrderService")
public class OtcOrderService{
	
    private Logger logger = Logger.getLogger(OtcOrderService.class);
	
	
    
    
	
	// 测试分页查询
    public static String testPage() {
		List<OtcOrder> list = new ArrayList<OtcOrder>();
		OtcOrder g = new OtcOrder();
		g.setUid("1");
		g.setOrderId("1");
		g.setOrderType(1);
		g.setOrderPayType("010201");
		g.setCurrencyId("1");
		g.setOrderStatus(1);
		g.setCurrencySymbol("USDT");
		g.setOrderMinNumber(new BigDecimal(0));
		
		OtcOrder g1 = new OtcOrder();
		g1.setUid("2");
		g1.setOrderId("2");
		g1.setOrderType(2);
		g1.setOrderPayType("020202");
		g1.setCurrencyId("2");
		g1.setOrderStatus(3);
		g1.setCurrencySymbol("EOS");
		g1.setOrderMinNumber(new BigDecimal(2342));
		list.add(g);
		list.add(g1);

		PageBean pageInfo = new PageBean(1, 1,1, list);
		return JSON.toJSONString(pageInfo);
	}

    // 测试查询一条记录
    public static String testOne() {
    	OtcOrder g = new OtcOrder();
		g.setUid("1");
		g.setOrderId("1");
		g.setOrderType(1);
		g.setOrderPayType("010201");
		g.setCurrencyId("1");
		g.setOrderStatus(1);
		g.setCurrencySymbol("USDT");
		g.setOrderMinNumber(new BigDecimal(0));
		return JSON.toJSONString(g);
    }
    
	
	/**
	 * 
	 * @Title: selectPage
	 * @Description: 分页查询
	 * @param @param request
	 * @param @param otcOrderVO
	 * @param @return
	 * @param @throws Exception
	 * @return PageInfo
	 * @throws
	 */
    public PageBean selectPage(HttpServletRequest request,OtcOrderVO otcOrderVO) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("PSIZE", otcOrderVO.getRows());
        map.put("BEGIN", (otcOrderVO.getPage() - 1) * otcOrderVO.getRows());
        
        if (null != otcOrderVO.getOrderId() && !StringUtils.isBlank(otcOrderVO.getOrderId())) {
        	if (StringUtil.isNumeric(otcOrderVO.getOrderId())) {
        		map.put("orderId", otcOrderVO.getOrderId());
        	}
        }
        if (null != otcOrderVO.getUid() && !StringUtils.isBlank(otcOrderVO.getUid())) {
        	if (StringUtil.isNumeric(otcOrderVO.getUid())) {
        		map.put("uid", otcOrderVO.getUid());
        	}
        }
        if (null != otcOrderVO.getOrderStatus()) {
        	map.put("orderStatus", otcOrderVO.getOrderStatus());
        }
        if (null != otcOrderVO.getOrderType()) {
        	map.put("orderType", otcOrderVO.getOrderType());
        }
        	
        
        Integer count = 0;
        // 查询总记录数
        try {
           /* String method = "g_otc_order_getPageCount";
            String json = SendRequestUtil.sendMapRequest(request, map, method);*/
        	String json = this.testPage();
        	if (null != json) {
        		PageBean pageInfo = JSON.parseObject(json, PageBean.class);
                count = pageInfo.getTotalCount();
                if (count == 0) {
                	return new PageBean(otcOrderVO.getRows(), otcOrderVO.getPage(), count, new ArrayList<OtcOrder>());
                }
        	}else {
            	return new PageBean(otcOrderVO.getRows(), otcOrderVO.getPage(), count, new ArrayList<OtcOrder>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[交易中心-otc订单记录-查询总记录条数]请求后台出错",e);
			return new PageBean(otcOrderVO.getRows(), otcOrderVO.getPage(), count, new ArrayList<OtcOrder>());
		}
        
        
        // 查询列表
        try {
			/*String method = "g_otc_order_getList";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
        	String json = this.testPage();
        	if (null != json) {
        		PageBean pageInfo = JSON.parseObject(json, PageBean.class);
                return pageInfo;
            }else {
            	return new PageBean(otcOrderVO.getRows(), otcOrderVO.getPage(), 0, new ArrayList<OtcOrder>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[交易中心-otc订单记录-查询所有记录]请求后台出错",e);
			return new PageBean(otcOrderVO.getRows(), otcOrderVO.getPage(), 0, new ArrayList<OtcOrder>());
		}
    }

    
    /**
     * @Title: get
     * @Description: 查询一条记录
     * @param @param request
     * @param @param entryOrderId
     * @param @return
     * @param @throws Exception
     * @return GOtcOrder
     * @throws
     */
    public OtcOrder get(HttpServletRequest request,String entryOrderId) throws Exception {
    	try {
    		Map<String,Object> map = new HashMap<String, Object>();
    		map.put("entryOrderId", entryOrderId);
			/*String method = "g_otc_order_getOne";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
    		String json = this.testOne();
			if (null != json) {
				OtcOrder gOtcOrder = JSON.parseObject(json, OtcOrder.class);
				return gOtcOrder;
			}else {
				return new OtcOrder();
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[交易中心-otc订单记录-查询一条记录]请求后台出错",e);
			return new OtcOrder();
		}
    }

    /**
     * 新增
     */
    /*public boolean add(GOtcOrder g_otc_order) throws Exception {
        Integer result = g_otc_order_dao.add(g_otc_order);
        return result > 0 ? true : false;
    }*/

    /**
     * 修改
     */
    /*public boolean update(GOtcOrder g_otc_order) throws Exception {
        Integer result = g_otc_order_dao.update(g_otc_order);
        return result > 0 ? true : false;
    }*/
	 /**
     * 删除
     */
    /*public boolean delete(java.lang.String entryOrderId) throws Exception {
        Integer result = g_otc_order_dao.deleteById(entryOrderId);
        return result > 0 ? true : false;
    }*/
    /**
	 * 获取所有数据
	 */
	/*public List<GOtcOrder> selectAll(GOtcOrderVO otcOrderVO) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		return g_otc_order_dao.selectAll(map);
	} */


}
