package com.springSecurityimplDemo.securityimpldemo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springSecurityimplDemo.securityimpldemo.Dto.UserRequestDto;
import com.springSecurityimplDemo.securityimpldemo.Dto.UserResponseDto;
import com.springSecurityimplDemo.securityimpldemo.service.AuthService;

@RestController
@RequestMapping("/api/user")
public class UserController {
      
	private AuthService authservice;
	
	
	 public UserController(AuthService authservice) {
		 this.authservice=authservice;
	 }
	 
	 @PostMapping("/Register")
	 public ResponseEntity<UserResponseDto> register(
			 @RequestBody UserRequestDto dto )
	 {
		 return  ResponseEntity.ok(authservice.registerUser(dto))  ;
		 
	 }
	 
	 @GetMapping("/getCsrfToken")
	 public CsrfToken getToken(CsrfToken csrftoken) {
		 return  csrftoken;
	 }
	
	
}
