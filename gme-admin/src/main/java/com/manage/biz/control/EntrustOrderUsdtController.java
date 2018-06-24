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
import com.manage.biz.service.EntrustOrderUsdtService;
import com.manage.biz.vo.EntrustOrderUsdtVO;
/**
 * 委托订单表（g_entrustOrderUsdt）
功能描述：存储币币交易的委托单历史记录。每个交易区生成一张委托订单表。entrustOrderId
控制类
 */
@Controller
@RequestMapping(value = "${adminPath}/biz/entrustOrderUsdt")
public class EntrustOrderUsdtController{
	private static final Log log = LogFactory.getLog(EntrustOrderUsdtController.class);

    @Resource(name = "EntrustOrderUsdtService")
    private EntrustOrderUsdtService entrustOrderUsdtService;

	/**
     * 去分页
     */
    @RequiresPermissions("biz:entrustOrderUsdt:view")
    @RequestMapping(value = "toList")
    public String toList(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
    	return "modules/biz/entrustOrderUsdtList";
    }
    /**
     * 分页
     */
    @RequiresPermissions("biz:entrustOrderUsdt:view")
    @RequestMapping(value = "list")
    @ResponseBody
    public Map<String, Object> list(HttpServletRequest request, HttpServletResponse response, Model model,
                       @FormModel("entrustOrderUsdtVO") EntrustOrderUsdtVO entrustOrderUsdtVO) throws Exception {
        if (entrustOrderUsdtVO == null) {
            entrustOrderUsdtVO = new EntrustOrderUsdtVO();
        }
        if (request.getParameter("page") != null) {
            entrustOrderUsdtVO.setPage(Integer.parseInt(request.getParameter("page")));
        }if (request.getParameter("rows") != null) {
            entrustOrderUsdtVO.setRows(Integer.parseInt(request.getParameter("rows")));
        }
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	PageInfo pageInfo = entrustOrderUsdtService.selectPage(request,entrustOrderUsdtVO);
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
   /* @RequiresPermissions("biz:entrustOrderUsdt:add")
    @RequestMapping(value = "toAdd")
    public String toAdd(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
        return "modules/biz/entrustOrderUsdtAdd";
    }*/

    /**
     * 新增
     */
    /*@RequiresPermissions("biz:entrustOrderUsdt:add")
    @RequestMapping(value = "add")
    @ResponseBody
    public Map<String, Object> add(HttpServletRequest request, HttpServletResponse response, Model model,
                      @FormModel("g_entrustOrderUsdt") GEntrustOrderUsdt g_entrustOrderUsdt) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = entrustOrderUsdtService.add(g_entrustOrderUsdt);
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
    /*@RequiresPermissions("biz:entrustOrderUsdt:update")
    @RequestMapping(value = "toUpdate")
    public String toUpdate(HttpServletRequest request, HttpServletResponse response, Model model, java.lang.String entrustOrderId) throws Exception {
        model.addAttribute("item", entrustOrderUsdtService.get(entrustOrderId));
        return "modules/biz/entrustOrderUsdtUpdate";
    }*/

    /**
     * 修改
     */
    /*@RequiresPermissions("biz:entrustOrderUsdt:update")
    @RequestMapping(value = "update")
    @ResponseBody
    public Map<String, Object> update(HttpServletRequest request, HttpServletResponse response, Model model,
                         @FormModel("g_entrustOrderUsdt") GEntrustOrderUsdt g_entrustOrderUsdt) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = entrustOrderUsdtService.update(g_entrustOrderUsdt);
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
    /*@RequiresPermissions("biz:entrustOrderUsdt:delete")
    @RequestMapping(value = "delete")
    @ResponseBody
    public Map<String, Object> delete(HttpServletRequest request, HttpServletResponse response, Model model,
                         java.lang.String entrustOrderId) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = entrustOrderUsdtService.delete(entrustOrderId);
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
    @RequiresPermissions("biz:entrustOrderUsdt:view")
    @RequestMapping(value = "info")
    public String info(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam(name = "id") String entrustOrderId) throws Exception {
        model.addAttribute("item", entrustOrderUsdtService.get(request,entrustOrderId));
        return "modules/biz/entrustOrderUsdtInfo";
    }
}
