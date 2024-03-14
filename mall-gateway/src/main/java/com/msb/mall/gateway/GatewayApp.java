package com.msb.mall.gateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class GatewayApp {
    public static void main(String[] args) {
        log.info("【网关服务】---开始启动");
        SpringApplication.run(GatewayApp.class, args);
        log.info("【网关服务】---启动完成");
    }
}