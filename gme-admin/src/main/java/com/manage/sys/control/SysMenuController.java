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
import com.manage.sys.entity.SysMenu;
import com.manage.sys.service.SysMenuService;
import com.manage.sys.vo.SysMenuVO;

/**
 * 菜单控制类
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/sysMenu")
public class SysMenuController{
	private static final Log log = LogFactory.getLog(SysMenuController.class);

    @Resource(name = "sysMenuService")
    private SysMenuService sysMenuService;

	/**
     * 去菜单列表页
     */
    @RequiresPermissions("sys:sysMenu:view")
    @RequestMapping(value = "toList")
    public String toList(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
    	return "modules/sys/sysMenuList";
    }
    
    /**
     * 获取所有菜单数据
     */
    @RequiresPermissions("sys:sysMenu:view")
    @RequestMapping(value = "list")
    @ResponseBody
    public Map<String, Object> list(HttpServletRequest request, HttpServletResponse response, Model model,
                       @FormModel("sysMenuVO") SysMenuVO sysMenuVO) throws Exception {
        if (sysMenuVO == null) {
            sysMenuVO = new SysMenuVO();
        }
        if (request.getParameter("page") != null) {
            sysMenuVO.setPage(Integer.parseInt(request.getParameter("page")));
        }if (request.getParameter("rows") != null) {
            sysMenuVO.setRows(Integer.parseInt(request.getParameter("rows")));
        }
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	List<SysMenu> list = sysMenuService.selectTree();
	        jsonMap.put("rows", list);
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
    	List<SysMenu> list=sysMenuService.selectAllFather();
    	request.setAttribute("result", list);
        return "modules/sys/sysMenuAdd";
    }

    /**
     * 新增菜单
     */
    @RequiresPermissions("sys:sysMenu:add")
    @RequestMapping(value = "add")
    @ResponseBody
    public Map<String, Object> add(HttpServletRequest request, HttpServletResponse response, Model model,
                      @FormModel("sysMenu") SysMenu sysMenu) throws Exception {
    	sysMenu.setType(0);
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = sysMenuService.add(sysMenu);
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
        model.addAttribute("item", sysMenuService.get(id));
        List<SysMenu> list=sysMenuService.selectAllFather();
    	request.setAttribute("result", list);
        return "modules/sys/sysMenuUpdate";
    }

    /**
     * 修改菜单信息
     */
    @RequiresPermissions("sys:sysMenu:update")
    @RequestMapping(value = "update")
    @ResponseBody
    public Map<String, Object> update(HttpServletRequest request, HttpServletResponse response, Model model,
                         @FormModel("sysMenu") SysMenu sysMenu) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = sysMenuService.update(sysMenu);
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
     * 删除菜单信息
     */
    @RequiresPermissions("sys:sysMenu:delete")
    @RequestMapping(value = "delete")
    @ResponseBody
    public Map<String, Object> delete(HttpServletRequest request, HttpServletResponse response, Model model,java.lang.Long id) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = sysMenuService.delete(id);
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
     * 查看菜单详情
     */
    @RequiresPermissions("sys:sysMenu:view")
    @RequestMapping(value = "info")
    public String info(HttpServletRequest request, HttpServletResponse response, Model model, java.lang.Long id) throws Exception {
        model.addAttribute("item", sysMenuService.get(id));
        List<SysMenu> list = sysMenuService.selectAllFather();
    	request.setAttribute("result", list);
        return "modules/sys/sysMenuInfo";
    }
    
}
