package com.examplejwt;

import com.examplejwt.model.Role;
import com.examplejwt.model.User;
import com.examplejwt.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class DemoSpringBootJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringBootJwtApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "John Travolta", "John", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Will Smith", "Will", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Jim Carry", "Jim", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "arnold Schwarzenegger", "Arnold", "1234", new ArrayList<>()));

			userService.addRoleToUser("John", "ROLE_USER");
			userService.addRoleToUser("John", "ROLE_MANAGER");
			userService.addRoleToUser("Will", "ROLE_MANAGER");
			userService.addRoleToUser("Jim", "ROLE_ADMIN");
			userService.addRoleToUser("Arnold", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("Arnold", "ROLE_ADMIN");
			userService.addRoleToUser("Arnold", "ROLE_USER");
		};
	}
}
