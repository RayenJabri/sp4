


package com.rayen.boisson.service;

import com.rayen.boisson.entities.Role;
import com.rayen.boisson.entities.User;

public interface UserService {
	void deleteAllusers();
	void deleteAllRoles();
	User saveUser(User user);
	User findUserByUsername (String username);
	Role addRole(Role role);
	User addRoleToUser(String username, String rolename);
}
