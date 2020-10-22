package com.consumer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:./config/dubbo.properties")
@ImportResource(locations = {"classpath:dubbo/*.xml"})
public class DubboConfig {
}
