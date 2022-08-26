package com.example.questapp.repository;

import com.example.questapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User getOneUserById(Long id);
}
