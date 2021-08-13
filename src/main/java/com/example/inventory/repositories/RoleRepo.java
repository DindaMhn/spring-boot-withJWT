package com.example.inventory.repositories;

import com.example.inventory.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role,String> {
    Role findByName(String name);
}
