package com.example.questapp.service.abstracts;

import com.example.questapp.model.Post;
import com.example.questapp.model.User;
import com.example.questapp.model.dto.PostCreateRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface PostService {
    List<Post> findAll(Optional<Long> userId);

    Post createPost(PostCreateRequest postCreateRequest);

    Post getOnePostById(Long postId);

    Post updatePost(Long postId, Post newPost);

    void deletePost(Long postId);
}
