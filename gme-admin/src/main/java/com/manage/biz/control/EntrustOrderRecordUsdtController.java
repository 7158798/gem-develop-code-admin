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
import com.manage.biz.entity.EntrustOrderRecordUsdt;
import com.manage.biz.service.EntrustOrderRecordUsdtService;
import com.manage.biz.vo.EntrustOrderRecordUsdtVO;
/**
 * 委托单历史订单表（entrustOrderRecordUsdt）
功能描述：存储币币交易的委托单历史记录。
控制类
 */
@Controller
@RequestMapping(value = "${adminPath}/biz/entrustOrderRecordUsdt")
public class EntrustOrderRecordUsdtController{
	private static final Log log = LogFactory.getLog(EntrustOrderRecordUsdtController.class);

    @Resource(name = "EntrustOrderRecordUsdtService")
    private EntrustOrderRecordUsdtService entrustOrderRecordUsdtService;

	/**
     * 去分页
     */
    @RequiresPermissions("biz:entrustOrderRecordUsdt:view")
    @RequestMapping(value = "toList")
    public String toList(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
    	return "modules/biz/entrustOrderRecordUsdtList";
    }
    /**
     * 分页
     */
    @RequiresPermissions("biz:entrustOrderRecordUsdt:view")
    @RequestMapping(value = "list")
    @ResponseBody
    public Map<String, Object> list(HttpServletRequest request, HttpServletResponse response, Model model,
                       @FormModel("entrustOrderRecordUsdtVO") EntrustOrderRecordUsdtVO entrustOrderRecordUsdtVO) throws Exception {
        if (entrustOrderRecordUsdtVO == null) {
            entrustOrderRecordUsdtVO = new EntrustOrderRecordUsdtVO();
        }
        if (request.getParameter("page") != null) {
            entrustOrderRecordUsdtVO.setPage(Integer.parseInt(request.getParameter("page")));
        }if (request.getParameter("rows") != null) {
            entrustOrderRecordUsdtVO.setRows(Integer.parseInt(request.getParameter("rows")));
        }
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	PageInfo pageInfo = entrustOrderRecordUsdtService.selectPage(request,entrustOrderRecordUsdtVO);
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
    /*@RequiresPermissions("biz:entrustOrderRecordUsdt:add")
    @RequestMapping(value = "toAdd")
    public String toAdd(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
        return "modules/biz/entrustOrderRecordUsdtAdd";
    }*/

    /**
     * 新增
     */
    /*@RequiresPermissions("biz:entrustOrderRecordUsdt:add")
    @RequestMapping(value = "add")
    @ResponseBody
    public Map<String, Object> add(HttpServletRequest request, HttpServletResponse response, Model model,
                      @FormModel("entrustOrderRecordUsdt") GEntrustOrderRecordUsdt entrustOrderRecordUsdt) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = entrustOrderRecordUsdtService.add(entrustOrderRecordUsdt);
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
    /*@RequiresPermissions("biz:entrustOrderRecordUsdt:update")
    @RequestMapping(value = "toUpdate")
    public String toUpdate(HttpServletRequest request, HttpServletResponse response, Model model, java.lang.String entrustOrderId) throws Exception {
        model.addAttribute("item", entrustOrderRecordUsdtService.get(entrustOrderId));
        return "modules/biz/entrustOrderRecordUsdtUpdate";
    }*/

    /**
     * 修改
     */
    /*@RequiresPermissions("biz:entrustOrderRecordUsdt:update")
    @RequestMapping(value = "update")
    @ResponseBody
    public Map<String, Object> update(HttpServletRequest request, HttpServletResponse response, Model model,
                         @FormModel("entrustOrderRecordUsdt") GEntrustOrderRecordUsdt entrustOrderRecordUsdt) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = entrustOrderRecordUsdtService.update(entrustOrderRecordUsdt);
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
    /*@RequiresPermissions("biz:entrustOrderRecordUsdt:delete")
    @RequestMapping(value = "delete")
    @ResponseBody
    public Map<String, Object> delete(HttpServletRequest request, HttpServletResponse response, Model model,
                         java.lang.String entrustOrderId) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = entrustOrderRecordUsdtService.delete(entrustOrderId);
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
    @RequiresPermissions("biz:entrustOrderRecordUsdt:view")
    @RequestMapping(value = "info")
    public String info(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam(name = "id") String entrustOrderId) throws Exception {
        model.addAttribute("item", entrustOrderRecordUsdtService.get(request,entrustOrderId));
        return "modules/biz/entrustOrderRecordUsdtInfo";
    }
}
