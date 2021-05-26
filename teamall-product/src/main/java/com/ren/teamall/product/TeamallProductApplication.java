package com.ren.teamall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@MapperScan("com.ren.teamall.product.dao")
@SpringBootApplication
@EnableDiscoveryClient
public class TeamallProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeamallProductApplication.class, args);
    }

}
