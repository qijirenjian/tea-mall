package com.ren.teamall.product.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ren.teamall.product.entity.BrandEntity;
import com.ren.teamall.product.service.BrandService;
import com.ren.common.utils.PageUtils;
import com.ren.common.utils.R;

import javax.validation.Valid;


/**
 * 品牌
 *
 * @author ren
 * @email qijirenjian@163.com
 * @date 2021-05-21 18:35:14
 */
@RestController
@RequestMapping("product/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = brandService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{brandId}")
    public R info(@PathVariable("brandId") Long brandId) {
        BrandEntity brand = brandService.getById(brandId);

        return R.ok().put("brand", brand);
    }

    /**
     * 保存
     *
     *      * 字段后台校验
     *      * 1，在entity上添加校验注解
     *      * 2，在要用的方法上添加开启校验注解@Valid
     */
    @RequestMapping("/save")
    public R save(@Valid @RequestBody BrandEntity brand /*, BindingResult bindingResult*/) {
       /* if (bindingResult.hasErrors()) {
            Map<String, String> map = new HashMap<>();
            //获取校验结果
            bindingResult.getFieldErrors().forEach((item) -> {
                String message = item.getDefaultMessage(); //配置文件中的，，想要自己的可以在entity上添加
                String filed = item.getField();
                map.put(filed, message);
            });
            return R.error(400, "提交的数据不合法！").put("data", map);
        } else {
            brandService.save(brand);
        }*/

        brandService.save(brand);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody BrandEntity brand) {
        brandService.updateById(brand);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] brandIds) {
        brandService.removeByIds(Arrays.asList(brandIds));

        return R.ok();
    }

}
