package com.ren.teamall.coupon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TeamallCouponApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeamallCouponApplication.class, args);
    }

}
