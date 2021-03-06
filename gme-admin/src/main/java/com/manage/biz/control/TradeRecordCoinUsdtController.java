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
import com.manage.biz.service.TradeRecordCoinUsdtService;
import com.manage.biz.vo.TradeRecordCoinUsdtVO;
/**
 * 委托交易记录表（g_tradeRecordCoinUsdt）控制类
 */
@Controller
@RequestMapping(value = "${adminPath}/biz/tradeRecordCoinUsdt")
public class TradeRecordCoinUsdtController{
	private static final Log log = LogFactory.getLog(TradeRecordCoinUsdtController.class);

    @Resource(name = "TradeRecordCoinUsdtService")
    private TradeRecordCoinUsdtService tradeRecordCoinUsdtService;

	/**
     * 去分页
     */
    @RequiresPermissions("biz:tradeRecordCoinUsdt:view")
    @RequestMapping(value = "toList")
    public String toList(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
    	return "modules/biz/tradeRecordCoinUsdtList";
    }
    /**
     * 分页
     */
    @RequiresPermissions("biz:tradeRecordCoinUsdt:view")
    @RequestMapping(value = "list")
    @ResponseBody
    public Map<String, Object> list(HttpServletRequest request, HttpServletResponse response, Model model,
                       @FormModel("tradeRecordCoinUsdtVO") TradeRecordCoinUsdtVO tradeRecordCoinUsdtVO) throws Exception {
        if (tradeRecordCoinUsdtVO == null) {
            tradeRecordCoinUsdtVO = new TradeRecordCoinUsdtVO();
        }
        if (request.getParameter("page") != null) {
            tradeRecordCoinUsdtVO.setPage(Integer.parseInt(request.getParameter("page")));
        }if (request.getParameter("rows") != null) {
            tradeRecordCoinUsdtVO.setRows(Integer.parseInt(request.getParameter("rows")));
        }
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	PageBean pageInfo = tradeRecordCoinUsdtService.selectPage(request,tradeRecordCoinUsdtVO);
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
    /*@RequiresPermissions("biz:tradeRecordCoinUsdt:add")
    @RequestMapping(value = "toAdd")
    public String toAdd(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
        return "modules/biz/tradeRecordCoinUsdtAdd";
    }*/

    /**
     * 新增
     */
    /*@RequiresPermissions("biz:tradeRecordCoinUsdt:add")
    @RequestMapping(value = "add")
    @ResponseBody
    public Map<String, Object> add(HttpServletRequest request, HttpServletResponse response, Model model,
                      @FormModel("g_tradeRecordCoinUsdt") GTradeRecordCoinUsdt g_tradeRecordCoinUsdt) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = tradeRecordCoinUsdtService.add(g_tradeRecordCoinUsdt);
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
    /*@RequiresPermissions("biz:tradeRecordCoinUsdt:update")
    @RequestMapping(value = "toUpdate")
    public String toUpdate(HttpServletRequest request, HttpServletResponse response, Model model, java.lang.String id) throws Exception {
        model.addAttribute("item", tradeRecordCoinUsdtService.get(id));
        return "modules/biz/tradeRecordCoinUsdtUpdate";
    }*/

    /**
     * 修改
     */
    /*@RequiresPermissions("biz:tradeRecordCoinUsdt:update")
    @RequestMapping(value = "update")
    @ResponseBody
    public Map<String, Object> update(HttpServletRequest request, HttpServletResponse response, Model model,
                         @FormModel("g_tradeRecordCoinUsdt") GTradeRecordCoinUsdt g_tradeRecordCoinUsdt) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = tradeRecordCoinUsdtService.update(g_tradeRecordCoinUsdt);
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
    /*@RequiresPermissions("biz:tradeRecordCoinUsdt:delete")
    @RequestMapping(value = "delete")
    @ResponseBody
    public Map<String, Object> delete(HttpServletRequest request, HttpServletResponse response, Model model,
                         java.lang.String id) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = tradeRecordCoinUsdtService.delete(id);
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
    @RequiresPermissions("biz:tradeRecordCoinUsdt:view")
    @RequestMapping(value = "info")
    public String info(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam(name = "id") String id) throws Exception {
        model.addAttribute("item", tradeRecordCoinUsdtService.get(request,id));
        return "modules/biz/tradeRecordCoinUsdtInfo";
    }
}
