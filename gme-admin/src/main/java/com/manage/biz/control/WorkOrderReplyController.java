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
import com.manage.base.entity.PageBean;
import com.manage.biz.entity.WorkOrderReply;
import com.manage.biz.service.WorkOrderReplyService;
import com.manage.biz.vo.WorkOrderReplyVO;
/**
 * 工单答复表（workOrderReply）
功能描述：存储工单答复信息。		
控制类
 */
@Controller
@RequestMapping(value = "${adminPath}/biz/workOrderReply")
public class WorkOrderReplyController{
	private static final Log log = LogFactory.getLog(WorkOrderReplyController.class);

    @Resource(name = "WorkOrderReplyService")
    private WorkOrderReplyService workOrderReplyService;

	/**
     * 去分页
     */
    @RequiresPermissions("biz:workOrderReply:view")
    @RequestMapping(value = "toList")
    public String toList(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
    	return "modules/biz/workOrderReplyList";
    }
    /**
     * 分页
     */
    @RequiresPermissions("biz:workOrderReply:view")
    @RequestMapping(value = "list")
    @ResponseBody
    public Map<String, Object> list(HttpServletRequest request, HttpServletResponse response, Model model,
                       @FormModel("workOrderReplyVO") WorkOrderReplyVO workOrderReplyVO) throws Exception {
        if (workOrderReplyVO == null) {
            workOrderReplyVO = new WorkOrderReplyVO();
        }
        if (request.getParameter("page") != null) {
            workOrderReplyVO.setPage(Integer.parseInt(request.getParameter("page")));
        }if (request.getParameter("rows") != null) {
            workOrderReplyVO.setRows(Integer.parseInt(request.getParameter("rows")));
        }
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	PageBean pageInfo = workOrderReplyService.selectPage(request,workOrderReplyVO);
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
    @RequiresPermissions("biz:workOrderReply:add")
    @RequestMapping(value = "toAdd")
    public String toAdd(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
        return "modules/biz/workOrderReplyAdd";
    }

    /**
     * 新增
     */
    @RequiresPermissions("biz:workOrderReply:add")
    @RequestMapping(value = "add")
    @ResponseBody
    public Map<String, Object> add(HttpServletRequest request, HttpServletResponse response, Model model,
                      @FormModel("workOrderReply") WorkOrderReply workOrderReply) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = workOrderReplyService.add(request,workOrderReply);
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
    /*@RequiresPermissions("biz:workOrderReply:update")
    @RequestMapping(value = "toUpdate")
    public String toUpdate(HttpServletRequest request, HttpServletResponse response, Model model, java.lang.String replyId) throws Exception {
        model.addAttribute("item", workOrderReplyService.get(replyId));
        return "modules/biz/workOrderReplyUpdate";
    }*/

    /**
     * 修改
     */
    /*@RequiresPermissions("biz:workOrderReply:update")
    @RequestMapping(value = "update")
    @ResponseBody
    public Map<String, Object> update(HttpServletRequest request, HttpServletResponse response, Model model,
                         @FormModel("workOrderReply") GWorkOrderReply workOrderReply) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = workOrderReplyService.update(workOrderReply);
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
    /*@RequiresPermissions("biz:workOrderReply:delete")
    @RequestMapping(value = "delete")
    @ResponseBody
    public Map<String, Object> delete(HttpServletRequest request, HttpServletResponse response, Model model,
                         java.lang.String replyId) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = workOrderReplyService.delete(replyId);
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
    @RequiresPermissions("biz:workOrderReply:view")
    @RequestMapping(value = "info")
    public String info(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam(name = "id") String replyId) throws Exception {
        model.addAttribute("item", workOrderReplyService.get(request,replyId));
        return "modules/biz/workOrderReplyInfo";
    }
}
