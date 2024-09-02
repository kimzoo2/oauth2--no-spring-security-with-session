package com.oauth2.no_spring_security.auth.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AuthGrantType {
	AUTHORIZATION_CODE("authorization_code"),
	REFRESH_TOKEN("refresh_token"),
	DELETE("delete");

	private final String value;
}
