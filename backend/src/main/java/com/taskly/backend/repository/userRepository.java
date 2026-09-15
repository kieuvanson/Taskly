package com.taskly.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taskly.backend.entity.user;

public interface userRepository extends JpaRepository<user, String> {
    boolean existsByUsername(String username);
    java.util.Optional<user> findByUsername(String username);
}
