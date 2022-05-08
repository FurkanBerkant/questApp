package com.project.questDemo.business.abstracts;

import com.project.questDemo.entities.Dto.PostRequest;
import com.project.questDemo.entities.concretes.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {
    List<Post> getAll(Optional<Integer> userId);
    PostRequest add(PostRequest postRequest);

    Post getOnePostById(int id);
    Post updateOnePost(int postId, Post newPost);

    void deleteById(int postId);
}
