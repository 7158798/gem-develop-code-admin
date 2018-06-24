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
import com.manage.sys.entity.SysRole;
import com.manage.sys.service.SysMenuService;
import com.manage.sys.service.SysRmenuService;
import com.manage.sys.service.SysRoleService;
import com.manage.sys.vo.SysMenuPersions;
import com.manage.sys.vo.SysRoleVO;

/**
 * 角色说明控制类
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/sysRole")
public class SysRoleController{
	private static final Log log = LogFactory.getLog(SysRoleController.class);

    @Resource(name = "sysRoleService")
    private SysRoleService sysRoleService;
    @Resource(name = "sysMenuService")
    private SysMenuService sysMenuService;
    @Resource(name = "sysRmenuService")
    private SysRmenuService sysRmenuService;
	
    /**
     * 去分页
     */
    @RequiresPermissions("sys:sysRole:view")
    @RequestMapping(value = "toList")
    public String toList(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
    	return "modules/sys/sysRoleList";
    }
   
    /**
     * 分页
     */
    @RequiresPermissions("sys:sysRole:view")
    @RequestMapping(value = "list")
    @ResponseBody
    public Map<String, Object> list(HttpServletRequest request, HttpServletResponse response, Model model,
                       @FormModel("sysRoleVO") SysRoleVO sysRoleVO) throws Exception {
        if (sysRoleVO == null) {
            sysRoleVO = new SysRoleVO();
        }
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	List<SysRole> list= sysRoleService.selectAll(sysRoleVO);
	        jsonMap.put("rows", list);
        }catch (Exception e) {
        	log.error("系统异常",e);
		}
        return jsonMap;
    }

    /**
     * 去新增
     */
    @RequiresPermissions("sys:sysRole:add")
    @RequestMapping(value = "toAdd")
    public String toAdd(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
        return "modules/sys/sysRoleAdd";
    }

    /**
     * 新增
     */
    @RequiresPermissions("sys:sysRole:add")
    @RequestMapping(value = "add")
    @ResponseBody
    public Map<String, Object> add(HttpServletRequest request, HttpServletResponse response, Model model,
                      @FormModel("sysRole") SysRole sysRole) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = sysRoleService.add(sysRole);
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
    @RequiresPermissions("sys:sysRole:update")
    @RequestMapping(value = "toUpdate")
    public String toUpdate(HttpServletRequest request, HttpServletResponse response, Model model, java.lang.Long id) throws Exception {
        model.addAttribute("item", sysRoleService.get(id));
        return "modules/sys/sysRoleUpdate";
    }

    /**
     * 修改
     */
    @RequiresPermissions("sys:sysRole:update")
    @RequestMapping(value = "update")
    @ResponseBody
    public Map<String, Object> update(HttpServletRequest request, HttpServletResponse response, Model model,
                         @FormModel("sysRole") SysRole sysRole) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = sysRoleService.update(sysRole);
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
    @RequiresPermissions("sys:sysRole:delete")
    @RequestMapping(value = "delete")
    @ResponseBody
    public Map<String, Object> delete(HttpServletRequest request, HttpServletResponse response, Model model,java.lang.Long id) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = sysRoleService.delete(id);
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
    @RequiresPermissions("sys:sysRole:view")
    @RequestMapping(value = "info")
    public String info(HttpServletRequest request, HttpServletResponse response, Model model, java.lang.Long id) throws Exception {
        model.addAttribute("item", sysRoleService.get(id));
        return "modules/sys/sysRoleInfo";
    }
    /**
     * 查询角色菜单
     */
    @RequiresPermissions("sys:sysRole:view")
    @RequestMapping(value = "listRoleMenu")
    public String listRoleMenu(HttpServletRequest request, HttpServletResponse response, Model model,@FormModel("sysRoleVO") SysRoleVO sysRoleVO) throws Exception {
    	List<SysMenu> list=sysMenuService.getAllMenuFromCache();
    	List<SysMenuPersions> list3=sysRmenuService.selectCheckBoxTree(list, sysRoleVO.getId());
    	model.addAttribute("list", list3);
    	model.addAttribute("rid", sysRoleVO.getId());
    	return "modules/sys/setRoleMenuPersions";
    }
    /**
     * 设置角色菜单
     */
    @RequiresPermissions("sys:sysRole:add")
    @RequestMapping(value = "addRoleMenu")
    @ResponseBody
    public Map<String, Object> addRoleMenu(HttpServletRequest request, HttpServletResponse response, Model model,@FormModel("sysRoleVO") SysRoleVO sysRoleVO) throws Exception {
    	try{
	    	boolean result =sysRmenuService.addBatch(sysRoleVO.getMenuIds(), sysRoleVO.getId());
	        Map<String, Object> jsonMap = new HashMap<String, Object>();
	        if (result) {
	            jsonMap.put("success", true);
	            jsonMap.put("msg", "操作成功");
	        } else {
	            jsonMap.put("success", false);
	            jsonMap.put("msg", "操作失败");
	        }
	        return jsonMap;
    	}catch (Exception e) {
    		e.printStackTrace();
		}
    	return null;
    }
}
