package com.ren.teamall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ren.common.utils.PageUtils;
import com.ren.teamall.order.entity.OrderEntity;

import java.util.Map;

/**
 * 订单
 *
 * @author ren
 * @email qijirenjian@163.com
 * @date 2021-01-28 15:57:44
 */
public interface OrderService extends IService<OrderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

