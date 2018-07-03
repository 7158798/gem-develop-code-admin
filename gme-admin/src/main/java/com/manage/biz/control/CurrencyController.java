package com.manage.biz.control;

import java.text.SimpleDateFormat;
import java.util.Date;
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
import org.springframework.web.multipart.MultipartFile;

import com.manage.base.annotation.FormModel;
import com.manage.base.entity.PageBean;
import com.manage.biz.entity.Currency;
import com.manage.biz.service.CurrencyService;
import com.manage.biz.vo.CurrencyVO;



/**
 * 
 * @Project：gme-admin   
 * @Class：GCurrencyController   
 * @Description 类描述：币种管理-币种信息   
 * @Author：zhou   
 * @Date：2018年6月11日 下午9:32:31   
 * @version V1.0
 */
@Controller
@RequestMapping(value = "${adminPath}/biz/currency")
public class CurrencyController{
	private static final Log log = LogFactory.getLog(CurrencyController.class);

    @Resource(name = "CurrencyService")
    private CurrencyService currencyService;

	/**
     * 去分页
     */
    @RequiresPermissions("biz:currency:view")
    @RequestMapping(value = "toList")
    public String toList(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
    	return "modules/biz/currencyList";
    }
    /**
     * 分页
     */
    @RequiresPermissions("biz:currency:view")
    @RequestMapping(value = "list")
    @ResponseBody
    public Map<String, Object> list(HttpServletRequest request, HttpServletResponse response, Model model,
                       @FormModel("currencyVO") CurrencyVO currencyVO) throws Exception {
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	String bgCreateDate = request.getParameter("bgCreateDate");
    	if (null != bgCreateDate && !"".equals(bgCreateDate) && !"null".equals(bgCreateDate)) {
    		Date bgDate = sdf.parse(bgCreateDate);
    		currencyVO.setBgCreateDate(bgDate);
    	}
    	String endCreateDate = request.getParameter("endCreateDate");
    	if (null != endCreateDate && !"".equals(endCreateDate) && !"null".equals(endCreateDate)) {
    		Date endDate = sdf.parse(endCreateDate);
    		currencyVO.setEndCreateDate(endDate);
    	}
    	
        if (currencyVO == null) {
            currencyVO = new CurrencyVO();
        }
        if (request.getParameter("page") != null) {
            currencyVO.setPage(Integer.parseInt(request.getParameter("page")));
        }if (request.getParameter("rows") != null) {
            currencyVO.setRows(Integer.parseInt(request.getParameter("rows")));
        }
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	PageBean pageInfo = currencyService.selectPage(request,currencyVO);
	        jsonMap.put("total", pageInfo.getTotalCount());
	        jsonMap.put("pages", pageInfo.getTotalPageCount());
	        jsonMap.put("rows", pageInfo.getData());
        }catch (Exception e) {
        	log.error("币种管理发生异常",e);
		}
        return jsonMap;
    }

    /**
     * 去新增
     */
    @RequiresPermissions("biz:currency:add")
    @RequestMapping(value = "toAdd")
    public String toAdd(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
        return "modules/biz/currencyAdd";
    }

    /**
     * 新增
     */
    @RequiresPermissions("biz:currency:add")
    @RequestMapping(value = "add")
    @ResponseBody
    public Map<String, Object> add(HttpServletRequest request, HttpServletResponse response, Model model,
                     /*@FormModel("currency") Currency currency*/MultipartFile iconIdImg) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	//boolean result = currencyService.add(request,currency);
        	boolean result = false;
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
    @RequiresPermissions("biz:currency:update")
    @RequestMapping(value = "toUpdate")
    public String toUpdate(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam(name="id") String currencyId) throws Exception {
    	Currency currency = currencyService.get(request,currencyId);
        model.addAttribute("item", currency);
        return "modules/biz/currencyUpdate";
    }

    /**
     * 修改
     */
    @RequiresPermissions("biz:currency:update")
    @RequestMapping(value = "update")
    @ResponseBody
    public Map<String, Object> update(HttpServletRequest request, HttpServletResponse response, Model model,
                         @FormModel("currency") Currency currency) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = currencyService.update(request,currency);
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
    @RequiresPermissions("biz:currency:delete")
    @RequestMapping(value = "delete")
    @ResponseBody
    public Map<String, Object> delete(HttpServletRequest request, HttpServletResponse response, Model model,
                         @RequestParam(name = "id") String currencyId) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = currencyService.delete(request,currencyId);
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
    @RequiresPermissions("biz:currency:view")
    @RequestMapping(value = "info")
    public String info(HttpServletRequest request, HttpServletResponse response, Model model,@RequestParam(name="id") String currencyId) throws Exception {
        model.addAttribute("item", currencyService.get(request,currencyId));
        return "modules/biz/currencyInfo";
    }
}
