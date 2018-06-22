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
import com.manage.base.entity.PageInfo;
import com.manage.biz.entity.GOtcOrderRecord;
import com.manage.biz.vo.GOtcOrderRecordVO;
import com.manage.util.StringUtil;


/**
 * 
 * @Project：gme-admin   
 * @Class：GOtcOrderRecordService   
 * @Description 类描述：otc历史订单   
 * @Author：zhou   
 * @Date：2018年6月19日 下午12:52:27   
 * @version V1.0
 */
@Service("GOtcOrderRecordService")
public class GOtcOrderRecordService{

    private Logger logger = Logger.getLogger(GOtcOrderRecordService.class);
	
   	@Value("${SERVICE_BASE_PARAM}")
    private String SERVICE_BASE_PARAM;

 // 测试分页查询
    public static String testPage() {
		List<GOtcOrderRecord> list = new ArrayList<GOtcOrderRecord>();
		GOtcOrderRecord g = new GOtcOrderRecord();
		g.setUid("1");
		g.setOrder_id("1");
		g.setOrder_type(1);
		g.setCurrency_id("1");
		g.setOrder_status(1);
		g.setCurrency_symbol("USDT");
		g.setOrder_amount(new BigDecimal(100));
		g.setOrder_price(new BigDecimal(22332));
		
		GOtcOrderRecord g1 = new GOtcOrderRecord();
		g1.setUid("2");
		g1.setOrder_id("2");
		g1.setCurrency_symbol("EOS");
		g1.setOrder_type(2);
		g1.setCurrency_id("2");
		g1.setOrder_status(3);
		g1.setOrder_amount(new BigDecimal(300));
		g1.setOrder_price(new BigDecimal(22));
		list.add(g);
		list.add(g1);

		PageInfo pageInfo = new PageInfo(1, 1,1, list);
		return JSON.toJSONString(pageInfo);
	}

    // 测试查询一条记录
    public static String testOne() {
    	GOtcOrderRecord g = new GOtcOrderRecord();
		g.setUid("1");
		g.setOrder_id("1");
		g.setCurrency_symbol("USDT");
		g.setOrder_type(1);
		g.setCurrency_id("1");
		g.setOrder_status(1);
		return JSON.toJSONString(g);
    }
   	
   	
   	/**
   	 * 
   	 * @Title: selectPage
   	 * @Description: 分页查询
   	 * @param @param request
   	 * @param @param g_otc_order_record_vo
   	 * @param @return
   	 * @param @throws Exception
   	 * @return PageInfo
   	 * @throws
   	 */
    public PageInfo selectPage(HttpServletRequest request,GOtcOrderRecordVO g_otc_order_record_vo) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("PSIZE", g_otc_order_record_vo.getRows());
        map.put("BEGIN", (g_otc_order_record_vo.getPage() - 1) * g_otc_order_record_vo.getRows());
        
        if (null != g_otc_order_record_vo.getOrder_id() && !StringUtils.isBlank(g_otc_order_record_vo.getOrder_id())) {
        	if (StringUtil.isNumeric(g_otc_order_record_vo.getOrder_id())) {
        		map.put("orderId", g_otc_order_record_vo.getOrder_id());
        	}
        }
        if (null != g_otc_order_record_vo.getUid() && !StringUtils.isBlank(g_otc_order_record_vo.getUid())) {
        	if (StringUtil.isNumeric(g_otc_order_record_vo.getUid())) {
        		map.put("uid", g_otc_order_record_vo.getUid());
        	}
        }
        if (null != g_otc_order_record_vo.getObject_uid() && !StringUtils.isBlank(g_otc_order_record_vo.getObject_uid())) {
        	if (StringUtil.isNumeric(g_otc_order_record_vo.getObject_uid())) {
        		map.put("objectUid", g_otc_order_record_vo.getUid());
        	}
        }
        if (null != g_otc_order_record_vo.getOrder_status()) {
        	map.put("orderStatus", g_otc_order_record_vo.getOrder_status());
        }
        if (null != g_otc_order_record_vo.getOrder_type()) {
        	map.put("orderType", g_otc_order_record_vo.getOrder_type());
        }
        
        
        Integer count = 0;
        // 查询总记录数
        try {
           /* String method = SERVICE_BASE_PARAM + "g_otc_order_record_getPageCount";
            String json = SendRequestUtil.sendMapRequest(request, map, method);*/
        	String json = this.testPage();
        	if (null != json) {
        		PageInfo pageInfo = JSON.parseObject(json, PageInfo.class);
                count = pageInfo.getTotalCount();
                if (count == 0) {
                	return new PageInfo(g_otc_order_record_vo.getRows(), g_otc_order_record_vo.getPage(), count, new ArrayList<GOtcOrderRecord>());
                }
        	}else {
            	return new PageInfo(g_otc_order_record_vo.getRows(), g_otc_order_record_vo.getPage(), count, new ArrayList<GOtcOrderRecord>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[交易中心-otc历史订单记录-查询总记录条数]请求后台出错",e);
			return new PageInfo(g_otc_order_record_vo.getRows(), g_otc_order_record_vo.getPage(), count, new ArrayList<GOtcOrderRecord>());
		}
        
        
        // 查询列表
        try {
			/*String method = SERVICE_BASE_PARAM + "g_otc_order_record_getList";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
        	String json = this.testPage();
        	if (null != json) {
        		PageInfo pageInfo = JSON.parseObject(json, PageInfo.class);
                return pageInfo;
            }else {
            	return new PageInfo(g_otc_order_record_vo.getRows(), g_otc_order_record_vo.getPage(), 0, new ArrayList<GOtcOrderRecord>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[交易中心-otc历史订单记录-查询所有记录]请求后台出错",e);
			return new PageInfo(g_otc_order_record_vo.getRows(), g_otc_order_record_vo.getPage(), 0, new ArrayList<GOtcOrderRecord>());
		}
    }

    
    /**
     * @Title: get
     * @Description: 查询一条记录
     * @param @param request
     * @param @param entry_order_id
     * @param @return
     * @param @throws Exception
     * @return GOtcOrderRecord
     * @throws
     */
    public GOtcOrderRecord get(HttpServletRequest request,String entry_order_id) throws Exception {
    	try {
    		Map<String,Object> map = new HashMap<String, Object>();
    		map.put("entryOrderId", entry_order_id);
			/*String method = SERVICE_BASE_PARAM + "g_otc_order_record_getOne";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
    		String json = this.testOne();
			if (null != json) {
				GOtcOrderRecord gOtcOrderRecord = JSON.parseObject(json, GOtcOrderRecord.class);
				return gOtcOrderRecord;
			}else {
				return new GOtcOrderRecord();
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[交易中心-otc历史订单记录-查询一条记录]请求后台出错",e);
			return new GOtcOrderRecord();
		}
    }

    /**
     * 新增
     */
    /*public boolean add(GOtcOrderRecord g_otc_order_record) throws Exception {
        Integer result = g_otc_order_record_dao.add(g_otc_order_record);
        return result > 0 ? true : false;
    }*/
    
    /**
     * 修改
     */
    /*public boolean update(GOtcOrderRecord g_otc_order_record) throws Exception {
        Integer result = g_otc_order_record_dao.update(g_otc_order_record);
        return result > 0 ? true : false;
    }*/
    
	 /**
     * 删除
     */
    /*public boolean delete(java.lang.String entry_order_id) throws Exception {
        Integer result = g_otc_order_record_dao.deleteById(entry_order_id);
        return result > 0 ? true : false;
    }*/
    
    /**
	 * 获取所有数据
	 */
	/*public List<GOtcOrderRecord> selectAll(GOtcOrderRecordVO g_otc_order_record_vo) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		return g_otc_order_record_dao.selectAll(map);
	} */


}
