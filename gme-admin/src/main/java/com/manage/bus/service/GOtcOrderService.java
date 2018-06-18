package com.manage.bus.service;

import com.manage.base.entity.PageInfo;
import com.manage.base.util.UserUtil;
import com.manage.bus.dao.GOtcOrderDAO;
import com.manage.bus.entity.GOtcOrder;
import com.manage.bus.vo.GOtcOrderVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
/**
 * OTC订单表（g_otc_order）
功能描述：存储OTC订单信息。
服务
 */
@Transactional(readOnly = true)
@Service("GOtcOrderService")
public class GOtcOrderService{

    @Resource(name = "GOtcOrderDAO")
    private GOtcOrderDAO g_otc_order_dao;


    /**
     * 分页查询
     */
    public PageInfo selectPage(GOtcOrderVO g_otc_order_vo) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("PSIZE", g_otc_order_vo.getRows());
        map.put("BEGIN", (g_otc_order_vo.getPage() - 1) * g_otc_order_vo.getRows());
        Integer count = this.g_otc_order_dao.selectPageCount(map);
        if (count == 0) {
            return new PageInfo(g_otc_order_vo.getRows(), g_otc_order_vo.getPage(), count, new ArrayList<GOtcOrder>());
        }
        List<GOtcOrder> list = this.g_otc_order_dao.selectPage(map);
        PageInfo pageInfo = new PageInfo(g_otc_order_vo.getRows(), g_otc_order_vo.getPage(), count, list);
        return pageInfo;
    }

    /**
     * 查询一条记录
     */
    public GOtcOrder get(java.lang.String entry_order_id) throws Exception {
        GOtcOrder g_otc_order = g_otc_order_dao.getById(entry_order_id);
        return g_otc_order;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean add(GOtcOrder g_otc_order) throws Exception {
        Integer result = g_otc_order_dao.add(g_otc_order);
        return result > 0 ? true : false;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean update(GOtcOrder g_otc_order) throws Exception {
        Integer result = g_otc_order_dao.update(g_otc_order);
        return result > 0 ? true : false;
    }
	 /**
     * 删除
     */
    @Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean delete(java.lang.String entry_order_id) throws Exception {
        Integer result = g_otc_order_dao.deleteById(entry_order_id);
        return result > 0 ? true : false;
    }
    /**
	 * 获取所有数据
	 */
	public List<GOtcOrder> selectAll(GOtcOrderVO g_otc_order_vo) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		return g_otc_order_dao.selectAll(map);
	} 


}
