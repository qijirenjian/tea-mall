package com.ren.teamall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ren.common.utils.PageUtils;
import com.ren.teamall.product.entity.BrandEntity;

import java.util.Map;

/**
 * 品牌
 *
 * @author ren
 * @email qijirenjian@163.com
 * @date 2021-05-21 18:35:14
 */
public interface BrandService extends IService<BrandEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

