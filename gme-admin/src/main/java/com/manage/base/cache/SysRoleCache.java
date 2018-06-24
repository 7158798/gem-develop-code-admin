package com.manage.base.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.manage.sys.entity.SysRmenu;
import com.manage.sys.entity.SysRole;
import com.manage.sys.entity.SysRpersion;

public class SysRoleCache {
	
	public static Map<String,Object> map = new HashMap<String, Object>();

	public static void setRolesInCache(List<SysRole> list){
		if(list == null || list.size() == 0){
			return;
		}
		map.put("ll_sys_roles", list);
		for (SysRole ll_sys_role : list) {
			map.put("ll_sys_roles_"+ll_sys_role.getId(), ll_sys_role);
		}
	}

	public static List<SysRole> getRolesFromCache(){
		List<SysRole> list = (List<SysRole>)map.get("ll_sys_roles");
		return list;
	}

	public static SysRole getOneRoleFromCache(Long rId){
		SysRole ll_sys_role = (SysRole)map.get("ll_sys_roles_"+rId);
		return ll_sys_role;
	}

	public static void setRoleMenusInCache(List<SysRmenu> list){
		if(list == null || list.size() == 0){
			return;
		}
		map.put("ll_sys_rmenus", list);
	}

	public static List<SysRmenu> getRoleMenusFromCache(){
		List<SysRmenu> list = (List<SysRmenu>)map.get("ll_sys_rmenus");
		return list;
	}

	/**
	 * 获取用户一级菜单
	 * @param rId 用户角色id
	 * @return
	 */
	public static List<SysRmenu> getOneRoleMenusFromCache(Long rId){
		List<SysRmenu> list = (List<SysRmenu>)map.get("ll_sys_rmenus");
		if(list == null){
			return new ArrayList<SysRmenu>();
		}
		List<SysRmenu> rlist = new ArrayList<SysRmenu>();
		for (SysRmenu ll_sys_rmenu : list) {
			if(ll_sys_rmenu.getRoleId().toString().equals(rId.toString())){
				rlist.add(ll_sys_rmenu);
			}
		}
		return rlist;
	}
	
	/**
	 * 获取用户二级菜单
	 * @param list
	 */
	public static void setRoleMenusPersionInCache(List<SysRpersion> list){
		if(list == null || list.size() == 0){
			return;
		}
		map.put("ll_sys_rpersions", list);
	}

	public static List<SysRpersion> getRoleMenusPersionFromCache(){
		List<SysRpersion> list = (List<SysRpersion>)map.get("ll_sys_rpersions");
		return list;
	}
	
}
