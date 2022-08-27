package com.example.questapp.model.dto;

import lombok.Data;

@Data
public class LikeCreateRequest {
    private Long id;
    private String text;
    private String title;
    private Long userId;
    private Long postId;
}
