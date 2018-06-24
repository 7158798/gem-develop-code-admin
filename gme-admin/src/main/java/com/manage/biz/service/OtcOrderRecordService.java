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
import com.manage.biz.entity.OtcOrderRecord;
import com.manage.biz.vo.OtcOrderRecordVO;
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
@Service("OtcOrderRecordService")
public class OtcOrderRecordService{

    private Logger logger = Logger.getLogger(OtcOrderRecordService.class);
	
   	@Value("${SERVICE_BASE_PARAM}")
    private String SERVICE_BASE_PARAM;

 // 测试分页查询
    public static String testPage() {
		List<OtcOrderRecord> list = new ArrayList<OtcOrderRecord>();
		OtcOrderRecord g = new OtcOrderRecord();
		g.setUid("1");
		g.setOrderId("1");
		g.setOrderType(1);
		g.setCurrencyId("1");
		g.setOrderStatus(1);
		g.setCurrencySymbol("USDT");
		g.setOrderAmount(new BigDecimal(100));
		g.setOrderPrice(new BigDecimal(22332));
		
		OtcOrderRecord g1 = new OtcOrderRecord();
		g1.setUid("2");
		g1.setOrderId("2");
		g1.setCurrencySymbol("EOS");
		g1.setOrderType(2);
		g1.setCurrencyId("2");
		g1.setOrderStatus(3);
		g1.setOrderAmount(new BigDecimal(300));
		g1.setOrderPrice(new BigDecimal(22));
		list.add(g);
		list.add(g1);

		PageInfo pageInfo = new PageInfo(1, 1,1, list);
		return JSON.toJSONString(pageInfo);
	}

    // 测试查询一条记录
    public static String testOne() {
		OtcOrderRecord g = new OtcOrderRecord();
		g.setUid("1");
		g.setOrderId("1");
		g.setOrderType(1);
		g.setCurrencyId("1");
		g.setOrderStatus(1);
		g.setCurrencySymbol("USDT");
		g.setOrderAmount(new BigDecimal(100));
		g.setOrderPrice(new BigDecimal(22332));
		return JSON.toJSONString(g);
    }
   	
   	
   	/**
   	 * 
   	 * @Title: selectPage
   	 * @Description: 分页查询
   	 * @param @param request
   	 * @param @param otcOrderRecordVO
   	 * @param @return
   	 * @param @throws Exception
   	 * @return PageInfo
   	 * @throws
   	 */
    public PageInfo selectPage(HttpServletRequest request,OtcOrderRecordVO otcOrderRecordVO) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("PSIZE", otcOrderRecordVO.getRows());
        map.put("BEGIN", (otcOrderRecordVO.getPage() - 1) * otcOrderRecordVO.getRows());
        
        if (null != otcOrderRecordVO.getOrderId() && !StringUtils.isBlank(otcOrderRecordVO.getOrderId())) {
        	if (StringUtil.isNumeric(otcOrderRecordVO.getOrderId())) {
        		map.put("orderId", otcOrderRecordVO.getOrderId());
        	}
        }
        if (null != otcOrderRecordVO.getUid() && !StringUtils.isBlank(otcOrderRecordVO.getUid())) {
        	if (StringUtil.isNumeric(otcOrderRecordVO.getUid())) {
        		map.put("uid", otcOrderRecordVO.getUid());
        	}
        }
        if (null != otcOrderRecordVO.getObjectUid() && !StringUtils.isBlank(otcOrderRecordVO.getObjectUid())) {
        	if (StringUtil.isNumeric(otcOrderRecordVO.getObjectUid())) {
        		map.put("objectUid", otcOrderRecordVO.getObjectUid());
        	}
        }
        if (null != otcOrderRecordVO.getOrderStatus()) {
        	map.put("orderStatus", otcOrderRecordVO.getOrderStatus());
        }
        if (null != otcOrderRecordVO.getOrderType()) {
        	map.put("orderType", otcOrderRecordVO.getOrderType());
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
                	return new PageInfo(otcOrderRecordVO.getRows(), otcOrderRecordVO.getPage(), count, new ArrayList<OtcOrderRecord>());
                }
        	}else {
            	return new PageInfo(otcOrderRecordVO.getRows(), otcOrderRecordVO.getPage(), count, new ArrayList<OtcOrderRecord>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[交易中心-otc历史订单记录-查询总记录条数]请求后台出错",e);
			return new PageInfo(otcOrderRecordVO.getRows(), otcOrderRecordVO.getPage(), count, new ArrayList<OtcOrderRecord>());
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
            	return new PageInfo(otcOrderRecordVO.getRows(), otcOrderRecordVO.getPage(), 0, new ArrayList<OtcOrderRecord>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[交易中心-otc历史订单记录-查询所有记录]请求后台出错",e);
			return new PageInfo(otcOrderRecordVO.getRows(), otcOrderRecordVO.getPage(), 0, new ArrayList<OtcOrderRecord>());
		}
    }

    
    /**
     * @Title: get
     * @Description: 查询一条记录
     * @param @param request
     * @param @param entryOrderId
     * @param @return
     * @param @throws Exception
     * @return GOtcOrderRecord
     * @throws
     */
    public OtcOrderRecord get(HttpServletRequest request,String entryOrderId) throws Exception {
    	try {
    		Map<String,Object> map = new HashMap<String, Object>();
    		map.put("entryOrderId", entryOrderId);
			/*String method = SERVICE_BASE_PARAM + "g_otc_order_record_getOne";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
    		String json = this.testOne();
			if (null != json) {
				OtcOrderRecord gOtcOrderRecord = JSON.parseObject(json, OtcOrderRecord.class);
				return gOtcOrderRecord;
			}else {
				return new OtcOrderRecord();
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[交易中心-otc历史订单记录-查询一条记录]请求后台出错",e);
			return new OtcOrderRecord();
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
    /*public boolean delete(java.lang.String entryOrderId) throws Exception {
        Integer result = g_otc_order_record_dao.deleteById(entryOrderId);
        return result > 0 ? true : false;
    }*/
    
    /**
	 * 获取所有数据
	 */
	/*public List<GOtcOrderRecord> selectAll(GOtcOrderRecordVO otcOrderRecordVO) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		return g_otc_order_record_dao.selectAll(map);
	} */


}
