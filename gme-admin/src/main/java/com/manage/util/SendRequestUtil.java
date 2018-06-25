package com.manage.util;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.manage.util.net.CommonUtil;
import com.manage.util.net.JsonUtil;
import com.manage.util.net.modle.ResultJson;

/*
 * @Author zhou
 * @Date 2018/5/28 14:18
 * @Desc 发送请求到后台
 */
public class SendRequestUtil {


	private static final Logger log = LoggerFactory.getLogger(SendRequestUtil.class);
	
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
	public static ResponseResult sendRequestReceiveResponse(HttpServletRequest request, Map<String, Object> map,String method) {
		try {
			String json = SendRequestUtil.sendMapRequest(request, map, method);
			if (null != json) {
				// 将后台web返回的json转成结果对象
				ResponseResult responseResult = JSON.parseObject(json, ResponseResult.class);
				if (null != responseResult) {
					if (responseResult.getCode().equals("200")) {
						return responseResult;
					} else {
						log.info("====>后台web返回 code:" + responseResult.getCode() + ",message:"
								+ responseResult.getMessage());
						return null;
					}
				}
			}
		} catch (Exception e) {
			log.error("{} 后台web返回数据格式错误.",e);
			return null;
		}
		return null;
	}

	// 发送带有java pojo参数的post请求
	public static String sendPojoRequest(HttpServletRequest request, Object object, String method) {
		String data = JsonUtil.getJsonStringJavaPOJO(object);
		ResultJson resultJson = null;
		try {
			resultJson = CommonUtil.getResultJson(data, request, method);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			log.error("发送请求失败:" + e.getMessage());
		}
		if (null == resultJson) {
			return null;
		}
		return resultJson.getData().toString();

	}

	// 发送带有map参数的post请求
	public static String sendMapRequest(HttpServletRequest request, Map map, String method) {
		String data = JsonUtil.mapToJson(map);
		ResultJson resultJson = null;
		try {
			resultJson = CommonUtil.getResultJson(data, request, method);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			log.error("发送请求失败:" + e.toString());
		}
		if (null == resultJson.getData()) {
			return null;
		}
		return resultJson.getData().toString();
	}

	// 发送没有参数的post请求 直接转发,不做任何处理
	public static String sendRequest(HttpServletRequest request, String method) {
		ResultJson resultJson = null;
		try {
			resultJson = CommonUtil.getResultJson(request, method);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			log.error("发送请求失败:" + e.getMessage());
		}
		if (null == resultJson) {
			return null;
		}
		return resultJson.getData().toString();
	}

}
