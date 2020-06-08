package com.ludus.tutapp.service.impl;

import com.ludus.tutapp.entity.UserEntity;
import com.ludus.tutapp.repository.UserRepository;
import com.ludus.tutapp.service.UserService;
import com.ludus.tutapp.shared.Utils;
import com.ludus.tutapp.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl  implements UserService {

    private UserRepository userRepository;
    private Utils utils;

    public UserServiceImpl(UserRepository userRepository, Utils utils) {
        this.userRepository = userRepository;
        this.utils = utils;
    }

    @Override
    public UserDto createUser(UserDto user) {
        if(userRepository.findByEmail(user.getEmail()) != null)
        {
            throw new RuntimeException("User already exist");

        }
         UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user,userEntity);
        userEntity.setEncryptedPassword("encrypted password test");
        userEntity.setUserId(utils.generateUserId(30));
        UserEntity storedUser =userRepository.save(userEntity);

        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(storedUser,returnValue);
        return returnValue;
    }
}
























