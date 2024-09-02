package com.oauth2.no_spring_security.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@ConfigurationProperties(prefix = "oauth2.naver")
public class AuthProperty {

	private String loginUrl;
	private String clientId;
	private String clientSecret;
	private String redirectUri;
	private String tokenUri;
	private String resourceUri;

}
