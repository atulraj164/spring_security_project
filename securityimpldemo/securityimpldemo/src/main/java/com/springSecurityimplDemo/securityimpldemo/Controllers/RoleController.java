package com.springSecurityimplDemo.securityimpldemo.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springSecurityimplDemo.securityimpldemo.Entity.Role;
import com.springSecurityimplDemo.securityimpldemo.service.RoleService;

@RestController
@RequestMapping("/userRoles")
public class RoleController {
	
	private RoleService roleservice;
	
	public RoleController(RoleService roleservice) {
		this.roleservice=roleservice;
	}
	
	@PostMapping("/registeRole")
	public ResponseEntity<Role> registerRole(@RequestBody Role role){
		return ResponseEntity.ok(roleservice.addRole(role)); 
	}
	
}
