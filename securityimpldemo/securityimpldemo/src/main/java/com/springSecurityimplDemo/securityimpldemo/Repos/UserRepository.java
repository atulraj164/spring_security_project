package com.springSecurityimplDemo.securityimpldemo.Repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springSecurityimplDemo.securityimpldemo.Entity.User;


public interface UserRepository extends JpaRepository<User, Long> {
	@EntityGraph(attributePaths = "roles")
  public Optional<User> getUserByusername(String username);
}
