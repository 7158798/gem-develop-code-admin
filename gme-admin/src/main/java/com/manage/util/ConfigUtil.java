/*
 * 文 件 名  :  CommonConfigUtil.java
 * 版    权    :  Ltd. Copyright (c) 2013 深圳市商巢互联网软件有限公司,All rights reserved
 * 描    述    :  <描述>
 * 创建人    :  彭彩云
 * 创建时间:  下午4:10:52
 */
package com.manage.util;

import java.util.ResourceBundle;

/**
 * 项目参数工具类
 * 
 * @author 彭彩云
 * @version [版本号, 2013-7-1]
 */
public class ConfigUtil {
	// 对应资源文件commonconfig.properties
	private static final ResourceBundle bundle = ResourceBundle
			.getBundle("sysConfig");

	
	/**
	 * 
	* @Title: get  
	* @Description: 通过键获取值 
	* @param key
	* @return
	* @return String
	 */
	public static final String get(String key) {
		try {
			return bundle.getString(key);
		} catch (Exception e) {
			return null;
		}

	}
}
