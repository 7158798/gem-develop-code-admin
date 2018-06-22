package com.manage.biz.control;

import java.sql.Timestamp;
import com.manage.base.annotation.FormModel;
import com.manage.base.entity.PageInfo;
import com.manage.biz.entity.GWorkOrderReply;
import com.manage.biz.service.GWorkOrderReplyService;
import com.manage.biz.vo.GWorkOrderReplyVO;

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
 * 工单答复表（g_work_order_reply）
功能描述：存储工单答复信息。		
控制类
 */
@Controller
@RequestMapping(value = "${adminPath}/bus/g_work_order_reply")
public class GWorkOrderReplyController{
	private static final Log log = LogFactory.getLog(GWorkOrderReplyController.class);

    @Resource(name = "GWorkOrderReplyService")
    private GWorkOrderReplyService g_work_order_reply_service;

	/**
     * 去分页
     */
    @RequiresPermissions("bus:g_work_order_reply:view")
    @RequestMapping(value = "toList")
    public String toList(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
    	return "modules/bus/g_work_order_replyList";
    }
    /**
     * 分页
     */
    @RequiresPermissions("bus:g_work_order_reply:view")
    @RequestMapping(value = "list")
    @ResponseBody
    public Map<String, Object> list(HttpServletRequest request, HttpServletResponse response, Model model,
                       @FormModel("g_work_order_reply_vo") GWorkOrderReplyVO g_work_order_reply_vo) throws Exception {
        if (g_work_order_reply_vo == null) {
            g_work_order_reply_vo = new GWorkOrderReplyVO();
        }
        if (request.getParameter("page") != null) {
            g_work_order_reply_vo.setPage(Integer.parseInt(request.getParameter("page")));
        }if (request.getParameter("rows") != null) {
            g_work_order_reply_vo.setRows(Integer.parseInt(request.getParameter("rows")));
        }
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	PageInfo pageInfo = g_work_order_reply_service.selectPage(request,g_work_order_reply_vo);
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
    @RequiresPermissions("bus:g_work_order_reply:add")
    @RequestMapping(value = "toAdd")
    public String toAdd(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
        return "modules/bus/g_work_order_replyAdd";
    }

    /**
     * 新增
     */
    @RequiresPermissions("bus:g_work_order_reply:add")
    @RequestMapping(value = "add")
    @ResponseBody
    public Map<String, Object> add(HttpServletRequest request, HttpServletResponse response, Model model,
                      @FormModel("g_work_order_reply") GWorkOrderReply g_work_order_reply) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = g_work_order_reply_service.add(request,g_work_order_reply);
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
    /*@RequiresPermissions("bus:g_work_order_reply:update")
    @RequestMapping(value = "toUpdate")
    public String toUpdate(HttpServletRequest request, HttpServletResponse response, Model model, java.lang.String reply_id) throws Exception {
        model.addAttribute("item", g_work_order_reply_service.get(reply_id));
        return "modules/bus/g_work_order_replyUpdate";
    }*/

    /**
     * 修改
     */
    /*@RequiresPermissions("bus:g_work_order_reply:update")
    @RequestMapping(value = "update")
    @ResponseBody
    public Map<String, Object> update(HttpServletRequest request, HttpServletResponse response, Model model,
                         @FormModel("g_work_order_reply") GWorkOrderReply g_work_order_reply) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = g_work_order_reply_service.update(g_work_order_reply);
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
    /*@RequiresPermissions("bus:g_work_order_reply:delete")
    @RequestMapping(value = "delete")
    @ResponseBody
    public Map<String, Object> delete(HttpServletRequest request, HttpServletResponse response, Model model,
                         java.lang.String reply_id) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = g_work_order_reply_service.delete(reply_id);
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
    @RequiresPermissions("bus:g_work_order_reply:view")
    @RequestMapping(value = "info")
    public String info(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam(name = "id") String reply_id) throws Exception {
        model.addAttribute("item", g_work_order_reply_service.get(request,reply_id));
        return "modules/bus/g_work_order_replyInfo";
    }
}
