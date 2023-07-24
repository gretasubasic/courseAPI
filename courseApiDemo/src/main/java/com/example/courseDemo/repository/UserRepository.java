package com.example.courseDemo.repository;

import com.example.courseDemo.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<MyUser, Integer> {
    @Query("SELECT u FROM MyUser u JOIN FETCH u.userRoles WHERE u.username = ?1")
    Optional<MyUser> findByUsername(String username);
}
