package com.example.demo.services;

import com.example.demo.services.dto.UserDTO;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;
import java.util.Optional;

/**
 * @author vzpintor
 * @project demo
 * @date 10/10/17
 */
public interface UserService {

    UserDTO createUser(UserDTO userDTO);

    List<UserDTO> getAllUsers();

    Boolean findByEmail(String email);
}
