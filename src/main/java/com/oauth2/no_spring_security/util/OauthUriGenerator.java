package com.oauth2.no_spring_security.util;

import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.oauth2.no_spring_security.property.AuthProperty;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class OauthUriGenerator {

	private final AuthProperty authProperty;

	public String generateRedirectURL() {
		UriComponents uriComponents = UriComponentsBuilder
			.fromUriString(authProperty.getLoginUrl())
			.queryParam("response_type", "code")
			.queryParam("client_id", authProperty.getClientId())
			.queryParam("redirect_uri", authProperty.getRedirectUri())
			.queryParam("state", "STATE_STRING")
			.build();
		return uriComponents.toUriString();
	}
}
