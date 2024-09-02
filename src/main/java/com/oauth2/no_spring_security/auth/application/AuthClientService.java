package com.oauth2.no_spring_security.auth.application;

import org.springframework.stereotype.Service;

import com.oauth2.no_spring_security.auth.client.NaveResourceApiClient;
import com.oauth2.no_spring_security.auth.client.NaverApiClient;
import com.oauth2.no_spring_security.auth.domain.AuthGrantType;
import com.oauth2.no_spring_security.auth.dto.NaverAccessResponse;
import com.oauth2.no_spring_security.auth.dto.NaverResourceResonse;
import com.oauth2.no_spring_security.property.AuthProperty;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthClientService {

	private final AuthProperty authProperty;
	private final NaverApiClient naverApiClient;
	private final NaveResourceApiClient naveResourceApiClient;

	/**
	 * 외부와 연동하여 access token과 resource를 조회한다.
	 * @param code
	 * @param state
	 * @return
	 */
	public NaverResourceResonse getTokenAndResource(String code, String state) {
		NaverAccessResponse accessToken = getAccessToken(code, state);
		log.info("accessToken = {}", accessToken);
		return getResource(accessToken.getAccessToken(), accessToken.getTokenType());
	}

	/**
	 * access token을 조회한다.
	 * @param code
	 * @param state
	 * @return
	 */
	public NaverAccessResponse getAccessToken(String code, String state){
		return naverApiClient.getAccessToken(
			AuthGrantType.AUTHORIZATION_CODE.getValue(),
			authProperty.getClientId(),
			authProperty.getClientSecret(),
			code,
			state
		);
	}

	/**
	 * 외부 resource를 조회한다.
	 * @param accessToken
	 * @param tokenType
	 * @return
	 */
	public NaverResourceResonse getResource(String accessToken, String tokenType){
		return naveResourceApiClient.getResource(String.format("%s %s", tokenType, accessToken));
	}
}
