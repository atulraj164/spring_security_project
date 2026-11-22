package com.springSecurityimplDemo.securityimpldemo.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springSecurityimplDemo.securityimpldemo.Dto.UserRequestDto;
import com.springSecurityimplDemo.securityimpldemo.Dto.UserResponseDto;
import com.springSecurityimplDemo.securityimpldemo.Entity.User;
import com.springSecurityimplDemo.securityimpldemo.Repos.RoleRepository;
import com.springSecurityimplDemo.securityimpldemo.Repos.UserRepository;

@Service
public class AuthService {
     private  PasswordEncoder encoder;
     private  UserRepository userrepository;
     private  RoleRepository rolerepository;
     
     public AuthService(PasswordEncoder encoder,
                        UserRepository userrepository,
                        RoleRepository rolerepository)
     {
    	 this.userrepository=userrepository;
    	 this.rolerepository=rolerepository;
    	  this.encoder=encoder;
    	 
     }
     
     public UserResponseDto registerUser(UserRequestDto requestdto) {
    	 
    	 
    	 if(requestdto!=null) {
    		 User user=new User();
    		 user.setUsername(requestdto.getUsername());
    		 user.setPassword( encoder.encode(requestdto.getPassword()));
    		 user.getRoles().add(rolerepository.getRoleByname("ROLE_ADMIN").get());
             userrepository.save(user);
             
             
             UserResponseDto responsedto=new UserResponseDto();
             responsedto.setUsername(user.getUsername());
             responsedto.setPassword(user.getPassword());
             return responsedto;
    	 }
    	 
    	 return null;
    	 
     }
     
}
