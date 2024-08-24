package com.itschool.project.services;

import com.itschool.project.models.User;

import java.util.List;
import java.util.UUID;

public interface UserService {

    User createUser(User user);
    List<User>getUsers();
    void deleteUser(UUID id);
}
