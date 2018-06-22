package com.manage.biz.control;

import java.sql.Timestamp;
import com.manage.base.annotation.FormModel;
import com.manage.base.entity.PageInfo;
import com.manage.biz.entity.GNotice;
import com.manage.biz.service.GNoticeService;
import com.manage.biz.vo.GNoticeVO;

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
 * 通知公告表（g_notice）
功能描述：存储通知公告信息。
控制类
 */
@Controller
@RequestMapping(value = "${adminPath}/bus/g_notice")
public class GNoticeController{
	private static final Log log = LogFactory.getLog(GNoticeController.class);

    @Resource(name = "GNoticeService")
    private GNoticeService g_notice_service;

	/**
     * 去分页
     */
    @RequiresPermissions("bus:g_notice:view")
    @RequestMapping(value = "toList")
    public String toList(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
    	return "modules/bus/g_noticeList";
    }
    /**
     * 分页
     */
    @RequiresPermissions("bus:g_notice:view")
    @RequestMapping(value = "list")
    @ResponseBody
    public Map<String, Object> list(HttpServletRequest request, HttpServletResponse response, Model model,
                       @FormModel("g_notice_vo") GNoticeVO g_notice_vo) throws Exception {
        if (g_notice_vo == null) {
            g_notice_vo = new GNoticeVO();
        }
        if (request.getParameter("page") != null) {
            g_notice_vo.setPage(Integer.parseInt(request.getParameter("page")));
        }if (request.getParameter("rows") != null) {
            g_notice_vo.setRows(Integer.parseInt(request.getParameter("rows")));
        }
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	PageInfo pageInfo = g_notice_service.selectPage(request,g_notice_vo);
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
    @RequiresPermissions("bus:g_notice:add")
    @RequestMapping(value = "toAdd")
    public String toAdd(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
        return "modules/bus/g_noticeAdd";
    }

    /**
     * 新增
     */
    @RequiresPermissions("bus:g_notice:add")
    @RequestMapping(value = "add")
    @ResponseBody
    public Map<String, Object> add(HttpServletRequest request, HttpServletResponse response, Model model,
                      @FormModel("g_notice") GNotice g_notice) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = g_notice_service.add(request,g_notice);
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
    @RequiresPermissions("bus:g_notice:update")
    @RequestMapping(value = "toUpdate")
    public String toUpdate(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam(name = "id") String notice_id) throws Exception {
        model.addAttribute("item", g_notice_service.get(request,notice_id));
        return "modules/bus/g_noticeUpdate";
    }

    /**
     * 修改
     */
    @RequiresPermissions("bus:g_notice:update")
    @RequestMapping(value = "update")
    @ResponseBody
    public Map<String, Object> update(HttpServletRequest request, HttpServletResponse response, Model model,
                         @FormModel("g_notice") GNotice g_notice) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = g_notice_service.update(request,g_notice);
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
    @RequiresPermissions("bus:g_notice:delete")
    @RequestMapping(value = "delete")
    @ResponseBody
    public Map<String, Object> delete(HttpServletRequest request, HttpServletResponse response, Model model,
    		@RequestParam(name = "id") String notice_id) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = g_notice_service.delete(request,notice_id);
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
    @RequiresPermissions("bus:g_notice:view")
    @RequestMapping(value = "info")
    public String info(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam(name = "id") String notice_id) throws Exception {
        model.addAttribute("item", g_notice_service.get(request,notice_id));
        return "modules/bus/g_noticeInfo";
    }
}
