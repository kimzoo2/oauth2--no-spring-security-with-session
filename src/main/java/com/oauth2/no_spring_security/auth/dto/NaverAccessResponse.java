package com.oauth2.no_spring_security.auth.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class NaverAccessResponse {
	private final String accessToken;
	private final String refreshToken;
	private final String tokenType;
	private final Integer expiresIn;
	private final String errorCode;
	private final String errorDescription;
	private final String result;

	@JsonCreator
	public NaverAccessResponse(
		@JsonProperty("access_token") String accessToken,
		@JsonProperty("refresh_token") String refreshToken,
		@JsonProperty("token_type") String tokenType,
		@JsonProperty("expires_in") Integer expiresIn,
		@JsonProperty("error") String errorCode,
		@JsonProperty("error_description") String errorDescription,
		@JsonProperty("result") String result
	) {
		this.accessToken = accessToken;
		this.refreshToken = refreshToken;
		this.tokenType = tokenType;
		this.expiresIn = expiresIn;
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
		this.result = result;
	}

	@Override
	public String toString() {
		return "NaverAccessResponse{" +
			"accessToken='" + accessToken + '\'' +
			", refreshToken='" + refreshToken + '\'' +
			", tokenType='" + tokenType + '\'' +
			", expiresIn=" + expiresIn +
			", errorCode='" + errorCode + '\'' +
			", errorDescription='" + errorDescription + '\'' +
			", result='" + result + '\'' +
			'}';
	}
}
