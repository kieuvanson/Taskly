package com.taskly.backend.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskly.backend.dto.request.UserCreationRequest;
import com.taskly.backend.entity.user;
import com.taskly.backend.service.userService;


@RestController
@RequestMapping("/users")
public class userController {
    @Autowired 
    private  userService userService;

    @PostMapping
    public user createUser(@RequestBody UserCreationRequest request) {
        return userService.createRequest(request);
    }
    
    @GetMapping 
    List<user> getAllUsers() {
        return userService.getAllUsers();
    }
  
}
