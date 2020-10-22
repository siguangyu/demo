package com.consumer;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.stereotype.Component;


@SpringBootApplication
@Component("com.consumer.**")
@DubboComponentScan(basePackages = "com.api.core")
public class ConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}

}
