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
import com.manage.biz.service.OtcOrderRecordService;
import com.manage.biz.vo.GOtcOrderRecordVO;
/**
 * OTC历史订单表（g_otcOrderRecord）控制类
 */
@Controller
@RequestMapping(value = "${adminPath}/biz/otcOrderRecord")
public class OtcOrderRecordController{
	private static final Log log = LogFactory.getLog(OtcOrderRecordController.class);

    @Resource(name = "OtcOrderRecordService")
    private OtcOrderRecordService otcOrderRecordService;

	/**
     * 去分页
     */
    @RequiresPermissions("biz:otcOrderRecord:view")
    @RequestMapping(value = "toList")
    public String toList(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
    	return "modules/biz/otcOrderRecordList";
    }
    /**
     * 分页
     */
    @RequiresPermissions("biz:otcOrderRecord:view")
    @RequestMapping(value = "list")
    @ResponseBody
    public Map<String, Object> list(HttpServletRequest request, HttpServletResponse response, Model model,
                       @FormModel("otcOrderRecordVO") GOtcOrderRecordVO otcOrderRecordVO) throws Exception {
        if (otcOrderRecordVO == null) {
            otcOrderRecordVO = new GOtcOrderRecordVO();
        }
        if (request.getParameter("page") != null) {
            otcOrderRecordVO.setPage(Integer.parseInt(request.getParameter("page")));
        }if (request.getParameter("rows") != null) {
            otcOrderRecordVO.setRows(Integer.parseInt(request.getParameter("rows")));
        }
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	PageInfo pageInfo = otcOrderRecordService.selectPage(request,otcOrderRecordVO);
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
  /*  @RequiresPermissions("biz:otcOrderRecord:add")
    @RequestMapping(value = "toAdd")
    public String toAdd(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
        return "modules/biz/otcOrderRecordAdd";
    }*/

    /**
     * 新增
     */
   /* @RequiresPermissions("biz:otcOrderRecord:add")
    @RequestMapping(value = "add")
    @ResponseBody
    public Map<String, Object> add(HttpServletRequest request, HttpServletResponse response, Model model,
                      @FormModel("g_otcOrderRecord") GOtcOrderRecord g_otcOrderRecord) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = otcOrderRecordService.add(g_otcOrderRecord);
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
   /* @RequiresPermissions("biz:otcOrderRecord:update")
    @RequestMapping(value = "toUpdate")
    public String toUpdate(HttpServletRequest request, HttpServletResponse response, Model model, java.lang.String entryOrderId) throws Exception {
        model.addAttribute("item", otcOrderRecordService.get(entryOrderId));
        return "modules/biz/otcOrderRecordUpdate";
    }*/

    /**
     * 修改
     */
    /*@RequiresPermissions("biz:otcOrderRecord:update")
    @RequestMapping(value = "update")
    @ResponseBody
    public Map<String, Object> update(HttpServletRequest request, HttpServletResponse response, Model model,
                         @FormModel("g_otcOrderRecord") GOtcOrderRecord g_otcOrderRecord) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = otcOrderRecordService.update(g_otcOrderRecord);
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
   /* @RequiresPermissions("biz:otcOrderRecord:delete")
    @RequestMapping(value = "delete")
    @ResponseBody
    public Map<String, Object> delete(HttpServletRequest request, HttpServletResponse response, Model model,
                         java.lang.String entryOrderId) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = otcOrderRecordService.delete(entryOrderId);
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
    @RequiresPermissions("biz:otcOrderRecord:view")
    @RequestMapping(value = "info")
    public String info(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam(name = "id") String entryOrderId) throws Exception {
        model.addAttribute("item", otcOrderRecordService.get(request,entryOrderId));
        return "modules/biz/otcOrderRecordInfo";
    }
}
