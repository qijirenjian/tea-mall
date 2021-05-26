package com.ren.teamall.ware;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TeamallWareApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeamallWareApplication.class, args);
    }

}
