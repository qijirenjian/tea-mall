package com.ren.teamall.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})//排除数据源的相关操作
public class TeamallGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeamallGatewayApplication.class, args);
    }

}
