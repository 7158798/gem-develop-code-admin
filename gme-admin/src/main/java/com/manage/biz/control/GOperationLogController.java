package com.manage.biz.control;

import java.sql.Timestamp;
import com.manage.base.annotation.FormModel;
import com.manage.base.entity.PageInfo;
import com.manage.biz.entity.GOperationLog;
import com.manage.biz.service.GOperationLogService;
import com.manage.biz.vo.GOperationLogVO;

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
 * 操作日志表（g_operation_log）
功能描述：存储用户业务操作日志信息。
控制类
 */
@Controller
@RequestMapping(value = "${adminPath}/bus/g_operation_log")
public class GOperationLogController{
	private static final Log log = LogFactory.getLog(GOperationLogController.class);

    @Resource(name = "GOperationLogService")
    private GOperationLogService g_operation_log_service;

	/**
     * 去分页
     */
    @RequiresPermissions("bus:g_operation_log:view")
    @RequestMapping(value = "toList")
    public String toList(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
    	return "modules/bus/g_operation_logList";
    }
    /**
     * 分页
     */
    @RequiresPermissions("bus:g_operation_log:view")
    @RequestMapping(value = "list")
    @ResponseBody
    public Map<String, Object> list(HttpServletRequest request, HttpServletResponse response, Model model,
                       @FormModel("g_operation_log_vo") GOperationLogVO g_operation_log_vo) throws Exception {
        if (g_operation_log_vo == null) {
            g_operation_log_vo = new GOperationLogVO();
        }
        if (request.getParameter("page") != null) {
            g_operation_log_vo.setPage(Integer.parseInt(request.getParameter("page")));
        }if (request.getParameter("rows") != null) {
            g_operation_log_vo.setRows(Integer.parseInt(request.getParameter("rows")));
        }
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	PageInfo pageInfo = g_operation_log_service.selectPage(request,g_operation_log_vo);
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
    /*@RequiresPermissions("bus:g_operation_log:add")
    @RequestMapping(value = "toAdd")
    public String toAdd(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
        return "modules/bus/g_operation_logAdd";
    }*/

    /**
     * 新增
     */
    /*@RequiresPermissions("bus:g_operation_log:add")
    @RequestMapping(value = "add")
    @ResponseBody
    public Map<String, Object> add(HttpServletRequest request, HttpServletResponse response, Model model,
                      @FormModel("g_operation_log") GOperationLog g_operation_log) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = g_operation_log_service.add(g_operation_log);
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
    /*@RequiresPermissions("bus:g_operation_log:update")
    @RequestMapping(value = "toUpdate")
    public String toUpdate(HttpServletRequest request, HttpServletResponse response, Model model, java.lang.String id) throws Exception {
        model.addAttribute("item", g_operation_log_service.get(id));
        return "modules/bus/g_operation_logUpdate";
    }*/

    /**
     * 修改
     */
    /*@RequiresPermissions("bus:g_operation_log:update")
    @RequestMapping(value = "update")
    @ResponseBody
    public Map<String, Object> update(HttpServletRequest request, HttpServletResponse response, Model model,
                         @FormModel("g_operation_log") GOperationLog g_operation_log) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = g_operation_log_service.update(g_operation_log);
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
    /*@RequiresPermissions("bus:g_operation_log:delete")
    @RequestMapping(value = "delete")
    @ResponseBody
    public Map<String, Object> delete(HttpServletRequest request, HttpServletResponse response, Model model,
                         java.lang.String id) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = g_operation_log_service.delete(id);
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
    @RequiresPermissions("bus:g_operation_log:view")
    @RequestMapping(value = "info")
    public String info(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam(name = "id") String id) throws Exception {
        model.addAttribute("item", g_operation_log_service.get(request,id));
        return "modules/bus/g_operation_logInfo";
    }
}
