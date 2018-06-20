package com.manage.bus.control;

import java.sql.Timestamp;
import com.manage.base.annotation.FormModel;
import com.manage.base.entity.PageInfo;
import com.manage.bus.entity.GEntrustOrderUsdt;
import com.manage.bus.vo.GEntrustOrderUsdtVO;
import com.manage.bus.service.GEntrustOrderUsdtService;
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
 * 委托订单表（g_entrust_order_usdt）
功能描述：存储币币交易的委托单历史记录。每个交易区生成一张委托订单表。entrust_order_id
控制类
 */
@Controller
@RequestMapping(value = "${adminPath}/bus/g_entrust_order_usdt")
public class GEntrustOrderUsdtController{
	private static final Log log = LogFactory.getLog(GEntrustOrderUsdtController.class);

    @Resource(name = "GEntrustOrderUsdtService")
    private GEntrustOrderUsdtService g_entrust_order_usdt_service;

	/**
     * 去分页
     */
    @RequiresPermissions("bus:g_entrust_order_usdt:view")
    @RequestMapping(value = "toList")
    public String toList(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
    	return "modules/bus/g_entrust_order_usdtList";
    }
    /**
     * 分页
     */
    @RequiresPermissions("bus:g_entrust_order_usdt:view")
    @RequestMapping(value = "list")
    @ResponseBody
    public Map<String, Object> list(HttpServletRequest request, HttpServletResponse response, Model model,
                       @FormModel("g_entrust_order_usdt_vo") GEntrustOrderUsdtVO g_entrust_order_usdt_vo) throws Exception {
        if (g_entrust_order_usdt_vo == null) {
            g_entrust_order_usdt_vo = new GEntrustOrderUsdtVO();
        }
        if (request.getParameter("page") != null) {
            g_entrust_order_usdt_vo.setPage(Integer.parseInt(request.getParameter("page")));
        }if (request.getParameter("rows") != null) {
            g_entrust_order_usdt_vo.setRows(Integer.parseInt(request.getParameter("rows")));
        }
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	PageInfo pageInfo = g_entrust_order_usdt_service.selectPage(request,g_entrust_order_usdt_vo);
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
   /* @RequiresPermissions("bus:g_entrust_order_usdt:add")
    @RequestMapping(value = "toAdd")
    public String toAdd(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
        return "modules/bus/g_entrust_order_usdtAdd";
    }*/

    /**
     * 新增
     */
    /*@RequiresPermissions("bus:g_entrust_order_usdt:add")
    @RequestMapping(value = "add")
    @ResponseBody
    public Map<String, Object> add(HttpServletRequest request, HttpServletResponse response, Model model,
                      @FormModel("g_entrust_order_usdt") GEntrustOrderUsdt g_entrust_order_usdt) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = g_entrust_order_usdt_service.add(g_entrust_order_usdt);
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
    /*@RequiresPermissions("bus:g_entrust_order_usdt:update")
    @RequestMapping(value = "toUpdate")
    public String toUpdate(HttpServletRequest request, HttpServletResponse response, Model model, java.lang.String entrust_order_id) throws Exception {
        model.addAttribute("item", g_entrust_order_usdt_service.get(entrust_order_id));
        return "modules/bus/g_entrust_order_usdtUpdate";
    }*/

    /**
     * 修改
     */
    /*@RequiresPermissions("bus:g_entrust_order_usdt:update")
    @RequestMapping(value = "update")
    @ResponseBody
    public Map<String, Object> update(HttpServletRequest request, HttpServletResponse response, Model model,
                         @FormModel("g_entrust_order_usdt") GEntrustOrderUsdt g_entrust_order_usdt) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = g_entrust_order_usdt_service.update(g_entrust_order_usdt);
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
    /*@RequiresPermissions("bus:g_entrust_order_usdt:delete")
    @RequestMapping(value = "delete")
    @ResponseBody
    public Map<String, Object> delete(HttpServletRequest request, HttpServletResponse response, Model model,
                         java.lang.String entrust_order_id) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = g_entrust_order_usdt_service.delete(entrust_order_id);
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
    @RequiresPermissions("bus:g_entrust_order_usdt:view")
    @RequestMapping(value = "info")
    public String info(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam(name = "id") String entrust_order_id) throws Exception {
        model.addAttribute("item", g_entrust_order_usdt_service.get(request,entrust_order_id));
        return "modules/bus/g_entrust_order_usdtInfo";
    }
}
