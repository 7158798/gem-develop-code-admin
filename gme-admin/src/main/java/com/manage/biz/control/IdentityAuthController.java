package com.manage.biz.control;

import java.sql.Timestamp;
import com.manage.base.annotation.FormModel;
import com.manage.base.entity.PageInfo;
import com.manage.biz.entity.IdentityAuth;
import com.manage.biz.service.IdentityAuthService;
import com.manage.biz.vo.IdentityAuthVO;

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
 * 身份认证表（identityAuth）
功能描述：存储用户身份认证信息。控制类
 */
@Controller
@RequestMapping(value = "${adminPath}/biz/identityAuth")
public class IdentityAuthController{
	private static final Log log = LogFactory.getLog(IdentityAuthController.class);

    @Resource(name = "IdentityAuthService")
    private IdentityAuthService identityAuthService;

	/**
     * 去分页
     */
    @RequiresPermissions("biz:identityAuth:view")
    @RequestMapping(value = "toList")
    public String toList(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
    	return "modules/biz/identityAuthList";
    }
    /**
     * 分页
     */
    @RequiresPermissions("biz:identityAuth:view")
    @RequestMapping(value = "list")
    @ResponseBody
    public Map<String, Object> list(HttpServletRequest request, HttpServletResponse response, Model model,
                       @FormModel("identityAuthVO") IdentityAuthVO identityAuthVO) throws Exception {
        if (identityAuthVO == null) {
            identityAuthVO = new IdentityAuthVO();
        }
        if (request.getParameter("page") != null) {
            identityAuthVO.setPage(Integer.parseInt(request.getParameter("page")));
        }if (request.getParameter("rows") != null) {
            identityAuthVO.setRows(Integer.parseInt(request.getParameter("rows")));
        }
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	PageInfo pageInfo = identityAuthService.selectPage(request,identityAuthVO);
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
    @RequiresPermissions("biz:identityAuth:add")
    @RequestMapping(value = "toAdd")
    public String toAdd(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
        return "modules/biz/identityAuthAdd";
    }

    /**
     * 新增
     */
   /* @RequiresPermissions("biz:identityAuth:add")
    @RequestMapping(value = "add")
    @ResponseBody
    public Map<String, Object> add(HttpServletRequest request, HttpServletResponse response, Model model,
                      @FormModel("identityAuth") GIdentityAuth identityAuth) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = identityAuthService.add(request,identityAuth);
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
    @RequiresPermissions("biz:identityAuth:update")
    @RequestMapping(value = "toUpdate")
    public String toUpdate(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam(name = "id") String authId) throws Exception {
        model.addAttribute("item", identityAuthService.get(request,authId));
        return "modules/biz/identityAuthUpdate";
    }

    /**
     * 修改
     */
    @RequiresPermissions("biz:identityAuth:update")
    @RequestMapping(value = "update")
    @ResponseBody
    public Map<String, Object> update(HttpServletRequest request, HttpServletResponse response, Model model,
                         @FormModel("identityAuth") IdentityAuth identityAuth) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = identityAuthService.update(request,identityAuth);
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
    /*@RequiresPermissions("biz:identityAuth:delete")
    @RequestMapping(value = "delete")
    @ResponseBody
    public Map<String, Object> delete(HttpServletRequest request, HttpServletResponse response, Model model,
                         java.lang.String authId) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = identityAuthService.delete(authId);
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
    @RequiresPermissions("biz:identityAuth:view")
    @RequestMapping(value = "info")
    public String info(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam(name = "id") String authId) throws Exception {
        model.addAttribute("item", identityAuthService.get(request,authId));
        return "modules/biz/identityAuthInfo";
    }
}
