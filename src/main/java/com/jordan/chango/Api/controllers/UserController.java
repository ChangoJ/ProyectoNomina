package com.jordan.chango.Api.controllers;

import com.jordan.chango.Api.dtos.UserDto;
import com.jordan.chango.Api.entities.UserPayroll;
import com.jordan.chango.Api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(UserPayroll user) {
        this.userRepository.save(user);
    }

    public UserDto login(UserDto userDto) {
        Optional<UserPayroll> userOptional = this.userRepository.findUserByEmail(userDto.getEmail());
        if (userOptional.isPresent()) {
            UserPayroll userPayroll = userOptional.get();
            UserDto userDto1;
            if (userPayroll.getPassword().equals(userDto.getPassword())) {
                userDto1 = new UserDto(userPayroll);
            } else {
                userDto1 = new UserDto();
                userDto1.setEmail(userPayroll.getEmail());
            }
            return userDto1;

        } else {
            return new UserDto();
        }

    }
}
