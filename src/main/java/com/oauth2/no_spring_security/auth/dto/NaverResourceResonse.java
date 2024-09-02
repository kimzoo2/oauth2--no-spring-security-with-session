package com.oauth2.no_spring_security.auth.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class NaverResourceResonse {

	private String resultCode;
	private String message;
	private NaverResourceResponseBody resonseBody;

	@JsonCreator
	public NaverResourceResonse(
		@JsonProperty("resultcode") String resultCode,
		@JsonProperty("message") String message,
		@JsonProperty("response") NaverResourceResponseBody resonseBody
	) {
		this.resultCode = resultCode;
		this.message = message;
		this.resonseBody = resonseBody;
	}

	@Override
	public String toString() {
		return "NaverResourceResonse{" +
			"resultCode='" + resultCode + '\'' +
			", message='" + message + '\'' +
			'}';
	}

	@Getter
	public static class NaverResourceResponseBody {
		private String email;
		private String profileImage;

		@JsonCreator
		public NaverResourceResponseBody(
			@JsonProperty("email") String email,
			@JsonProperty("profile_image") String profileImage) {
			this.email = email;
			this.profileImage = profileImage;
		}

		@Override
		public String toString() {
			return "NaverResourceResponseBody{" +
				"email='" + email + '\'' +
				", profileImage='" + profileImage + '\'' +
				'}';
		}
	}
}
