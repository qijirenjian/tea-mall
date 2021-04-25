package com.ren.teamall.order;

import com.ren.teamall.order.entity.OrderEntity;
import com.ren.teamall.order.service.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@RunWith(SpringRunner.class)
@SpringBootTest
class TeamallOrderApplicationTests {

    @Autowired
    OrderService orderService;

    @Test
    void contextLoads() {

        System.out.println("存");
        OrderEntity orderEntity = new OrderEntity();

        orderEntity.setBillType(1);
        orderEntity.setDeliveryCompany("wodeya!");
//        orderService.save(orderEntity);
        orderService.query();
        System.out.println("保存成功！");


    }

}
