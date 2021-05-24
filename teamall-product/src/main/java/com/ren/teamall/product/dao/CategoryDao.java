package com.ren.teamall.product.dao;

import com.ren.teamall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author ren
 * @email qijirenjian@163.com
 * @date 2021-05-21 18:35:14
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
