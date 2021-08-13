package com.example.inventory.services;

import com.example.inventory.entities.Role;
import com.example.inventory.entities.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username,String roleName);
    User getUser(String username);
    List<User> getUser();
    void deleteUser(String id);
}
