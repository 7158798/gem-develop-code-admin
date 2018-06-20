package com.manage.bus.control;

import java.sql.Timestamp;
import com.manage.base.annotation.FormModel;
import com.manage.base.entity.PageInfo;
import com.manage.bus.entity.GOtcOrderRecord;
import com.manage.bus.vo.GOtcOrderRecordVO;
import com.manage.bus.service.GOtcOrderRecordService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.HashMap;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 * OTC历史订单表（g_otc_order_record）控制类
 */
@Controller
@RequestMapping(value = "${adminPath}/bus/g_otc_order_record")
public class GOtcOrderRecordController{
	private static final Log log = LogFactory.getLog(GOtcOrderRecordController.class);

    @Resource(name = "GOtcOrderRecordService")
    private GOtcOrderRecordService g_otc_order_record_service;

	/**
     * 去分页
     */
    @RequiresPermissions("bus:g_otc_order_record:view")
    @RequestMapping(value = "toList")
    public String toList(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
    	return "modules/bus/g_otc_order_recordList";
    }
    /**
     * 分页
     */
    @RequiresPermissions("bus:g_otc_order_record:view")
    @RequestMapping(value = "list")
    @ResponseBody
    public Map<String, Object> list(HttpServletRequest request, HttpServletResponse response, Model model,
                       @FormModel("g_otc_order_record_vo") GOtcOrderRecordVO g_otc_order_record_vo) throws Exception {
        if (g_otc_order_record_vo == null) {
            g_otc_order_record_vo = new GOtcOrderRecordVO();
        }
        if (request.getParameter("page") != null) {
            g_otc_order_record_vo.setPage(Integer.parseInt(request.getParameter("page")));
        }if (request.getParameter("rows") != null) {
            g_otc_order_record_vo.setRows(Integer.parseInt(request.getParameter("rows")));
        }
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	PageInfo pageInfo = g_otc_order_record_service.selectPage(request,g_otc_order_record_vo);
	        jsonMap.put("total", pageInfo.getTotalCount());
	        jsonMap.put("pages", pageInfo.getTotalPageCount());
	        jsonMap.put("rows", pageInfo.getData());
        }catch (Exception e) {
        	log.error("系统异常",e);
		}
        return jsonMap;
    }

    /**
     * 去新增
     */
  /*  @RequiresPermissions("bus:g_otc_order_record:add")
    @RequestMapping(value = "toAdd")
    public String toAdd(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
        return "modules/bus/g_otc_order_recordAdd";
    }*/

    /**
     * 新增
     */
   /* @RequiresPermissions("bus:g_otc_order_record:add")
    @RequestMapping(value = "add")
    @ResponseBody
    public Map<String, Object> add(HttpServletRequest request, HttpServletResponse response, Model model,
                      @FormModel("g_otc_order_record") GOtcOrderRecord g_otc_order_record) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = g_otc_order_record_service.add(g_otc_order_record);
	        if (result) {
	            jsonMap.put("success", true);
	            jsonMap.put("msg", "操作成功");
	        } else {
	            jsonMap.put("success", false);
	            jsonMap.put("msg", "操作失败");
	        }
        }catch (Exception e) {
        	log.error("系统异常",e);
        	jsonMap.put("success", false);
            jsonMap.put("msg", "操作失败");
		}
        return jsonMap;
    }*/

    /**
     * 去修改
     */
   /* @RequiresPermissions("bus:g_otc_order_record:update")
    @RequestMapping(value = "toUpdate")
    public String toUpdate(HttpServletRequest request, HttpServletResponse response, Model model, java.lang.String entry_order_id) throws Exception {
        model.addAttribute("item", g_otc_order_record_service.get(entry_order_id));
        return "modules/bus/g_otc_order_recordUpdate";
    }*/

    /**
     * 修改
     */
    /*@RequiresPermissions("bus:g_otc_order_record:update")
    @RequestMapping(value = "update")
    @ResponseBody
    public Map<String, Object> update(HttpServletRequest request, HttpServletResponse response, Model model,
                         @FormModel("g_otc_order_record") GOtcOrderRecord g_otc_order_record) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = g_otc_order_record_service.update(g_otc_order_record);
	        if (result) {
	            jsonMap.put("success", true);
	            jsonMap.put("msg", "操作成功");
	        } else {
	            jsonMap.put("success", false);
	            jsonMap.put("msg", "操作失败");
	        }
        }catch (Exception e) {
        	log.error("系统异常",e);
        	jsonMap.put("success", false);
            jsonMap.put("msg", "操作失败");
		}
        return jsonMap;
    }*/

	/**
     * 删除
     */
   /* @RequiresPermissions("bus:g_otc_order_record:delete")
    @RequestMapping(value = "delete")
    @ResponseBody
    public Map<String, Object> delete(HttpServletRequest request, HttpServletResponse response, Model model,
                         java.lang.String entry_order_id) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = g_otc_order_record_service.delete(entry_order_id);
	        if (result) {
	            jsonMap.put("success", true);
	            jsonMap.put("msg", "操作成功");
	        } else {
	            jsonMap.put("success", false);
	            jsonMap.put("msg", "操作失败");
	        }
        }catch (Exception e) {
        	log.error("系统异常",e);
        	jsonMap.put("success", false);
            jsonMap.put("msg", "操作失败");
		}
        return jsonMap;
    }*/
    /**
     * 查看详情
     */
    @RequiresPermissions("bus:g_otc_order_record:view")
    @RequestMapping(value = "info")
    public String info(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam(name = "id") String entry_order_id) throws Exception {
        model.addAttribute("item", g_otc_order_record_service.get(request,entry_order_id));
        return "modules/bus/g_otc_order_recordInfo";
    }
}
