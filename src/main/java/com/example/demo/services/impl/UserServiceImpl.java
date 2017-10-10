package com.example.demo.services.impl;

import com.example.demo.model.UserEntity;
import com.example.demo.repository.UserCustomRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.UserService;
import com.example.demo.services.dto.UserDTO;
import com.example.demo.services.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author vzpintor
 * @project demo
 * @date 10/10/17
 */

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {

        UserEntity userEntity = userMapper.mapFromUserDtoToUserEntity(userDTO);
        UserEntity user = userRepository.save(userEntity);

        user.setFechaAlta(new Date());
        return userMapper.mapFromUserEntityToUserDto(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserEntity> allUsers = userRepository.findAll();

        return userMapper.mapFromListUserEntityToListUserDto(allUsers);

    }

    @Override
    public Boolean findByEmail(String email) {

        return userRepository.findOneByEmail(email).isPresent();
    }
}
