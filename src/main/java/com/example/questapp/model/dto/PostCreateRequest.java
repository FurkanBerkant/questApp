package com.example.questapp.model.dto;

import lombok.Data;

@Data
public class PostCreateRequest {
    private Long id;
    private String text;
    private String title;
    private Long userId;
}
