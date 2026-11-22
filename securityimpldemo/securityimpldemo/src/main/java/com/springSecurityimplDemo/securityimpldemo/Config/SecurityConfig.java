package com.springSecurityimplDemo.securityimpldemo.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
   
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider(
	        UserDetailsService userDetailsService,
	        PasswordEncoder passwordEncoder) {

	    DaoAuthenticationProvider provider =
	            new DaoAuthenticationProvider(userDetailsService);

	    provider.setPasswordEncoder(passwordEncoder);

	    return provider;
	}
	
	@Bean 
	public SecurityFilterChain securityfilterchain(HttpSecurity httpsecurity,
			DaoAuthenticationProvider authentication) {
		
		return httpsecurity.csrf(csrf->csrf.disable())
		.authenticationProvider(authentication)
		.httpBasic(Customizer.withDefaults())
		.formLogin(Customizer.withDefaults())
		.authorizeHttpRequests(auth->
		auth.requestMatchers("/home/**").permitAll()
		.anyRequest().authenticated())
		.build();
		
	}

}
