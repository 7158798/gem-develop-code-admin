package com.manage.biz.control;

import java.sql.Timestamp;
import com.manage.base.annotation.FormModel;
import com.manage.base.entity.PageInfo;
import com.manage.biz.entity.GSupplierInfo;
import com.manage.biz.service.GSupplierInfoService;
import com.manage.biz.vo.GSupplierInfoVO;

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
 * 商家信息表（g_supplier_info）
功能描述：存储商家统计数据信息。控制类
 */
@Controller
@RequestMapping(value = "${adminPath}/bus/g_supplier_info")
public class GSupplierInfoController{
	private static final Log log = LogFactory.getLog(GSupplierInfoController.class);

    @Resource(name = "GSupplierInfoService")
    private GSupplierInfoService g_supplier_info_service;

	/**
     * 去分页
     */
    @RequiresPermissions("bus:g_supplier_info:view")
    @RequestMapping(value = "toList")
    public String toList(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
    	return "modules/bus/g_supplier_infoList";
    }
    /**
     * 分页
     */
    @RequiresPermissions("bus:g_supplier_info:view")
    @RequestMapping(value = "list")
    @ResponseBody
    public Map<String, Object> list(HttpServletRequest request, HttpServletResponse response, Model model,
                       @FormModel("g_supplier_info_vo") GSupplierInfoVO g_supplier_info_vo) throws Exception {
        if (g_supplier_info_vo == null) {
            g_supplier_info_vo = new GSupplierInfoVO();
        }
        if (request.getParameter("page") != null) {
            g_supplier_info_vo.setPage(Integer.parseInt(request.getParameter("page")));
        }if (request.getParameter("rows") != null) {
            g_supplier_info_vo.setRows(Integer.parseInt(request.getParameter("rows")));
        }
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	PageInfo pageInfo = g_supplier_info_service.selectPage(request,g_supplier_info_vo);
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
    /*@RequiresPermissions("bus:g_supplier_info:add")
    @RequestMapping(value = "toAdd")
    public String toAdd(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
        return "modules/bus/g_supplier_infoAdd";
    }*/

    /**
     * 新增
     */
    /*@RequiresPermissions("bus:g_supplier_info:add")
    @RequestMapping(value = "add")
    @ResponseBody
    public Map<String, Object> add(HttpServletRequest request, HttpServletResponse response, Model model,
                      @FormModel("g_supplier_info") GSupplierInfo g_supplier_info) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = g_supplier_info_service.add(g_supplier_info);
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
    @RequiresPermissions("bus:g_supplier_info:update")
    @RequestMapping(value = "toUpdate")
    public String toUpdate(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam(name = "id") String uid) throws Exception {
        model.addAttribute("item", g_supplier_info_service.get(request,uid));
        return "modules/bus/g_supplier_infoUpdate";
    }

    /**
     * 修改
     */
    @RequiresPermissions("bus:g_supplier_info:update")
    @RequestMapping(value = "update")
    @ResponseBody
    public Map<String, Object> update(HttpServletRequest request, HttpServletResponse response, Model model,
                         @FormModel("g_supplier_info") GSupplierInfo g_supplier_info) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = g_supplier_info_service.update(request,g_supplier_info);
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
    }

	/**
     * 删除
     */
    /*@RequiresPermissions("bus:g_supplier_info:delete")
    @RequestMapping(value = "delete")
    @ResponseBody
    public Map<String, Object> delete(HttpServletRequest request, HttpServletResponse response, Model model,
                         java.lang.String uid) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = g_supplier_info_service.delete(uid);
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
    @RequiresPermissions("bus:g_supplier_info:view")
    @RequestMapping(value = "info")
    public String info(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam(name = "id") String uid) throws Exception {
        model.addAttribute("item", g_supplier_info_service.get(request,uid));
        return "modules/bus/g_supplier_infoInfo";
    }
}
