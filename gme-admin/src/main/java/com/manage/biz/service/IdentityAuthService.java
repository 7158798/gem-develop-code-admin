package com.manage.biz.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.gme.common.core.utils.Resp;
import com.manage.base.entity.PageInfo;
import com.manage.biz.dto.IdentityAuthAdminDTO;
import com.manage.biz.entity.IdentityAuth;
import com.manage.biz.entity.IdentityAuthImage;
import com.manage.biz.vo.IdentityAuthVO;
import com.manage.util.ResponseResult;
import com.manage.util.SendRequestUtil;


/**
 * 
 * @Project：gme-admin   
 * @Class：GIdentityAuthService   
 * @Description 类描述：实名认证管理   
 * @Author：zhou   
 * @Date：2018年6月13日 下午9:07:14   
 * @version V1.0
 */
@Transactional(readOnly = true)
@Service("IdentityAuthService")
public class IdentityAuthService{

    private  Logger logger = Logger.getLogger(IdentityAuthService.class);
    
    @Value("${SERVICE_BASE_PARAM}")
    private String SERVICE_BASE_PARAM;
    
    // 测试分页查询
    public static String testPage() {
		List<IdentityAuth> list = new ArrayList<IdentityAuth>();
		IdentityAuth g = new IdentityAuth();
		g.setAuthId("1");
		g.setCertificateNumber("3423423434234232323");
		g.setAuthStatus(2);
		g.setCertificateType(2);
		g.setIsAuthSupplier(1);
		g.setRealName("张三");
		g.setStatus(0);
		
		IdentityAuth g1 = new IdentityAuth();
		g1.setAuthId("3");
		g1.setCertificateNumber("dfasfdasffdasf");
		g1.setAuthStatus(1);
		g1.setCertificateType(1);
		g1.setIsAuthSupplier(2);
		g1.setRealName("李四");
		g1.setStatus(1);
		list.add(g);
		list.add(g1);
		PageInfo pageInfo = new PageInfo(1, 1,1, list);
		return JSON.toJSONString(pageInfo);
	}

    // 测试查询一条记录
    public static String testOne() {
    	/*IdentityAuthImage g = new IdentityAuthImage();
		g.setAuthId("1");
		g.setCertificateNumber("3423423434234232323");
		g.setAuthStatus(2);
		g.setCertificateType(2);
		g.setIsAuthSupplier(1);
		g.setRealName("张三");
		g.setStatus(0);
		g.setStatus(0);
		g.setInHandImgUrl("http://img.zcool.cn/community/010a1b554c01d1000001bf72a68b37.jpg@1280w_1l_2o_100sh.png");
		g.setInHandImgPreview("http://img.zcool.cn/community/010a1b554c01d1000001bf72a68b37.jpg@1280w_1l_2o_100sh.png");
		g.setFrontImgUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1528956814406&di=811d73ef65bc0b7462765d7b079243de&imgtype=0&src=http%3A%2F%2Fuploads.5068.com%2Fallimg%2F151028%2F57-15102Q33H7.jpg");
		g.setFrontImgPreview("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1528956814406&di=811d73ef65bc0b7462765d7b079243de&imgtype=0&src=http%3A%2F%2Fuploads.5068.com%2Fallimg%2F151028%2F57-15102Q33H7.jpg");
		g.setReverseImgUrl("http://img.zcool.cn/community/010f87596f13e6a8012193a363df45.jpg@1280w_1l_2o_100sh.jpg");
		g.setReverseImgPreview("http://img.zcool.cn/community/010f87596f13e6a8012193a363df45.jpg@1280w_1l_2o_100sh.jpg");
		return JSON.toJSONString(g);*/
    	IdentityAuthAdminDTO identityAuthAdminDTO = new IdentityAuthAdminDTO();
    	identityAuthAdminDTO.setAuthStatus(1);
    	identityAuthAdminDTO.setCertificateNumber("1");
    	identityAuthAdminDTO.setCertificateType(1);
    	identityAuthAdminDTO.setCreateTime(new Date());
    	identityAuthAdminDTO.setFeedback("1");
    	identityAuthAdminDTO.setFrontImgId("1");
    	identityAuthAdminDTO.setFrontImgPreview("1");
    	identityAuthAdminDTO.setFrontImgUrl("1");
    	identityAuthAdminDTO.setId("1");
    	identityAuthAdminDTO.setInHandImgId("1");
    	identityAuthAdminDTO.setInHandImgPreview("1");
    	identityAuthAdminDTO.setInHandImgUrl("1");
    	identityAuthAdminDTO.setIsAuthSupplier(1);
    	identityAuthAdminDTO.setRealName("1");
    	identityAuthAdminDTO.setRemark("1");
    	identityAuthAdminDTO.setReverseImgId("1");
    	identityAuthAdminDTO.setReverseImgPreview("1");
    	identityAuthAdminDTO.setReverseImgUrl("1");
    	identityAuthAdminDTO.setStatus(1);
    	identityAuthAdminDTO.setUid("1");
    	identityAuthAdminDTO.setUpdatedTime(new Date());
    	
    	Resp<IdentityAuthAdminDTO> success = Resp.success("成功", identityAuthAdminDTO);
    	String json = JSON.toJSONString(success);
    	System.out.println(json);
    	
    	return json;
    	
    }
    
    // 测试添加一条数据
    public static String testAdd() {
    	Boolean flag = false;
		return JSON.toJSONString(flag);
    }
    
    // 测试修改一条数据
    public static String testUpdate() {
    	Boolean flag = true;
		return JSON.toJSONString(flag);
    }
    
    // 测试删除一条数据
    public static String testDelete() {
    	Boolean flag = false;
		return JSON.toJSONString(flag);
    }
    
    
    
    /**
     * 
     * @Title: selectPage
     * @Description: 分页查询
     * @param @param request
     * @param @param identityAuthVO
     * @param @return
     * @param @throws Exception
     * @return PageInfo
     * @throws
     */
    public PageInfo selectPage(HttpServletRequest request,IdentityAuthVO identityAuthVO) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("PSIZE", identityAuthVO.getRows());
        map.put("BEGIN", (identityAuthVO.getPage() - 1) * identityAuthVO.getRows());
        
        if (null != identityAuthVO.getRealName() && !StringUtils.isBlank(identityAuthVO.getRealName())) {
        	map.put("realName", identityAuthVO.getRealName());
        }
        if (null != identityAuthVO.getAuthStatus()) {
        	map.put("authStatus", identityAuthVO.getAuthStatus());
        }
        if (null != identityAuthVO.getIsAuthSupplier()) {
        	map.put("isAuthSupplier", identityAuthVO.getIsAuthSupplier());
        }
        if (null != identityAuthVO.getCertificateType()) {
        	map.put("certificateType", identityAuthVO.getCertificateType());
        }
        if (null != identityAuthVO.getStatus()) {
        	map.put("status", identityAuthVO.getStatus());
        }
      
        
        Integer count = 0;
        // 查询总记录数
        try {
           /* String method = SERVICE_BASE_PARAM + "identityAuth_getPageCount";
            String json = SendRequestUtil.sendMapRequest(request, map, method);*/
        	String json = this.testPage();
        	if (null != json) {
        		PageInfo pageInfo = JSON.parseObject(json, PageInfo.class);
                count = pageInfo.getTotalCount();
                if (count == 0) {
                	return new PageInfo(identityAuthVO.getRows(), identityAuthVO.getPage(), count, new ArrayList<IdentityAuth>());
                }
        	}else {
            	return new PageInfo(identityAuthVO.getRows(), identityAuthVO.getPage(), count, new ArrayList<IdentityAuth>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[用户管理-实名认证-查询记录条数]请求后台出错",e);
			return new PageInfo(identityAuthVO.getRows(), identityAuthVO.getPage(), count, new ArrayList<IdentityAuth>());
		}
        
        
        // 查询列表
        try {
			/*String method = SERVICE_BASE_PARAM + "identityAuth_getList";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
        	String json = this.testPage();
        	if (null != json) {
        		PageInfo pageInfo = JSON.parseObject(json, PageInfo.class);
                return pageInfo;
            }else {
            	return new PageInfo(identityAuthVO.getRows(), identityAuthVO.getPage(), 0, new ArrayList<IdentityAuth>());
            }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[用户管理-实名认证-查询所有记录]请求后台出错",e);
			return new PageInfo(identityAuthVO.getRows(), identityAuthVO.getPage(), 0, new ArrayList<IdentityAuth>());
		}
    }


    
    /**
     * 
     * @Title: get
     * @Description: 查询一条记录
     * @param @param request
     * @param @param authId
     * @param @return
     * @param @throws Exception
     * @return GIdentityAuth
     * @throws
     */
    public IdentityAuth get(HttpServletRequest request,String authId) throws Exception {
    	try {
    		Map<String,Object> map = new HashMap<String, Object>();
    		map.put("authId", authId);
			/*String method = SERVICE_BASE_PARAM + "identityAuth/getById";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
    		String json = this.testOne();
			if (null != json) {
				ResponseResult responseResult = JSON.parseObject(json, ResponseResult.class);
				if (responseResult.getData() != null) {
//					IdentityAuthImage identityAuthImage = (IdentityAuthImage) responseResult.getData();
					Object obj = responseResult.getData();
					System.out.println(obj.toString());
					IdentityAuthAdminDTO identityAuthImage = (IdentityAuthAdminDTO) JSON.parse(obj.toString());
					return null;
				}
				return null;
			}else {
				return new IdentityAuthImage();
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[用户管理-实名认证-查询一条记录]请求后台出错",e);
			return new IdentityAuthImage();
		}
    }

    
    
    /**
     * 
     * @Title: add
     * @Description: 新增一条记录
     * @param @param request
     * @param @param identityAuth
     * @param @return
     * @param @throws Exception
     * @return boolean
     * @throws
     */
    /*public boolean add(HttpServletRequest request,GIdentityAuth identityAuth) throws Exception {
    	try {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("GCurrencyData", g_currency_data);
			String method = SERVICE_BASE_PARAM + "g_currency_data_add";
			String json = SendRequestUtil.sendMapRequest(request, map, method);
			String json = this.testAdd();
			if (null != json) {
				Boolean flag = JSON.parseObject(json,Boolean.class);
				return flag;
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[币种管理-币种资料-新增一条记录]请求后台出错",e);
			return false;
		}
    }*/

    
    /**
     * 
     * @Title: update
     * @Description: 修改记录
     * @param @param request
     * @param @param identityAuth
     * @param @return
     * @param @throws Exception
     * @return boolean
     * @throws
     */
    public boolean update(HttpServletRequest request,IdentityAuth identityAuth) throws Exception {
    	try {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("GIdentityAuth", identityAuth);
			/*String method = SERVICE_BASE_PARAM + "identityAuth_update";
			String json = SendRequestUtil.sendMapRequest(request, map, method);*/
			String json = this.testUpdate();
			if (null != json) {
				Boolean flag = JSON.parseObject(json,Boolean.class);
				return flag;
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[用户管理-实名认证-修改一条记录]请求后台出错",e);
			return false;
		}
    }
	 /**
     * 删除
     */
    /*public boolean delete(java.lang.String authId) throws Exception {
        Integer result = identityAuth_dao.deleteById(authId);
        return result > 0 ? true : false;
    }*/
    /**
	 * 获取所有数据
	 */
	/*public List<GIdentityAuth> selectAll(GIdentityAuthVO identityAuthVO) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		return identityAuth_dao.selectAll(map);
	}*/ 


}
