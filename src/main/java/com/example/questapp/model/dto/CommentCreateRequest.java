package com.example.questapp.model.dto;

import lombok.Data;

@Data
public class CommentCreateRequest {
    private Long id;
    private Long userId;
    private Long postId;
    private String text;
}
