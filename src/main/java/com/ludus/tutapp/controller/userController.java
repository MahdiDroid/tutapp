package com.ludus.tutapp.controller;

import com.ludus.tutapp.model.request.UserDetailsRequestModel;
import com.ludus.tutapp.model.response.UserRest;
import com.ludus.tutapp.service.UserService;
import com.ludus.tutapp.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class userController {

    private UserService userService;
    @Autowired
    public userController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public UserRest getUser(@PathVariable String id){
        UserRest returnValue = new UserRest();
        UserDto userDto = userService.getUserByUserId(id);
        BeanUtils.copyProperties(userDto,returnValue);
        return returnValue;
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

    @PutMapping("/{id}")
    public UserRest updateUser(@PathVariable String id,@RequestBody UserDetailsRequestModel userDetails ){

        UserDto userDto =new UserDto();
        BeanUtils.copyProperties(userDetails,userDto);
        UserDto updatedUser = userService.updateUser(id,userDto);
        UserRest returnedUser = new UserRest();
        BeanUtils.copyProperties(updatedUser,returnedUser);
        return returnedUser;
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable String id){
        userService.deleteUser(id);
        return "user deleted";
    }
}
