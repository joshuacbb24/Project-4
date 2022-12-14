package com.skillstorm.project4.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.csrf.DefaultCsrfToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.project4.models.Account;
import com.skillstorm.project4.models.CustomUserDetails;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/auth/v1")
public class AuthenticationController {

	@GetMapping("/login")
	public Map<String, String> login(@AuthenticationPrincipal CustomUserDetails customUserDetails,
			HttpServletRequest req) {
		DefaultCsrfToken csrf = (DefaultCsrfToken) req.getAttribute("_csrf");
		Map<String, String> mapData = new HashMap<String, String>();
		if (csrf != null) {
			mapData.put("token", csrf.getToken());
		}
		return mapData;

	}
/*
	@PostMapping("/logout")
	public String logoutDo(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		SecurityContextHolder.clearContext();
		session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		
		for (Cookie cookie : request.getCookies()) {
			System.out.println("cookies " + cookie.getName());
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		return "logout";
	}
	*/
}
