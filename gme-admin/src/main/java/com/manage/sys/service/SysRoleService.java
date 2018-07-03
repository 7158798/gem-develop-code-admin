package com.manage.sys.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.manage.base.cache.SysRoleCache;
import com.manage.base.entity.PageBean;
import com.manage.sys.dao.SysRoleDAO;
import com.manage.sys.entity.SysRole;
import com.manage.sys.vo.SysRoleVO;
/**
 * 角色说明服务
 */
@Transactional(readOnly = true)
@Service("sysRoleService")
public class SysRoleService{

    @Resource(name = "sysRoleDao")
    private SysRoleDAO sysRoleDao;
    @Resource(name = "sysRmenuService")
    private SysRmenuService sysRmenuService;
    @Resource(name = "sysRpersionService")
    private SysRpersionService sysRpersionService;

    /**
     * 分页查询
     */
    public PageBean selectPage(SysRoleVO llSysRoleVO) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("PSIZE", llSysRoleVO.getRows());
        map.put("BEGIN", (llSysRoleVO.getPage() - 1) * llSysRoleVO.getRows());
        Integer count = this.sysRoleDao.selectPageCount(map);
        if (count == 0) {
            return new PageBean(llSysRoleVO.getRows(), llSysRoleVO.getPage(), count, new ArrayList<SysRole>());
        }
        List<SysRole> list = this.sysRoleDao.selectPage(map);
        PageBean pageInfo = new PageBean(llSysRoleVO.getRows(), llSysRoleVO.getPage(), count, list);
        return pageInfo;
    }

    /**
     * 查询一条记录
     */
    public SysRole get(java.lang.Long ID) throws Exception {
        SysRole llSysRole = sysRoleDao.getById(ID);
        return llSysRole;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean add(SysRole llSysRole) throws Exception {
        Integer result = sysRoleDao.add(llSysRole);
        if(result>0){
        	cache();
        }
        return result > 0 ? true : false;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean update(SysRole llSysRole) throws Exception {
        Integer result = sysRoleDao.update(llSysRole);
        if(result>0){
        	cache();
        }
        return result > 0 ? true : false;
    }
	 /**
     * 删除
     */
    @Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean delete(java.lang.Long ID) throws Exception {
    	SysRole llSysRole=get(ID);
        Integer result = sysRoleDao.deleteById(ID);
        if(result>0){
        	sysRmenuService.delete(null,null,ID);
        	sysRpersionService.delete(ID, null, null);
        	
        	cache();
        }
        return result > 0 ? true : false;
    }
    /**
	 * 获取所有数据
	 */
	public List<SysRole> selectAll(SysRoleVO llSysRoleVO) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		if(llSysRoleVO!=null){
			if(StringUtils.isNotEmpty(llSysRoleVO.getRoleName())){
				map.put("roleName", llSysRoleVO.getRoleName());
			}
		}
		return sysRoleDao.selectAll(map);
	} 

	/**
	 * 缓存角色
	 */
	public void cache()throws Exception{
		List<SysRole> list=sysRoleDao.selectAll(null);
		SysRoleCache.setRolesInCache(list);
	}
}
