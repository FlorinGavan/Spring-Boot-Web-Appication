package com.itschool.project.services;

import com.itschool.project.models.dtos.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO createUser(UserDTO userDTO);
    UserDTO updateUser(UserDTO userDTO);
    UserDTO getUserById(Long id);
    List<UserDTO>getUsers();
    void deleteUser(Long id);

}
