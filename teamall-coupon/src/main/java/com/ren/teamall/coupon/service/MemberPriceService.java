package com.ren.teamall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ren.common.utils.PageUtils;
import com.ren.teamall.coupon.entity.MemberPriceEntity;

import java.util.Map;

/**
 * 商品会员价格
 *
 * @author ren
 * @email qijirenjian@163.com
 * @date 2021-05-24 09:55:08
 */
public interface MemberPriceService extends IService<MemberPriceEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

