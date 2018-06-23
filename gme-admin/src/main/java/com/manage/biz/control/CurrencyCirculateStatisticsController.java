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
import com.manage.biz.entity.CurrencyCirculateStatistics;
import com.manage.biz.service.CurrencyCirculateStatisticsService;
import com.manage.biz.vo.CurrencyCirculateStatisticsVO;


/**
 * 
 * @Project：gme-admin   
 * @Class：GCurrencyCirculateStatisticsController   
 * @Description 类描述：币种管理-币种流通统计   
 * @Author：zhou   
 * @Date：2018年6月11日 下午9:28:30   
 * @version V1.0
 */
@Controller
@RequestMapping(value = "${adminPath}/biz/currencyCirculateStatistics")
public class CurrencyCirculateStatisticsController{
	private static final Log log = LogFactory.getLog(CurrencyCirculateStatisticsController.class);

    @Resource(name = "CurrencyCirculateStatisticsService")
    private CurrencyCirculateStatisticsService currencyCirculateStatisticsService;

	/**
     * 去分页
     */
    @RequiresPermissions("biz:currencyCirculateStatistics:view")
    @RequestMapping(value = "toList")
    public String toList(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
    	return "modules/biz/currencyCirculateStatisticsList";
    }
    /**
     * 分页
     */
    @RequiresPermissions("biz:currencyCirculateStatistics:view")
    @RequestMapping(value = "list")
    @ResponseBody
    public Map<String, Object> list(HttpServletRequest request, HttpServletResponse response, Model model,
                       @FormModel("currencyCirculateStatisticsVO") CurrencyCirculateStatisticsVO currencyCirculateStatisticsVO) throws Exception {
        if (currencyCirculateStatisticsVO == null) {
            currencyCirculateStatisticsVO = new CurrencyCirculateStatisticsVO();
        }
        if (request.getParameter("page") != null) {
            currencyCirculateStatisticsVO.setPage(Integer.parseInt(request.getParameter("page")));
        }if (request.getParameter("rows") != null) {
            currencyCirculateStatisticsVO.setRows(Integer.parseInt(request.getParameter("rows")));
        }
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	PageInfo pageInfo = currencyCirculateStatisticsService.selectPage(request,currencyCirculateStatisticsVO);
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
    @RequiresPermissions("biz:currencyCirculateStatistics:add")
    @RequestMapping(value = "toAdd")
    public String toAdd(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
        return "modules/biz/currencyCirculateStatisticsAdd";
    }

    /**
     * 新增
     */
    @RequiresPermissions("biz:currencyCirculateStatistics:add")
    @RequestMapping(value = "add")
    @ResponseBody
    public Map<String, Object> add(HttpServletRequest request, HttpServletResponse response, Model model,
                      @FormModel("currencyCirculateStatistics") CurrencyCirculateStatistics currencyCirculateStatistics) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = currencyCirculateStatisticsService.add(request,currencyCirculateStatistics);
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
    @RequiresPermissions("biz:currencyCirculateStatistics:update")
    @RequestMapping(value = "toUpdate")
    public String toUpdate(HttpServletRequest request, HttpServletResponse response0, Model model, @RequestParam(name = "id") String volumeId) throws Exception {
        model.addAttribute("item", currencyCirculateStatisticsService.get(request,volumeId));
        return "modules/biz/currencyCirculateStatisticsUpdate";
    }

    /**
     * 修改
     */
    @RequiresPermissions("biz:currencyCirculateStatistics:update")
    @RequestMapping(value = "update")
    @ResponseBody
    public Map<String, Object> update(HttpServletRequest request, HttpServletResponse response, Model model,
                         @FormModel("currencyCirculateStatistics") CurrencyCirculateStatistics currencyCirculateStatistics) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = currencyCirculateStatisticsService.update(request,currencyCirculateStatistics);
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
    @RequiresPermissions("biz:currencyCirculateStatistics:delete")
    @RequestMapping(value = "delete")
    @ResponseBody
    public Map<String, Object> delete(HttpServletRequest request, HttpServletResponse response, Model model,
                         @RequestParam(name = "id") String volumeId) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = currencyCirculateStatisticsService.delete(request,volumeId);
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
    @RequiresPermissions("biz:currencyCirculateStatistics:view")
    @RequestMapping(value = "info")
    public String info(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam(name = "id") String volumeId) throws Exception {
        model.addAttribute("item", currencyCirculateStatisticsService.get(request,volumeId));
        return "modules/biz/currencyCirculateStatisticsInfo";
    }
}
