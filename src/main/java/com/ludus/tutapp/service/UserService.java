package com.ludus.tutapp.service;

import com.ludus.tutapp.shared.dto.UserDto;

public interface UserService {
    UserDto createUser(UserDto user);
}
