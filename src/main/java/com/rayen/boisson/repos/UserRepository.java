package com.rayen.boisson.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rayen.boisson.entities.User;
public interface UserRepository extends JpaRepository<User, Long> {
User findByUsername (String username);
}