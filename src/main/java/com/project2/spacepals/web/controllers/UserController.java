package com.project2.spacepals.web.controllers;

import com.project2.spacepals.entities.Users;
import com.project2.spacepals.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService service){
        super();
        this.userService = service;
    }


    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
    public Users registerNewUser(@RequestBody Users newUser) {
    return userService.register(newUser);
    }
}
