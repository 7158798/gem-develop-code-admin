package com.manage.bus.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
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
import com.manage.bus.dao.GTradeRecordCoinUsdtDAO;
import com.manage.bus.entity.GTradeRecordCoinUsdt;
import com.manage.bus.entity.GTradeRecordOtcUsdt;
import com.manage.bus.vo.GTradeRecordCoinUsdtVO;
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
@Service("GTradeRecordCoinUsdtService")
public class GTradeRecordCoinUsdtService{

	private Logger logger = Logger.getLogger(GTradeRecordCoinUsdtService.class);
	
	@Value("${SERVICE_BASE_PARAM}")
    private String SERVICE_BASE_PARAM;
	
	
	// 测试分页查询
    public static String testPage() {
		List<GTradeRecordCoinUsdt> list = new ArrayList<GTradeRecordCoinUsdt>();
		GTradeRecordCoinUsdt g = new GTradeRecordCoinUsdt();
		g.setUid("1");
		g.setOrder_id("1");
		g.setTrade_type(1);
		g.setAmount(new BigDecimal(300));
		g.setTrade_status(1);
		g.setTrade_price(new BigDecimal(1000));
		g.setUid("3");
		g.setTrade_status(4);
		g.setTrade_time(new Timestamp(new Date().getTime()));
		
		GTradeRecordCoinUsdt g1 = new GTradeRecordCoinUsdt();
		g1.setUid("2");
		g1.setOrder_id("2");
		g1.setTrade_type(2);
		g1.setAmount(new BigDecimal(1100));
		g1.setTrade_status(2);
		g1.setTrade_price(new BigDecimal(2323));
		g1.setUid("6");
		g1.setTrade_status(6);
		g1.setTrade_time(new Timestamp(new Date().getTime()));
		
		list.add(g);
		list.add(g1);

		PageInfo pageInfo = new PageInfo(1, 1,1, list);
		return JSON.toJSONString(pageInfo);
	}

    // 测试查询一条记录
    public static String testOne() {
    	GTradeRecordCoinUsdt g = new GTradeRecordCoinUsdt();
		g.setUid("1");
		g.setOrder_id("1");
		g.setTrade_type(1);
		g.setAmount(new BigDecimal(300));
		g.setTrade_status(1);
		g.setTrade_price(new BigDecimal(1000));
		g.setUid("3");
		g.setTrade_status(4);
		g.setTrade_time(new Timestamp(new Date().getTime()));
		return JSON.toJSONString(g);
    }
	
	

    /**
     * 
     * @Title: selectPage
     * @Description: 分页查询
     * @param @param request
     * @param @param g_trade_record_coin_usdt_vo
     * @param @return
     * @param @throws Exception
     * @return PageInfo
     * @throws
     */
    public PageInfo selectPage(HttpServletRequest request,GTradeRecordCoinUsdtVO g_trade_record_coin_usdt_vo) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("PSIZE", g_trade_record_coin_usdt_vo.getRows());
        map.put("BEGIN", (g_trade_record_coin_usdt_vo.getPage() - 1) * g_trade_record_coin_usdt_vo.getRows());
        
        if (null != g_trade_record_coin_usdt_vo.getUid() && !StringUtils.isBlank(g_trade_record_coin_usdt_vo.getUid())) {
        	if (StringUtil.isNumeric(g_trade_record_coin_usdt_vo.getUid())) {
        		map.put("uid", g_trade_record_coin_usdt_vo.getUid());
        	}
        }
        if (null != g_trade_record_coin_usdt_vo.getObject_uid() && !StringUtils.isBlank(g_trade_record_coin_usdt_vo.getObject_uid())) {
        	if (StringUtil.isNumeric(g_trade_record_coin_usdt_vo.getObject_uid())) {
        		map.put("objectUid", g_trade_record_coin_usdt_vo.getObject_uid());
        	}
        }
        if (null != g_trade_record_coin_usdt_vo.getOrder_id() && !StringUtils.isBlank(g_trade_record_coin_usdt_vo.getOrder_id())) {
        	if (StringUtil.isNumeric(g_trade_record_coin_usdt_vo.getOrder_id())) {
        		map.put("orderId", g_trade_record_coin_usdt_vo.getOrder_id());
        	}
        }
        if (null != g_trade_record_coin_usdt_vo.getTrade_status()) {
        	map.put("tradeStatus", g_trade_record_coin_usdt_vo.getTrade_status());
        }
        if (null != g_trade_record_coin_usdt_vo.getTrade_type()) {
        	map.put("tradeType", g_trade_record_coin_usdt_vo.getTrade_type());
        }
        
        
        Integer count = 0;
        // 查询总记录数
        try {
           /* String method = SERVICE_BASE_PARAM + "g_trade_record_coin_usdt_getPageCount";
            String json = SendRequestUtil.sendMapRequest(request, map, method);*/
        	String json = this.testPage();
        	if (null != json) {
        		PageInfo pageInfo = JSON.parseObject(json, PageInfo.class);
                count = pageInfo.getTotalCount();
                if (count == 0) {
                	return new PageInfo(g_trade_record_coin_usdt_vo.getRows(), g_trade_record_coin_usdt_vo.getPage(), count, new ArrayList<GTradeRecordCoinUsdt>());
                }
        	}else {
            	return new PageInfo(g_trade_record_coin_usdt_vo.getRows(), g_trade_record_coin_usdt_vo.getPage(), count, new ArrayList<GTradeRecordCoinUsdt>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[交易中心-委托交易记录-查询总记录条数]请求后台出错",e);
			return new PageInfo(g_trade_record_coin_usdt_vo.getRows(), g_trade_record_coin_usdt_vo.getPage(), count, new ArrayList<GTradeRecordCoinUsdt>());
		}
        
        
        // 查询列表
        try {
			/*String method = SERVICE_BASE_PARAM + "g_trade_record_coin_usdt_getList";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
        	String json = this.testPage();
        	if (null != json) {
        		PageInfo pageInfo = JSON.parseObject(json, PageInfo.class);
                return pageInfo;
            }else {
            	return new PageInfo(g_trade_record_coin_usdt_vo.getRows(), g_trade_record_coin_usdt_vo.getPage(), 0, new ArrayList<GTradeRecordCoinUsdt>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[交易中心-委托交易记录-查询所有记录]请求后台出错",e);
			return new PageInfo(g_trade_record_coin_usdt_vo.getRows(), g_trade_record_coin_usdt_vo.getPage(), 0, new ArrayList<GTradeRecordCoinUsdt>());
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
    public GTradeRecordCoinUsdt get(HttpServletRequest request,String id) throws Exception {
    	try {
    		Map<String,Object> map = new HashMap<String, Object>();
    		map.put("id", id);
			/*String method = SERVICE_BASE_PARAM + "g_trade_record_coin_usdt_getOne";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
    		String json = this.testOne();
			if (null != json) {
				GTradeRecordCoinUsdt gTradeRecordCoinUsdt = JSON.parseObject(json, GTradeRecordCoinUsdt.class);
				return gTradeRecordCoinUsdt;
			}else {
				return new GTradeRecordCoinUsdt();
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[交易中心-委托交易记录-查询一条记录]请求后台出错",e);
			return new GTradeRecordCoinUsdt();
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
	/*public List<GTradeRecordCoinUsdt> selectAll(GTradeRecordCoinUsdtVO g_trade_record_coin_usdt_vo) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		return g_trade_record_coin_usdt_dao.selectAll(map);
	} */


}
