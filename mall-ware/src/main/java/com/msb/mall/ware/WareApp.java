package com.msb.mall.ware;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.msb.mall.ware.dao")
@Slf4j
public class WareApp {
    public static void main(String[] args) {
        log.info("【库存服务】---开始启动");
        SpringApplication.run(WareApp.class, args);
        log.info("【库存服务】---启动完成");
    }
}