package com.msb.mall.coupon;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.msb.mall.coupon.dao")
@Slf4j
public class CouponApp {
    public static void main(String[] args) {
        log.info("【营销服务】---开始启动");
        SpringApplication.run(CouponApp.class, args);
        log.info("【营销服务】---启动完成");
    }
}