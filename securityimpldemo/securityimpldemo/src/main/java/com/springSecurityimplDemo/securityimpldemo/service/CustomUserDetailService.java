package com.springSecurityimplDemo.securityimpldemo.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springSecurityimplDemo.securityimpldemo.Entity.CustomUserDetail;
import com.springSecurityimplDemo.securityimpldemo.Entity.User;
import com.springSecurityimplDemo.securityimpldemo.Repos.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService{

	private UserRepository userRepository;
	
	public CustomUserDetailService(UserRepository userRepository) {
		this.userRepository=userRepository;
	}
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
	User user=userRepository.getUserByusername(username)
			.orElseThrow(()->new UsernameNotFoundException("user not found"));
		    return new CustomUserDetail(user);
	
	}

}
