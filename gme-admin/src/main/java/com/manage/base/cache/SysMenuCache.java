package com.manage.base.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.manage.sys.entity.SysMenu;
import com.manage.sys.entity.SysPersion;


public class SysMenuCache {
	
	public static Map<String,Object> map = new HashMap<String, Object>();
	public static Map<String,Object> map2 = new HashMap<String, Object>();

	public static void putAllInCache(List < SysMenu > list){
		if(list == null || list.size() == 0){
			return;
		}
		map.clear();
		map.put("ll_sys_menus", list);
		for (SysMenu ll_sys_menu : list) {
			map.put("ll_sys_menu_"+ll_sys_menu.getId(), ll_sys_menu);
		}
	}

	public static List<SysMenu> getMenusListFromCache(){
		List<SysMenu> list = (List<SysMenu>)map.get("ll_sys_menus");
		return list;
	}

	public static SysMenu getOneMenuFromCache(Long mId){
		SysMenu sys_menu = (SysMenu)map.get("ll_sys_menu_"+mId);
		return sys_menu;
	}
	

	public static void setPersionInCache(List<SysPersion> list){
		if(list == null || list.size() == 0){
			return;
		}
		map2.clear();
		map2.put("ll_sys_persions", list);
	}

	public static List<SysPersion> getPersionListFromCache(){
		List<SysPersion> list = (List<SysPersion>)map2.get("ll_sys_persions");
		return list;
	}

	public static List<SysPersion> getPersionByMenuIdFromCache(Long mid){
		List<SysPersion> list = (List<SysPersion>)map2.get("ll_sys_persions");
		List<SysPersion> result = new ArrayList<SysPersion>();
		if(list!=null && list.size() != 0){
			if(list!=null && list.size() != 0){
				for (SysPersion ll_sys_persion : list) {
					if(ll_sys_persion.getMid().toString().equals(mid.toString())){
						result.add(ll_sys_persion);
					}
				}
			}
		}
		return result;
	}
}
