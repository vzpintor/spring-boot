package com.example.demo.services.mapper;

import com.example.demo.model.UserEntity;
import com.example.demo.services.dto.UserDTO;

import java.util.List;

/**
 * @author vzpintor
 * @project demo
 * @date 10/10/17
 */
public interface UserMapper {

    UserDTO mapFromUserEntityToUserDto(UserEntity from);

    List<UserDTO> mapFromListUserEntityToListUserDto(List<UserEntity> fromList);

    UserEntity mapFromUserDtoToUserEntity(UserDTO from);

    List<UserEntity> mapFromListUserDtoToListUserEntity(List<UserDTO> fromList);

}
