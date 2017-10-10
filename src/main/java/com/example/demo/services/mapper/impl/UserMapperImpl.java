package com.example.demo.services.mapper.impl;

import com.example.demo.model.UserEntity;
import com.example.demo.services.dto.UserDTO;
import com.example.demo.services.mapper.UserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vzpintor
 * @project demo
 * @date 10/10/17
 */

@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO mapFromUserEntityToUserDto(UserEntity from) {

        UserDTO to = new UserDTO();

        BeanUtils.copyProperties(from, to);

        return to;
    }

    @Override
    public List<UserDTO> mapFromListUserEntityToListUserDto(List<UserEntity> fromList) {

        List<UserDTO> toList = new ArrayList<>();

        for (UserEntity from : fromList) {
            UserDTO userDTO = mapFromUserEntityToUserDto(from);
            toList.add(userDTO);
        }

        return toList;
    }

    @Override
    public UserEntity mapFromUserDtoToUserEntity(UserDTO from) {

        UserEntity to = new UserEntity();
        BeanUtils.copyProperties(from, to);

        return to;
    }

    @Override
    public List<UserEntity> mapFromListUserDtoToListUserEntity(List<UserDTO> fromList) {
        List<UserEntity> toList = new ArrayList<>();

        for (UserDTO from : fromList) {
            UserEntity userDTO = mapFromUserDtoToUserEntity(from);
            toList.add(userDTO);
        }

        return toList;
    }
}
