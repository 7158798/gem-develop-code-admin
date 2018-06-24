package com.manage.sys.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.manage.base.entity.PageInfo;
import com.manage.sys.dao.SysUserDAO;
import com.manage.sys.entity.SysUser;
import com.manage.sys.vo.SysUserVO;
/**
 * 后台管理员服务
 */
@Transactional(readOnly = true)
@Service("sysUserService")
public class SysUserService{

    @Resource(name = "sysUserDao")
    private SysUserDAO sysUserDao;

    /**
     * 分页查询
     */
    public PageInfo selectPage(SysUserVO llSysUserVO) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("PSIZE", llSysUserVO.getRows());
        map.put("BEGIN", (llSysUserVO.getPage() - 1) * llSysUserVO.getRows());
        if(llSysUserVO!=null){
        	if(llSysUserVO.getTruename()!=null){
            	map.put("truename", llSysUserVO.getTruename());
            }if(llSysUserVO.getUserName()!=null){
            	map.put("userName", llSysUserVO.getUserName());
            }if(llSysUserVO.getPhone()!=null){
            	map.put("phone", llSysUserVO.getPhone());
            }
        }
        Integer count = this.sysUserDao.selectPageCount(map);
        if (count == 0) {
            return new PageInfo(llSysUserVO.getRows(), llSysUserVO.getPage(), count, new ArrayList<SysUser>());
        }
        List<SysUser> list = this.sysUserDao.selectPage(map);
        PageInfo pageInfo = new PageInfo(llSysUserVO.getRows(), llSysUserVO.getPage(), count, list);
        return pageInfo;
    }

    /**
     * 查询一条记录
     */
    public SysUser get(java.lang.Long id) throws Exception {
        SysUser llSysUser = sysUserDao.getById(id);
        return llSysUser;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean add(SysUser llSysUser) throws Exception {
        Integer result = sysUserDao.add(llSysUser);
        return result > 0 ? true : false;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean update(SysUser llSysUser) throws Exception {
    	String userpwd = llSysUser.getUserpwd();
    	if (null != userpwd && !StringUtils.isBlank(userpwd)) {
    		//使用shiro 的加密方式
    		llSysUser.setUserpwd(md5Salt(llSysUser));
    	}
        Integer result = sysUserDao.update(llSysUser);
        return result > 0 ? true : false;
    }
	 /**
     * 删除
     */
    @Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean delete(java.lang.Long id) throws Exception {
    	SysUser llSysUser =get(id);
        Integer result = sysUserDao.deleteById(id);
        return result > 0 ? true : false;
    }
    /**
	 * 获取所有数据
	 */
	public List<SysUser> selectAll(SysUserVO llSysUserVO) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		if(llSysUserVO!=null){
		  if(llSysUserVO.getUserName()!=null){
			  map.put("userName", llSysUserVO.getUserName());
		  }
		  if(llSysUserVO.getStatus()!=null){
			  map.put("status", llSysUserVO.getStatus());
		  }
		}
		return sysUserDao.selectAll(map);
	} 

	
	/**
	 * 
	 * @Title: md5Salt
	 * @Description: md5盐值加密 
	 * @param @param pwd
	 * @param @return
	 * @return String
	 * @throws
	 */
	private String md5Salt (SysUser llSysUser){
		String algorithmName = "MD5";
		String source = llSysUser.getUserpwd();
		int hashIterations = 2;
		ByteSource credentialsSalt = ByteSource.Util.bytes(llSysUser.getUsername().toLowerCase());
		Object obj = new SimpleHash(algorithmName, source, credentialsSalt, hashIterations);
		return obj.toString();
	}
	
	public static void main(String[] args) {
		String algorithmName = "MD5";
//		String source = llSysUser.getUserpwd();
		String name = "admin";
		String source = "123456";
		int hashIterations = 2;
		ByteSource credentialsSalt = ByteSource.Util.bytes(name);
		Object obj = new SimpleHash(algorithmName, source, credentialsSalt, hashIterations);
		System.out.println(obj);
	}

}
