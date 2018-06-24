package com.manage.biz.control;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.manage.base.annotation.FormModel;
import com.manage.base.entity.PageInfo;
import com.manage.biz.entity.SupplierInfo;
import com.manage.biz.service.SupplierInfoService;
import com.manage.biz.vo.SupplierInfoVO;
/**
 * 商家信息表（supplierInfo）
功能描述：存储商家统计数据信息。控制类
 */
@Controller
@RequestMapping(value = "${adminPath}/biz/supplierInfo")
public class SupplierInfoController{
	private static final Log log = LogFactory.getLog(SupplierInfoController.class);

    @Resource(name = "SupplierInfoService")
    private SupplierInfoService supplierInfoService;

	/**
     * 去分页
     */
    @RequiresPermissions("biz:supplierInfo:view")
    @RequestMapping(value = "toList")
    public String toList(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
    	return "modules/biz/supplierInfoList";
    }
    /**
     * 分页
     */
    @RequiresPermissions("biz:supplierInfo:view")
    @RequestMapping(value = "list")
    @ResponseBody
    public Map<String, Object> list(HttpServletRequest request, HttpServletResponse response, Model model,
                       @FormModel("supplierInfoVO") SupplierInfoVO supplierInfoVO) throws Exception {
        if (supplierInfoVO == null) {
            supplierInfoVO = new SupplierInfoVO();
        }
        if (request.getParameter("page") != null) {
            supplierInfoVO.setPage(Integer.parseInt(request.getParameter("page")));
        }if (request.getParameter("rows") != null) {
            supplierInfoVO.setRows(Integer.parseInt(request.getParameter("rows")));
        }
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	PageInfo pageInfo = supplierInfoService.selectPage(request,supplierInfoVO);
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
    /*@RequiresPermissions("biz:supplierInfo:add")
    @RequestMapping(value = "toAdd")
    public String toAdd(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
        return "modules/biz/supplierInfoAdd";
    }*/

    /**
     * 新增
     */
    /*@RequiresPermissions("biz:supplierInfo:add")
    @RequestMapping(value = "add")
    @ResponseBody
    public Map<String, Object> add(HttpServletRequest request, HttpServletResponse response, Model model,
                      @FormModel("supplierInfo") GSupplierInfo supplierInfo) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = supplierInfoService.add(supplierInfo);
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
    @RequiresPermissions("biz:supplierInfo:update")
    @RequestMapping(value = "toUpdate")
    public String toUpdate(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam(name = "id") String uid) throws Exception {
        model.addAttribute("item", supplierInfoService.get(request,uid));
        return "modules/biz/supplierInfoUpdate";
    }

    /**
     * 修改
     */
    @RequiresPermissions("biz:supplierInfo:update")
    @RequestMapping(value = "update")
    @ResponseBody
    public Map<String, Object> update(HttpServletRequest request, HttpServletResponse response, Model model,
                         @FormModel("supplierInfo") SupplierInfo supplierInfo) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = supplierInfoService.update(request,supplierInfo);
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
    /*@RequiresPermissions("biz:supplierInfo:delete")
    @RequestMapping(value = "delete")
    @ResponseBody
    public Map<String, Object> delete(HttpServletRequest request, HttpServletResponse response, Model model,
                         java.lang.String uid) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = supplierInfoService.delete(uid);
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
    @RequiresPermissions("biz:supplierInfo:view")
    @RequestMapping(value = "info")
    public String info(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam(name = "id") String uid) throws Exception {
        model.addAttribute("item", supplierInfoService.get(request,uid));
        return "modules/biz/supplierInfoInfo";
    }
}
