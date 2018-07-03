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
import com.manage.biz.service.TradeRecordOtcUsdtService;
import com.manage.biz.vo.TradeRecordOtcUsdtVO;

/**
 * 
 * @Project：gme-admin   
 * @Class：GTradeRecordOtcUsdtController   
 * @Description 类描述：OTC交易记录   
 * @Author：zhou   
 * @Date：2018年6月19日 下午5:16:06   
 * @version V1.0
 */
@Controller
@RequestMapping(value = "${adminPath}/biz/tradeRecordOtcUsdt")
public class TradeRecordOtcUsdtController{
	private static final Log log = LogFactory.getLog(TradeRecordOtcUsdtController.class);

    @Resource(name = "TradeRecordOtcUsdtService")
    private TradeRecordOtcUsdtService tradeRecordOtcUsdtService;

	/**
     * 去分页
     */
    @RequiresPermissions("biz:tradeRecordOtcUsdt:view")
    @RequestMapping(value = "toList")
    public String toList(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
    	return "modules/biz/tradeRecordOtcUsdtList";
    }
    /**
     * 分页
     */
    @RequiresPermissions("biz:tradeRecordOtcUsdt:view")
    @RequestMapping(value = "list")
    @ResponseBody
    public Map<String, Object> list(HttpServletRequest request, HttpServletResponse response, Model model,
                       @FormModel("tradeRecordOtcUsdtVO") TradeRecordOtcUsdtVO tradeRecordOtcUsdtVO) throws Exception {
        if (tradeRecordOtcUsdtVO == null) {
            tradeRecordOtcUsdtVO = new TradeRecordOtcUsdtVO();
        }
        if (request.getParameter("page") != null) {
            tradeRecordOtcUsdtVO.setPage(Integer.parseInt(request.getParameter("page")));
        }if (request.getParameter("rows") != null) {
            tradeRecordOtcUsdtVO.setRows(Integer.parseInt(request.getParameter("rows")));
        }
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	PageBean pageInfo = tradeRecordOtcUsdtService.selectPage(request,tradeRecordOtcUsdtVO);
	        jsonMap.put("total", pageInfo.getTotalCount());
	        jsonMap.put("pages", pageInfo.getTotalPageCount());
	        jsonMap.put("rows", pageInfo.getData());
        }catch (Exception e) {
        	log.error("系统异常",e);
        	e.printStackTrace();
		}
        return jsonMap;
    }

    /**
     * 去新增
     */
   /* @RequiresPermissions("biz:tradeRecordOtcUsdt:add")
    @RequestMapping(value = "toAdd")
    public String toAdd(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
        return "modules/biz/tradeRecordOtcUsdtAdd";
    }*/

    /**
     * 新增
     */
    /*@RequiresPermissions("biz:tradeRecordOtcUsdt:add")
    @RequestMapping(value = "add")
    @ResponseBody
    public Map<String, Object> add(HttpServletRequest request, HttpServletResponse response, Model model,
                      @FormModel("g_tradeRecordOtcUsdt") GTradeRecordOtcUsdt g_tradeRecordOtcUsdt) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = tradeRecordOtcUsdtService.add(g_tradeRecordOtcUsdt);
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
    /*@RequiresPermissions("biz:tradeRecordOtcUsdt:update")
    @RequestMapping(value = "toUpdate")
    public String toUpdate(HttpServletRequest request, HttpServletResponse response, Model model, java.lang.String id) throws Exception {
        model.addAttribute("item", tradeRecordOtcUsdtService.get(id));
        return "modules/biz/tradeRecordOtcUsdtUpdate";
    }*/

    /**
     * 修改
     */
    /*@RequiresPermissions("biz:tradeRecordOtcUsdt:update")
    @RequestMapping(value = "update")
    @ResponseBody
    public Map<String, Object> update(HttpServletRequest request, HttpServletResponse response, Model model,
                         @FormModel("g_tradeRecordOtcUsdt") GTradeRecordOtcUsdt g_tradeRecordOtcUsdt) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = tradeRecordOtcUsdtService.update(g_tradeRecordOtcUsdt);
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
    /*@RequiresPermissions("biz:tradeRecordOtcUsdt:delete")
    @RequestMapping(value = "delete")
    @ResponseBody
    public Map<String, Object> delete(HttpServletRequest request, HttpServletResponse response, Model model,
                         java.lang.String id) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = tradeRecordOtcUsdtService.delete(id);
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
    @RequiresPermissions("biz:tradeRecordOtcUsdt:view")
    @RequestMapping(value = "info")
    public String info(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam(name = "id") String id) throws Exception {
        model.addAttribute("item", tradeRecordOtcUsdtService.get(request,id));
        return "modules/biz/tradeRecordOtcUsdtInfo";
    }
}
