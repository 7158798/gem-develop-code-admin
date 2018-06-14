package com.manage.bus.control;

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
import com.manage.bus.entity.GCurrencyTradePair;
import com.manage.bus.service.GCurrencyTradePairService;
import com.manage.bus.vo.GCurrencyTradePairVO;
/**
 * 币种交易对表控制类
 */
@Controller
@RequestMapping(value = "${adminPath}/bus/g_currency_trade_pair")
public class GCurrencyTradePairController{
	private static final Log log = LogFactory.getLog(GCurrencyTradePairController.class);

    @Resource(name = "GCurrencyTradePairService")
    private GCurrencyTradePairService g_currency_trade_pair_service;

	/**
     * 去分页
     */
    @RequiresPermissions("bus:g_currency_trade_pair:view")
    @RequestMapping(value = "toList")
    public String toList(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
    	return "modules/bus/g_currency_trade_pairList";
    }
    /**
     * 分页
     */
    @RequiresPermissions("bus:g_currency_trade_pair:view")
    @RequestMapping(value = "list")
    @ResponseBody
    public Map<String, Object> list(HttpServletRequest request, HttpServletResponse response, Model model,
    		@FormModel("g_currency_trade_pair_vo") GCurrencyTradePairVO g_currency_trade_pair_vo) throws Exception {
        if (g_currency_trade_pair_vo == null) {
            g_currency_trade_pair_vo = new GCurrencyTradePairVO();
        }
        if (request.getParameter("page") != null) {
            g_currency_trade_pair_vo.setPage(Integer.parseInt(request.getParameter("page")));
        }if (request.getParameter("rows") != null) {
            g_currency_trade_pair_vo.setRows(Integer.parseInt(request.getParameter("rows")));
        }
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	PageInfo pageInfo = g_currency_trade_pair_service.selectPage(request,g_currency_trade_pair_vo);
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
    @RequiresPermissions("bus:g_currency_trade_pair:add")
    @RequestMapping(value = "toAdd")
    public String toAdd(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
        return "modules/bus/g_currency_trade_pairAdd";
    }

    /**
     * 新增
     */
    @RequiresPermissions("bus:g_currency_trade_pair:add")
    @RequestMapping(value = "add")
    @ResponseBody
    public Map<String, Object> add(HttpServletRequest request, HttpServletResponse response, Model model,
                      @FormModel("g_currency_trade_pair") GCurrencyTradePair g_currency_trade_pair) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = g_currency_trade_pair_service.add(request,g_currency_trade_pair);
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
    @RequiresPermissions("bus:g_currency_trade_pair:update")
    @RequestMapping(value = "toUpdate")
    public String toUpdate(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam(name = "id") String pair_id) throws Exception {
        model.addAttribute("item", g_currency_trade_pair_service.get(request,pair_id));
        return "modules/bus/g_currency_trade_pairUpdate";
    }

    /**
     * 修改
     */
    @RequiresPermissions("bus:g_currency_trade_pair:update")
    @RequestMapping(value = "update")
    @ResponseBody
    public Map<String, Object> update(HttpServletRequest request, HttpServletResponse response, Model model,
                         @FormModel("g_currency_trade_pair") GCurrencyTradePair g_currency_trade_pair) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = g_currency_trade_pair_service.update(request,g_currency_trade_pair);
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
    @RequiresPermissions("bus:g_currency_trade_pair:delete")
    @RequestMapping(value = "delete")
    @ResponseBody
    public Map<String, Object> delete(HttpServletRequest request, HttpServletResponse response, Model model,
    		@RequestParam(name = "id") String pair_id) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = g_currency_trade_pair_service.delete(request,pair_id);
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
    @RequiresPermissions("bus:g_currency_trade_pair:view")
    @RequestMapping(value = "info")
    public String info(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam(name = "id") String pair_id) throws Exception {
        model.addAttribute("item", g_currency_trade_pair_service.get(request,pair_id));
        return "modules/bus/g_currency_trade_pairInfo";
    }
}
