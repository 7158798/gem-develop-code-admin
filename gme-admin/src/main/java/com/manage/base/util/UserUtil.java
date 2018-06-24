package com.manage.base.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;

import com.manage.base.cache.SysMenuCache;
import com.manage.base.cache.SysRoleCache;
import com.manage.sys.entity.SysMenu;
import com.manage.sys.entity.SysPersion;
import com.manage.sys.entity.SysRmenu;
import com.manage.sys.entity.SysRole;
import com.manage.sys.entity.SysRpersion;
import com.manage.sys.entity.SysUser;

/**
 * 登录用户帮助类
 */
public class UserUtil {
	
	/**
	 * 获取用户的 权限列表 缓存中获取
	 * @param roleId 角色编号
	 * @return
	 */
	public static List<String> getUserStringPermission(Long roleId){
		List<SysRmenu> list = SysRoleCache.getOneRoleMenusFromCache(roleId);
		List<SysRpersion> list2 = SysRoleCache.getRoleMenusPersionFromCache();
		List<SysPersion> list3 = SysMenuCache.getPersionListFromCache();
		List<String> permissions = new ArrayList<String>();
		for (SysRmenu Ll_sys_rmenu_entiy : list) {
			String rmid = Ll_sys_rmenu_entiy.getId().toString();
			for (SysRpersion ll_sys_rpersion : list2) {
				if(ll_sys_rpersion.getRolemenuid().toString().equals(rmid)){
					for (SysPersion ll_sys_persion : list3) {
						if(ll_sys_persion.getId().toString().equals(ll_sys_rpersion.getPerssionid().toString())){
							permissions.add(ll_sys_persion.getPersion());
							break;
						}
					}
				}
			}
		}
		return permissions;
	}
	
	/**
	 * 获取当前登录用户
	 */
	public static SysUser getCurUser(){
		SysUser user = (SysUser)SecurityUtils.getSubject().getPrincipal();
		return user;
	}
	
	/**
	 * 获取当前登录用户角色
	 */
	public static SysRole getCurUserRol(){
		SysUser user = (SysUser)SecurityUtils.getSubject().getPrincipal();
		SysRole ll_sys_role = SysRoleCache.getOneRoleFromCache(user.getRoleid());
		if(ll_sys_role == null){
			return new SysRole();
		}
		return ll_sys_role;
	}
	
	/**
	 * 获取当前用户的 一级菜单列表
	 * @return
	 */
	public static List<SysMenu> getUserFirstMenus(){
		try{
			SysUser user = getCurUser();
			if(user == null){
				return new ArrayList<SysMenu>();
			}
			List<SysRmenu> list = SysRoleCache.getOneRoleMenusFromCache(user.getRoleid());
			List<SysMenu> menus = new ArrayList<SysMenu>();
			Map<Long,Long> map = new HashMap<Long,Long>();
			for (SysRmenu ll_sys_rmenu : list) {
				SysMenu ll_sys_menu = SysMenuCache.getOneMenuFromCache(ll_sys_rmenu.getMenuId());
				if(ll_sys_menu == null){
					continue;
				}
				SysMenu first = SysMenuCache.getOneMenuFromCache(ll_sys_menu.getMenufatherid());
				if(first == null){
					continue;
				}
				if(map.get(ll_sys_menu.getMenufatherid()) == null){
					map.put(ll_sys_menu.getMenufatherid(), ll_sys_menu.getMenufatherid());
					menus.add(first);
				}
			}
			Collections.sort(menus);
			return menus;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取当前用户的菜单列表
	 * @return
	 */
	public static Map<Long,List<SysMenu>> getUserSecondMenus(){
		SysUser user = getCurUser();
		if(user == null){
			return new HashMap<Long,List<SysMenu>>();
		}
		List<SysRmenu> list = SysRoleCache.getOneRoleMenusFromCache(user.getRoleid());
		Map<Long,List<SysMenu>> menus = new HashMap<Long,List<SysMenu>>();
		for (SysRmenu Ll_sys_rmenu_entiy : list) {
			SysMenu ll_sys_menu = SysMenuCache.getOneMenuFromCache(Ll_sys_rmenu_entiy.getMenuId());
			if(ll_sys_menu == null){
				continue;
			}
			List<SysMenu> temp = menus.get(ll_sys_menu.getMenufatherid());
			if(temp == null){
				temp = new ArrayList<SysMenu>();
				menus.put(ll_sys_menu.getMenufatherid(), temp);
			}
			temp.add(ll_sys_menu);
		}
		return menus;
	}

}
