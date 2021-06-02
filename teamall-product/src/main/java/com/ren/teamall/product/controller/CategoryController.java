package com.ren.teamall.product.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ren.teamall.product.entity.CategoryEntity;
import com.ren.teamall.product.service.CategoryService;
import com.ren.common.utils.PageUtils;
import com.ren.common.utils.R;

import javax.validation.Valid;


/**
 * 商品三级分类
 *
 * @author ren
 * @email qijirenjian@163.com
 * @date 2021-05-21 18:35:14
 */
@RestController
@RequestMapping("product/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;


    /**
     *
     * 查出所有分类子分类
     *
     * */
    @RequestMapping("/list/tree")
    public R list(){
        List<CategoryEntity> entities = categoryService.listWithTree();
        return R.ok().put("data", entities);
    }


    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = categoryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{catId}")
    public R info(@PathVariable("catId") Long catId){
		CategoryEntity category = categoryService.getById(catId);

        return R.ok().put("data", category);
    }

    /**
     * 保存
     *
     * 字段后台校验
     * 1，在entity上添加校验注解
     * 2，在要用的方法上添加开启校验注解@Valid
     *
     */
    @RequestMapping("/save")
    public R save(@Valid @RequestBody CategoryEntity category, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            Map<String ,String > map = new HashMap<>();
            //获取校验结果
            bindingResult.getFieldErrors().forEach((item)->{
                String message = item.getDefaultMessage(); //配置文件中的，，想要自己的可以在entity上添加
                String filed =item.getField();
                map.put(filed,message);
            });
            return R.error(400,"提交的数据不合法！").put("data",map);
        }else{
            categoryService.save(category);
        }

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody CategoryEntity category){
		categoryService.updateById(category);

        return R.ok();
    }

    /**
     * 删除
     * @RequestBody:获取请求体，必须发送post请求
     * springmvc自动将请求体数据转为对应对象
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] catIds){

		categoryService.removeMenuByIds(Arrays.asList(catIds));

        return R.ok();
    }

}
