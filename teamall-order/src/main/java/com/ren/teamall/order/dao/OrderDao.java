package com.ren.teamall.order.dao;

import com.ren.teamall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author ren
 * @email qijirenjian@163.com
 * @date 2021-01-28 15:57:44
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
