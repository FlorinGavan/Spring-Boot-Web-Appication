package com.itschool.project.models.dtos;

import lombok.Data;

import java.rmi.server.UID;
import java.util.UUID;

@Data
public class UserDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;

}