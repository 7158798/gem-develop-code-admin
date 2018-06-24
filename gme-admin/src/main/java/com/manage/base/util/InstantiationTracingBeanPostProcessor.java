package com.manage.base.util;


import org.apache.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.manage.sys.service.SysMenuService;
import com.manage.sys.service.SysPersionService;
import com.manage.sys.service.SysRmenuService;
import com.manage.sys.service.SysRoleService;
import com.manage.sys.service.SysRpersionService;
 

/**
 * 系统启动完加载默认数据到缓存
 */
public class InstantiationTracingBeanPostProcessor implements ApplicationListener<ContextRefreshedEvent>{
	private static final Logger LOG = Logger.getLogger(InstantiationTracingBeanPostProcessor.class);
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if(event.getApplicationContext().getParent() == null){
			try{
				SysMenuService sys_menu_Service= (SysMenuService)SpringContextUtil.getBean("sysMenuService");
				sys_menu_Service.cache();
				LOG.info("系统加载初始化菜单数据完成。。。。");
			}catch (Exception e) {
				LOG.error("加载所有菜单数据失败！",e);
			}
			try{
				SysPersionService ll_sys_persion_Service = (SysPersionService)SpringContextUtil.getBean("sysPersionService");
				ll_sys_persion_Service.cache();
				LOG.info("系统加载菜单功能数据完成。。。。");
			}catch (Exception e) {
				LOG.error("系统加载菜单功能数据失败！",e);
			}
			try{
				SysRoleService ll_sys_role_Service= (SysRoleService)SpringContextUtil.getBean("sysRoleService");
				ll_sys_role_Service.cache();
				LOG.info("系统加载角色数据完成。。。。");
			}catch (Exception e) {
				LOG.error("系统加载角色数据失败！",e);
			}
			try{
				SysRmenuService ll_sys_rmenu_Service = (SysRmenuService)SpringContextUtil.getBean("sysRmenuService");
				ll_sys_rmenu_Service.cacheSysRoleMenu();
				LOG.info("系统加载角色菜单数据完成。。。。");
			}catch (Exception e) {
				LOG.error("系统加载角色菜单数据失败！",e);
			}
			try{
				SysRpersionService ll_sys_rpersion_Service = (SysRpersionService)SpringContextUtil.getBean("sysRpersionService");
				ll_sys_rpersion_Service.cache();
				LOG.info("系统加载角色菜单功能数据完成。。。。");
			}catch (Exception e) {
				LOG.error("系统加载角色菜单功能数据失败！",e);
			}
			
		}  
	}

}
