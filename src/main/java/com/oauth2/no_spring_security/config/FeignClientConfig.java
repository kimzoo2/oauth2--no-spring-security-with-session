package com.oauth2.no_spring_security.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

import com.oauth2.no_spring_security.auth.client.NaverApiClient;

@Configuration
@EnableFeignClients(basePackageClasses = NaverApiClient.class)
public class FeignClientConfig {
}
