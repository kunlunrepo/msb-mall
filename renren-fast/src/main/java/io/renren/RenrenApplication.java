package io.renren;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


//@EnableDiscoveryClient
@SpringBootApplication
@Slf4j
public class RenrenApplication {

	public static void main(String[] args) {
		log.info("【快速开发平台】---开始启动");
		SpringApplication.run(RenrenApplication.class, args);
		log.info("【快速开发平台】---启动完成");
	}

}