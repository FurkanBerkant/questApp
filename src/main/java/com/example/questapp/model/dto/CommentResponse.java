package com.example.questapp.model.dto;

import lombok.Data;

@Data
public class CommentResponse {

    private Long id;
    private Long userId;
    private String userName;
    private String text;
}
