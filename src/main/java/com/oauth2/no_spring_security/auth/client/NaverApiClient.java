package com.oauth2.no_spring_security.auth.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oauth2.no_spring_security.auth.dto.NaverAccessResponse;

@FeignClient(name = "naverLogin", url ="${oauth2.naver.token-uri}")
public interface NaverApiClient {

	@GetMapping
	NaverAccessResponse getAccessToken(
		@RequestParam("grant_type") String grantType,
		@RequestParam("client_id") String clientId,
		@RequestParam("client_secret") String clientSecret,
		@RequestParam("code") String code,
		@RequestParam("state") String state
	);
}
