package com.rayen.boisson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.rayen.boisson.entities.Boisson;
import com.rayen.boisson.entities.Role;
import com.rayen.boisson.entities.User;
import com.rayen.boisson.service.BoissonService;
import com.rayen.boisson.service.UserService;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class BoissonSp3Application implements CommandLineRunner{
	@Autowired
	BoissonService boissonService;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	UserService userService;
	public static void main(String[] args) {
		SpringApplication.run(BoissonSp3Application.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		
		 System.out.println("Password Encoded BCRYPT :******************** ");
		 System.out.println(passwordEncoder.encode("123"));
		 
		/*
		 * boissonService.saveBoisson(new Boisson("jus fraise", 7.0));
		 * boissonService.saveBoisson(new Boisson("cafee", 1.1));
		 * boissonService.saveBoisson(new Boisson("experss", 1.3));
		 */
		
		
	}

	
	/*
	 * @PostConstruct void init_users() { //ajouter les rôles
	 * userService.addRole(new Role(null,"ADMIN")); userService.addRole(new
	 * Role(null,"AGENT")); userService.addRole(new Role(null,"USER")); //ajouter
	 * les users userService.saveUser(new User(null,"admin","123",true,null));
	 * userService.saveUser(new User(null,"rayen","123",true,null));
	 * userService.saveUser(new User(null,"user1","123",true,null)); //ajouter les
	 * rôles aux users userService.addRoleToUser("admin", "ADMIN");
	 * userService.addRoleToUser("rayen", "USER");
	 * userService.addRoleToUser("rayen", "AGENT");
	 * userService.addRoleToUser("user1", "USER"); }
	 */
}
