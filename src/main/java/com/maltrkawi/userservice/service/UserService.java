package com.maltrkawi.userservice.service;

import com.maltrkawi.userservice.domain.Role;
import com.maltrkawi.userservice.domain.User;

import java.util.List;


public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
}
