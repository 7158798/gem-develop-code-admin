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
import com.manage.base.entity.PageInfo;
import com.manage.sys.dao.SysPersionDAO;
import com.manage.sys.entity.SysPersion;
import com.manage.sys.vo.SysPersionVO;
/**
 * 菜单功能表服务
 */
@Transactional(readOnly = true)
@Service("sysPersionService")
public class SysPersionService{

    @Resource(name = "sysPersionDAO")
    private SysPersionDAO sysPersionDAO;
    @Resource(name = "sysRpersionService")
    private SysRpersionService sysRpersionService;

    /**
     * 分页查询
     */
    public PageInfo selectPage(SysPersionVO llSysPersionVO) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("PSIZE", llSysPersionVO.getRows());
        map.put("BEGIN", (llSysPersionVO.getPage() - 1) * llSysPersionVO.getRows());
        Integer count = this.sysPersionDAO.selectPageCount(map);
        if (count == 0) {
            return new PageInfo(llSysPersionVO.getRows(), llSysPersionVO.getPage(), count, new ArrayList<SysPersion>());
        }
        List<SysPersion> list = this.sysPersionDAO.selectPage(map);
        PageInfo pageInfo = new PageInfo(llSysPersionVO.getRows(), llSysPersionVO.getPage(), count, list);
        return pageInfo;
    }

    /**
     * 查询一条记录
     */
    public SysPersion get(java.lang.Long ID) throws Exception {
        SysPersion llSysPersion = sysPersionDAO.getById(ID);
        return llSysPersion;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean add(SysPersion llSysPersion) throws Exception {
        Integer result = sysPersionDAO.add(llSysPersion);
        if(result>0){
        	cache();
        }
        return result > 0 ? true : false;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean update(SysPersion llSysPersion) throws Exception {
        Integer result = sysPersionDAO.update(llSysPersion);
        if(result>0){
        	cache();
        }
        return result > 0 ? true : false;
    }
    /**
     * 删除
     */
    @Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean delete(java.lang.Long id,Long mid) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
    	if(id!=null){
    		map.put("id", id);
    	}if(mid!=null){
    		map.put("mid", mid);
    	}
        Integer result = sysPersionDAO.deleteData(map);
        if(result>0){
        	if(id!=null){
        		sysRpersionService.delete(null, null, id);
        	}
        	cache();
        }
        return result > 0 ? true : false;
    }
    /**
	 * 获取所有数据
	 */
	public List<SysPersion> selectAll(SysPersionVO llSysPersionVO) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		if(llSysPersionVO!=null){
			if(llSysPersionVO.getMid()!=null){
				map.put("mid", llSysPersionVO.getMid());
			}
		}
		return sysPersionDAO.selectAll(map);
	} 
	/**
	 * 缓存权限
	 */
	public void cache()throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		List<SysPersion> list=sysPersionDAO.selectAll(map);
		SysMenuCache.setPersionInCache(list);
	}

}
