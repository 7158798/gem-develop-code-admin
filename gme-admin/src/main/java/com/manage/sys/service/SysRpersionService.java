package com.manage.sys.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.manage.base.cache.SysRoleCache;
import com.manage.sys.dao.SysRpersionDAO;
import com.manage.sys.entity.SysRpersion;
/**
 * 角色菜单功能服务
 */
@Transactional(readOnly = true)
@Service("sysRpersionService")
public class SysRpersionService{

    @Resource(name = "sysRpersionDao")
    private SysRpersionDAO sysRpersionDao;

    /**
     * 新增
     */
    @Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean add(SysRpersion llSysRpersion) throws Exception {
        Integer result = sysRpersionDao.add(llSysRpersion);
        return result > 0 ? true : false;
    }
    /**
     * 删除
     */
    @Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean delete(java.lang.Long rid,java.lang.Long mid,Long perssionId) throws Exception {
    	Map<String, Object> map = new HashMap<String, Object>();
    	if(rid!=null){
    		map.put("roleId", rid);
    	}if(mid!=null){
    		map.put("menuId", mid);
    	}if(perssionId!=null){
    		map.put("perssionId", perssionId);
    	}
        Integer result = sysRpersionDao.deleteData(map);
        if(result>0){
        	cache();
        }
        return result > 0 ? true : false;
    }
    /**
     * 缓存角色权限
     */
    public void cache()throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		List<SysRpersion> list=sysRpersionDao.selectAll(map);
		SysRoleCache.setRoleMenusPersionInCache(list);
	}


}
