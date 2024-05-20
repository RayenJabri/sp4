package com.rayen.boisson.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rayen.boisson.entities.Role;

public interface RoleRepository  extends JpaRepository<Role, Long>  {
	Role findByRole(String role);
}
