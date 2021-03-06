package com.ren.teamall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ren.common.utils.PageUtils;
import com.ren.teamall.order.entity.OrderItemEntity;

import java.util.Map;

/**
 * 订单项信息
 *
 * @author ren
 * @email qijirenjian@163.com
 * @date 2021-05-24 12:52:45
 */
public interface OrderItemService extends IService<OrderItemEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

