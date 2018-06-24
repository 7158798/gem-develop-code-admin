package com.manage.sys.entity;
import java.io.Serializable;
/**
 *	表名：ll_sys_rmenu
 *  注释:角色权限
 */
 
public class SysRmenu implements Serializable{
	
	private static final long serialVersionUID = -7296152939176682689L;
	
	/**自增ID*/	
	private java.lang.Long id;
	/**角色编号*/	
	private java.lang.Long roleId;
	/**菜单编号*/	
	private java.lang.Long menuId;
	
	public void setId(java.lang.Long id){
		this.id = id;
	}
	public java.lang.Long getId(){
		return this.id;
	}
	public java.lang.Long getRoleId() {
		return roleId;
	}
	public void setRoleId(java.lang.Long roleId) {
		this.roleId = roleId;
	}
	public java.lang.Long getMenuId() {
		return menuId;
	}
	public void setMenuId(java.lang.Long menuId) {
		this.menuId = menuId;
	}
	@Override
	public String toString() {
		return "SysRmenu [id=" + id + ", roleId=" + roleId + ", menuId=" + menuId + "]";
	}
	
}
