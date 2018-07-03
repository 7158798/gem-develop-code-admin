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
import com.manage.biz.entity.TradeRecordCoinUsdt;
import com.manage.biz.vo.TradeRecordCoinUsdtVO;
import com.manage.util.StringUtil;


/**
 * 
 * @Project：gme-admin   
 * @Class：GTradeRecordCoinUsdtService   
 * @Description 类描述：委托交易记录   
 * @Author：zhou   
 * @Date：2018年6月19日 下午5:15:24   
 * @version V1.0
 */
@Service("TradeRecordCoinUsdtService")
public class TradeRecordCoinUsdtService{

	private Logger logger = Logger.getLogger(TradeRecordCoinUsdtService.class);
	
	
    
	
	
	// 测试分页查询
    public static String testPage() {
		List<TradeRecordCoinUsdt> list = new ArrayList<TradeRecordCoinUsdt>();
		TradeRecordCoinUsdt g = new TradeRecordCoinUsdt();
		g.setUid("1");
		g.setOrderId("1");
		g.setTradeType(1);
		g.setAmount(new BigDecimal(300));
		g.setTradeStatus(1);
		g.setTradePrice(new BigDecimal(1000));
		g.setUid("3");
		g.setTradeStatus(4);
		g.setServiceCharge(new BigDecimal(0.002));
		g.setTradeTime(new Timestamp(new Date().getTime()));
		
		TradeRecordCoinUsdt g1 = new TradeRecordCoinUsdt();
		g1.setUid("2");
		g1.setOrderId("2");
		g1.setTradeType(2);
		g1.setAmount(new BigDecimal(1100));
		g1.setTradeStatus(2);
		g1.setTradePrice(new BigDecimal(2323));
		g1.setUid("6");
		g1.setTradeStatus(6);
		g1.setTradeTime(new Timestamp(new Date().getTime()));
		g1.setServiceCharge(new BigDecimal(0.004));
		
		list.add(g);
		list.add(g1);

		PageBean pageInfo = new PageBean(1, 1,1, list);
		return JSON.toJSONString(pageInfo);
	}

    // 测试查询一条记录
    public static String testOne() {
    	TradeRecordCoinUsdt g = new TradeRecordCoinUsdt();
		g.setUid("1");
		g.setOrderId("1");
		g.setTradeType(1);
		g.setAmount(new BigDecimal(300));
		g.setTradeStatus(1);
		g.setTradePrice(new BigDecimal(1000));
		g.setUid("3");
		g.setTradeStatus(4);
		g.setServiceCharge(new BigDecimal(0.002));
		g.setTradeTime(new Timestamp(new Date().getTime()));
		return JSON.toJSONString(g);
    }
	
	

    /**
     * 
     * @Title: selectPage
     * @Description: 分页查询
     * @param @param request
     * @param @param tradeRecordCoinUsdtVO
     * @param @return
     * @param @throws Exception
     * @return PageInfo
     * @throws
     */
    public PageBean selectPage(HttpServletRequest request,TradeRecordCoinUsdtVO tradeRecordCoinUsdtVO) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("PSIZE", tradeRecordCoinUsdtVO.getRows());
        map.put("BEGIN", (tradeRecordCoinUsdtVO.getPage() - 1) * tradeRecordCoinUsdtVO.getRows());
        
        if (null != tradeRecordCoinUsdtVO.getUid() && !StringUtils.isBlank(tradeRecordCoinUsdtVO.getUid())) {
        	if (StringUtil.isNumeric(tradeRecordCoinUsdtVO.getUid())) {
        		map.put("uid", tradeRecordCoinUsdtVO.getUid());
        	}
        }
        if (null != tradeRecordCoinUsdtVO.getObjectUid() && !StringUtils.isBlank(tradeRecordCoinUsdtVO.getObjectUid())) {
        	if (StringUtil.isNumeric(tradeRecordCoinUsdtVO.getObjectUid())) {
        		map.put("objectUid", tradeRecordCoinUsdtVO.getObjectUid());
        	}
        }
        if (null != tradeRecordCoinUsdtVO.getOrderId() && !StringUtils.isBlank(tradeRecordCoinUsdtVO.getOrderId())) {
        	if (StringUtil.isNumeric(tradeRecordCoinUsdtVO.getOrderId())) {
        		map.put("orderId", tradeRecordCoinUsdtVO.getOrderId());
        	}
        }
        if (null != tradeRecordCoinUsdtVO.getTradeStatus()) {
        	map.put("tradeStatus", tradeRecordCoinUsdtVO.getTradeStatus());
        }
        if (null != tradeRecordCoinUsdtVO.getTradeType()) {
        	map.put("tradeType", tradeRecordCoinUsdtVO.getTradeType());
        }
        
        
        Integer count = 0;
        // 查询总记录数
        try {
           /* String method = "g_trade_record_coin_usdt_getPageCount";
            String json = SendRequestUtil.sendMapRequest(request, map, method);*/
        	String json = this.testPage();
        	if (null != json) {
        		PageBean pageInfo = JSON.parseObject(json, PageBean.class);
                count = pageInfo.getTotalCount();
                if (count == 0) {
                	return new PageBean(tradeRecordCoinUsdtVO.getRows(), tradeRecordCoinUsdtVO.getPage(), count, new ArrayList<TradeRecordCoinUsdt>());
                }
        	}else {
            	return new PageBean(tradeRecordCoinUsdtVO.getRows(), tradeRecordCoinUsdtVO.getPage(), count, new ArrayList<TradeRecordCoinUsdt>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[交易中心-委托交易记录-查询总记录条数]请求后台出错",e);
			return new PageBean(tradeRecordCoinUsdtVO.getRows(), tradeRecordCoinUsdtVO.getPage(), count, new ArrayList<TradeRecordCoinUsdt>());
		}
        
        
        // 查询列表
        try {
			/*String method = "g_trade_record_coin_usdt_getList";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
        	String json = this.testPage();
        	if (null != json) {
        		PageBean pageInfo = JSON.parseObject(json, PageBean.class);
                return pageInfo;
            }else {
            	return new PageBean(tradeRecordCoinUsdtVO.getRows(), tradeRecordCoinUsdtVO.getPage(), 0, new ArrayList<TradeRecordCoinUsdt>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[交易中心-委托交易记录-查询所有记录]请求后台出错",e);
			return new PageBean(tradeRecordCoinUsdtVO.getRows(), tradeRecordCoinUsdtVO.getPage(), 0, new ArrayList<TradeRecordCoinUsdt>());
		}
    }

    
    /**
     * 
     * @Title: get
     * @Description: 查询一条记录
     * @param @param request
     * @param @param id
     * @param @return
     * @param @throws Exception
     * @return GTradeRecordCoinUsdt
     * @throws
     */
    public TradeRecordCoinUsdt get(HttpServletRequest request,String id) throws Exception {
    	try {
    		Map<String,Object> map = new HashMap<String, Object>();
    		map.put("id", id);
			/*String method = "g_trade_record_coin_usdt_getOne";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
    		String json = this.testOne();
			if (null != json) {
				TradeRecordCoinUsdt gTradeRecordCoinUsdt = JSON.parseObject(json, TradeRecordCoinUsdt.class);
				return gTradeRecordCoinUsdt;
			}else {
				return new TradeRecordCoinUsdt();
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[交易中心-委托交易记录-查询一条记录]请求后台出错",e);
			return new TradeRecordCoinUsdt();
		}
    }

    /**
     * 新增
     */
    /*public boolean add(GTradeRecordCoinUsdt g_trade_record_coin_usdt) throws Exception {
        Integer result = g_trade_record_coin_usdt_dao.add(g_trade_record_coin_usdt);
        return result > 0 ? true : false;
    }*/

    /**
     * 修改
     */
   /* public boolean update(GTradeRecordCoinUsdt g_trade_record_coin_usdt) throws Exception {
        Integer result = g_trade_record_coin_usdt_dao.update(g_trade_record_coin_usdt);
        return result > 0 ? true : false;
    }*/
    
	 /**
     * 删除
     */
   /* public boolean delete(java.lang.String id) throws Exception {
        Integer result = g_trade_record_coin_usdt_dao.deleteById(id);
        return result > 0 ? true : false;
    }*/
    
    /**
	 * 获取所有数据
	 */
	/*public List<GTradeRecordCoinUsdt> selectAll(GTradeRecordCoinUsdtVO tradeRecordCoinUsdtVO) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		return g_trade_record_coin_usdt_dao.selectAll(map);
	} */


}
