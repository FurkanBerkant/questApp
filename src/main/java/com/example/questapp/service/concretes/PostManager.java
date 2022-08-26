package com.example.questapp.service.concretes;

import com.example.questapp.config.dtoConverter.DtoConverterService;
import com.example.questapp.model.Post;
import com.example.questapp.model.User;
import com.example.questapp.model.dto.PostCreateRequest;
import com.example.questapp.repository.PostRepository;
import com.example.questapp.service.abstracts.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

@AllArgsConstructor
public class PostManager implements PostService {
    private PostRepository postRepository;
    private DtoConverterService dtoConverterService;

    @Override
    public List<Post> findAll(Optional<Long> userId) {
        if (userId.isPresent()){
            return postRepository.findByUserId(userId.get());
        }
        return postRepository.findAll();

    }


    @Override
    public Post createPost(PostCreateRequest postCreateRequest) {
        return postRepository.save((Post)
                dtoConverterService.dtoClassConverter(postCreateRequest,Post.class));
    }

    @Override
    public Post getOnePostById(Long postId) {
        return postRepository.findById(postId).orElse(null);
    }

    @Override
    public Post updatePost(Long postId, Post newPost) {
        Optional<Post> post = postRepository.findById(postId);
        if (post.isPresent()) {
            Post foundPost = post.get();
            foundPost.setText(newPost.getText());
            foundPost.setTitle(newPost.getTitle());
            postRepository.save(foundPost);
            return foundPost;
    }else {
        return null;
}}

    @Override
    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }
}
