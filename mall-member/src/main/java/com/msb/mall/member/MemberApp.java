package com.msb.mall.member;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.msb.mall.member.dao")
@Slf4j
public class MemberApp {
    public static void main(String[] args) {
        log.info("【会员服务】---开始启动");
        SpringApplication.run(MemberApp.class, args);
        log.info("【会员服务】---启动完成");
    }
}