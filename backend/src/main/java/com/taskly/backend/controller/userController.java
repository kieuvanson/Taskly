package com.taskly.backend.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskly.backend.dto.request.APIrespone;
import com.taskly.backend.dto.request.UserCreationRequest;
import com.taskly.backend.dto.request.UserUpdateRequest;
import com.taskly.backend.entity.user;
import com.taskly.backend.service.userService;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/users")
public class userController {
    @Autowired 
    private  userService userService;

    @PostMapping
    public  APIrespone<user> createUser(@RequestBody @Valid UserCreationRequest request) {
        APIrespone<user> response = new APIrespone<>();
        response.setData(userService.createRequest(request));
        return response;
    }
    
    @GetMapping 
    List<user> getAllUsers() {
        return userService.getAllUsers();
    }
  @GetMapping("/{userId}")
    public user getUserById(@PathVariable String userId) {
        return userService.getUserById(userId);
    }

   @PutMapping("/{userId}")
    public user updateUser(@PathVariable String userId, @RequestBody UserUpdateRequest request) {
        return userService.updateUser(userId, request);
    }
@DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
        return "User with id " + userId + " has been deleted.";
    }
}

