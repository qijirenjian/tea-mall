package com.ren.teamall.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("com.ren.teamall.order.dao")
@SpringBootApplication
public class TeamallOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeamallOrderApplication.class, args);
    }



}
