package com.example.questapp.controllers;

import com.example.questapp.model.Post;
import com.example.questapp.model.dto.PostCreateRequest;
import com.example.questapp.model.dto.PostResponse;
import com.example.questapp.service.abstracts.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
@AllArgsConstructor
public class PostController {
    private PostService postService;

    @GetMapping()
    public ResponseEntity<List<PostResponse>> getAll(@RequestParam Optional<Long> userId){
        return new ResponseEntity<>(postService.findAll(userId), HttpStatus.OK);
    }
    @GetMapping("/{postId}")
    public ResponseEntity<Post> getOnePost(@PathVariable Long postId){
        return new ResponseEntity<>(postService.getOnePostById(postId),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody PostCreateRequest postCreateRequest){
        return new ResponseEntity<>(postService.createPost(postCreateRequest),HttpStatus.CREATED);
    }
    @PutMapping("/{postId}")
    public ResponseEntity<Post> updatePost(@PathVariable Long postId,@RequestBody Post newPost){
        return new ResponseEntity<>(postService.updatePost(postId,newPost),HttpStatus.OK);
    }
    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
