package com.project.questDemo.business.abstracts;

import com.project.questDemo.entities.Dto.PostRequest;
import com.project.questDemo.entities.Dto.PostResponse;
import com.project.questDemo.entities.concretes.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {
    List<Post> getAll(Optional<Integer> userId);
    Post add(PostRequest postRequest);

    Post getOnePostById(int postId);
    Post updateOnePostById(int postId, PostRequest updatePost);

    void deleteById(int postId);
}
