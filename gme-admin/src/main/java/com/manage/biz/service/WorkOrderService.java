package com.manage.biz.service;

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
import com.manage.biz.entity.WorkOrder;
import com.manage.biz.entity.WorkOrderImage;
import com.manage.biz.vo.WorkOrderVO;
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
@Service("WorkOrderService")
public class WorkOrderService{

	private  Logger logger = Logger.getLogger(WorkOrderService.class);
	
    
    
    
    
    
 // 测试分页查询
    public static String testPage() {
		List<WorkOrder> list = new ArrayList<WorkOrder>();
		WorkOrder g = new WorkOrder();
		g.setCurrencyId("1");
		g.setAccountId("1");
		g.setBizId("1");
		g.setFinishedTime(new Timestamp(new Date().getTime()));
		g.setName("aaaa");
		g.setPhoneCode("124543223");
		g.setSubject("测试工单1");
		g.setWorkStatus(1);
		g.setWorkContent("测试工单内容1");
		g.setWorkType(1);
		
		WorkOrder g1 = new WorkOrder();
		g1.setCurrencyId("2");
		g1.setAccountId("2");
		g1.setBizId("2");
		g1.setFinishedTime(new Timestamp(new Date().getTime()));
		g1.setName("aaaaBBBB");
		g1.setPhoneCode("8546766");
		g1.setSubject("测试工单2");
		g1.setWorkStatus(3);
		g1.setWorkContent("测试工单内容2");
		g1.setWorkType(4);
		
		list.add(g);
		list.add(g1);
		
		PageBean pageInfo = new PageBean(1, 1,1, list);
		return JSON.toJSONString(pageInfo);
	}
    
    // 测试查询一条记录
    public static String testOne() {
    	WorkOrder g = new WorkOrder();
		g.setCurrencyId("1");
		g.setAccountId("1");
		g.setBizId("1");
		g.setFinishedTime(new Timestamp(new Date().getTime()));
		g.setName("aaaa");
		g.setPhoneCode("124543223");
		g.setSubject("测试工单1");
		g.setWorkStatus(1);
		g.setWorkContent("测试工单内容1");
		g.setWorkType(1);
		g.setWorkImg("http://img.zcool.cn/community/010a1b554c01d1000001bf72a68b37.jpg@1280w_1l_2o_100sh.png;https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1528956814406&di=811d73ef65bc0b7462765d7b079243de&imgtype=0&src=http%3A%2F%2Fuploads.5068.com%2Fallimg%2F151028%2F57-15102Q33H7.jpg;http://img.zcool.cn/community/010f87596f13e6a8012193a363df45.jpg@1280w_1l_2o_100sh.jpg");
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
     * @param @param workOrderVO
     * @param @return
     * @param @throws Exception
     * @return PageInfo
     * @throws
     */
    public PageBean selectPage(HttpServletRequest request,WorkOrderVO workOrderVO) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("PSIZE", workOrderVO.getRows());
        map.put("BEGIN", (workOrderVO.getPage() - 1) * workOrderVO.getRows());
        
        if (null != workOrderVO.getBizId() && !StringUtils.isBlank(workOrderVO.getBizId())) {
        	if (StringUtil.isNumeric(workOrderVO.getBizId())) {
        		map.put("bizId", workOrderVO.getBizId());
        	}
        }
        if (null != workOrderVO.getAccountId() && !StringUtils.isBlank(workOrderVO.getAccountId())) {
        	if (StringUtil.isNumeric(workOrderVO.getAccountId())) {
        		map.put("accountId", workOrderVO.getAccountId());
        	}
        }
        if (null != workOrderVO.getPhoneCode() && !StringUtils.isBlank(workOrderVO.getPhoneCode())) {
        	if (StringUtil.isNumeric(workOrderVO.getPhoneCode())) {
        		map.put("phoneCode", workOrderVO.getPhoneCode());
        	}
        }
        if (null != workOrderVO.getWorkStatus()) {
        	map.put("workStatus", workOrderVO.getWorkStatus());
        }
        if (null != workOrderVO.getWorkType()) {
        	map.put("workType", workOrderVO.getWorkType());
        }
        
        
        Integer count = 0;
        // 查询总记录数
        try {
           /* String method = "workOrder_getPageCount";
            String json = SendRequestUtil.sendMapRequest(request, map, method);*/
        	String json = this.testPage();
        	if (null != json) {
        		PageBean pageInfo = JSON.parseObject(json, PageBean.class);
                count = pageInfo.getTotalCount();
                if (count == 0) {
                	return new PageBean(workOrderVO.getRows(), workOrderVO.getPage(), count, new ArrayList<WorkOrder>());
                }
        	}else {
            	return new PageBean(workOrderVO.getRows(), workOrderVO.getPage(), count, new ArrayList<WorkOrder>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[运营管理-工单管理-查询记录条数]请求后台出错",e);
			return new PageBean(workOrderVO.getRows(), workOrderVO.getPage(), count, new ArrayList<WorkOrder>());
		}
        
        
        // 查询列表
        try {
			/*String method = "workOrder_getList";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
        	String json = this.testPage();
        	if (null != json) {
        		PageBean pageInfo = JSON.parseObject(json, PageBean.class);
                return pageInfo;
            }else {
            	return new PageBean(workOrderVO.getRows(), workOrderVO.getPage(), 0, new ArrayList<WorkOrder>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[运营管理-工单管理-查询所有记录]请求后台出错",e);
			return new PageBean(workOrderVO.getRows(), workOrderVO.getPage(), 0, new ArrayList<WorkOrder>());
		}
    }

    
    /**
     * 
     * @Title: get
     * @Description: 查询一条记录
     * @param @param request
     * @param @param subjectId
     * @param @return
     * @param @throws Exception
     * @return GWorkOrder
     * @throws
     */
    public WorkOrder get(HttpServletRequest request,String subjectId) throws Exception {
    	try {
    		Map<String,Object> map = new HashMap<String, Object>();
    		map.put("subjectId", subjectId);
			/*String method = "workOrder_getOne";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
    		String json = this.testOne();
			if (null != json) {
				WorkOrderImage gWorkOrderImage = JSON.parseObject(json, WorkOrderImage.class);
				return gWorkOrderImage;
			}else {
				return new WorkOrderImage();
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[运营管理-工单管理-查询一条记录]请求后台出错",e);
			return new WorkOrderImage();
		}
    }

    /**
     * 新增
     */
    /*public boolean add(GWorkOrder workOrder) throws Exception {
        Integer result = workOrder_dao.add(workOrder);
        return result > 0 ? true : false;
    }*/

    
    /**
     * 
     * @Title: update
     * @Description: 修改一条数据
     * @param @param workOrder
     * @param @return
     * @param @throws Exception
     * @return boolean
     * @throws
     */
    public boolean update(HttpServletRequest request,WorkOrder workOrder) throws Exception {
    	try {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("GWorkOrder", workOrder);
			/*String method = "workOrder_update";
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
    /*public boolean delete(java.lang.String subjectId) throws Exception {
        Integer result = workOrder_dao.deleteById(subjectId);
        return result > 0 ? true : false;
    }*/
    
    /**
	 * 获取所有数据
	 */
	/*public List<GWorkOrder> selectAll(GWorkOrderVO workOrderVO) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		return workOrder_dao.selectAll(map);
	} */


}
