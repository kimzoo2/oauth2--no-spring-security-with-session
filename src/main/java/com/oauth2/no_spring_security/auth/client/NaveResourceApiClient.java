package com.oauth2.no_spring_security.auth.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.oauth2.no_spring_security.auth.dto.NaverResourceResonse;

@FeignClient(name = "naverResource", url = "${oauth2.naver.resource-uri}")
public interface NaveResourceApiClient {

	@GetMapping
	NaverResourceResonse getResource(@RequestHeader("Authorization") String headers);

}
