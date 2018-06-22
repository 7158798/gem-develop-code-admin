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
import com.manage.biz.entity.GCurrencyCirculateStatistics;
import com.manage.biz.service.GCurrencyCirculateStatisticsService;
import com.manage.biz.vo.GCurrencyCirculateStatisticsVO;




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
@RequestMapping(value = "${adminPath}/bus/g_currency_circulate_statistics")
public class GCurrencyCirculateStatisticsController{
	private static final Log log = LogFactory.getLog(GCurrencyCirculateStatisticsController.class);

    @Resource(name = "GCurrencyCirculateStatisticsService")
    private GCurrencyCirculateStatisticsService g_currency_circulate_statistics_service;

	/**
     * 去分页
     */
    @RequiresPermissions("bus:g_currency_circulate_statistics:view")
    @RequestMapping(value = "toList")
    public String toList(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
    	return "modules/bus/g_currency_circulate_statisticsList";
    }
    /**
     * 分页
     */
    @RequiresPermissions("bus:g_currency_circulate_statistics:view")
    @RequestMapping(value = "list")
    @ResponseBody
    public Map<String, Object> list(HttpServletRequest request, HttpServletResponse response, Model model,
                       @FormModel("g_currency_circulate_statistics_vo") GCurrencyCirculateStatisticsVO g_currency_circulate_statistics_vo) throws Exception {
        if (g_currency_circulate_statistics_vo == null) {
            g_currency_circulate_statistics_vo = new GCurrencyCirculateStatisticsVO();
        }
        if (request.getParameter("page") != null) {
            g_currency_circulate_statistics_vo.setPage(Integer.parseInt(request.getParameter("page")));
        }if (request.getParameter("rows") != null) {
            g_currency_circulate_statistics_vo.setRows(Integer.parseInt(request.getParameter("rows")));
        }
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	PageInfo pageInfo = g_currency_circulate_statistics_service.selectPage(request,g_currency_circulate_statistics_vo);
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
    @RequiresPermissions("bus:g_currency_circulate_statistics:add")
    @RequestMapping(value = "toAdd")
    public String toAdd(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
        return "modules/bus/g_currency_circulate_statisticsAdd";
    }

    /**
     * 新增
     */
    @RequiresPermissions("bus:g_currency_circulate_statistics:add")
    @RequestMapping(value = "add")
    @ResponseBody
    public Map<String, Object> add(HttpServletRequest request, HttpServletResponse response, Model model,
                      @FormModel("g_currency_circulate_statistics") GCurrencyCirculateStatistics g_currency_circulate_statistics) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = g_currency_circulate_statistics_service.add(request,g_currency_circulate_statistics);
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
    @RequiresPermissions("bus:g_currency_circulate_statistics:update")
    @RequestMapping(value = "toUpdate")
    public String toUpdate(HttpServletRequest request, HttpServletResponse response0, Model model, @RequestParam(name = "id") String volume_id) throws Exception {
        model.addAttribute("item", g_currency_circulate_statistics_service.get(request,volume_id));
        return "modules/bus/g_currency_circulate_statisticsUpdate";
    }

    /**
     * 修改
     */
    @RequiresPermissions("bus:g_currency_circulate_statistics:update")
    @RequestMapping(value = "update")
    @ResponseBody
    public Map<String, Object> update(HttpServletRequest request, HttpServletResponse response, Model model,
                         @FormModel("g_currency_circulate_statistics") GCurrencyCirculateStatistics g_currency_circulate_statistics) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = g_currency_circulate_statistics_service.update(request,g_currency_circulate_statistics);
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
    @RequiresPermissions("bus:g_currency_circulate_statistics:delete")
    @RequestMapping(value = "delete")
    @ResponseBody
    public Map<String, Object> delete(HttpServletRequest request, HttpServletResponse response, Model model,
                         @RequestParam(name = "id") String volume_id) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = g_currency_circulate_statistics_service.delete(request,volume_id);
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
    @RequiresPermissions("bus:g_currency_circulate_statistics:view")
    @RequestMapping(value = "info")
    public String info(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam(name = "id") String volume_id) throws Exception {
        model.addAttribute("item", g_currency_circulate_statistics_service.get(request,volume_id));
        return "modules/bus/g_currency_circulate_statisticsInfo";
    }
}
