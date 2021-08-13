package com.example.inventory;

import com.example.inventory.entities.Role;
import com.example.inventory.entities.User;
import com.example.inventory.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.UUID;

@SpringBootApplication
public class InventoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveRole(new Role(UUID.randomUUID().toString(),"ROLE_MANAGER"));
			userService.saveRole(new Role(UUID.randomUUID().toString(),"ROLE_ADMIN"));
			userService.saveRole(new Role(UUID.randomUUID().toString(),"ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(UUID.randomUUID().toString(),"Dinda Maharani","Dinda","1234", new ArrayList<>(),"Active"));
			userService.saveUser(new User(UUID.randomUUID().toString(),"Tiara Arung Rahayu","Tiara","1234", new ArrayList<>(),"Active"));
			userService.saveUser(new User(UUID.randomUUID().toString(),"Tegar Langgeng Nugroho","Tegar","1234", new ArrayList<>(),"Active"));

			userService.addRoleToUser("Dinda","MANAGER");
			userService.addRoleToUser("Tiara","ROLE_ADMIN");
			userService.addRoleToUser("Tegar","ROLE_SUPER_ADMIN");

		};
	}
}
