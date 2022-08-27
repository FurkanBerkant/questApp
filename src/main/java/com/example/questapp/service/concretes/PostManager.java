package com.example.questapp.service.concretes;

import com.example.questapp.config.dtoConverter.DtoConverterService;
import com.example.questapp.model.Post;
import com.example.questapp.model.User;
import com.example.questapp.model.dto.LikeResponse;
import com.example.questapp.model.dto.PostCreateRequest;
import com.example.questapp.model.dto.PostResponse;
import com.example.questapp.repository.PostRepository;
import com.example.questapp.service.abstracts.LikeService;
import com.example.questapp.service.abstracts.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

@AllArgsConstructor
public class PostManager implements PostService {
    private PostRepository postRepository;
    private DtoConverterService dtoConverterService;
    private LikeService likeService;

    @Override
    public List<PostResponse> findAll(Optional<Long> userId) {
        List<Post> list;
        if(userId.isPresent()) {
            list = postRepository.findByUserId(userId.get());
        }else
            list = postRepository.findAll();
        return list.stream().map(p -> {
            List<LikeResponse> likes = likeService.getAllLikesWithParam(Optional.empty(),
                    Optional.of(p.getId()));
            return new PostResponse(p, likes);}).collect(Collectors.toList());
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
