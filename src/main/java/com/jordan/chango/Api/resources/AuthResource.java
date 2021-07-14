package com.jordan.chango.Api.resources;

import com.jordan.chango.Api.controllers.UserController;
import com.jordan.chango.Api.dtos.UserDto;
import com.jordan.chango.Api.entities.UserPayroll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(AuthResource.AUTH)
public class AuthResource {

    public static final String AUTH = "/auth";
    public static final String LOGIN = "/login";

    private UserController userController;

    @Autowired
    public AuthResource(UserController userController) {
        this.userController = userController;
    }

    @PostMapping
    public void createUser(@RequestBody UserPayroll user) {
        this.userController.createUser(user);
    }

    @PostMapping(value = LOGIN)
    public ResponseEntity login(@RequestBody UserDto userDto) {
        UserDto response = this.userController.login(userDto);
        if (response.getEmail()== null) {
            return new ResponseEntity("\"El usuario no  existe\"", HttpStatus.BAD_REQUEST);
        } else if (response.getPassword()==null) {
            return new ResponseEntity("\"Los datos ingresados son incorrectos\"", HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity(response, HttpStatus.ACCEPTED);
        }

    }
}
