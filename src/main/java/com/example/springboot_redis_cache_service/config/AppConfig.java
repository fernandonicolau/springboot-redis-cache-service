package com.example.springboot_redis_cache_service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class AppConfig {

  @Value("${POSTGRESS_URL}")
  String POSTGRESS_URL;
  
  @Value("${POSTGRESS_USERNAME}")
  String POSTGRESS_USERNAME;
  
  @Value("${POSTGRESS_PASSWORD}")
  String POSTGRESS_PASSWORD;
}