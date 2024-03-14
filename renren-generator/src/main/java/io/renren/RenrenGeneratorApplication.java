package io.renren;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
@MapperScan("io.renren.dao")
public class RenrenGeneratorApplication {

	// 日志
	private static final Logger log = LoggerFactory.getLogger(RenrenGeneratorApplication.class);
	public static void main(String[] args) {
		log.info("【代码生成平台】---开始启动");
		SpringApplication.run(RenrenGeneratorApplication.class, args);
		log.info("【代码生成平台】---启动完成");
	}
}
