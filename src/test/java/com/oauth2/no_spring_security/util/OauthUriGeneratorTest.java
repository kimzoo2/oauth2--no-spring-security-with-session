package com.oauth2.no_spring_security.util;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.oauth2.no_spring_security.property.AuthProperty;

@ExtendWith(MockitoExtension.class)
class OauthUriGeneratorTest {

	@InjectMocks
	private OauthUriGenerator oauthUriGenerator;

	@Mock
	private AuthProperty authProperty;


	@Test
	@DisplayName("설정 파일에서 redirect uri를 가져온다.")
	void getRedirectUri() {
		// given
		given(authProperty.getRedirectUri()).willReturn("http://localhost:8080/test/naver");
		given(authProperty.getLoginUrl()).willReturn("https://nid.naver.com/oauth2.0/authorize");
		given(authProperty.getClientId()).willReturn("test_naver_id");

		UriComponents uriComponents = UriComponentsBuilder
			.fromUriString(authProperty.getLoginUrl())
			.queryParam("response_type", "code")
			.queryParam("client_id", authProperty.getClientId())
			.queryParam("redirect_uri", authProperty.getRedirectUri())
			.queryParam("state", "STATE_STRING")
			.build();

		// when
		String redirectURL = oauthUriGenerator.generateRedirectURL();

		// then
		assertThat(redirectURL).isEqualTo(uriComponents.toUriString());
	}

}
