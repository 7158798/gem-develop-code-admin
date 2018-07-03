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
import com.manage.base.entity.PageBean;
import com.manage.sys.dao.SysMenuDAO;
import com.manage.sys.entity.SysMenu;
import com.manage.sys.vo.SysMenuVO;
/**
 * 菜单服务
 */
@Transactional(readOnly = true)
@Service("sysMenuService")
public class SysMenuService{

    @Resource(name = "sysMenuDAO")
    private SysMenuDAO sysMenuDAO;

    /**
     * 分页查询
     */
    public PageBean selectPage(SysMenuVO llSysMenuVO) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("PSIZE", llSysMenuVO.getRows());
        map.put("BEGIN", (llSysMenuVO.getPage() - 1) * llSysMenuVO.getRows());
        Integer count = this.sysMenuDAO.selectPageCount(map);
        if (count == 0) {
            return new PageBean(llSysMenuVO.getRows(), llSysMenuVO.getPage(), count, new ArrayList<SysMenu>());
        }
        List<SysMenu> list = this.sysMenuDAO.selectPage(map);
        PageBean pageInfo = new PageBean(llSysMenuVO.getRows(), llSysMenuVO.getPage(), count, list);
        return pageInfo;
    }

    /**
     * 查询一条记录
     */
    public SysMenu get(java.lang.Long ID) throws Exception {
        SysMenu llSysMenu = sysMenuDAO.getById(ID);
        return llSysMenu;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean add(SysMenu llSysMenu) throws Exception {
        Integer result = sysMenuDAO.add(llSysMenu);
        if(result>0){
        	cache(); 
        }
        return result > 0 ? true : false;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean update(SysMenu llSysMenu) throws Exception {
        Integer result = sysMenuDAO.update(llSysMenu);
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
    	SysMenu oldData = get(ID);
        Integer result = sysMenuDAO.deleteById(ID);
        if(result>0){
        	cache(); 
        }
        return result > 0 ? true : false;
    }
    
    /**
	 * 获取所有数据
	 */
	public List<SysMenu> selectAll(SysMenuVO llSysMenuVO) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		return sysMenuDAO.selectAll(map);
	} 
	
	/**
	 * 缓存菜单列表
	 */
	public void cache()throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("isShow", 1);
		List<SysMenu> list = sysMenuDAO.selectAll(map);
		SysMenuCache.putAllInCache(list);
	}
	
	/**
	 * 获取所有数据 组成树型返回
	 */
	public List<SysMenu> selectTree() throws Exception{
		List<SysMenu> list = sysMenuDAO.selectAll(null);
		List<SysMenu> tresult = new ArrayList<SysMenu>();
		for(int i = 0;i < list.size();i++){
			if(list.get(i).getMenufatherid().toString().equals("0")){
				getChild(list.get(i), list);
				tresult.add(list.get(i));
			}
		}
		return tresult;
	}
	
	private static void getChild(SysMenu llSysMenu,List<SysMenu> list){
		for(int i  =0;i < list.size();i++){
			if(list.get(i).getMenufatherid().toString().equals(llSysMenu.getId().toString())){
				llSysMenu.getChildren().add(list.get(i));
				getChild(list.get(i), list);
			}
		}
	}
	
	/**
	 * 获取所有顶级数据
	 */
	public List<SysMenu> selectAllFather() throws Exception{
		List<SysMenu> list = SysMenuCache.getMenusListFromCache();
		if(list == null){
			cache();
			list = SysMenuCache.getMenusListFromCache();
		}
		List<SysMenu> tresult = new ArrayList<SysMenu>();
		for(int i = 0;i<list.size();i++){
			if(list.get(i).getMenufatherid().toString().equals("0")){
				tresult.add(list.get(i));
			}
		}
		return tresult;
	}
	
	/**
	 * 缓存中获取 菜单列表
	 * @return
	 * @throws Exception
	 */
	public List<SysMenu> getAllMenuFromCache()throws Exception{
		List<SysMenu> list = SysMenuCache.getMenusListFromCache();
		if(list == null){
			cache();
		}
		return list;
	}

}
