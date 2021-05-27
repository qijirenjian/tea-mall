package com.ren.teamall.product.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ren.common.utils.PageUtils;
import com.ren.common.utils.Query;

import com.ren.teamall.product.dao.CategoryDao;
import com.ren.teamall.product.entity.CategoryEntity;
import com.ren.teamall.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {



    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        List<CategoryEntity> categoryEntities = baseMapper.selectList(null);

        List<CategoryEntity> leve1Menus = categoryEntities.stream().filter((entitys)->{
            return entitys.getParentCid() == 0;
        }).map((menu)->{
            menu.setChildren(getChildrens(menu,categoryEntities));
            return menu;
        }).sorted((menu1,menu2)->{
            return menu1.getSort() - menu2.getSort();
        }).collect(Collectors.toList());
        return leve1Menus;
    }




    //递归查找所有菜单子菜单
    private List<CategoryEntity> getChildrens(CategoryEntity root,List<CategoryEntity> all){
        List<CategoryEntity>  children = all.stream().filter(categoryEntity ->{
            return categoryEntity.getParentCid() == root.getCatId();
        }).map(categoryEntity->{
            categoryEntity.setChildren(getChildrens(categoryEntity,all));
            return categoryEntity;
        }).sorted((menu1, menu2)->{
            return (menu1.getSort()==null? 0:menu1.getSort()) - (menu2.getSort()==null ? 0 :menu2.getSort());
        }).collect(Collectors.toList());
        return children;
    }

    @Override
    public void removeMenuByIds(List<Long> asList) {
        //TODO  1.检查当前删除菜单，是否被别的地方引用

        baseMapper.deleteBatchIds(asList);
    }
}