package com.springSecurityimplDemo.securityimpldemo.Repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springSecurityimplDemo.securityimpldemo.Entity.Role;


public interface RoleRepository extends JpaRepository<Role, Long>{
 public Optional<Role> getRoleByname(String name);
}
