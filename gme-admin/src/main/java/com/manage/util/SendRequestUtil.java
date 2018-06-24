package com.manage.util;

import com.alibaba.fastjson.JSON;
import com.manage.util.net.CommonUtil;
import com.manage.util.net.JsonUtil;
import com.manage.util.net.modle.ResultJson;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/*
 * @Author zhou
 * @Date 2018/5/28 14:18
 * @Desc 发送请求到后台
 */
public class SendRequestUtil {

    private static Logger logger = Logger.getLogger(SendRequestUtil.class);
    
    
    /**
     * 
     * @Title: sendRequestReceiveResponse
     * @Description: TODO 封装发送http请求到admin-web,接收返回的响应
     * @param @param request
     * @param @param map
     * @param @param method
     * @param @return
     * @return ResponseResult
     * @throws
     */
    public static ResponseResult sendRequestReceiveResponse(HttpServletRequest request,Map<String,Object> map,String method){
    	try {
    		String json = SendRequestUtil.sendMapRequest(request, map, method);
    		if (null != json) {
    			ResponseResult responseResult = JSON.parseObject(json, ResponseResult.class);
    			if (null != responseResult && responseResult.getCode().equals("200")) {
    				return responseResult;
    			}
    			return null;
    		}else {
    			return null;
    		}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }
    
    
    

    // 发送带有java pojo参数的post请求
    public static String sendPojoRequest(HttpServletRequest request, Object object, String method) {
        String data = JsonUtil.getJsonStringJavaPOJO(object);
        ResultJson resultJson = null;
        try {
            resultJson = CommonUtil.getResultJson(data, request, method);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            logger.error("发送请求失败:" + e.getMessage());
        }
        if (null == resultJson) {
            return null;
        }
        return resultJson.getData().toString();

    }

    // 发送带有map参数的post请求
    public static String sendMapRequest (HttpServletRequest request, Map map, String method){
        String data = JsonUtil.mapToJson(map);
        ResultJson resultJson = null;
        try {
            resultJson = CommonUtil.getResultJson(data, request, method);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            logger.error("发送请求失败:" + e.toString());
        }
        if (null == resultJson.getData()) {
            return null;
        }
        return resultJson.getData().toString();
    }
    

    // 发送没有参数的post请求 直接转发,不做任何处理
    public static String sendRequest(HttpServletRequest request, String method){
        ResultJson resultJson = null;
        try {
            resultJson = CommonUtil.getResultJson(request, method);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            logger.error("发送请求失败:" + e.getMessage());
        }
        if (null == resultJson) {
            return null;
        }
        return resultJson.getData().toString();
    }

}
