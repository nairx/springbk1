package com.example.springbk1.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbk1.dto.UserRequestDTO;
import com.example.springbk1.dto.UserResponseDTO;
import com.example.springbk1.entity.User;
import com.example.springbk1.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /// Before DTO

    // public User createUser(User user){
    // return userRepository.save(user);
    // }

    /////

    public UserResponseDTO createUser(UserRequestDTO dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setRole("user");
        User savedUser = userRepository.save(user);
        UserResponseDTO response = new UserResponseDTO();
        response.setId(savedUser.getId());
        response.setName(savedUser.getName());
        response.setEmail(savedUser.getEmail());
        response.setRole(savedUser.getRole());
        return response;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User getUserByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User user) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            User userToUpdate = existingUser.get();
            userToUpdate.setName(user.getName());
            userToUpdate.setEmail(user.getEmail());
            userToUpdate.setPassword(user.getPassword());
            userToUpdate.setRole(user.getRole());
            return userRepository.save(userToUpdate);
        }
        return null;
    }

      public void deleteById(Long id){
        userRepository.deleteById(id);
    }


}
