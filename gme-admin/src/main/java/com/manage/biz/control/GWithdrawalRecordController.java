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
import com.manage.biz.entity.GWithdrawalRecord;
import com.manage.biz.service.GWithdrawalRecordService;
import com.manage.biz.vo.GWithdrawalRecordVO;
/**
 * 钱包提现记录表（withdrawalRecord）
功能描述：存储钱包提现记录信息。
控制类
 */
@Controller
@RequestMapping(value = "${adminPath}/biz/withdrawalRecord")
public class GWithdrawalRecordController{
	private static final Log log = LogFactory.getLog(GWithdrawalRecordController.class);

    @Resource(name = "GWithdrawalRecordService")
    private GWithdrawalRecordService withdrawalRecordService;

	/**
     * 去分页
     */
    @RequiresPermissions("biz:withdrawalRecord:view")
    @RequestMapping(value = "toList")
    public String toList(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
    	return "modules/biz/withdrawalRecordList";
    }
    /**
     * 分页
     */
    @RequiresPermissions("biz:withdrawalRecord:view")
    @RequestMapping(value = "list")
    @ResponseBody
    public Map<String, Object> list(HttpServletRequest request, HttpServletResponse response, Model model,
                       @FormModel("withdrawalRecordVO") GWithdrawalRecordVO withdrawalRecordVO) throws Exception {
        if (withdrawalRecordVO == null) {
            withdrawalRecordVO = new GWithdrawalRecordVO();
        }
        if (request.getParameter("page") != null) {
            withdrawalRecordVO.setPage(Integer.parseInt(request.getParameter("page")));
        }if (request.getParameter("rows") != null) {
            withdrawalRecordVO.setRows(Integer.parseInt(request.getParameter("rows")));
        }
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	PageBean pageInfo = withdrawalRecordService.selectPage(request,withdrawalRecordVO);
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
  /*  @RequiresPermissions("biz:withdrawalRecord:add")
    @RequestMapping(value = "toAdd")
    public String toAdd(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
        return "modules/biz/withdrawalRecordAdd";
    }*/

    /**
     * 新增
     */
   /* @RequiresPermissions("biz:withdrawalRecord:add")
    @RequestMapping(value = "add")
    @ResponseBody
    public Map<String, Object> add(HttpServletRequest request, HttpServletResponse response, Model model,
                      @FormModel("withdrawalRecord") GWithdrawalRecord withdrawalRecord) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = withdrawalRecordService.add(withdrawalRecord);
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
    @RequiresPermissions("biz:withdrawalRecord:update")
    @RequestMapping(value = "toUpdate")
    public String toUpdate(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam(name="id") String id) throws Exception {
        model.addAttribute("item", withdrawalRecordService.get(request,id));
        return "modules/biz/withdrawalRecordUpdate";
    }

    /**
     * 修改
     */
    @RequiresPermissions("biz:withdrawalRecord:update")
    @RequestMapping(value = "update")
    @ResponseBody
    public Map<String, Object> update(HttpServletRequest request, HttpServletResponse response, Model model,
                         @FormModel("withdrawalRecord") GWithdrawalRecord withdrawalRecord) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = withdrawalRecordService.update(request,withdrawalRecord);
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
    /*@RequiresPermissions("biz:withdrawalRecord:delete")
    @RequestMapping(value = "delete")
    @ResponseBody
    public Map<String, Object> delete(HttpServletRequest request, HttpServletResponse response, Model model,
                         java.lang.String id) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = withdrawalRecordService.delete(id);
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
    @RequiresPermissions("biz:withdrawalRecord:view")
    @RequestMapping(value = "info")
    public String info(HttpServletRequest request, HttpServletResponse response, Model model,@RequestParam(name="id") String id) throws Exception {
        model.addAttribute("item", withdrawalRecordService.get(request,id));
        return "modules/biz/withdrawalRecordInfo";
    }
}
