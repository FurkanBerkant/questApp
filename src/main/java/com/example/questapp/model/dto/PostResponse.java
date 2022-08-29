package com.example.questapp.model.dto;

import com.example.questapp.model.Post;
import lombok.Data;

import java.util.List;

@Data
public class PostResponse {
    private Long id;
    private Long userId;
    private String userName;
    private String title;
    private String text;
    private List<LikeResponse> postLikes;

}
