package com.example.questapp.model.dto;

import lombok.Data;

@Data
public class RefreshRequest {

    Long userId;
    String refreshToken;
}