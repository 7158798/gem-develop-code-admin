package com.manage.sys.control;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.manage.base.annotation.FormModel;
import com.manage.base.cache.SysRoleCache;
import com.manage.base.entity.PageBean;
import com.manage.base.util.Constants;
import com.manage.base.util.UserUtil;
import com.manage.sys.entity.SysUser;
import com.manage.sys.service.SysUserService;
import com.manage.sys.vo.SysUserVO;

/**
 * 后台管理员控制类
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/sysUser")
public class SysUserController{
	private static final Log log = LogFactory.getLog(SysUserController.class);

    @Resource(name = "sysUserService")
    private SysUserService sysUserService;

	/**
     * 去分页
     */
    @RequiresPermissions("sys:sysUser:view")
    @RequestMapping(value = "toList")
    public String toList(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
    	model.addAttribute("roles", SysRoleCache.getRolesFromCache());
    	return "modules/sys/sysUserList";
    }
    
    /**
     * 分页
     */
    @RequiresPermissions("sys:sysUser:view")
    @RequestMapping(value = "list")
    @ResponseBody
    public Map<String, Object> list(HttpServletRequest request, HttpServletResponse response, Model model,
                       @FormModel("sysUserVO") SysUserVO sysUserVO) throws Exception {
        if (sysUserVO == null) {
            sysUserVO = new SysUserVO();
        }
        if (request.getParameter("page") != null) {
            sysUserVO.setPage(Integer.parseInt(request.getParameter("page")));
        }if (request.getParameter("rows") != null) {
            sysUserVO.setRows(Integer.parseInt(request.getParameter("rows")));
        }
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	PageBean pageInfo = sysUserService.selectPage(sysUserVO);
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
    @RequiresPermissions("sys:sysUser:add")
    @RequestMapping(value = "toAdd")
    public String toAdd(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
    	model.addAttribute("roles", SysRoleCache.getRolesFromCache());
        return "modules/sys/sysUserAdd";
    }

    /**
     * 新增
     */
    @RequiresPermissions("sys:sysUser:add")
    @RequestMapping(value = "add")
    @ResponseBody
    public Map<String, Object> add(HttpServletRequest request, HttpServletResponse response, Model model,
                      @FormModel("sysUser") SysUser sysUser) throws Exception {
    	sysUser.setCreatetime(new Timestamp(System.currentTimeMillis()));
    	
    	System.out.println("1 =====>>>> : "+sysUser);
    	System.out.println("2 用户名  =====>>>> : "+sysUser.getUsername());
    	System.out.println("3 密码  =====>>>> : "+sysUser.getUserpwd());
    	System.out.println("3 密码  =====>>>> : "+sysUser.getUserpwd());
    	System.out.println("3 密码  =====>>>> : "+sysUser.getUserpwd());
    	
        String newPwd = new SimpleHash(Constants.PASSWORD_TYPE, sysUser.getUserpwd(), sysUser.getUsername().toLowerCase(),2).toString();
    	System.out.println("4 newPwd  =====>>>> : "+newPwd);
    	
        sysUser.setUserpwd(newPwd);
    	sysUser.setStatus(Integer.parseInt("1"));//默认用户状态:1-正常;2-禁用
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = sysUserService.add(sysUser);
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
    @RequiresPermissions("sys:sysUser:update")
    @RequestMapping(value = "toUpdate")
    public String toUpdate(HttpServletRequest request, HttpServletResponse response, Model model, java.lang.Long id) throws Exception {
    	model.addAttribute("roles", SysRoleCache.getRolesFromCache());
        model.addAttribute("item", sysUserService.get(id));
        return "modules/sys/sysUserUpdate";
    }

    /**
     * 修改
     */
    @RequiresPermissions("sys:sysUser:update")
    @RequestMapping(value = "update")
    @ResponseBody
    public Map<String, Object> update(HttpServletRequest request, HttpServletResponse response, Model model,
                         @FormModel("sysUser") SysUser sysUser) throws Exception {
    	boolean isCheck=false;
    	Map<String, Object> jsonMap = new HashMap<String, Object>();
    	try{
    		SysUserVO sysUserVO=new SysUserVO();
    		sysUserVO.setUserName(sysUser.getUsername());
        	List<SysUser> list=sysUserService.selectAll(sysUserVO);
    		if(list==null && list.size()==0){
    			isCheck=true;
    		}else{
    			boolean t=false;
    			for(int i=0;i<list.size();i++){
    				if(list.get(i).getUsername().equals(sysUser.getUsername()) && !list.get(i).getId().toString().equals(sysUser.getId().toString())){
    					t=true;
    				}
    			}
    			if(t){
    				jsonMap.put("success", false);
                    jsonMap.put("msg", "已经有了该用户！");
    			}else{
    				isCheck=true;
    			}
    		}
    		if(isCheck){
    	        boolean result = sysUserService.update(sysUser);
    	        if (result) {
    	            jsonMap.put("success", true);
    	            jsonMap.put("msg", "操作成功");
    	        } else {
    	            jsonMap.put("success", false);
    	            jsonMap.put("msg", "操作失败");
    	        }
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
    @RequiresPermissions("sys:sysUser:delete")
    @RequestMapping(value = "delete")
    @ResponseBody
    public Map<String, Object> delete(HttpServletRequest request, HttpServletResponse response, Model model,java.lang.Long id ) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = sysUserService.delete(id);
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
    @RequiresPermissions("sys:sysUser:view")
    @RequestMapping(value = "info")
    public String info(HttpServletRequest request, HttpServletResponse response, Model model, java.lang.Long id) throws Exception {
        model.addAttribute("item", sysUserService.get(id));
        model.addAttribute("roles", SysRoleCache.getRolesFromCache());
        return "modules/sys/sysUserInfo";
    }
    
    /**
     * 重置密码
     */
    @RequiresPermissions("sys:sysUser:update")
    @RequestMapping(value = "rsetPass")
    @ResponseBody
    public Map<String, Object> rsetPass(HttpServletRequest request, HttpServletResponse response, Model model, @FormModel("sysUser") SysUser sysUser) throws Exception {
    	String newPwd = new SimpleHash(Constants.PASSWORD_TYPE, Constants.DEFAULT_PAS, sysUser.getUsername().toLowerCase(),2).toString();
    	Map<String, Object> jsonMap = new HashMap<String, Object>();
    	try{
    		sysUser.setUserpwd(newPwd);
    		boolean result = sysUserService.update(sysUser);
	        if (result) {
	            jsonMap.put("success", true);
	            jsonMap.put("msg", "操作成功新密码为："+Constants.DEFAULT_PAS);
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
     * 校验用户名是否重名
     */
    @RequiresPermissions("sys:sysUser:view")
    @RequestMapping(value = "checkUser")
    @ResponseBody
    public Map<String, Object> checkUser(HttpServletRequest request, HttpServletResponse response, Model model,@FormModel("sysUserVO") SysUserVO sysUserVO) throws Exception {
    	sysUserVO.setUserName(request.getParameter("param"));
    	Map<String, Object> jsonMap = new HashMap<String, Object>();
    	try{
    		if(sysUserVO.getCheckType().equals("1")){
        		List<SysUser> list=sysUserService.selectAll(sysUserVO);
        		if(list!=null && list.size()>0){
        			jsonMap.put("status", "n");
                    jsonMap.put("info", "已经有了该用户！");
        		}else{
        			jsonMap.put("status", "y");
                    jsonMap.put("info", "校验通过！");
        		}
        		return jsonMap;
        	}
        	if(sysUserVO.getCheckType().equals("2")){
        		List<SysUser> list=sysUserService.selectAll(sysUserVO);
        		if(list==null && list.size()==0){
        			jsonMap.put("status", "y");
                    jsonMap.put("info", "校验通过！");
        		}else{
        			boolean t=false;
        			for(int i=0;i<list.size();i++){
        				if(list.get(i).getUsername().equals(sysUserVO.getUserName()) && !list.get(i).getId().toString().equals(sysUserVO.getId().toString())){
        					t=true;
        				}
        			}
        			if(t){
        				jsonMap.put("status", "n");
                        jsonMap.put("info", "已经有了该用户！");
        			}else{
        				jsonMap.put("status", "y");
                        jsonMap.put("info", "校验通过！");
        			}
        		}
        		return jsonMap;
        	}
        	jsonMap.put("status", "n");
            jsonMap.put("info", "操作异常！");
        }catch (Exception e) {
        	log.error("系统异常",e);
        	jsonMap.put("success", false);
            jsonMap.put("msg", "操作失败");
		}
        return jsonMap;
    }
    /**
     * 查看当前用户详情
     */
    @RequiresUser
    @RequestMapping(value = "curInfo")
    public String curInfo(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception { 
    	 model.addAttribute("item", UserUtil.getCurUser());
    	 return "modules/sys/modifyUserInfo";
    }
    /**
     * 去修改当前用户密码
     */
    @RequiresUser
    @RequestMapping(value = "toCurUpdatePass")
    public String toCurUpdatePass(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
    	
    	return "modules/sys/modifyPassword";
    }
    /**
     * 校验用户密码
     */
    @RequestMapping(value = "checkUserPass")
    @ResponseBody
    public Map<String, Object> checkUserPass(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
    	Map<String, Object> jsonMap = new HashMap<String, Object>();
    	SysUser sysUser=UserUtil.getCurUser();
    	String userOldPass=request.getParameter("param");
    	String oldPwd = new SimpleHash(Constants.PASSWORD_TYPE,userOldPass, sysUser.getUsername().toLowerCase(),2).toString();
    	if(!sysUser.getUserpwd().equals(oldPwd)){
    		jsonMap.put("status", "n");
            jsonMap.put("info", "旧密码错误！");
            return jsonMap;
    	}
    	jsonMap.put("status", "y");
        jsonMap.put("info", "通过信息验证！");
        return jsonMap;
    }
    /**
     * 修改当前用户密码
     */
    @RequiresUser
    @RequestMapping(value = "curUpdatePass")
    @ResponseBody
    public Map<String, Object> curUpdatePass(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
    	String userOldPass=request.getParameter("oldPassword");
    	String userNewPass=request.getParameter("newPassword");
    	Map<String, Object> jsonMap = new HashMap<String, Object>();
    	SysUser sysUser=UserUtil.getCurUser();
    	String oldPwd = new SimpleHash(Constants.PASSWORD_TYPE,userOldPass, sysUser.getUsername().toLowerCase(),2).toString();
    	String newPwd = new SimpleHash(Constants.PASSWORD_TYPE,userNewPass, sysUser.getUsername().toLowerCase(),2).toString();
    	if(!sysUser.getUserpwd().equals(oldPwd)){
    		jsonMap.put("success", false);
            jsonMap.put("msg", "旧密码错误！");
            return jsonMap;
    	}
    	SysUser sysUser2=new SysUser();
    	sysUser2.setUserpwd(newPwd);
    	sysUser2.setId(sysUser.getId());
    	try{
    		boolean result = sysUserService.update(sysUser2);
            if (result) {
            	sysUser.setUserpwd(newPwd);
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
     * 修改当前用户信息
     */
    @RequestMapping(value = "curUpdate")
    @ResponseBody
    public Map<String, Object> curUpdate(HttpServletRequest request, HttpServletResponse response, Model model,@FormModel("sysUser") SysUser sysUser) throws Exception {
    	Map<String, Object> jsonMap = new HashMap<String, Object>();
    	try{
    		boolean result = sysUserService.update(sysUser);
 	        if (result) {
 	        	SysUser sessionUser=UserUtil.getCurUser();
 	        	sessionUser.setPhone(sysUser.getPhone());
 	        	sessionUser.setQq(sysUser.getQq());
 	        	sessionUser.setTruename(sysUser.getTruename());
 	        	sessionUser.setEmail(sysUser.getEmail());
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
}
