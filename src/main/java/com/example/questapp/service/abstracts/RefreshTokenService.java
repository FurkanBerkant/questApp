package com.example.questapp.service.abstracts;

import com.example.questapp.model.RefreshToken;
import com.example.questapp.model.User;

public interface RefreshTokenService {
    String createRefreshToken(User user);
    boolean isRefreshExpired(RefreshToken token);
    RefreshToken getByUser(Long userId);
}

