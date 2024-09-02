package com.oauth2.no_spring_security.auth.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oauth2.no_spring_security.util.OauthUriGenerator;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

	private final OauthUriGenerator oauthUriGenerator;

	@GetMapping("/url")
	public ResponseEntity<Object> getRedirectUri(){
		return new ResponseEntity<>(oauthUriGenerator.generateRedirectURL(), HttpStatus.OK);
	}

}
