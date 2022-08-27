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
    public PostResponse(Post entity, List<LikeResponse> likes) {
        this.id = entity.getId();
        this.userId = entity.getUser().getId();
        this.userName = entity.getUser().getUser_name();
        this.title = entity.getTitle();
        this.text = entity.getText();
        this.postLikes = likes;
    }
}
