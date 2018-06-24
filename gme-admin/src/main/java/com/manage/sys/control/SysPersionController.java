package com.manage.sys.control;

import java.util.HashMap;
import java.util.List;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.manage.base.annotation.FormModel;
import com.manage.sys.entity.SysPersion;
import com.manage.sys.service.SysPersionService;
import com.manage.sys.vo.SysPersionVO;

/**
 * 菜单功能表控制类
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/sysPersion")
public class SysPersionController{
	private static final Log log = LogFactory.getLog(SysPersionController.class);

    @Resource(name = "sysPersionService")
    private SysPersionService sysPersionService;

	/**
     * 去分页
     */
    @RequiresPermissions("sys:sysMenu:view")
    @RequestMapping(value = "toList")
    public String toList(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
    	return "modules/sys/sysPersionList";
    }
    
    /**
     * 分页
     */
    @RequiresPermissions("sys:sysMenu:view")
    @RequestMapping(value = "list")
    @ResponseBody
    public Map<String, Object> list(HttpServletRequest request, HttpServletResponse response, Model model,
                       @FormModel("sysPersionVO") SysPersionVO sysPersionVO) throws Exception {
        if (sysPersionVO == null) {
            sysPersionVO = new SysPersionVO();
        }
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	List<SysPersion> list = sysPersionService.selectAll(sysPersionVO);
	        jsonMap.put("rows",list);
        }catch (Exception e) {
        	log.error("系统异常",e);
		}
        return jsonMap;
    }

    /**
     * 去新增
     */
    @RequiresPermissions("sys:sysMenu:add")
    @RequestMapping(value = "toAdd")
    public String toAdd(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
    	model.addAttribute("mid", request.getParameter("mid"));
        return "modules/sys/sysPersionAdd";
    }

    /**
     * 新增
     */
    @RequiresPermissions("sys:sysMenu:add")
    @RequestMapping(value = "add")
    @ResponseBody
    public Map<String, Object> add(HttpServletRequest request, HttpServletResponse response, Model model,
                      @FormModel("sysPersion") SysPersion sysPersion) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = sysPersionService.add(sysPersion);
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
     * 去修改
     */
    @RequiresPermissions("sys:sysMenu:update")
    @RequestMapping(value = "toUpdate")
    public String toUpdate(HttpServletRequest request, HttpServletResponse response, Model model, java.lang.Long id) throws Exception {
        model.addAttribute("item", sysPersionService.get(id));
        return "modules/sys/sysPersionUpdate";
    }

    /**
     * 修改
     */
    @RequiresPermissions("sys:sysMenu:update")
    @RequestMapping(value = "update")
    @ResponseBody
    public Map<String, Object> update(HttpServletRequest request, HttpServletResponse response, Model model,
                         @FormModel("sysPersion") SysPersion sysPersion) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = sysPersionService.update(sysPersion);
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
     * 查看详情
     */
    @RequiresPermissions("sys:sysMenu:view")
    @RequestMapping(value = "info")
    public String info(HttpServletRequest request, HttpServletResponse response, Model model, java.lang.Long id) throws Exception {
        model.addAttribute("item", sysPersionService.get(id));
        return "modules/sys/sysPersionInfo";
    }
    
    /**
     * 删除
     */
    @RequiresPermissions("sys:sysMenu:delete")
    @RequestMapping(value = "delete")
    @ResponseBody
    public Map<String, Object> delete(HttpServletRequest request, HttpServletResponse response, Model model,java.lang.Long id ) throws Exception {
        boolean result = sysPersionService.delete(id,null);
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        if (result) {
            jsonMap.put("success", true);
            jsonMap.put("msg", "操作成功");
        } else {
            jsonMap.put("success", false);
            jsonMap.put("msg", "操作失败");
        }
        return jsonMap;
    }
    
}
