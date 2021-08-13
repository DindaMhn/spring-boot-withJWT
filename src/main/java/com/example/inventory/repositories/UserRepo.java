package com.example.inventory.repositories;

import com.example.inventory.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,String> {
    User findByUsername(String username);
}
