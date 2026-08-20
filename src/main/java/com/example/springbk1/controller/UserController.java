package com.example.springbk1.controller;

import com.example.springbk1.entity.User;
import com.example.springbk1.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    
    @Autowired
    private UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

}

//sample json
// {
//     "name": "John",
//     "email":"john@gmail.com",
//     "password":"1234",
//     "role":"user"
// }
