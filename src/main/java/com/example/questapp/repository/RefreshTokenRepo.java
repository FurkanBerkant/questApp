package com.example.questapp.repository;

import com.example.questapp.model.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefreshTokenRepo extends JpaRepository<RefreshToken, Long> {

    RefreshToken findByUserId(Long userId);

}