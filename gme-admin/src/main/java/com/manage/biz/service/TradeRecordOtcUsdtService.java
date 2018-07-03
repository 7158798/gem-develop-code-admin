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
import com.manage.biz.entity.TradeRecordOtcUsdt;
import com.manage.biz.vo.TradeRecordOtcUsdtVO;
import com.manage.util.StringUtil;


/**
 * 
 * @Project：gme-admin   
 * @Class：GTradeRecordOtcUsdtService   
 * @Description 类描述：   otc交易记录
 * @Author：zhou   
 * @Date：2018年6月19日 下午2:29:36   
 * @version V1.0
 */
@Service("TradeRecordOtcUsdtService")
public class TradeRecordOtcUsdtService{

	private Logger logger = Logger.getLogger(TradeRecordOtcUsdtService.class);
	
	
    

	
	// 测试分页查询
    public static String testPage() {
		List<TradeRecordOtcUsdt> list = new ArrayList<TradeRecordOtcUsdt>();
		TradeRecordOtcUsdt g = new TradeRecordOtcUsdt();
		g.setUid("1");
		g.setOrderId("1");
		g.setTradeType(1);
		g.setAmount(new BigDecimal(300));
		g.setCurrencySymbol("eos");
		g.setTradeStatus(1);
		g.setTradePrice(new BigDecimal(1000));
		g.setTradeStatus(4);
		g.setServiceCharge(new BigDecimal(0.002));
		
		TradeRecordOtcUsdt g1 = new TradeRecordOtcUsdt();
		g1.setUid("2");
		g1.setOrderId("2");
		g1.setTradeType(2);
		g1.setAmount(new BigDecimal(1100));
		g1.setCurrencySymbol("BTC");
		g1.setTradeStatus(2);
		g1.setTradePrice(new BigDecimal(2323));
		g1.setTradeStatus(6);
		g1.setServiceCharge(new BigDecimal(0.004));
		
		list.add(g);
		list.add(g1);

		PageBean pageInfo = new PageBean(1, 1,1, list);
		return JSON.toJSONString(pageInfo);
	}

    // 测试查询一条记录
    public static String testOne() {
    	TradeRecordOtcUsdt g = new TradeRecordOtcUsdt();
		g.setUid("1");
		g.setOrderId("1");
		g.setTradeType(1);
		g.setAmount(new BigDecimal(300));
		g.setCurrencySymbol("eos");
		g.setTradeStatus(1);
		g.setTradePrice(new BigDecimal(1000));
		g.setTradeStatus(4);
		g.setServiceCharge(new BigDecimal(0.002));
		return JSON.toJSONString(g);
    }
	
	
	/**
	 * 
	 * @Title: selectPage
	 * @Description: 分页查询
	 * @param @param request
	 * @param @param tradeRecordOtcUsdtVO
	 * @param @return
	 * @param @throws Exception
	 * @return PageInfo
	 * @throws
	 */
    public PageBean selectPage(HttpServletRequest request,TradeRecordOtcUsdtVO tradeRecordOtcUsdtVO) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("PSIZE", tradeRecordOtcUsdtVO.getRows());
        map.put("BEGIN", (tradeRecordOtcUsdtVO.getPage() - 1) * tradeRecordOtcUsdtVO.getRows());
        
        if (null != tradeRecordOtcUsdtVO.getUid() && !StringUtils.isBlank(tradeRecordOtcUsdtVO.getUid())) {
        	if (StringUtil.isNumeric(tradeRecordOtcUsdtVO.getUid())) {
        		map.put("uid", tradeRecordOtcUsdtVO.getUid());
        	}
        }
        if (null != tradeRecordOtcUsdtVO.getObjectUid() && !StringUtils.isBlank(tradeRecordOtcUsdtVO.getObjectUid())) {
        	if (StringUtil.isNumeric(tradeRecordOtcUsdtVO.getObjectUid())) {
        		map.put("objectUid", tradeRecordOtcUsdtVO.getObjectUid());
        	}
        }
        if (null != tradeRecordOtcUsdtVO.getOrderId() && !StringUtils.isBlank(tradeRecordOtcUsdtVO.getOrderId())) {
        	if (StringUtil.isNumeric(tradeRecordOtcUsdtVO.getOrderId())) {
        		map.put("orderId", tradeRecordOtcUsdtVO.getOrderId());
        	}
        }
        if (null != tradeRecordOtcUsdtVO.getTradeStatus()) {
        	map.put("tradeStatus", tradeRecordOtcUsdtVO.getTradeStatus());
        }
        if (null != tradeRecordOtcUsdtVO.getTradeType()) {
        	map.put("tradeType", tradeRecordOtcUsdtVO.getTradeType());
        }
        
        
        Integer count = 0;
        // 查询总记录数
        try {
           /* String method = "g_trade_record_otc_usdt_getPageCount";
            String json = SendRequestUtil.sendMapRequest(request, map, method);*/
        	String json = this.testPage();
        	if (null != json) {
        		PageBean pageInfo = JSON.parseObject(json, PageBean.class);
                count = pageInfo.getTotalCount();
                if (count == 0) {
                	return new PageBean(tradeRecordOtcUsdtVO.getRows(), tradeRecordOtcUsdtVO.getPage(), count, new ArrayList<TradeRecordOtcUsdt>());
                }
        	}else {
            	return new PageBean(tradeRecordOtcUsdtVO.getRows(), tradeRecordOtcUsdtVO.getPage(), count, new ArrayList<TradeRecordOtcUsdt>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[交易中心-otc交易记录-查询总记录条数]请求后台出错",e);
			return new PageBean(tradeRecordOtcUsdtVO.getRows(), tradeRecordOtcUsdtVO.getPage(), count, new ArrayList<TradeRecordOtcUsdt>());
		}
        
        
        // 查询列表
        try {
			/*String method = "g_trade_record_otc_usdt_getList";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
        	String json = this.testPage();
        	if (null != json) {
        		PageBean pageInfo = JSON.parseObject(json, PageBean.class);
                return pageInfo;
            }else {
            	return new PageBean(tradeRecordOtcUsdtVO.getRows(), tradeRecordOtcUsdtVO.getPage(), 0, new ArrayList<TradeRecordOtcUsdt>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[交易中心-otc交易记录-查询所有记录]请求后台出错",e);
			return new PageBean(tradeRecordOtcUsdtVO.getRows(), tradeRecordOtcUsdtVO.getPage(), 0, new ArrayList<TradeRecordOtcUsdt>());
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
     * @return GTradeRecordOtcUsdt
     * @throws
     */
    public TradeRecordOtcUsdt get(HttpServletRequest request,String id) throws Exception {
    	try {
    		Map<String,Object> map = new HashMap<String, Object>();
    		map.put("id", id);
			/*String method = "g_trade_record_otc_usdt_getOne";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
    		String json = this.testOne();
			if (null != json) {
				TradeRecordOtcUsdt gTradeRecordOtcUsdt = JSON.parseObject(json, TradeRecordOtcUsdt.class);
				return gTradeRecordOtcUsdt;
			}else {
				return new TradeRecordOtcUsdt();
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[交易中心-otc交易记录-查询一条记录]请求后台出错",e);
			return new TradeRecordOtcUsdt();
		}
    }

    /**
     * 新增
     */
    /*public boolean add(GTradeRecordOtcUsdt g_trade_record_otc_usdt) throws Exception {
        Integer result = g_trade_record_otc_usdt_dao.add(g_trade_record_otc_usdt);
        return result > 0 ? true : false;
    }*/

    /**
     * 修改
     */
    /*public boolean update(GTradeRecordOtcUsdt g_trade_record_otc_usdt) throws Exception {
        Integer result = g_trade_record_otc_usdt_dao.update(g_trade_record_otc_usdt);
        return result > 0 ? true : false;
    }*/
    
	 /**
     * 删除
     */
    /*public boolean delete(java.lang.String id) throws Exception {
        Integer result = g_trade_record_otc_usdt_dao.deleteById(id);
        return result > 0 ? true : false;
    }*/
    
    /**
	 * 获取所有数据
	 */
	/*public List<GTradeRecordOtcUsdt> selectAll(GTradeRecordOtcUsdtVO tradeRecordOtcUsdtVO) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		return g_trade_record_otc_usdt_dao.selectAll(map);
	} */


}
