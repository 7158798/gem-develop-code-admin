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
import com.manage.biz.entity.CurrencyTradePair;
import com.manage.biz.service.CurrencyTradePairService;
import com.manage.biz.vo.CurrencyTradePairVO;
/**
 * 币种交易对表控制类
 */
@Controller
@RequestMapping(value = "${adminPath}/biz/currencyTradePair")
public class CurrencyTradePairController{
	private static final Log log = LogFactory.getLog(CurrencyTradePairController.class);

    @Resource(name = "CurrencyTradePairService")
    private CurrencyTradePairService currencyTradePairService;

	/**
     * 去分页
     */
    @RequiresPermissions("biz:currencyTradePair:view")
    @RequestMapping(value = "toList")
    public String toList(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
    	return "modules/biz/currencyTradePairList";
    }
    /**
     * 分页
     */
    @RequiresPermissions("biz:currencyTradePair:view")
    @RequestMapping(value = "list")
    @ResponseBody
    public Map<String, Object> list(HttpServletRequest request, HttpServletResponse response, Model model,
    		@FormModel("currencyTradePairVO") CurrencyTradePairVO currencyTradePairVO) throws Exception {
        if (currencyTradePairVO == null) {
            currencyTradePairVO = new CurrencyTradePairVO();
        }
        if (request.getParameter("page") != null) {
            currencyTradePairVO.setPage(Integer.parseInt(request.getParameter("page")));
        }if (request.getParameter("rows") != null) {
            currencyTradePairVO.setRows(Integer.parseInt(request.getParameter("rows")));
        }
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	PageBean pageInfo = currencyTradePairService.selectPage(request,currencyTradePairVO);
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
    @RequiresPermissions("biz:currencyTradePair:add")
    @RequestMapping(value = "toAdd")
    public String toAdd(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
        return "modules/biz/currencyTradePairAdd";
    }

    /**
     * 新增
     */
    @RequiresPermissions("biz:currencyTradePair:add")
    @RequestMapping(value = "add")
    @ResponseBody
    public Map<String, Object> add(HttpServletRequest request, HttpServletResponse response, Model model,
                      @FormModel("currencyTradePair") CurrencyTradePair currencyTradePair) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = currencyTradePairService.add(request,currencyTradePair);
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
    @RequiresPermissions("biz:currencyTradePair:update")
    @RequestMapping(value = "toUpdate")
    public String toUpdate(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam(name = "id") String pairId) throws Exception {
        model.addAttribute("item", currencyTradePairService.get(request,pairId));
        return "modules/biz/currencyTradePairUpdate";
    }

    /**
     * 修改
     */
    @RequiresPermissions("biz:currencyTradePair:update")
    @RequestMapping(value = "update")
    @ResponseBody
    public Map<String, Object> update(HttpServletRequest request, HttpServletResponse response, Model model,
                         @FormModel("currencyTradePair") CurrencyTradePair currencyTradePair) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = currencyTradePairService.update(request,currencyTradePair);
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
    @RequiresPermissions("biz:currencyTradePair:delete")
    @RequestMapping(value = "delete")
    @ResponseBody
    public Map<String, Object> delete(HttpServletRequest request, HttpServletResponse response, Model model,
    		@RequestParam(name = "id") String pairId) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = currencyTradePairService.delete(request,pairId);
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
    @RequiresPermissions("biz:currencyTradePair:view")
    @RequestMapping(value = "info")
    public String info(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam(name = "id") String pairId) throws Exception {
        model.addAttribute("item", currencyTradePairService.get(request,pairId));
        return "modules/biz/currencyTradePairInfo";
    }
}
