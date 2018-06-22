package com.manage.biz.control;

import java.sql.Timestamp;
import com.manage.base.annotation.FormModel;
import com.manage.base.entity.PageInfo;
import com.manage.biz.entity.GIdentityAuth;
import com.manage.biz.service.GIdentityAuthService;
import com.manage.biz.vo.GIdentityAuthVO;

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
 * 身份认证表（g_identity_auth）
功能描述：存储用户身份认证信息。控制类
 */
@Controller
@RequestMapping(value = "${adminPath}/bus/g_identity_auth")
public class GIdentityAuthController{
	private static final Log log = LogFactory.getLog(GIdentityAuthController.class);

    @Resource(name = "GIdentityAuthService")
    private GIdentityAuthService g_identity_auth_service;

	/**
     * 去分页
     */
    @RequiresPermissions("bus:g_identity_auth:view")
    @RequestMapping(value = "toList")
    public String toList(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
    	return "modules/bus/g_identity_authList";
    }
    /**
     * 分页
     */
    @RequiresPermissions("bus:g_identity_auth:view")
    @RequestMapping(value = "list")
    @ResponseBody
    public Map<String, Object> list(HttpServletRequest request, HttpServletResponse response, Model model,
                       @FormModel("g_identity_auth_vo") GIdentityAuthVO g_identity_auth_vo) throws Exception {
        if (g_identity_auth_vo == null) {
            g_identity_auth_vo = new GIdentityAuthVO();
        }
        if (request.getParameter("page") != null) {
            g_identity_auth_vo.setPage(Integer.parseInt(request.getParameter("page")));
        }if (request.getParameter("rows") != null) {
            g_identity_auth_vo.setRows(Integer.parseInt(request.getParameter("rows")));
        }
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	PageInfo pageInfo = g_identity_auth_service.selectPage(request,g_identity_auth_vo);
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
    @RequiresPermissions("bus:g_identity_auth:add")
    @RequestMapping(value = "toAdd")
    public String toAdd(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
        return "modules/bus/g_identity_authAdd";
    }

    /**
     * 新增
     */
   /* @RequiresPermissions("bus:g_identity_auth:add")
    @RequestMapping(value = "add")
    @ResponseBody
    public Map<String, Object> add(HttpServletRequest request, HttpServletResponse response, Model model,
                      @FormModel("g_identity_auth") GIdentityAuth g_identity_auth) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = g_identity_auth_service.add(request,g_identity_auth);
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
    @RequiresPermissions("bus:g_identity_auth:update")
    @RequestMapping(value = "toUpdate")
    public String toUpdate(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam(name = "id") String auth_id) throws Exception {
        model.addAttribute("item", g_identity_auth_service.get(request,auth_id));
        return "modules/bus/g_identity_authUpdate";
    }

    /**
     * 修改
     */
    @RequiresPermissions("bus:g_identity_auth:update")
    @RequestMapping(value = "update")
    @ResponseBody
    public Map<String, Object> update(HttpServletRequest request, HttpServletResponse response, Model model,
                         @FormModel("g_identity_auth") GIdentityAuth g_identity_auth) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = g_identity_auth_service.update(request,g_identity_auth);
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
    /*@RequiresPermissions("bus:g_identity_auth:delete")
    @RequestMapping(value = "delete")
    @ResponseBody
    public Map<String, Object> delete(HttpServletRequest request, HttpServletResponse response, Model model,
                         java.lang.String auth_id) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = g_identity_auth_service.delete(auth_id);
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
    @RequiresPermissions("bus:g_identity_auth:view")
    @RequestMapping(value = "info")
    public String info(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam(name = "id") String auth_id) throws Exception {
        model.addAttribute("item", g_identity_auth_service.get(request,auth_id));
        return "modules/bus/g_identity_authInfo";
    }
}
