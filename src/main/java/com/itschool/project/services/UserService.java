package com.itschool.project.services;

import com.itschool.project.models.dtos.UserDTO;
import com.itschool.project.models.entities.User;

import java.util.List;
import java.util.UUID;

public interface UserService {

    UserDTO createUser(UserDTO userDTO);
    List<UserDTO>getUsers();
    void deleteUser(UUID id);
}
