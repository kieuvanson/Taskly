package com.taskly.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskly.backend.dto.request.UserCreationRequest;
import com.taskly.backend.entity.user;
import com.taskly.backend.repository.userRepository;

@Service
public class userService {
    @Autowired
private  userRepository userRepository;



public user createRequest(UserCreationRequest request) {
    user newUser = new user();
    newUser.setUsername(request.getUsername());
    newUser.setFirstName(request.getFirstName());
    newUser.setLastName(request.getLastName());
    newUser.setPassword(request.getPassword());
    newUser.setEmail(request.getEmail());
    newUser.setAge(request.getAge());

   return userRepository.save(newUser);

}
public List<user> getAllUsers() {
    return userRepository.findAll();
}
}
