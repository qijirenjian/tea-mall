package com.ren.teamall.product;

import com.ren.teamall.product.entity.BrandEntity;
import com.ren.teamall.product.service.BrandService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class TeamallProductApplicationTests {

    @Autowired
    BrandService brandService;

    @Test
    void contextLoads() {

        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setDescript("woshi baba");
        brandEntity.setName("111");
        brandService.save(brandEntity);
        System.out.println("保存成功！");
    }

}
