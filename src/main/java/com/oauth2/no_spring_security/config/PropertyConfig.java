package com.oauth2.no_spring_security.config;

import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.oauth2.no_spring_security.property.AuthProperty;

@Configuration
@PropertySource(value = "classpath:env.properties", ignoreResourceNotFound = true)
@ConfigurationPropertiesScan(basePackageClasses = AuthProperty.class)
public class PropertyConfig {
}
