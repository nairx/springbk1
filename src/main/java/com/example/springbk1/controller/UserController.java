package com.example.springbk1.controller;

import com.example.springbk1.dto.UserRequestDTO;
import com.example.springbk1.dto.UserResponseDTO;
import com.example.springbk1.entity.User;
import com.example.springbk1.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    // create user before dto
    // @PostMapping
    // public User createUser(@RequestBody User user){
    // return userService.createUser(user);
    // }

    @GetMapping
    public List<User> getUsers() {
        return userService.getAllUsers();

    }

    @PostMapping
    public UserResponseDTO createUser(@RequestBody UserRequestDTO userRequestDTO) {
        return userService.createUser(userRequestDTO);
    }

    @PostMapping("/login")
    public User login(@RequestBody User user) {
        String email = user.getEmail();
        String password = user.getPassword();
        return userService.getUserByEmailAndPassword(email, password);
    }

    @PostMapping("/register")
    public User regoster(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
        return "User Deleted";
    }
}

// sample json
// {
// "name": "John",
// "email":"john@gmail.com",
// "password":"1234",
// "role":"user"
// }
