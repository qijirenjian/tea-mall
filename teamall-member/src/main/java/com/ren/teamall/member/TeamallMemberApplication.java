package com.ren.teamall.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.ren.teamall.member.feign")
@EnableDiscoveryClient
@SpringBootApplication
public class TeamallMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeamallMemberApplication.class, args);
    }

}
