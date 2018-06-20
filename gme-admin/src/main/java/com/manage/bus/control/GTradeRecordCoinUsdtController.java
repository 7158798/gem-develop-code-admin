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
import com.manage.bus.entity.GTradeRecordCoinUsdt;
import com.manage.bus.service.GTradeRecordCoinUsdtService;
import com.manage.bus.vo.GTradeRecordCoinUsdtVO;
/**
 * 委托交易记录表（g_trade_record_coin_usdt）控制类
 */
@Controller
@RequestMapping(value = "${adminPath}/bus/g_trade_record_coin_usdt")
public class GTradeRecordCoinUsdtController{
	private static final Log log = LogFactory.getLog(GTradeRecordCoinUsdtController.class);

    @Resource(name = "GTradeRecordCoinUsdtService")
    private GTradeRecordCoinUsdtService g_trade_record_coin_usdt_service;

	/**
     * 去分页
     */
    @RequiresPermissions("bus:g_trade_record_coin_usdt:view")
    @RequestMapping(value = "toList")
    public String toList(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
    	return "modules/bus/g_trade_record_coin_usdtList";
    }
    /**
     * 分页
     */
    @RequiresPermissions("bus:g_trade_record_coin_usdt:view")
    @RequestMapping(value = "list")
    @ResponseBody
    public Map<String, Object> list(HttpServletRequest request, HttpServletResponse response, Model model,
                       @FormModel("g_trade_record_coin_usdt_vo") GTradeRecordCoinUsdtVO g_trade_record_coin_usdt_vo) throws Exception {
        if (g_trade_record_coin_usdt_vo == null) {
            g_trade_record_coin_usdt_vo = new GTradeRecordCoinUsdtVO();
        }
        if (request.getParameter("page") != null) {
            g_trade_record_coin_usdt_vo.setPage(Integer.parseInt(request.getParameter("page")));
        }if (request.getParameter("rows") != null) {
            g_trade_record_coin_usdt_vo.setRows(Integer.parseInt(request.getParameter("rows")));
        }
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	PageInfo pageInfo = g_trade_record_coin_usdt_service.selectPage(request,g_trade_record_coin_usdt_vo);
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
    /*@RequiresPermissions("bus:g_trade_record_coin_usdt:add")
    @RequestMapping(value = "toAdd")
    public String toAdd(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
        return "modules/bus/g_trade_record_coin_usdtAdd";
    }*/

    /**
     * 新增
     */
    /*@RequiresPermissions("bus:g_trade_record_coin_usdt:add")
    @RequestMapping(value = "add")
    @ResponseBody
    public Map<String, Object> add(HttpServletRequest request, HttpServletResponse response, Model model,
                      @FormModel("g_trade_record_coin_usdt") GTradeRecordCoinUsdt g_trade_record_coin_usdt) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = g_trade_record_coin_usdt_service.add(g_trade_record_coin_usdt);
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
    /*@RequiresPermissions("bus:g_trade_record_coin_usdt:update")
    @RequestMapping(value = "toUpdate")
    public String toUpdate(HttpServletRequest request, HttpServletResponse response, Model model, java.lang.String id) throws Exception {
        model.addAttribute("item", g_trade_record_coin_usdt_service.get(id));
        return "modules/bus/g_trade_record_coin_usdtUpdate";
    }*/

    /**
     * 修改
     */
    /*@RequiresPermissions("bus:g_trade_record_coin_usdt:update")
    @RequestMapping(value = "update")
    @ResponseBody
    public Map<String, Object> update(HttpServletRequest request, HttpServletResponse response, Model model,
                         @FormModel("g_trade_record_coin_usdt") GTradeRecordCoinUsdt g_trade_record_coin_usdt) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = g_trade_record_coin_usdt_service.update(g_trade_record_coin_usdt);
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
    /*@RequiresPermissions("bus:g_trade_record_coin_usdt:delete")
    @RequestMapping(value = "delete")
    @ResponseBody
    public Map<String, Object> delete(HttpServletRequest request, HttpServletResponse response, Model model,
                         java.lang.String id) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = g_trade_record_coin_usdt_service.delete(id);
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
    @RequiresPermissions("bus:g_trade_record_coin_usdt:view")
    @RequestMapping(value = "info")
    public String info(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam(name = "id") String id) throws Exception {
        model.addAttribute("item", g_trade_record_coin_usdt_service.get(request,id));
        return "modules/bus/g_trade_record_coin_usdtInfo";
    }
}
