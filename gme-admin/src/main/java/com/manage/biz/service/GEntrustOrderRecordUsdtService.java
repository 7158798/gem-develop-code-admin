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
import com.manage.base.entity.PageInfo;
import com.manage.biz.entity.GEntrustOrderRecordUsdt;
import com.manage.biz.vo.GEntrustOrderRecordUsdtVO;
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
@Service("GEntrustOrderRecordUsdtService")
public class GEntrustOrderRecordUsdtService{

	
	private  Logger logger = Logger.getLogger(GEntrustOrderRecordUsdtService.class);
	
	@Value("${SERVICE_BASE_PARAM}")
    private String SERVICE_BASE_PARAM;

	
	// 测试分页查询
    public static String testPage() {
		List<GEntrustOrderRecordUsdt> list = new ArrayList<GEntrustOrderRecordUsdt>();
		GEntrustOrderRecordUsdt g = new GEntrustOrderRecordUsdt();
		g.setOrder_id("1");
		g.setUid("1");
		g.setDeal_status(1);
		g.setFinished_amount(new BigDecimal(232));
		g.setCreate_time(new Timestamp(new Date().getTime()));
		g.setEntrust_order_id("1");
		g.setOrder_status(1);
		g.setEntrust_type(1);
		
		GEntrustOrderRecordUsdt g1 = new GEntrustOrderRecordUsdt();
		g1.setOrder_id("2");
		g1.setUid("2");
		g1.setDeal_status(2);
		g1.setFinished_amount(new BigDecimal(23432));
		g1.setCreate_time(new Timestamp(new Date().getTime()));
		g1.setEntrust_order_id("2");
		g1.setOrder_status(3);
		g1.setEntrust_type(2);
		list.add(g);
		list.add(g1);
		PageInfo pageInfo = new PageInfo(1, 1,1, list);
		return JSON.toJSONString(pageInfo);
	}

    // 测试查询一条记录
    public static String testOne() {
    	GEntrustOrderRecordUsdt g = new GEntrustOrderRecordUsdt();
		g.setOrder_id("1");
		g.setUid("1");
		g.setDeal_status(1);
		g.setFinished_amount(new BigDecimal(232));
		g.setCreate_time(new Timestamp(new Date().getTime()));
		g.setEntrust_order_id("1");
		g.setOrder_status(1);
		g.setEntrust_type(1);
		return JSON.toJSONString(g);
    }
    
    
    /**
     * 
     * @Title: selectPage
     * @Description: 分页查询
     * @param @param request
     * @param @param g_entrust_order_record_usdt_vo
     * @param @return
     * @param @throws Exception
     * @return PageInfo
     * @throws
     */
    public PageInfo selectPage(HttpServletRequest request,GEntrustOrderRecordUsdtVO g_entrust_order_record_usdt_vo) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("PSIZE", g_entrust_order_record_usdt_vo.getRows());
        map.put("BEGIN", (g_entrust_order_record_usdt_vo.getPage() - 1) * g_entrust_order_record_usdt_vo.getRows());
        
        if (null != g_entrust_order_record_usdt_vo.getOrder_id() && !StringUtils.isBlank(g_entrust_order_record_usdt_vo.getOrder_id())) {
        	if (StringUtil.isNumeric(g_entrust_order_record_usdt_vo.getOrder_id())) {
        		map.put("orderId", g_entrust_order_record_usdt_vo.getOrder_id());
        	}
        }
        if (null != g_entrust_order_record_usdt_vo.getUid() && !StringUtils.isBlank(g_entrust_order_record_usdt_vo.getUid())) {
        	if (StringUtil.isNumeric(g_entrust_order_record_usdt_vo.getUid())) {
        		map.put("uid", g_entrust_order_record_usdt_vo.getUid());
        	}
        }
        if (null != g_entrust_order_record_usdt_vo.getEntrust_type()) {
        	map.put("objectUid", g_entrust_order_record_usdt_vo.getEntrust_type());
        }
        if (null != g_entrust_order_record_usdt_vo.getOrder_status()) {
        	map.put("orderStatus", g_entrust_order_record_usdt_vo.getOrder_status());
        }
        if (null != g_entrust_order_record_usdt_vo.getDeal_status()) {
        	map.put("dealStatus", g_entrust_order_record_usdt_vo.getDeal_status());
        }
        
        Integer count = 0;
        // 查询总记录数
        try {
           /* String method = SERVICE_BASE_PARAM + "g_entrust_order_record_usdt_getPageCount";
            String json = SendRequestUtil.sendMapRequest(request, map, method);*/
        	String json = this.testPage();
        	if (null != json) {
        		PageInfo pageInfo = JSON.parseObject(json, PageInfo.class);
                count = pageInfo.getTotalCount();
                if (count == 0) {
                	return new PageInfo(g_entrust_order_record_usdt_vo.getRows(), g_entrust_order_record_usdt_vo.getPage(), count, new ArrayList<GEntrustOrderRecordUsdt>());
                }
        	}else {
            	return new PageInfo(g_entrust_order_record_usdt_vo.getRows(), g_entrust_order_record_usdt_vo.getPage(), count, new ArrayList<GEntrustOrderRecordUsdt>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[交易中心-委托历史订单记录-查询总记录条数]请求后台出错",e);
			return new PageInfo(g_entrust_order_record_usdt_vo.getRows(), g_entrust_order_record_usdt_vo.getPage(), count, new ArrayList<GEntrustOrderRecordUsdt>());
		}
        
        
        // 查询列表
        try {
			/*String method = SERVICE_BASE_PARAM + "g_entrust_order_record_usdt_getList";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
        	String json = this.testPage();
        	if (null != json) {
        		PageInfo pageInfo = JSON.parseObject(json, PageInfo.class);
                return pageInfo;
            }else {
            	return new PageInfo(g_entrust_order_record_usdt_vo.getRows(), g_entrust_order_record_usdt_vo.getPage(), 0, new ArrayList<GEntrustOrderRecordUsdt>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[交易中心-委托历史订单记录-查询所有记录]请求后台出错",e);
			return new PageInfo(g_entrust_order_record_usdt_vo.getRows(), g_entrust_order_record_usdt_vo.getPage(), 0, new ArrayList<GEntrustOrderRecordUsdt>());
		}
        
    }

    
    /**
     * 
     * @Title: get
     * @Description: 查询一条记录
     * @param @param request
     * @param @param entrust_order_id
     * @param @return
     * @param @throws Exception
     * @return GEntrustOrderRecordUsdt
     * @throws
     */
    public GEntrustOrderRecordUsdt get(HttpServletRequest request,String entrust_order_id) throws Exception {
    	try {
    		Map<String,Object> map = new HashMap<String, Object>();
    		map.put("entrustOrderId", entrust_order_id);
			/*String method = SERVICE_BASE_PARAM + "g_entrust_order_record_usdt_getOne";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
    		String json = this.testOne();
			if (null != json) {
				GEntrustOrderRecordUsdt gEntrustOrderRecordUsdt = JSON.parseObject(json, GEntrustOrderRecordUsdt.class);
				return gEntrustOrderRecordUsdt;
			}else {
				return new GEntrustOrderRecordUsdt();
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[交易中心-委托历史订单记录-查询一条记录]请求后台出错",e);
			return new GEntrustOrderRecordUsdt();
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
    /*public boolean delete(java.lang.String entrust_order_id) throws Exception {
        Integer result = g_entrust_order_record_usdt_dao.deleteById(entrust_order_id);
        return result > 0 ? true : false;
    }*/
    
    /**
	 * 获取所有数据
	 */
	/*public List<GEntrustOrderRecordUsdt> selectAll(GEntrustOrderRecordUsdtVO g_entrust_order_record_usdt_vo) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		return g_entrust_order_record_usdt_dao.selectAll(map);
	} */


}
