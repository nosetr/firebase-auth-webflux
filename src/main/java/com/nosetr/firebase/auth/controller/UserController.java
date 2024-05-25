package com.nosetr.firebase.auth.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nosetr.firebase.auth.config.SecurityConfig.CustomPrincipal;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserController {

	@GetMapping("/user")
	public Mono<CustomPrincipal> getUserInfo(Authentication authentication) {
		CustomPrincipal customPrincipal = (CustomPrincipal) authentication.getPrincipal();

		return Mono.just(customPrincipal);
	}
}
