package com.springSecurityimplDemo.securityimpldemo.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springSecurityimplDemo.securityimpldemo.Entity.Role;
import com.springSecurityimplDemo.securityimpldemo.Repos.RoleRepository;

@Service
public class RoleService {
  
	private RoleRepository rolerepository;
	
	public RoleService(RoleRepository rolerepository) {
		this.rolerepository=rolerepository;
	}
	
	public Role addRole(Role role) {
		if(role!=null) {
			return rolerepository.save(role);
		}
		return null;
	}
	
	
	
}
