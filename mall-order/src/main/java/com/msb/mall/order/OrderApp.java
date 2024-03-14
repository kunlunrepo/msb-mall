package com.msb.mall.order;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.msb.mall.order.dao")
@EnableFeignClients(basePackages = "com.msb.mall.order.fegin")
@Slf4j
public class OrderApp {
    public static void main(String[] args) {
        log.info("【订单服务】---开始启动");
        SpringApplication.run(OrderApp.class, args);
        log.info("【订单服务】---启动完成");
    }
}