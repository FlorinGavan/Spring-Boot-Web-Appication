package com.itschool.project.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itschool.project.models.dtos.UserDTO;
import com.itschool.project.models.entities.User;
import com.itschool.project.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ObjectMapper objectMapper;

    public UserServiceImpl(UserRepository userRepository, ObjectMapper objectMapper) {
        this.userRepository = userRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public List<UserDTO> getUsers() {
        List<User> users = userRepository.findAll();

        return users.stream()
                .map(user -> objectMapper.convertValue(user, UserDTO.class))
                .toList();
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        if (userDTO.getEmail().length() < 3) {
            throw new RuntimeException("Invalid email");
        }
        User userEntityToBeSaved = objectMapper.convertValue(userDTO, User.class);
        User userResponseEntity = userRepository.save(userEntityToBeSaved);
        log.info("Created user with id: {}", userResponseEntity.getId());

        return objectMapper.convertValue(userResponseEntity, UserDTO.class);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        User updateValue = userRepository.save( objectMapper.convertValue(userDTO, User.class));
        return objectMapper.convertValue(updateValue,UserDTO.class);
    }

    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        return objectMapper.convertValue(user, UserDTO.class);
    }


    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}