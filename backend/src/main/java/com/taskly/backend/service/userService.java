package com.taskly.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskly.backend.dto.request.UserCreationRequest;
import com.taskly.backend.dto.request.UserUpdateRequest;
import com.taskly.backend.entity.user;
import com.taskly.backend.exception.AppException;
import com.taskly.backend.exception.ErrorCode;
import com.taskly.backend.repository.userRepository;

@Service
public class userService {
    @Autowired
private  userRepository userRepository;



public user createRequest(UserCreationRequest request) {
    user newUser = new user();
    if (userRepository.existsByUsername(request.getUsername())) {
        throw new AppException(ErrorCode.USERNAME_ALREADY_EXISTS);
    }

    newUser.setUsername(request.getUsername());
    newUser.setFirstName(request.getFirstName());
    newUser.setLastName(request.getLastName());
    if (!request.getPassword().matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$")) {
        throw new AppException(ErrorCode.IsValidPassword);
    }
    newUser.setPassword(request.getPassword());

    newUser.setEmail(request.getEmail());
    if (request.getAge() < 18) {
        throw new AppException(ErrorCode.AGE_MUST_BE_AT_LEAST_18);
    }
    newUser.setAge(request.getAge());

    return userRepository.saveAndFlush(newUser);

}
public user login(String username, String password) {
    user existingUser = userRepository.findByUsername(username)
            .orElseThrow(() -> new AppException(ErrorCode.INVALID_CREDENTIALS));

    if (!existingUser.getPassword().equals(password)) {
        throw new AppException(ErrorCode.INVALID_CREDENTIALS);
    }

    return existingUser;
}
public List<user> getAllUsers() {
    return userRepository.findAll();
}
public user getUserById(String userId) {
    return userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
}
public user updateUser(String userId, UserUpdateRequest request) {
   user user =getUserById(userId);
    user.setFirstName(request.getFirstName());
    user.setLastName(request.getLastName());
    user.setPassword(request.getPassword());
    user.setEmail(request.getEmail());
    user.setAge(request.getAge());

    return userRepository.saveAndFlush(user);
}
public void deleteUser(String userId) {
    user user = getUserById(userId);
    userRepository.delete(user);
    userRepository.flush();
}
}