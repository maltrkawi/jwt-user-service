package com.maltrkawi.userservice;

import com.maltrkawi.userservice.domain.Role;
import com.maltrkawi.userservice.domain.User;
import com.maltrkawi.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
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

			userService.saveUser(new User(null, "Mohammad Altrkawi", "maltrkawi", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Fares Altrkawi", "faltrkawi", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Julia Altrkawi", "jaltrkawi", "1234", new ArrayList<>()));

			userService.addRoleToUser("maltrkawi", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("maltrkawi", "ROLE_MANAGER");
			userService.addRoleToUser("maltrkawi", "ROLE_ADMIN");
			userService.addRoleToUser("faltrkawi", "ROLE_USER");
			userService.addRoleToUser("jaltrkawi", "ROLE_MANAGER");
		};
	}

}
