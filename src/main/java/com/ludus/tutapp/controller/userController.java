package com.ludus.tutapp.controller;

import com.ludus.tutapp.model.request.UserDetailsRequestModel;
import com.ludus.tutapp.model.response.UserRest;
import com.ludus.tutapp.service.UserService;
import com.ludus.tutapp.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class userController {

    private UserService userService;

    public userController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getUser(){
        return "get user was called";
    }
    @PostMapping
    public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails ){

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetails,userDto);
        UserDto createdUser = userService.createUser(userDto);

        UserRest userResponse  = new UserRest();
        BeanUtils.copyProperties(createdUser,userResponse);

        return userResponse;
    }
    @DeleteMapping
    public String deleteUser(){
        return "delete User was called";
    }
    @PutMapping
    public String updateUser(){
        return "update user was called";
    }
}
