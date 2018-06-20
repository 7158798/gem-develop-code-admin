package com.manage.bus.service;

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
import com.manage.bus.dao.GWorkOrderDAO;
import com.manage.bus.entity.GCurrency;
import com.manage.bus.entity.GCurrencyData;
import com.manage.bus.entity.GWorkOrder;
import com.manage.bus.entity.GWorkOrderImage;
import com.manage.bus.vo.GWorkOrderVO;
import com.manage.util.StringUtil;


/**
 * 
 * @Project：gme-admin   
 * @Class：GWorkOrderService   
 * @Description 类描述：工单信息   
 * @Author：zhou   
 * @Date：2018年6月19日 下午9:36:10   
 * @version V1.0
 */
@Service("GWorkOrderService")
public class GWorkOrderService{

	private  Logger logger = Logger.getLogger(GWorkOrderService.class);
	
    
    @Value("${SERVICE_BASE_PARAM}")
    private String SERVICE_BASE_PARAM;
    
    
 // 测试分页查询
    public static String testPage() {
		List<GWorkOrder> list = new ArrayList<GWorkOrder>();
		GWorkOrder g = new GWorkOrder();
		g.setCurrency_id("1");
		g.setAccount_id("1");
		g.setBiz_id("1");
		g.setFinished_time(new Timestamp(new Date().getTime()));
		g.setName("aaaa");
		g.setPhone_code("124543223");
		g.setSubject("测试工单1");
		g.setWork_status(1);
		g.setWork_content("测试工单内容1");
		g.setWork_type(1);
		
		GWorkOrder g1 = new GWorkOrder();
		g1.setCurrency_id("2");
		g1.setAccount_id("2");
		g1.setBiz_id("2");
		g1.setFinished_time(new Timestamp(new Date().getTime()));
		g1.setName("aaaaBBBB");
		g1.setPhone_code("8546766");
		g1.setSubject("测试工单2");
		g1.setWork_status(3);
		g1.setWork_content("测试工单内容2");
		g1.setWork_type(4);
		
		list.add(g);
		list.add(g1);
		
		PageInfo pageInfo = new PageInfo(1, 1,1, list);
		return JSON.toJSONString(pageInfo);
	}
    
    // 测试查询一条记录
    public static String testOne() {
    	GWorkOrderImage g = new GWorkOrderImage();
		g.setCurrency_id("1");
		g.setAccount_id("1");
		g.setBiz_id("1");
		g.setFinished_time(new Timestamp(new Date().getTime()));
		g.setName("aaaa");
		g.setPhone_code("124543223");
		g.setSubject("测试工单1");
		g.setWork_status(1);
		g.setWork_content("测试工单内容1");
		g.setWork_type(4);
		g.setWork_img("http://img.zcool.cn/community/010a1b554c01d1000001bf72a68b37.jpg@1280w_1l_2o_100sh.png;https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1528956814406&di=811d73ef65bc0b7462765d7b079243de&imgtype=0&src=http%3A%2F%2Fuploads.5068.com%2Fallimg%2F151028%2F57-15102Q33H7.jpg;http://img.zcool.cn/community/010f87596f13e6a8012193a363df45.jpg@1280w_1l_2o_100sh.jpg");
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
     * @param @param g_work_order_vo
     * @param @return
     * @param @throws Exception
     * @return PageInfo
     * @throws
     */
    public PageInfo selectPage(HttpServletRequest request,GWorkOrderVO g_work_order_vo) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("PSIZE", g_work_order_vo.getRows());
        map.put("BEGIN", (g_work_order_vo.getPage() - 1) * g_work_order_vo.getRows());
        
        if (null != g_work_order_vo.getBiz_id() && !StringUtils.isBlank(g_work_order_vo.getBiz_id())) {
        	if (StringUtil.isNumeric(g_work_order_vo.getBiz_id())) {
        		map.put("bizId", g_work_order_vo.getBiz_id());
        	}
        }
        if (null != g_work_order_vo.getAccount_id() && !StringUtils.isBlank(g_work_order_vo.getAccount_id())) {
        	if (StringUtil.isNumeric(g_work_order_vo.getAccount_id())) {
        		map.put("accountId", g_work_order_vo.getAccount_id());
        	}
        }
        if (null != g_work_order_vo.getPhone_code() && !StringUtils.isBlank(g_work_order_vo.getPhone_code())) {
        	if (StringUtil.isNumeric(g_work_order_vo.getPhone_code())) {
        		map.put("phoneCode", g_work_order_vo.getPhone_code());
        	}
        }
        if (null != g_work_order_vo.getWork_status()) {
        	map.put("workStatus", g_work_order_vo.getWork_status());
        }
        if (null != g_work_order_vo.getWork_type()) {
        	map.put("workType", g_work_order_vo.getWork_type());
        }
        
        
        Integer count = 0;
        // 查询总记录数
        try {
           /* String method = SERVICE_BASE_PARAM + "g_work_order_getPageCount";
            String json = SendRequestUtil.sendMapRequest(request, map, method);*/
        	String json = this.testPage();
        	if (null != json) {
        		PageInfo pageInfo = JSON.parseObject(json, PageInfo.class);
                count = pageInfo.getTotalCount();
                if (count == 0) {
                	return new PageInfo(g_work_order_vo.getRows(), g_work_order_vo.getPage(), count, new ArrayList<GWorkOrder>());
                }
        	}else {
            	return new PageInfo(g_work_order_vo.getRows(), g_work_order_vo.getPage(), count, new ArrayList<GWorkOrder>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[运营管理-工单管理-查询记录条数]请求后台出错",e);
			return new PageInfo(g_work_order_vo.getRows(), g_work_order_vo.getPage(), count, new ArrayList<GWorkOrder>());
		}
        
        
        // 查询列表
        try {
			/*String method = SERVICE_BASE_PARAM + "g_work_order_getList";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
        	String json = this.testPage();
        	if (null != json) {
        		PageInfo pageInfo = JSON.parseObject(json, PageInfo.class);
                return pageInfo;
            }else {
            	return new PageInfo(g_work_order_vo.getRows(), g_work_order_vo.getPage(), 0, new ArrayList<GWorkOrder>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[运营管理-工单管理-查询所有记录]请求后台出错",e);
			return new PageInfo(g_work_order_vo.getRows(), g_work_order_vo.getPage(), 0, new ArrayList<GWorkOrder>());
		}
    }

    
    /**
     * 
     * @Title: get
     * @Description: 查询一条记录
     * @param @param request
     * @param @param subject_id
     * @param @return
     * @param @throws Exception
     * @return GWorkOrder
     * @throws
     */
    public GWorkOrder get(HttpServletRequest request,String subject_id) throws Exception {
    	try {
    		Map<String,Object> map = new HashMap<String, Object>();
    		map.put("subjectId", subject_id);
			/*String method = SERVICE_BASE_PARAM + "g_work_order_getOne";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
    		String json = this.testOne();
			if (null != json) {
				GWorkOrderImage gWorkOrderImage = JSON.parseObject(json, GWorkOrderImage.class);
				return gWorkOrderImage;
			}else {
				return new GWorkOrderImage();
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[运营管理-工单管理-查询一条记录]请求后台出错",e);
			return new GWorkOrderImage();
		}
    }

    /**
     * 新增
     */
    /*public boolean add(GWorkOrder g_work_order) throws Exception {
        Integer result = g_work_order_dao.add(g_work_order);
        return result > 0 ? true : false;
    }*/

    
    /**
     * 
     * @Title: update
     * @Description: 修改一条数据
     * @param @param g_work_order
     * @param @return
     * @param @throws Exception
     * @return boolean
     * @throws
     */
    public boolean update(HttpServletRequest request,GWorkOrder g_work_order) throws Exception {
    	try {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("GWorkOrder", g_work_order);
			/*String method = SERVICE_BASE_PARAM + "g_work_order_update";
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
			logger.error("[运营管理-工单管理-修改一条记录]请求后台出错",e);
			return false;
		}
    }
    
	 /**
     * 删除
     */
    /*public boolean delete(java.lang.String subject_id) throws Exception {
        Integer result = g_work_order_dao.deleteById(subject_id);
        return result > 0 ? true : false;
    }*/
    
    /**
	 * 获取所有数据
	 */
	/*public List<GWorkOrder> selectAll(GWorkOrderVO g_work_order_vo) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		return g_work_order_dao.selectAll(map);
	} */


}
