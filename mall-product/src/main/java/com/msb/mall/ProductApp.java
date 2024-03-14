package com.msb.mall;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.msb.mall.product.dao")
@Slf4j
public class ProductApp {
    public static void main(String[] args) {
        log.info("【商品服务】---开始启动");
        SpringApplication.run(ProductApp.class, args);
        log.info("【商品服务】---启动完成");
    }
}