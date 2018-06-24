package com.manage.sys.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.manage.base.cache.SysMenuCache;
import com.manage.base.cache.SysRoleCache;
import com.manage.sys.dao.SysRmenuDAO;
import com.manage.sys.entity.SysMenu;
import com.manage.sys.entity.SysPersion;
import com.manage.sys.entity.SysRmenu;
import com.manage.sys.entity.SysRpersion;
import com.manage.sys.vo.SysMenuPersions;
/**
 * 角色权限服务
 */
@Transactional(readOnly = true)
@Service("sysRmenuService")
public class SysRmenuService{

    @Resource(name = "sysRmenuDao")
    private SysRmenuDAO sysRmenuDao;
    @Resource(name = "sysRpersionService")
    private SysRpersionService sysRpersionService;
    /**
     * 批量新增
     */
    @Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean addBatch(String str,Long roleId) throws Exception {
    	Map<String, Object> map = new HashMap<String, Object>();
		map.put("roleId", roleId);
		sysRpersionService.delete(roleId, null, null);
		sysRmenuDao.deleteData(map);
        if(str!=null){
        	String[]st=str.split(",");
        	for(int i=0;i<st.length;i++){
        		if(st[i].equals("")){
        			continue;
        		}
        		String[]ts=st[i].split("_");
        		if(ts[0].toString().equals("2")){
        			continue;
        		}
        		SysRmenu llSysRmenu=new SysRmenu();
        		llSysRmenu.setMenuId(Long.parseLong(ts[2]));
        		llSysRmenu.setRoleId(roleId);
        		Integer d=sysRmenuDao.add(llSysRmenu);
            	for(int j=0;j<st.length;j++){
            		if(st[j].equals("")){
            			continue;
            		}
            		String[]ts2=st[j].split("_");
            		
            		if(ts[2].equals(ts2[1])){
            			if(ts2[0].equals("1")){
                			continue;
                		}
            			SysRpersion llSysRpersion=new SysRpersion();
            			llSysRpersion.setPerssionid(Long.parseLong(ts2[2]));
            			llSysRpersion.setRolemenuid(llSysRmenu.getId());
            			sysRpersionService.add(llSysRpersion);
            		}
            	}
            }
        }
        cacheSysRoleMenu();
        sysRpersionService.cache();
        return true;
    }

    /**
     * 删除
     */
    @Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean delete(java.lang.Long id,java.lang.Long mid,Long rid) throws Exception {
    	Map<String, Object> map = new HashMap<String, Object>();
    	if(id!=null){
			map.put("id", id);
		}if(mid!=null){
			map.put("menuId", mid);
		}if(rid!=null){
			map.put("roleId", rid);
		}
        Integer result = sysRmenuDao.deleteData(map);
        if(result>0){
        	cacheSysRoleMenu();
        }
        return result > 0 ? true : false;
    }
    /**
     * 缓存数据
     * @throws Exception
     */
	public void cacheSysRoleMenu()throws Exception{
		List<SysRmenu> list=sysRmenuDao.selectAll(null);
		SysRoleCache.setRoleMenusInCache(list);
	}
	
	 /**
	 * 获取所有数据 组成树型返回 缓存中获取
	 */
	public List<SysMenuPersions> selectCheckBoxTree(List<SysMenu> list,Long roleId) throws Exception{
		if(roleId==null){
			return null;
		}
		List<SysRmenu> roleMenus=SysRoleCache.getOneRoleMenusFromCache(roleId);
		if(roleMenus==null){
			cacheSysRoleMenu();
			roleMenus=SysRoleCache.getRoleMenusFromCache();
		}
		
		List<SysMenuPersions> result=new ArrayList<SysMenuPersions>();
		for(int i=0;i<list.size();i++){
			if(list.get(i).getMenufatherid().toString().equals("0") && list.get(i).getIsshow().toString().equals("1")){
				SysMenuPersions sysMenuPersions=new SysMenuPersions();
				sysMenuPersions.setId(list.get(i).getId().toString());
				sysMenuPersions.setMenuName(list.get(i).getMenuname());
				sysMenuPersions.setType(1);
				sysMenuPersions.setIsCheck(0);
				sysMenuPersions.setPid("0");
				for(int j=0;j<roleMenus.size();j++){
					if(list.get(i).getId().toString().equals(roleMenus.get(j).getMenuId().toString())){
						sysMenuPersions.setIsCheck(1);
						break;
					}
				}
				getCheckBoxChild(sysMenuPersions, list,roleMenus);
				result.add(sysMenuPersions);
			}
		}
		return result;
	}
	/**
	 * 组成树返回
	 * @param sysMenuPersions
	 * @param list
	 * @param list2
	 */
	private void getCheckBoxChild(SysMenuPersions sysMenuPersions,List<SysMenu> list,List<SysRmenu> list2){
		List<SysRpersion> list3=SysRoleCache.getRoleMenusPersionFromCache();
		for(int i=0;i<list.size();i++){
			if(list.get(i).getMenufatherid().toString().equals(sysMenuPersions.getId().toString())){
				SysMenuPersions sysMenuPersions2=new SysMenuPersions();
				sysMenuPersions2.setId(list.get(i).getId().toString());
				sysMenuPersions2.setMenuName(list.get(i).getMenuname());
				sysMenuPersions2.setType(1);
				sysMenuPersions2.setIsCheck(0);
				sysMenuPersions.setPid(sysMenuPersions.getId());
				Long rmId=null;
				for(int j=0;j<list2.size();j++){
					if(list.get(i).getId().toString().equals(list2.get(j).getMenuId().toString())){
						rmId=list2.get(j).getId();
						sysMenuPersions2.setIsCheck(1);
						break;
					}
				}
				sysMenuPersions.getChildrens().add(sysMenuPersions2);
				getCheckBoxChild(sysMenuPersions2,list, list2);
				//获取权限列表
				List<SysPersion> persions=SysMenuCache.getPersionByMenuIdFromCache(Long.parseLong(sysMenuPersions2.getId()));
				if(persions!=null && persions!=null){
					for(int z=0;z<persions.size();z++){
						SysMenuPersions sysMenuPersions3=new SysMenuPersions();
						sysMenuPersions3.setId(persions.get(z).getId().toString());
						sysMenuPersions3.setMenuName(persions.get(z).getPersiondec());
						sysMenuPersions3.setType(2);
						sysMenuPersions3.setIsCheck(0);
						sysMenuPersions3.setPid(sysMenuPersions2.getId());
						if(rmId!=null && list3!=null && list3.size()!=0){
							for(int j=0;j<list3.size();j++){
								if(persions.get(z).getId().toString().equals(list3.get(j).getPerssionid().toString()) && rmId.toString().equals(list3.get(j).getRolemenuid().toString())){
									sysMenuPersions3.setIsCheck(1);
									break;
								}
							}
						}
						sysMenuPersions2.getChildrens().add(sysMenuPersions3);
					}
				}
			}
		}
	}

}
